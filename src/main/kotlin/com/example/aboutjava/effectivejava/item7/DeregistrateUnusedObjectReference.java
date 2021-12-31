package com.example.aboutjava.effectivejava.item7;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * "다 쓴 객체 참조를 해제해야 합니다"<p>
 * <p>
 * C, C++와 같은 언어를 사용하다가 Java와 같은 GC를 하는 언어를 사용하면 메모리 관리를 안해도 된다고 생각할 수 있습니다.<p>
 * 하지만 Java도 메모리 관리를 신경 써야합니다.<p>
 * 신경쓰지 않으면 '디스크 페이징', 'OOM'이 발생할 수 있습니다.<p>
 * 이미 정해진 Array의 크기는 자동으로 GC되지 않습니다. 계속해서 객체를 참조하고 있습니다.<p>
 * <p>
 * 1.자기 메모리를 직접 관리하는 클래스는 항상 Memory Leak을 조심해야합니다.<p>
 * - 객체를 참조하는 것은 null을 통해서 해제할 수 있습니다.<p>
 * - null로 다 쓴 객체 참조를 풀어주면 참조된 객체가 GC가 되고, 만약 참조를 잘못하게되면 NullPointException이 발생하는 장점이 있습니다.<p>
 * - 자기가 메모리를 만들어서 관리하는 경우에 한정해서 null 처리를 하는 방향으로 가야합니다. 즉, 객체 참조가 더 이상 없을 것이라고 판단하는 시점입니다.<p>
 * <p>
 * 2.캐시도 메모리 누수를 일으키는 주범입니다.<p>
 * - Map과 같은 자료구조를 이용해서 객체를 참조하고, 까먹고 참조를 해제해주지 않으면 계속적으로 참조하여 메모리가 누수됩니다.<p>
 * - 사실 캐시가 언제까지 살아있어야하는지 모르기 때문에 캐시 엔트리를 {@link java.util.concurrent.ScheduledThreadPoolExecutor}와 같은 수단으로 청소해줘야 합니다.
 * - {@link java.util.LinkedHashMap}같은 경우에는 다쓰고 remove 메서드를 명시적으로 호출해서 처리합니다.<p>
 * <p>
 * 3.리스너(listener) 혹은 콜백(callback)이 메모리 누수를 일으킬 수 있습니다.<p>
 * - 클라이언트가 콜백을 등록만하고 명확하게 해지하지 않으면 콜백은 쌓여갑니다.<p>
 * - 콜백을 약한 참조(weak reference)로 저장하면 가비지 컬렉터가 즉시 수거해갑니다.<p>
 * - 예를 들면, {@link java.util.WeakHashMap}에 키로 저장하면 됩니다.<p>
 * <p>
 * 메모리 누수는 겉으로 잘 나타나지 않아서 시스템에 수년간 잠복해있을 수 있습니다.<p>
 * 발견하는 방법은 (1) 철저한 코드 리뷰 (2) 디버깅 도구 사용 이 있습니다.
 */
class DeregistrateUnusedObjectReference {

    private static class Stack {
        private Object[] elements;
        private int size = 0;
        private static final int DEFAULT_INITIAL_CAPACITY = 16;

        public Stack() {
            this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public void push(Object e) {
            ensureCapacity();
            elements[size++] = e;
        }

        public Object pop() {
            if (size == 0)
                throw new EmptyStackException();
            return elements[--size];
        }

        public Object popWithoutMemoryLeak() {
            if (size == 0)
                throw new EmptyStackException();
            Object result = elements[--size];
            elements[size] = null;// 다 쓴 참조 해제
            return result;
        }

        private void ensureCapacity() {
            if (elements.length == size)
                this.elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}

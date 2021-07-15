package effectivejava.item7;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * "다 쓴 객체 참조를 해제해야 합니다"<p>
 * C, C++와 같은 언어를 사용하다가 Java와 같은 GC를 하는 언어를 사용하면 메모리 관리를 안해도 된다고 생각할 수 있습니다.<p>
 * 하지만 Java도 메모리 관리를 신경 써야합니다.<p>
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

        private void ensureCapacity() {
            if (elements.length == size)
                this.elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}

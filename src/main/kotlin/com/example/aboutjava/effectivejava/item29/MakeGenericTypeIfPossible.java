package com.example.aboutjava.effectivejava.item29;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * "Item 29 - 이왕이면 제네릭 타입으로 만들어야 합니다"<p>
 * <p>
 * JDK가 제공하는 제네릭 타입과 메서드를 사용하는 일은 일반적으로 쉬운 편이지만, 제네릭 타입을 새로 만드는 일은 조금 더 어렵습니다.<p>
 */
class MakeGenericTypeIfPossible {
    /**
     * Object 기반 스택 - 제네릭이 절실한 강력 후보!
     */
    private static class Stack {
        private Object[] elements;
        private int size = 0;
        private static final int DEFAULT_INITIAL_CAPACITY = 16;

        public Stack() {
            elements = new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public void push(Object e) {
            ensureCapacity();
            elements[size++] = e;
        }

        /**
         * Ensure space for at least one more element, roughly
         * doubling the capacity each time the array needs to grow.
         */
        private void ensureCapacity() {
            if (elements.length == size)
                elements = Arrays.copyOf(elements, 2 * size + 1);
        }

        // Corrected version of pop method (Page 27)
        public Object pop() {
            if (size == 0)
                throw new EmptyStackException();
            Object result = elements[--size];
            elements[size] = null; // Eliminate obsolete reference
            return result;
        }
    }
}

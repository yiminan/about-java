package com.example.aboutjava.effectivejava.item31;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Item 31 - 한정적 와일드카드를 사용해 API 유연성을 높여야합니다.<p> Item 28 에서 이야기 하듯, 매개변수화 타입은 불공변(invariant)입니다.<p> 즉, 서로 다른 타입 Type1과 Type2가 있을 때,<p>
 * List&#60;Type1&#62;은 List&#60;Type2&#62;의 하위 타입도 상위 타입도 아니다.<p> 직관적이지 않겠지만 List&#60;String&#62;은 List&#60;Object&#62;가 하는 일을 제대로 수행하지 못하니,<p> 하위
 * 타입이 될 수 없습니다.(리스코프 치완 원칙에 어긋납니다. Item 10 참조)<p> 하지만 때로는 불공변 방식보다 유연한 방식이 필요합니다.<p>
 */
class IncreaseApiFlexibilityByUsingQualifyingWildcard {

    private static class Stack<E> {

        private LinkedList<E> elements;

        private Stack() {
            elements = new LinkedList<>();
        }

        /**
         * Bad 결함이 있는 형태의 메서드
         */
        void pushAll(Iterable<E> src) {
            for (E e : src) {
                push(e);
            }
        }

        /**
         * Good 와일드 카드를 활용한 보완된 자료형 사용
         */
        void pushAllWithWildcard(Iterable<? extends E> src) {
            for (E e : src) {
                push(e);
            }
        }

        /**
         * Push element in stack
         */
        private void push(E element) {
            elements.add(element);
        }

        /**
         * Bad 결함이 있는 형태의 메서드
         */
        void popAll(Collection<E> dst) {
            while (!elements.isEmpty()) {
                dst.add(pop());
            }
        }

        /**
         * Good 와일드 카드를 활용한 보완된 자료형 사용
         */
        void popAllWithWildcard(Collection<? super E> dst) {
            while (!elements.isEmpty()) {
                dst.add(pop());
            }
        }

        /**
         * Pop element in stack
         */
        private E pop() {
            return elements.pop();
        }
    }
}

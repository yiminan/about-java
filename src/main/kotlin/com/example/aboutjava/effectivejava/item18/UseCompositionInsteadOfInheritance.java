package com.example.aboutjava.effectivejava.item18;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * "Item 18 - 상속보다는 컴포지션(구성)을 사용해야합니다"<p>
 * <p>
 * 상속은 코드를 재사용하는 강력한 수단이지만, 항상 최선은 아닙니다.<p>
 * 상위 클래스와 하위 클래스를 모두 같은 프로그래머가 통제하는 패키지 안에서라면 상속도 안전한 방법이다.<p>
 * 확장할 목적으로 설계되었고, 문서화도 잘 된 클래스도 안전하다.<p>
 * 구체 클래스를 패키지 경계를 넘어 즉 다른 패키지의 구체 클래스를 상속하는 일은 위험하다.<p>
 * 결론)<p>
 * 상속은 강력하지만 캡슐화를 해친다는 문제가 있다.<p>
 * 상속은 상위 클래스와 하위 클래스가 순수한 is-a 관계일 때만 써야 한다.<p>
 * is-a도 하위 클래스와 상위 클래스가 다르고, 상위 클래스가 확장을 고려하지 않게 설계되었다면 문제가 된다.<p>
 * 상속의 취약점을 피하려면 상속 대신 컴포지션과 전달을 사용하자.<p>
 * 특히 래퍼 클래스로 구현할 적당한 인터페이스가 있다면 더욱 그렇다. 래퍼 클래스는 하위 클래스보다 견고하고 강력하다.<p>
 */
class UseCompositionInsteadOfInheritance {

    static class MyHashSet<E> extends HashSet<E> {
        private int addCount = 0; // 추가된 원소의 개수

        /**
         * 이 메서드가 @Override가 되면, addAll()이 호출될 떄, 이 메서드를 호출하게 된다.<p>
         * 만약 없다면, 상위 클래스의 add()가 호출되게 된다. 이 관계를 유념해야한다.<p>
         */
        @Override
        public boolean add(E e) {
            addCount++;
            return super.add(e);
        }

        /**
         * {@link HashSet}의 addAll이 super.addAll(c) 형태로 사용되었다.<p>
         * 그런데 위를 보면 add(E e) 메서드가 @Override 되었다.<p>
         * super.addAll(c) 구현 내용을 보면, 위 @Override add(E e)를 사용한다.<p>
         * 결국, super.addAll(c) 호출시, @Override add(E e)이 추가된 element만큼 호출되고,<p>
         * 최종적으로 c.size()까지 더해져서 예상되지 않는 값이 나올 수 있다.<p>
         */
        @Override
        public boolean addAll(Collection<? extends E> c) {
            addCount = addCount + c.size();
            return super.addAll(c);
        }

        public int getAddCount() {
            return addCount;
        }
    }

    static class MySet<E> extends ForwardingSet<E> {
        private int addCount = 0;

        public MySet(Set<E> set) {
            super(set);
        }

        @Override
        public boolean add(E e) {
            addCount++;
            return super.add(e);
        }

        @Override
        public boolean addAll(Collection<? extends E> collection) {
            addCount = addCount + collection.size();
            return super.addAll(collection);
        }

        public int getAddCount() {
            return addCount;
        }
    }

    /**
     * 기존 클래스를 확장하는 대신에 새로운 클래스를 만들고 private 필드로 기존 클래스의 인스턴스를 참조하게 하면 됩니다.<p>
     * 기존 클래스가 새로운 클래스의 구성요소로 쓰인다는 뜻에서 이를 컴포지션(Composition)이라고 합니다.<p>
     * 새로운 클래스의 인스턴스 메서드들은 기존클래스에 대응하는 메서드를 호출해 그 결과를 반환합니다.<p>
     * 이를 전달(Forwarding)이라고 하며, 새 클래스의 메서드들은 전달 메서드라고 합니다.<p>
     * 이렇게 되면 새로운 클래스는 기존 클래스의 영향이 적어지고 기존 클래스 안에 새로운 메서드가 추가되어도 안전하게 됩니다.<p>
     */
    private static class ForwardingSet<E> implements Set<E> {
        private final Set<E> set;

        public ForwardingSet(Set<E> set) {
            this.set = set;
        }

        public void clear() {
            set.clear();
        }

        public boolean isEmpty() {
            return set.isEmpty();
        }

        public boolean add(E e) {
            return set.add(e);
        }

        public boolean addAll(Collection<? extends E> c) {
            return set.addAll(c);
        }

        /**
         * 아래부터는 구현 생략
         */

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<E> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }
    }
}

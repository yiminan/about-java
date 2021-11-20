package effectivejava.item18;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * "상속보다는 컴포지션(구성)을 사용해야합니다"<p>
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

    private static class InvalidCase {

        public static void main(String[] args) {
            MyHashSet<String> myHashSet = new MyHashSet<>();
            myHashSet.addAll(List.of("1", "2", "3"));
            System.out.println(myHashSet.getAddCount());// 예상 3, 실제 6
        }

        private static class MyHashSet<E> extends HashSet<E> {
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
    }
}

package com.example.aboutjava.effectivejava.item21;

/**
 * "Item 21 - 인터페이스는 구현하는 쪽을 생각해 설계해야합니다"<p>
 * <p>
 * Java8 전에는 기존 구현체를 깨뜨리지 않고 인터페이스에 메서드를 추가하지 못합니다.<p>
 * 그래서 인터페이스에 디폴트 메서드라는 개념이 추가되었습니다.<p>
 * 하지만 디폴트 메서드를 추가하면 재정의하지 않은 모든 클래스에서 디폴트 메서드 구현이 쓰이게 됩니다.<p>
 * 결국 디폴트 메서드는 은근슬적 기존의 구현 클래스들이 모르는 상태로 추가되게 됩니다.<p>
 * 기존 인터페이스에 디폴트 메서드로 새 메서드를 추가하는 일은 꼭 핖요한 경우가 아니면 피해야 한다.<p>
 * <p>
 * 디폴트 메서드의 단점<p>
 * - 구현체들은 default 메서드 추가 사실을 모른다. 구현체들이 어떤 오버라이드가 진행되었는지도 모를 수 있다.<p>
 * - 모든 상황에서 불변식을 해치지 않기란 어렵다. 불변식을 만족시키지 못하는 메서드이다.<p>
 * - 문제점이 런타임에서야 발견 될 수도 있다. ex) {@link java.util.Collection}<p>
 * <p>
 * 결론)<p>
 * - 기존 인터페이스에 기능을 추가하는 용도보다는 인터페이스에서 표준 메서드를 제공하는 형태로 구현되어야합니다.<p>
 * - 인터페이스를 릴리스한 후에 결함이 발생해서 수정 가능한 경우도 있지만, 절대 그 가능성에 기대어서는 안됩니다.<p>
 */
class DesignInterfaceWhichIsConsideredForImplementedClass {

    public static void main(String[] args) {
        DefaultTestable studentTest = new StudentTest();
        studentTest.rest();// 게임을 한다.
    }

    private interface DefaultTestable {

        void study();

        default void rest() {
            System.out.println("그냥 쉰다.");
        }

    }

    private static class StudentTest implements DefaultTestable {

        @Override
        public void study() {
            System.out.println("공부한다.");
        }

        @Override
        public void rest() {
            System.out.println("게임을 한다.");
        }
    }
}

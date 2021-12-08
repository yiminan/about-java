package effectivejava.item21;

/**
 * "인터페이스는 구현하는 쪽을 생각해 설계해야합니다"<p>
 * <p>
 * Java8 전에는 기존 구현체를 깨뜨리지 않고 인터페이스에 메서드를 추가하지 못합니다.<p>
 * 그래서 인터페이스에 디폴트 메서드라는 개념이 추가되었습니다.<p>
 * 하지만 디폴트 메서드를 추가하면 재정의하지 않은 모든 클래스에서 디폴트 메서드 구현이 쓰이게 됩니다.<p>
 * 결국 디폴트 메서드는 은근슬적 기존의 구현 클래스들이 모르는 상태로 추가되게 됩니다.<p>
 */
class DesignInterfaceWhichIsConsideredForImplementedClass {
}

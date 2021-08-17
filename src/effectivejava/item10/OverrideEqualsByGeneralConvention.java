package effectivejava.item10;

/**
 * "equals는 일반 규약을 지켜 재정의해야한다"<p>
 * <p>
 * equals() 메서드를 재정의하는 것은 쉬워 보입니다. 하지만 잘못 정의하게 되면 객체를 비교하는 과정에서 심각한 문제가 발생될 수 있습니다.<p>
 * 문제가 발생 안하게 하려면 equals()를 재정의하지 않는 방법이 있습니다.<p>
 * 재정의 하지 않으면 객체는 오직 자신과만 같아질 수 있습니다.<p>
 * <p>
 * equals()를 정의해야하는 경우<p>
 * - equals와 hashCode는 모두 VO(Value Object)에서만 사용하는 것을 권장합니다.<p>
 * - 값을 나타내는 것 외에 기능을 갖고 있는 인스턴스에서는 문제가 발생할 여지가 있어 사용하지 않는 것을 권장합니다.<p>
 * <p>
 * equals()를 재정의 하지 않아도 되는 경우<p>
 * 1.각 인스턴스가 본질적으로 고유한 경우<p>
 * - JPA의 entity와 같은 본질적으로 고유한 PK를 가지는 경우는 재정의하지 않아도 됩니다.<p>
 * - 본질적으로 객체 인스턴스가 고유한 예) {@link Thread}<p>
 * 2.인스턴스의 '논리적 동치성(logical equality)'을 검사할 일이 없는 경우<p>
 * - 인스턴스의 내부 필드에 값들이 존재할텐데, 애초에 이 값이 논리적으로 동치인지 확인이 필요하지 않은 경우는 equals()를 재정의할 필요가 없습니다.<p>
 * 3.상위 클래스에서 재정의한 equals가 하위 클래스에도 딱 들어맞는 경우<p>
 * - 대부분의 {@link java.util.Set} 구현체는 {@link java.util.AbstractSet}이 구현한 equals()를 상속받아 씁니다.<p>
 * - 대부분의 {@link java.util.List} 구현체는 {@link java.util.AbstractList}이 구현한 equals()를 상속받아 씁니다.<p>
 * - 대부분의 {@link java.util.Map} 구현체는 {@link java.util.AbstractMap}이 구현한 equals()를 상속받아 씁니다.<p>
 * - 상위 클래스의 equals()를 상속받아 쓰기 때문에 굳이 하위 클래스에서 재정의할 필요가 없습니다.<p>
 * 4.클래스가 private이거나 package-private이고 equals 메서드를 호출할 일이 없는 경우<p>
 * - 클래스가 애초에 equals()를 호출할 필요가 없는 경우이기 때문에 애초에 재정의하지 않거나, 재정의해서 호출시 예외를 발생하도록 하는 것도 좋습니다.<p>
 * <p>
 * equals()를 재정의해야 하는 경우<p>
 * - 객체 식별성(object identity=객체 동일성,물리적으로 같은가)이 아니라 논리적 동치성(=객체 동등성)을 확인해야하는데,상위 클래스의 equals가 논리적 동치성이 비교하도록 재정의되지 않았을 때다.<p>
 * -
 *
 * @see <a href="https://jojoldu.tistory.com/134">equals와 hashCode 사용하기 ( +lombok)</a>
 */
class OverrideEqualsByGeneralConvention {
}

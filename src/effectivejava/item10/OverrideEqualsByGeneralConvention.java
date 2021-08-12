package effectivejava.item10;

/**
 * "equals는 일반 규약을 지켜 재정의해야한다"<p>
 * <p>
 * equals() 메서드를 재정의하는 것은 쉬워 보입니다. 하지만 잘못 정의하게 되면 객체를 비교하는 과정에서 심각한 문제가 발생될 수 있습니다.<p>
 * 문제가 발생 안하게 하려면 equals()를 재정의하지 않는 방법이 있습니다.<p>
 * 재정의 하지 않으면 객체는 오직 자신과만 같아질 수 있습니다.<p>
 * <p>
 * equals()를 재정의 하지 않아도 되는 경우<p>
 * 1.각 인스턴스가 본질적으로 고유한 경우
 * 2.인스턴스의 '논리적 동치성(logical equality)'을 검사할 일이 없는 경우
 * 3.상위 클래스에서 재정의한 equals가 하위 클래스에도 딱 들어맞는 경우
 * 4.클래스가 private이거나 package-private이고 equals 메서드를 호출할 일이 없는 경우
 */
class OverrideEqualsByGeneralConvention {
}

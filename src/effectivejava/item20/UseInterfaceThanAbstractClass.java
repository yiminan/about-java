package effectivejava.item20;

/**
 * "추상 클래스보다는 인터페이스를 우선하라"<p>
 * <p>
 * 자바가 제공하는 다중 구현 메커니증은 (1) 인터페이스 (2) 추상클래스 입니다.<p>
 * 물론 인터페이스에서 default method로 instance method를 구현형태로 제공할 수 있습니다.<p>
 * 기존 클래스에도 손쉽게 새로운 인터페이스를 사용 구현해 넣을 수 있습니다.<p>
 * 자바에서도 기존 클래스에 쉽게 {@link Comparable}, {@link Iterable}, {@link AutoCloseable}를 추가 구현할 수 있다.<p>
 * <p>
 * 인터페이스는 믹스인(mixin) 정의에 안성맞춤이다.<p>
 *
 */
class UseInterfaceThanAbstractClass {
}

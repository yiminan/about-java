package effectivejava.item3;

/**
 * "private 생성자나 Enum 타입으로 싱글턴임을 보증해야합니다"<p>
 * 싱글턴(singleton)이란 인스턴스를 오직 하나만 생성할 수 있는 클래스를 말한다.<p>
 * 싱글턴의 예는 '무상태 객체'나 '설계상 유일해야하는 시스템 컴포넌트'에서 사용입니다.<p>
 * 무상태(stateless) 객체 : 내부 필드로 상태값을 가지고 있지 않은 객체<p>
 * 설계상 유일해야하는 시스템 컴포넌트 : 스프링 bean과 같은 시스템에 유일해야하는 컴포넌트<p>
 *
 */
class GuaranteeSingletonWithPrivateConstructorOrEnum {
}

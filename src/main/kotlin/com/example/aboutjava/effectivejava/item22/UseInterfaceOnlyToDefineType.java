package com.example.aboutjava.effectivejava.item22;

/**
 * "Item 22 - 인터페이스는 타입을 정의하는 용도로만 사용해야합니다"<p>
 * <p>
 * 인터페이스는 자신을 구현한 클래스의 인스턴스를 참조할 수 있는 타입 역할을 한다.<p>
 * 달리 말해, 클래스가 어떤 인터페이스를 구현한다는 것은 자신의 인스턴스로 무엇을 할 수 있는 지 알려주는 것이다.<p>
 * 인터페이스는 위 이야기한 용도로만 사용되어야한다.<p>
 * <p>
 * static final 필드로 가득찬 `상수 인터페이스`는 안티패턴으로 인터페이스를 잘못 사용한 예입니다.<p>
 * 클래스 내부에서 사용하는 상수는 외부 인터페이스가 아니라 내부 구현에 해당하는데, 상수 인터페이스는 내부 구현을 외부로 노출하는 것과 같습니다.<p>
 * final이 아닌 클래스가 상수 인터페이스를 구현한다면 모든 하위 클래스의 이름공간이 상수 인터페이스의 상수들로 오염됩니다.<p>
 * 잘못 사용된 상수 인터페이스 예) {@link java.io.ObjectStreamConstants} ... <p>
 */
class UseInterfaceOnlyToDefineType {
    interface InvalidInterface {
        int ONE = 1;
    }
}

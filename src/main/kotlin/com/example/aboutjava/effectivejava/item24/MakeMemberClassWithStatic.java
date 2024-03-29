package com.example.aboutjava.effectivejava.item24;

/**
 * "Item 24 - 멤버 클래스는 되도록 static으로 만들어야 합니다"<p>
 * <p>
 * 중첩 클래스(nested class)란 다른 클래스 안에 정의된 클래스를 말합니다.<p>
 * <p>
 * 중첩 클래스의 종류<p>
 * 1. 정적 멤버 클래스<p>
 * - 정적 멤버 클래스는 바깥 클래스와 함께 쓰일 때만 유용한 public 도우미 클래스로 쓰인다.<p>
 * 2. 비정적 멤버 클래스<p>
 * 3. 익명 클래스<p>
 * 4. 지역 클래스<p>
 * 총 네 가지가 있다.<p>
 * 정적 멤버 클래스와 비정적 멤버 클래스의 차이는 static 접두 유무이다.<p>
 * 비정적 멤버 클래스의 인스턴스는 바깥 클래스의 인스턴소와 암묵적으로 연결된다.<p>
 * 그래서 비정적 멤버 클래스의 인스턴스 메서드에서 정규화된 this를 사용해 바깥 인스턴스의 메서드를 호출하거나 바깥 인스턴스의 참조를 가져올 수 있습니다.<p>
 * <p>
 * 정규화된 this란?<p>
 * 클래스명.this 형태로 바깥 클래스의 이름을 명시하는 용법<p>
 * <p>
 * 중첩 클래스의 인스턴스가 바깥 인스턴스와 독립적으로 존재할 수 있다면 정적 멤버 클래스로 만들어야합니다.<p>
 * 비정적 멤버 클래스는 바깥 인스턴스 없이는 생성할 수 없기 때문입니다.<p>
 * 비정적 멤버 클래스의 인스턴스와 바깥 인스턴스 사이의 관계는 멤버 클래스가 인스턴스화될 때 확립하고, 변경할 수 없다.<p>
 * <p>
 * "멤버 클래스에서 바깥 인스턴스에 접근할 일이 없다면 무조건 static을 붙여서 정적 멤버 클래스로 만들어야 합니다.<p>
 * static을 생략하면 바깥 인스턴스로의 숨은 외부 참조를 갖게 됩니다. 이 참조를 저장하려면 시간과 공간이 소비됩니다.<p>
 * Gabage Collection이 바깥 클래스의 인스턴스를 수거하지 못하는 메모리 누수가 생길 수 있다는 점입니다.<p>
 * 하지만 바깥 클래스의 인스턴스 참조가 찾기 어려워 메모리 누수에 엄청난 문제를 초래하기도 합니다.<p>
 * <p>
 * 결론)<p>
 * 중첩 클래스에는 네 가지가 있고, 각각의 쓰임은 다릅니다.<p>
 * 1. 해당 클래스 메서드 밖에서도 사용하거나 메서드 안에 정의하기엔 너무 길다면 멤버 클래스로 만들어야합니다.<p>
 * 2. 멤버 클래스의 인스턴스 각각이 바깥 인스턴스를 참조한다면 비정적으로, 그렇지 않으면 정적으로 만들어야합니다.<p>
 * 중첩 클래스가 한 메서드 안에서만 쓰이면서 그 인스턴스를 생성하는 지점이 단 한 곳이고 해당 타입으로 쓰기에 적합한 클래스나 인터페이스가 이미 있다면,
 * 3. 익명 클래스로 만들고,<p>
 * 4. 그렇지 않으면 지역 클래스로 만들어야합니다.<p>
 */
class MakeMemberClassWithStatic {
    public static class Calculator {
        enum Operation {
            PLUS, MINUS, MULTIPLY, DIVIDE
        }
    }
}

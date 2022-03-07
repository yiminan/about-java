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
 *
 */
class MakeMemberClassWithStatic {
    public static class Calculator {
        enum Operation {
            PLUS, MINUS, MULTIPLY, DIVIDE
        }
    }
}

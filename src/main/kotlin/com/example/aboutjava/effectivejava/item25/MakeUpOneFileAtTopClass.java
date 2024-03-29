package com.example.aboutjava.effectivejava.item25;

/**
 * "Item 25 - 톱레벨 클래스는 한 파일에 하나만 담아야합니다"<p>
 * 결론)<p>
 * 소스 파일 하나에는 반드시 톱레벨 클래스(혹은 톱레벨 인터페이스)를 하나만 담아야 합니다.<p>
 * 이 규칙만 따른다면 컴파일러가 한 클래스에 대한 정의를 여러 개 만들어내는 일은 사라집니다.<p>
 * 소스 파일을 어떤 순서로 컴파일하든 바이너리 파일이나 프로그램의 동작이 달라지는 일은 결코 일어나지 않을 것 입니다.<p>
 * 여러 클래스가 하나의 파일에서 정의하는게 필요하다면, '정적 멤버 클래스'를 만들어야 합니다.<p>
 */
class MakeUpOneFileAtTopClass {

    /**
     * 정적 멤버 클래스
     */
    private static class Car {
        static final String NAME = "BMW";
    }

    /**
     * 정적 멤버 클래스
     */
    private static class Book {
        static final String NAME = "Real MySQL";
    }
}

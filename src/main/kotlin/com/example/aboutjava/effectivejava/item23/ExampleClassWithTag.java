package com.example.aboutjava.effectivejava.item23;

/**
 * item 23의 잘못된 태그형태 사용 예시<p>
 * <p>
 * a. 쓸데없는 코드가 너무 많다 : 열거 타입선언, 태그 필드, switch문<p>
 * b. 장황하고 오류를 내기 쉽고 비효율적이다.<p>
 * c. 클래스 계층 구조를 어설프레 흉내낸 것이다.<p>
 */
class ExampleClassWithTag implements UseHierarchicalClassThanClassWithTag {
    static class Figure {
        enum Shape {RECTANGLE, CIRCLE}

        // 태그 필드 - 현재 모양을 나타낸다.
        final Shape shape;

        // 다음 필드들은 모양이 사각형(RECTANGLE)일 때만 쓰인다.
        double length;
        double width;

        // 다음 필드는 모양이 원(CIRCLE)일 때만 쓰인다.
        double radius;

        // 원용 생성자
        Figure(double radius) {
            shape = Shape.CIRCLE;
            this.radius = radius;
        }

        // 사각형용 생성자
        Figure(double length, double width) {
            shape = Shape.RECTANGLE;
            this.length = length;
            this.width = width;
        }

        double area() {
            switch (shape) {
                case RECTANGLE:
                    return length * width;
                case CIRCLE:
                    return Math.PI * (radius * radius);
                default:
                    throw new AssertionError(shape);
            }
        }
    }
}

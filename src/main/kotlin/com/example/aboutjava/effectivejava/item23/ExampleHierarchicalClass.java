package com.example.aboutjava.effectivejava.item23;

/**
 * 클래스 계층 구조로의 리팩터링한 예시<p>
 * <p>
 * a. root가 될 추상 클래스를 정의하자<p>
 * b. 태그에 따라 행동이 달라지던 메서드는 추상 메서드로 구현하자 : 그렇지않으면 일반메서드<p>
 * c. 공통된 필드는 모두 root 클래스로 올리자<p>
 * d. 구체 클래스에서 추상클래스를 의미에 맞게 정의하자<p>
 */
class ExampleHierarchicalClass implements UseHierarchicalClassThanClassWithTag {
    abstract class Figure {
        abstract double area();
    }

    class Rectangle extends Figure {
        final double length;
        final double width;

        Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        @Override
        double area() {
            return length * width;
        }
    }

    class Circle extends Figure {
        final double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        @Override
        double area() {
            return Math.PI * (radius * radius);
        }
    }

    class Square extends Rectangle {
        Square(double side) {
            super(side, side);
        }
    }
}

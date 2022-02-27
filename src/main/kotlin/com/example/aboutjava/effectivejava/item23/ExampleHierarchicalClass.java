package com.example.aboutjava.effectivejava.item23;

/**
 * 클래스 계층 구조로의 리팩터링한 예시<p>
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
            this.width  = width;
        }
        @Override double area() { return length * width; }
    }

    class Circle extends Figure {
        final double radius;

        Circle(double radius) { this.radius = radius; }

        @Override double area() { return Math.PI * (radius * radius); }
    }

    class Square extends Rectangle {
        Square(double side) {
            super(side, side);
        }
    }
}

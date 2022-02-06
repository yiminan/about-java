package com.example.aboutjava.effectivejava.item16;

import java.util.Objects;

/**
 * "Item 16 - public 클래스에서는 public 필드가 아닌 접근자 메서드를 사용해야합니다"<p>
 * 기본적으로 내부 인스턴스 필드는 private을 적용하고, 필드의 내용을 변경하거나, 가져올땐 public setter, getter를 사용합니다.<p>
 */
class UseGetterInsteadOfPublicField {

    /**
     * public class로 지정해서 사용한다면 절대 내부 가변 필드를 public으로 노출해서는 안된다.
     */
    static class PointWithPublicInstanceField {
        public double x;
        public double y;
    }

    static class MutablePoint {
        private double x;
        private double y;

        public MutablePoint(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MutablePoint point = (MutablePoint) o;
            return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class ImmutablePoint {
        private final double x;
        private final double y;

        public ImmutablePoint(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ImmutablePoint point = (ImmutablePoint) o;
            return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}

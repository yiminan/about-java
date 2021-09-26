package effectivejava.item10.equivalence_relation;

import java.util.Objects;

/**
 * 동치관계(equivalence relation)의 추이성(transitivity)"
 * - 추이성은 'A->B'이고 'B->C' 이면, 'A->C'를 만족해야한다.<p>
 * - 동치관계를 지정한다.
 */
class TransitivityForEquivalenceRelation {

    private static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point)) {
                return false;
            }
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }
    }

    private static class ColorPoint extends Point {
        private final Color color;

        public ColorPoint(int x, int y, Color color) {
            super(x, y);
            this.color = color;
        }
    }

    private enum Color {
        RED, BLUE, GREEN;
    }
}

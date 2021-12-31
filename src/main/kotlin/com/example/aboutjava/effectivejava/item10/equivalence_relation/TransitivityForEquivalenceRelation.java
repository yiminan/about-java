package com.example.aboutjava.effectivejava.item10.equivalence_relation;

/**
 * 동치관계(equivalence relation)의 추이성(transitivity)"
 * - 추이성은 'A->B'이고 'B->C' 이면, 'A->C'를 만족해야한다.<p>
 * - 동치관계를 지정한다.<p>
 * -
 */
class TransitivityForEquivalenceRelation {

    public static void main(String[] args) {
        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
        System.out.println(p1.equals(p2));// true
        System.out.println(p2.equals(p3));// true
        System.out.println(p1.equals(p3));// false
    }

    private static class ColorPoint extends Point {
        private final Color color;

        public ColorPoint(int x, int y, Color color) {
            super(x, y);
            this.color = color;
        }

        /**
         * 추이성 위배
         */
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point))
                return false;
            if (!(o instanceof ColorPoint))
                return o.equals(this);
            return super.equals(o) && ((ColorPoint) o).color == color;
        }
    }

    private enum Color {
        RED, BLUE, GREEN;
    }
}

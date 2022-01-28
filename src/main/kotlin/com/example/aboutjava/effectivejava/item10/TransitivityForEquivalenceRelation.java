package com.example.aboutjava.effectivejava.item10;

/**
 * "동치관계(equivalence relation)의 추이성(transitivity)"
 * - 추이성은 'A->B'이고 'B->C' 이면, 'A->C'를 만족해야한다.<p>
 * - 동치관계를 지정한다.<p>
 * -
 */
class TransitivityForEquivalenceRelation {

    static class ColorPoint extends Point {
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

    enum Color {
        RED, BLUE, GREEN;
    }
}

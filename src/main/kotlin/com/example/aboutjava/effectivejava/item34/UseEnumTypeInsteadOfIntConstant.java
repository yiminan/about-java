package com.example.aboutjava.effectivejava.item34;

/**
 * Item 34 - int 상수 대신 열거 타입을 사용하라.<p>
 */
class UseEnumTypeInsteadOfIntConstant {

    /**
     * 정수 열거 패턴(int enum pattern) 기법에는 단점이 많다.<p>타입 안전을 보장할 방법이 없으며 표현력도 좋지 않다.
     */
    private static final int APPLE_FUJI = 0;
    private static final int APPLE_PIPPIN = 1;
    private static final int APPLE_GRANNY_SMITH = 2;
    private static final int ORANGE_NAVEL = 0;
    private static final int ORANGE_TEMPLE = 1;
    private static final int ORANGE_BLOOD = 2;

    private enum Apple {FUJI, PIPPIN, GRANNY_SMITH}

    private enum Orange {NAVEL, TEMPLE, BLOOD}

    /**
     * 상수별 메서드 구현을 활용한 열거 타입<p>
     * 각 상수는 하나의 상수 클래스 구현체와 같기에 추상 메서드를 개별 구현할 수 있다.
     */
    private enum Operation {
        PLUS("+") {
            public double apply(double x, double y) {
                return x + y;
            }
        },
        MINUS("-") {
            public double apply(double x, double y) {
                return x - y;
            }
        },
        TIMES("*") {
            public double apply(double x, double y) {
                return x * y;
            }
        },
        DIVIDE("/") {
            public double apply(double x, double y) {
                return x / y;
            }
        };

        private final String symbol;

        Operation(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return "Operation{" +
                    "symbol='" + symbol + '\'' +
                    '}';
        }

        abstract double apply(double x, double y);
    }
}

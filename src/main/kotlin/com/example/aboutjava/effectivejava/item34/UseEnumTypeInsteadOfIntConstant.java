package com.example.aboutjava.effectivejava.item34;

/**
 * Item 34 - int 상수 대신 열거 타입을 사용하라.<p>
 * <p>
 * 열거 타입은 확실히 정수 상수보다 뛰어나다. 더 읽기 쉽고 안전하고 강력하다.<p>
 * 대다수 열거 타입이 명시적 생성자나 메서드 없이 쓰이지만,<p>
 * 각 상수를 특정 데이터와 연결짓거나 상수마다 다르게 동작하게 할 때는 필요하다.<p>
 * 드물게는 하나의 메서드가 상수별로 다르게 동작해야 할 때도 있다.<p>
 * 이런 열거 타입에서는 switch 문 대신 상수별 메서드 구현을 사용하자.<p>
 * 열거 타입 상수 일부가 같은 동작을 공유한다면 전략 열거 타입 패턴을 사용하자.<p>
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
     * 상수별 메서드 구현을 활용한 열거 타입<p> 각 상수는 하나의 상수 클래스 구현체와 같기에 추상 메서드를 개별 구현할 수 있다.
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

    /**
     * 전략 열거 타입 패턴
     */
    private enum PayrollDay {
        MONDAY(PayType.WEEKDAY), TUESDAY(PayType.WEEKDAY), WEDNESDAY(PayType.WEEKDAY),
        THURSDAY(PayType.WEEKDAY), FRIDAY(PayType.WEEKDAY),
        SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

        private final PayType payType;

        PayrollDay(PayType payType) {
            this.payType = payType;
        }

        int pay(int hoursWorked, int payRate) {
            return payType.pay(hoursWorked, payRate);
        }

        /**
         * 전략 열거 타입
         */
        enum PayType {
            WEEKDAY {
                int overtimePay(int minsWorked, int payRate) {
                    return minsWorked <= MINS_PER_SHIFT ? 0 :
                            (minsWorked - MINS_PER_SHIFT) * payRate / 2;
                }
            },
            WEEKEND {
                int overtimePay(int minsWorked, int payRate) {
                    return minsWorked * payRate / 2;
                }
            };

            abstract int overtimePay(int minsWorked, int payRate);

            private static final int MINS_PER_SHIFT = 8 * 60;

            int pay(int minsWorked, int payRate) {
                int basePay = minsWorked * payRate;
                return basePay + overtimePay(minsWorked, payRate);
            }
        }
    }
}

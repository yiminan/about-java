package com.example.aboutjava.elegantobject.step2_education.step2_2_atleastencapsulatesomething;

/**
 * "객체는 최소한 무언가를 캡슐화해야합니다"<p>
 * <p>
 * 많은 필드를 캡슐화하는 것도 안좋지만, 아무 것도 캡슐화하지 않는 것도 안좋습니다.<p>
 * OOP에서 정적 클래스는 객체의 목적을 잃어버리는 안티 패턴입니다. 순수한 OOP에는 정적 메서드가 존재하지 않습니다.<p>
 * 객체 자체가 주체적인 상태와 행위를 둘 다 가지고 있지 않기 때문입니다.<p>
 * OOP에서 객체는 다른 객체들과 관계가 정의되어서 객체의 존재 의미가 인정되어야합니다.<p>
 * 다른 객체와의 관계가 정의되지 않은 객체는 OOP에서 객체라고 생각할 수 없습니다.<p>
 */
class AtLeastEncapsulateSomething {

    public static void main(String[] args) {
        WrongYear wrongYear = new WrongYear();
        ProperYear properYear = new ProperYear(new MilliSecond(System.currentTimeMillis()));
        System.out.println(wrongYear.read());
        System.out.println(properYear.read());
    }

    private static class WrongYear {
        public long read() {
            return System.currentTimeMillis() / (1000L * 60L * 60L * 24L * 365L) + 1970L;
        }
    }

    private interface Number<T> {
        T divide(long digits);

        T plus(long digits);

        long longValue();
    }

    private static class MilliSecond implements Number<MilliSecond> {
        private final long digits;

        public MilliSecond(long digits) {
            this.digits = digits;
        }

        @Override
        public MilliSecond divide(long digits) {
            return new MilliSecond(this.digits / digits);
        }

        @Override
        public MilliSecond plus(long digits) {
            return new MilliSecond(this.digits + digits);
        }

        @Override
        public long longValue() {
            return digits;
        }
    }

    private static class ProperYear {
        private static final long ONE_YEAR_MILLI_SEC = 1000L * 60L * 60L * 24L * 365L;
        private static final long BASE_YEAR = 1970L;

        private final Number<MilliSecond> num;

        public ProperYear(MilliSecond msec) {
            this.num = msec.divide(ONE_YEAR_MILLI_SEC).plus(BASE_YEAR);
        }

        public long read() {
            return this.num.longValue();
        }
    }
}

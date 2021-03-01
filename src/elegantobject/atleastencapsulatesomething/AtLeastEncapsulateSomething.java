package elegantobject.atleastencapsulatesomething;

public class AtLeastEncapsulateSomething {

    static class WrongYear {
        public long read() {
            return System.currentTimeMillis() / (1000L * 60L * 60L * 24L * 365L) + 1970L;
        }
    }

    interface Number<T> {
        T divide(long digits);

        T plus(long digits);

        long longValue();
    }

    static class MilliSecond implements Number<MilliSecond> {
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

    static class ProperYear {
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

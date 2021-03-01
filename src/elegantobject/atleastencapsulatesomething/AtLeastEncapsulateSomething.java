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
}

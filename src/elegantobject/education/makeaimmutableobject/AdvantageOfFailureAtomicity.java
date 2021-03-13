package elegantobject.education.makeaimmutableobject;

class AdvantageOfFailureAtomicity {

    private static class MutableCash {
        private int dollars;
        private int cents;

        public void multiply(int factor) {
            this.dollars *= factor;
            if (true) {
                throw new RuntimeException("객체의 연산 도중 예외 발생");
            }
            this.cents *= factor;
        }
    }

    private static class ImmutableCash {
        private final int dollars;
        private final int cents;

        public ImmutableCash(int dollars, int cents) {
            this.dollars = dollars;
            this.cents = cents;
        }

        public ImmutableCash multiply(int factor) {
            if (true) {
                throw new RuntimeException("객체의 연산 도중 예외 발생");
            }
            return new ImmutableCash(this.dollars * factor, this.cents * factor);
        }
    }
}

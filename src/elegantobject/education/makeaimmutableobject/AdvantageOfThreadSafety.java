package elegantobject.education.makeaimmutableobject;

class AdvantageOfThreadSafety {
    private static class NonThreadSafetyCash {
        private int dollars;
        private int cents;

        public NonThreadSafetyCash(int dollars, int cents) {
            this.dollars = dollars;
            this.cents = cents;
        }

        public void multiply(int factor) {
            this.dollars *= factor;
            this.cents *= factor;
        }

        @Override
        public String toString() {
            return String.format("$%d.%d", dollars, cents);
        }
    }
}

package elegantobject.education.makeaimmutableobject;

class MakeAImmutableObject {
    private static class MutableCash {
        private int dollars;

        public MutableCash(int dollars) {
            this.dollars = dollars;
        }

        public void multiply(int factor) {
            this.dollars *= factor;
        }

        @Override
        public String toString() {
            return "$" + dollars;
        }
    }

    private static class ImmutableCash {
        private final int dollars;

        public ImmutableCash(int dollars) {
            this.dollars = dollars;
        }

        public ImmutableCash multiply(int factor) {
            return new ImmutableCash(this.dollars * factor);
        }

        @Override
        public String toString() {
            return "$" + dollars;
        }
    }
}

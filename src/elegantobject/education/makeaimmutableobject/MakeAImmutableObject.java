package elegantobject.education.makeaimmutableobject;

class MakeAImmutableObject {

    public static void main(String[] args) {
        MutableCash five = new MutableCash(5);
        five.multiply(10);
        System.out.println(five);// $50

        ImmutableCash _five = new ImmutableCash(5);
        ImmutableCash _fifty = _five.multiply(10);
        System.out.println(_fifty);// $50
    }

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

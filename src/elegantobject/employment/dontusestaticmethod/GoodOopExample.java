package elegantobject.employment.dontusestaticmethod;

class GoodOopExample {
    private static class If {
        private final GreaterThan greaterThan;
        private final float trueValue;
        private final float falseValue;

        public If(GreaterThan greaterThan, float trueValue, float falseValue) {
            this.greaterThan = greaterThan;
            this.trueValue = trueValue;
            this.falseValue = falseValue;
        }

        public float result() {
            if (greaterThan.right()) {
                return trueValue;
            }
            return falseValue;
        }
    }

    private static class GreaterThan {
        private final AgeOf ageOf;
        private final int comparedAge;

        public GreaterThan(AgeOf ageOf, int comparedAge) {
            this.ageOf = ageOf;
            this.comparedAge = comparedAge;
        }

        public boolean right() {
            return ageOf.age() > comparedAge;
        }
    }

    private static class AgeOf {
        private final int age;

        public AgeOf(Client client) {
            this.age = client.age();
        }

        public int age() {
            return age;
        }
    }

    private static class Client {
        private final int age;

        public Client(int age) {
            this.age = age;
        }

        public int age() {
            return age;
        }
    }
}

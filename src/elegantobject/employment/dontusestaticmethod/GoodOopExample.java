package elegantobject.employment.dontusestaticmethod;

class GoodOopExample {
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

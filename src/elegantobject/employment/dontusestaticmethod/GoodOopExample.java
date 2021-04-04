package elegantobject.employment.dontusestaticmethod;

class GoodOopExample {
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

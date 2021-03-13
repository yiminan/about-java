package elegantobject.education.makeaimmutableobject;

class DisadvantageOfNullReference {

    private static class User {
        private final int id;
        private Age age;

        public User(int id) {
            this.id = id;
        }

        public void setAge(Age age) {
            this.age = age;
        }

        public int id() {
            return id;
        }

        public Age age() {
            return age;
        }
    }

    private static class Age {
        private final int value;

        public Age(int value) {
            this.value = value;
        }

        public int value() {
            return value;
        }
    }
}

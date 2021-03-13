package elegantobject.education.makeaimmutableobject;

class DisadvantageOfNullReference {

    public static void main(String[] args) {
        User user1 = new User(1);
        user1.setAge(new Age(20));
        System.out.println(user1.age().value());

        User user2 = new User(1);
        // User의 Age를 초기화하지 않았다.
        System.out.println(user2.age().value());// NullPointerException 발생
    }

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

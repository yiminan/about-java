package elegantobject.retirement.neverreturnnull;

/**
 * "null의 대안"
 * 원하는 객체가 존재하지 않을 때, null을 반환하지않고 대안을 찾아야합니다.
 *
 */
class SolutionForNonNull {

    private static class User {
        private final String name;
        private final String age;

        public User(String name, String age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getAge() {
            return age;
        }
    }
}

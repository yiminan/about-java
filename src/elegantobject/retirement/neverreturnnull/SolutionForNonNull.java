package elegantobject.retirement.neverreturnnull;

/**
 * "null의 대안"
 * 원하는 객체가 존재하지 않을 때, null을 반환하지않고 대안을 찾아야합니다.
 *
 */
class SolutionForNonNull {
    /**
     * 1. 리스트에 넣어서 반환 // 추천
     */
    public List<User> users(String name) {
        if (/*데이터베이스에서 User를 발견하지 못했다면*/false) {
            return Collections.emptyList();
        }
        return Collections.singletonList(
                /*데이터베이스에서 발견한 User 반환*/
                new User("name", 20)
        );
    }

    /**
     * 2. Optional에 담아서 반환 // 비추천
     * 반환하는 내용물이 의미적으로 Optional이던 User이던 불분명하기 때문에 비추천입니다.
     */
    public Optional<User> user(String name) {
        return Optional.ofNullable(
                /*데이터베이스에서 조회한 User 반환한다. 없을 경우를 대비해서 ofNullable 사용*/
                new User("name", 20)
        );
    }

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

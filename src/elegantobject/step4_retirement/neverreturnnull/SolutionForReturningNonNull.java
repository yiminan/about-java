package elegantobject.step4_retirement.neverreturnnull;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * "null의 대안"<p>
 * <p>
 * 원하는 객체가 존재하지 않을 때, null을 반환하지않고 대안을 찾아야합니다.<p>
 * 솔루션은 다음과 같습니다.<p>
 * 1. 리스트에 넣어서 반환 // 추천<p>
 * 2. Optional에 담아서 반환 // 비추천<p>
 * 3. 널 객체(null object) 디자인 패턴 사용 // OOP<p>
 * 무조건 어떤 방법이던 null만 반환하지 않으면 그래도 잘 사용한 방법입니다.<p>
 * 절대 null을 반환하면 안됩니다.<p>
 */
class SolutionForReturningNonNull {
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
     * 2. Optional에 담아서 반환 // 비추천<p>
     * 반환하는 내용물이 의미적으로 Optional이던 User이던 불분명하기 때문에 비추천입니다.<p>
     */
    public Optional<User> user(String name) {
        return Optional.ofNullable(
                /*데이터베이스에서 조회한 User 반환한다. 없을 경우를 대비해서 ofNullable 사용*/
                new User("name", 20)
        );
    }

    /**
     * 3. 널 객체(null object) 디자인 패턴 사용 // OOP<p>
     * 제한적으로 User의 인터페이스를 만들고, 객체를 만들어 사용해야하기 때문에 사용하기 힘듭니다.<p>
     */
//    private static class NullUser implements User {
//        private final String name;
//        private final int age;
//
//        public NullUser(String name, int age) {
//            this.name = name;
//            this.age = age;
//        }
//
//        @Override
//        public String name() {
//            return this.name;
//        }
//
//        @Override
//        public void raise(Cash salary) {
//            throw new IllegalStateException(
//                "NullUser이라서 메서드 호출이 불가합니다."
//            );
//        }
//    }

    private static class User {
        private final String name;
        private final int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}

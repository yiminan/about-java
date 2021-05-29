package elegantobject.step2_education.makeaimmutableobject;

/**
 * "객체에서 NULL 참조를 없애기"<p>
 * <p>
 * 객체에서 설정되지 않은(unset) 프로퍼티는 NULL이 기본적으로 할당됩니다.<p>
 * 객체에서 NULL을 허용하면 나중에 해당 프로퍼티를 가져올 때, NULL 체크가 없는 경우에는 예외를 발생할 수 있습니다.<p>
 * NULL을 허용하게 되면서 객체의 NULL로 참조된 프로퍼티의 상태를 체크하지 않으면 문제를 발생할 여지를 가집니다.<p>
 * 결국 문제는 커다란 클래스 내에서 문제를 작은 부분으로 분해하고 상속과 캡슐화를 하는 방법을 모르기 때문입니다.<p>
 * 일단, NULL로 참조된 부분을 캡슐화와 같은 방법으로 분리시켜서 해당하는 NULL 객체 로직을 독립시켜야합니다.<p>
 * 그리고 NULL이어야하는 이유를 생각해보고 비즈니스적으로 NULL이 필요없는 경우는 불변 객체로 만들어야합니다.<p>
 * 결국 불변 객체화를 통해서 NULL 참조를 없애면 작고, 응집도 높은 객체를 생성할 수 있게 강제되고 유지보수가 쉽습니다.<p>
 */
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

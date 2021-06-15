package effectivejava.item2;

/**
 * "생성자에 매개변수가 많다면 빌더를 고려하라"
 * <p>
 * 객체 생성 방식<p>
 * 1.점층적 생성자 패턴(telescoping constructor pattern)<p>
 * - 일반적으로 매개변수가 많아지면 "점층적 생성자 패턴(telescoping constructor pattern)"을 사용한다.<p>
 * - 하지만 점층적 생성자 패턴을 쓰다보면 매개변수 개수가 많아지면 클라이언트 코드를 작성하거나 읽기 어려워진다.<p>
 * - 생성자에 파라미터의 갯수가 많아지면 많아질수록 매개변수 입력에 대한 실수가 많아집니다.<p>
 * 2.자바빈즈 패턴(javaBeans pattern)<p>
 * - 매개변수가 없는 생성자로 객체 인스턴스를 만들고, setter를 통해서 내부 field를 설정하는 방식입니다.<p>
 * - 코드의 재사용성은 늘어나지만, setter를 여러개 호출해야하기 때문에 시간적 결합도가 증가합니다.<p>
 * - 불변 객체로 만들 수 없어서, 스레드 세이프하지 않습니다.즉, 런타임 오류에 취약합니다.<p>
 * 3.빌더 패턴(builder pattern)<p>
 * - 점층적 생성자 패턴(telescoping constructor pattern) 와 자바빈즈 패턴(javaBeans pattern)의 장점을 취한 패턴<p>
 * - 필수 매개변수는 점층적 생성자 패턴(telescoping constructor pattern)를 통해서 전달받습니다.<p>
 * - 선택 매개변수는 Builder를 만들어서 자바빈즈 패턴(javaBeans pattern)처럼 원하는 매개변수를 전달해서 생성자를 셋팅합니다.<p>
 */
class ConsiderABuilderWhenIHaveManyParameters {

    /**
     * 1.점층적 생성자 패턴(telescoping constructor pattern)
     */
    private static class TelescopingConstructorPatternForUser {
        private final String firstName;
        private final String lastName;
        private final int age;
        private final String sex;
        private final String email;

        public TelescopingConstructorPatternForUser(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = 0;
            this.sex = "none";
            this.email = "";
        }

        public TelescopingConstructorPatternForUser(String firstName, String lastName, int age, String sex, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
            this.email = email;
        }

        // ...
    }

    /**
     * 2.자바빈즈 패턴(javaBeans pattern)
     */
    private static class JavaBeansPatternForUser {
        private String firstName;
        private String lastName;
        private int age;
        private String sex;
        private String email;

        public JavaBeansPatternForUser() {
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    /**
     * 3.빌더 패턴(builder pattern)
     */
    private static class BuilderPatternForUser {
        private final String firstName;
        private final String lastName;
        private final String email;
        private final int age;
        private final String sex;

        private BuilderPatternForUser(Builder builder) {
            validate(builder);// 이 지점에서 유효성 검사를 실시합니다.
            this.firstName = builder.firstName;
            this.lastName = builder.lastName;
            this.email = builder.email;
            this.age = builder.age;
            this.sex = builder.sex;
        }

        private void validate(Builder builder) {
            if (!builder.firstName.equals("")) {
                throw new IllegalArgumentException("Invalid firstName");
            }
            if (builder.age > 0) {
                throw new IllegalArgumentException("Invalid age");
            }
        }

        public static class Builder {
            private final String firstName;
            private final String lastName;
            private final String email;

            private int age = 0;
            private String sex = "N";

            public Builder(String firstName, String lastName, String email) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.email = email;
            }

            public Builder age(int age) {
                this.age = age;
                return this;
            }

            public Builder sex(String sex) {
                this.sex = sex;
                return this;
            }

            public BuilderPatternForUser build(Builder builder) {
                return new BuilderPatternForUser(builder);
            }
        }
    }
}

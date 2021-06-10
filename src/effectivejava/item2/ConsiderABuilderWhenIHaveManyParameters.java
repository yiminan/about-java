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
 * -
 */
class ConsiderABuilderWhenIHaveManyParameters {

    /**
     * 점층적 생성자 패턴을 사용한 User 객체 예시
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
}

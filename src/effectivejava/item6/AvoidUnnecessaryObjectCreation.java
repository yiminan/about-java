package effectivejava.item6;

import java.util.regex.Pattern;

/**
 * "불필요한 객체 생성을 피해야합니다"<p>
 * <p>
 * 똑같은 기능의 객체는 매번 새로 생성하기보다는 재사용하는 편이 나을 때가 많습니다.<p>
 * 1. {@link String}<p>
 * - 생성자로 만드는 것과 리터럴로 선언되는 것이 기능적으로 같습니다.<p>
 * - 다만, Java에서는 리터럴로 새롭게 선언해도 내용이 같으면, String 객체를 재생성하지 않습니다.<p>
 * - 그래서 리터럴로 사용하는 것이 재사용성을 극대화할 수 있습니다.<p>
 * 2. {@link Boolean}<p>
 * - 팩터리 매서드를 만들어서 객체 내부에 미리 생성된 반환 객체를 재사용할 수 있습니다.<p>
 * - 생성자를 사용하면, 객체를 무제한 재생성합니다. 그래서 Boolean의 경우 생성자가 deprecated 되었습니다.<p>
 */
class AvoidUnnecessaryObjectCreation {

    public static void main(String[] args) {
        /**
         * 예시) {@link String}을 생성자와 상수풀에 선언해서 사용하는 방식 차이
         */
        exampleString();
        /**
         * 예시) {@link Boolean}을 생성자와 상수풀에 선언해서 사용하는 방식 차이
         */
        exampleBoolean();
    }

    private static void exampleString() {
        String s1 = new String("example");
        String s2 = new String("example");
        String s3 = "example";
        String s4 = "example";
        System.out.println(String.format("String 생성자 생성 %b", s1 == s2));// false
        System.out.println(String.format("String 상수풀 생성 %b", s3 == s4));// true
    }

    private static void exampleBoolean() {
        Boolean b1 = Boolean.valueOf("true");
        Boolean b2 = Boolean.valueOf("true");
        Boolean b3 = new Boolean("false");
        Boolean b4 = new Boolean("false");
        System.out.println(String.format("Boolean 생성자 생성 %b", b1 == b2));
        System.out.println(String.format("Boolean 정적 팩토리 메서드 생성 %b", b3 == b4));
    }

    /**
     * 생성 비용이 비싼 객체를 로컬 변수로 사용하는 경우
     */
    private static boolean isRomanNumeral(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    private static class RomanNumerals {
        public static final Pattern ROMAN = Pattern.compile(
                "^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$"
        );

        static boolean isRomanNumeral(String s) {
            return ROMAN.matcher(s).matches();
        }
    }
}

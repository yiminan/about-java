package effectivejava.item6;

/**
 * "불필요한 객체 생성을 피해야합니다"<p>
 * <p>
 *
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
}

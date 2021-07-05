package effectivejava.item6;

/**
 * "불필요한 객체 생성을 피해야합니다"<p>
 * <p>
 *
 */
class AvoidUnnecessaryObjectCreation {

    public static void main(String[] args) {
        exampleString();

        exampleBoolean();
    }

    private static void exampleString() {
        String s1 = new String("example");
        String s2 = new String("example");
        String s3 = "example";
        String s4 = "example";
        System.out.println(s1 == s2);// false
        System.out.println(s3 == s4);// true
    }

    private static void exampleBoolean() {
        Boolean b1 = Boolean.valueOf("true");
        Boolean b2 = Boolean.valueOf("true");
        Boolean b3 = new Boolean("false");
        Boolean b4 = new Boolean("false");
        System.out.println(b1 == b2);
        System.out.println(b3 == b4);
    }
}

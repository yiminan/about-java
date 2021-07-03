package effectivejava.item6;

/**
 * "불필요한 객체 생성을 피해야합니다"<p>
 * <p>
 */
class AvoidUnnecessaryObjectCreation {

    public static void main(String[] args) {
        String s1 = new String("example");
        String s2 = new String("example");
        String s3 = "example";
        String s4 = "example";
        System.out.println(s1 == s2);// false
        System.out.println(s3 == s4);// true
    }
}

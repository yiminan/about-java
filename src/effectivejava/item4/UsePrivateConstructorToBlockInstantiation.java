package effectivejava.item4;

/**
 * "클래스 인스턴스화를 막으려면 private 생성자를 사용해야합니다."<p>
 * <p>
 */
class UsePrivateConstructorToBlockInstantiation {

    public static void main(String[] args) {
        try {
            new ExampleUtility();
        } catch (AssertionError ex) {
            System.out.println("인스턴스화가 불가능한 클래스 예외");
        }
    }

    private static class ExampleUtility {
        private ExampleUtility() {
            throw new AssertionError();
        }
    }
}

package effectivejava.item4;

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

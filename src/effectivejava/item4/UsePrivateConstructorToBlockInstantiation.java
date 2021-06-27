package effectivejava.item4;

class UsePrivateConstructorToBlockInstantiation {

    private static class ExampleUtility {
        private ExampleUtility() {
            throw new AssertionError();
        }
    }
}

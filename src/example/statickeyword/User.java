package example.statickeyword;

class User {
    private static int age = 0;

    private User() {
        throw new AssertionError();
    }

    static void growOld() {
        System.out.println(++age);
    }
}

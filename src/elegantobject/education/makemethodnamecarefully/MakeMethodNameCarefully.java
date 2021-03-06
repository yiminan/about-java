package elegantobject.education.makemethodnamecarefully;

class MakeMethodNameCarefully {

    /**
     * Builder Method
     * 반환 타입 : void가 될 수 없다
     * 이름 : 명사
     */
    private interface BuilderMethod {
        int pow(int base, int power);

        float speed();

        Employee employee(int id);

        String parseCell(int x, int y);
    }

    private static class Employee {
    }

    /**
     * Manipulator Method
     * 반환 타입 : void
     * 이름 : 동사
     */
    private interface ManipulatorMethod {
    }
}

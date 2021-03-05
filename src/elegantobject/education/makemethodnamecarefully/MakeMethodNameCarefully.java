package elegantobject.education.makemethodnamecarefully;

class MakeMethodNameCarefully {

    /**
     * Builder Method의 예시입니다.
     * 반환 타입은 void가 될 수 없으며, 항상 이름은 명사이어야합니다.
     */
    interface BuilderMethod {
        int pow(int base, int power);

        float speed();

        Employee employee(int id);

        String parseCell(int x, int y);
    }

    private static class Employee {
    }
}

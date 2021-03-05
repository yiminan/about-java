package elegantobject.education.makemethodnamecarefully;

class MakeMethodNameCarefully {

    interface BuilderMethod {
        int pow(int base, int power);

        float speed();

        Employee employee(int id);

        String parseCell(int x, int y);
    }

    private static class Employee {
    }
}

package elegantobject.education.makemethodnamecarefully;

class MakeMethodNameCarefully {

    public static void main(String[] args) {
        PutOperation putOperation = new PutOperation();
        putOperation.save("content"); // 조정자
        System.out.println(putOperation.success()); // 빌더
    }

    /**
     * Builder Method
     * 반환 타입 : void가 될 수 없다
     * 이름 : 명사 (명사 or 형용사 + 명사)
     */
    private interface BuilderMethod {
        int pow(int base, int power);

        float speed();

        Employee employee(int id);

        String parsedCell(int x, int y);
    }

    private static class Employee {
    }

    /**
     * Manipulator Method
     * 반환 타입 : void
     * 이름 : 동사 (동사 or 부사 + 동사)
     */
    private interface ManipulatorMethod {
        void save(Employee employee);

        void put(String key, String value);

        void remove(Employee employee);

        void quicklyPrint(int id);
    }

    /**
     * Builder & Manipulator Method
     * 잘못된 빌더 + 조정자 역할 메서드
     */
    private interface WrongBuilderManipulatorMethod {
        int save(Employee employee);

        boolean put(String key, String value);

        float speed(float value);
    }

    /**
     * Separated class for Builder & Manipulator Method
     * 잘못된 빌더 + 조정자 역할 메서드를 분리한 클래스
     */
    private static class PutOperation {
        private String content;

        // boolean save(Employee employee)의 조정자로 분리된 메서드
        void save(String content) {
            // 값에 대한 조작
            this.content = content;
        }

        // boolean save(Employee employee)의 빌더로 분리된 메서드
        boolean success() {
            return content != null;
        }
    }
}

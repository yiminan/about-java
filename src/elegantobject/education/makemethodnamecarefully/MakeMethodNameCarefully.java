package elegantobject.education.makemethodnamecarefully;

/**
 * "메서드에는 빌더(Builder)와 조정자(Manipulator)에 맞는 이름을 지정해야합니다."
 * 빌더(Builder)는 어떤 것을 만들고,
 * 조정자(Manipulator)는 뭔가를 조작합니다.
 * <p>
 * 빌더와 조정자의 역할을 같이하는 메서드는 존재해서는 안됩니다.
 * ex 1) 뭔가를 조작하고, 반환하는 메서드
 * ex 2) 뭔가를 생성하고, 동시에 조작하는 메서드
 * 를 만들면 안됩니다.
 * <p>
 * 예를 들면, 빌더처럼 어떤 것을 만들면서 동시에 값도 조작하는 메서드를 이야기합니다.
 * 조정자인데 빌더처럼 반환해야하는 경우는 클래스를 만들어서 빌더 클래스를 구현해서 활용해야합니다.
 * 예시를 통해서 빌더 + 조정자를 풀어서 객체로 사용하는 법을 제시합니다.
 * 방법
 * - 빌더 + 조정자 => 클래스를 생성하고, 빌더와 조정자를 분리 생성
 */
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
package com.example.aboutjava.elegantobject.step2_education.step2_4_makemethodnamecarefully;

/**
 * "메서드는 빌더(Builder)와 조정자(Manipulator)에 따라 적합한 이름을 지어야합니다"<p>
 * <p>
 * 빌더(Builder)는 어떤 것을 만들고,<p>
 * 조정자(Manipulator)는 뭔가를 조작합니다.<p>
 * <p>
 * 빌더 패턴은 빌더와 다릅니다. 유지보수성이 낮고, 응집도가 떨어지는 커다란 객체를 만들도록 조작하기 때문에 안좋습니다.<p>
 * 빌더 패턴을 사용하는 대신 복잡한 객체를 더 작은 객체로 나눠야합니다.<p>
 * <p>
 * 빌더와 조정자의 역할을 같이하는 메서드는 존재해서는 안됩니다.<p>
 * ex 1) 뭔가를 조작하고, 반환하는 메서드<p>
 * ex 2) 뭔가를 생성하고, 동시에 조작하는 메서드<p>
 * 를 만들면 안됩니다.<p>
 * <p>
 * 예를 들면, 빌더처럼 어떤 것을 만들면서 동시에 값도 조작하는 메서드를 이야기합니다.<p>
 * 조정자인데 빌더처럼 반환해야하는 경우는 클래스를 만들어서 빌더 클래스를 구현해서 활용해야합니다.<p>
 * 예시를 통해서 빌더 + 조정자를 풀어서 객체로 사용하는 법을 제시합니다.<p>
 * 방법<p>
 * - 빌더 + 조정자 => 클래스를 생성하고, 빌더와 조정자를 분리 생성<p>
 */
class MakeMethodNameCarefully {

    public static void main(String[] args) {
        PutOperation putOperation = new PutOperation();
        putOperation.save("content"); // 조정자
        System.out.println(putOperation.success()); // 빌더
    }

    /**
     * Builder Method<p>
     * 반환 타입 : void가 될 수 없다<p>
     * 이름 : 명사 (명사 or 형용사 + 명사)<p>
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
     * Manipulator Method<p>
     * 반환 타입 : void<p>
     * 이름 : 동사 (동사 or 부사 + 동사)<p>
     */
    private interface ManipulatorMethod {
        void save(Employee employee);

        void put(String key, String value);

        void remove(Employee employee);

        void quicklyPrint(int id);
    }

    /**
     * Builder & Manipulator Method<p>
     * 잘못된 빌더 + 조정자 역할 메서드<p>
     */
    private interface WrongBuilderManipulatorMethod {
        int save(Employee employee);

        boolean put(String key, String value);

        float speed(float value);
    }

    /**
     * Separated class for Builder & Manipulator Method<p>
     * 잘못된 빌더 + 조정자 역할 메서드를 분리한 클래스<p>
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

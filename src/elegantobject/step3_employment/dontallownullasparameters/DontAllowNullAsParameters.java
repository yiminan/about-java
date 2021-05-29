package elegantobject.step3_employment.dontallownullasparameters;

import java.io.File;
import java.util.Collections;

/**
 * "파라미터로 null을 절대 허용하면 안됩니다"
 * "null 사용"은 "객체의 가변성", "정적 메서드"와 같이 OOP 골칫덩이입니다.
 * 코드 어딘가 null이 존재한다면 잘못된 코드입니다.
 * 이번에는 메서드의 인자값으로 null을 사용하는 경우를 살펴보겠습니다.
 * 메서드의 파라미터를 null을 허용하면 경우의 수가 줄어 메서드를 적게 만들어 효율적이라고 생각하지만,
 * SRP(Single Responsibility Principle)에 위반되고, 메서드 내부 구현 내용이 복잡해집니다.
 * 복잡해진 코드는 메서드의 이름으로 객체의 행동을 판단할 수 없습니다.
 * 파라미터로 null을 전달하면, 내부에서 null check하는 조건문이 있는 경우가 있는데, 완전히 잘못된 구현방법입니다.
 * <p>
 * 애초에 OOP에서는 "null 사용"을 허용하면 안됩니다.
 * 모든 메서드는 파라미터로 null을 허용하지 않고, 메서드 분리를 통해서 구현해야합니다.
 */
class DontAllowNullAsParameters {

    public static void main(String[] args) {
        String mask = "*.txt";

        NullableParameterMethod badCase = new NullableParameterMethod();
        badCase.find(mask);// 특정 파일을 찾는 경우
        badCase.find(null);// 모든 파일을 찾는 경우

        NonNullableParameterMethod goodCase = new NonNullableParameterMethod();
        goodCase.find(mask);// 특정 파일을 찾는 경우
        goodCase.findAll();// 모든 파일을 찾는 경우
    }

    /**
     * Bad
     * 파라미터로 null을 허용하는 적절하게 분리된 메서드
     */
    private static class NullableParameterMethod {
        /**
         * null을 허용하는 잘못된 예시의 메서드입니다.
         */
        public Iterable<File> find(String mask) {
            if (mask == null) {
                /**
                 * findAll()과 같은 기능
                 * 모든 파일을 찾는 경우
                 */
                return Collections.singleton(new File("")); // 실제 반환값은 모든 파일
            } else {
                /**
                 * find(String mask)와 같은 기능
                 * mask를 사용하여 해당하는 파일을 찾는 경우
                 */
                return Collections.singleton(new File("")); // 실제는 특정 mask 파일
            }
        }
    }

    /**
     * Good
     * 파라미터로 null을 허용하지 않는 적절하게 분리된 메서드
     */
    private static class NonNullableParameterMethod {
        public Iterable<File> findAll() {
            /**
             * 모든 File을 찾는 로직
             */
            return Collections.singleton(new File("")); // 실제 반환값은 모든 파일
        }

        public Iterable<File> find(String mask) {
            /**
             * 특정 File을 찾는 로직
             */
            return Collections.singleton(new File("")); // 실제는 특정 mask 파일
        }
    }
}

package elegantobject.step4_retirement.step4_1_neverreturnnull;

import java.io.File;
import java.io.IOException;

/**
 * "절대 null을 반환하지 마세요"<p>
 * <p>
 * 메서드의 파라미터에 null을 전달하는 것은 매우 안좋은 방법입니다.<p>
 * 마찬가지로 메서드가 null을 반환하는 것도 절대 안됩니다.<p>
 * 반환된 객체가 null이면 객체를 사용하면서 NPE가 발생할 수 있기 때문에,<p>
 * 해당 메서드를 신뢰할 수 없습니다. 그래서 null을 반환하면 안됩니다.<p>
 * 객체가 만든 반환 값을 의심하고 결과에 대한 확인 코드가 들어간다면 OOP를 위반하는 일입니다.<p>
 * <p>
 * 객체는 자신만의 생명주기/행동/상태를 가지는 살아있는 유기체입니다.<p>
 * 변수는 객체에게 붙여진 별명입니다. 이 변수가 null이라면 객체는 신뢰가 없어집니다.<p>
 * '객체의 신뢰'라는 것은 객체 스스로 행동에 대해서 전적으로 책임지고, 외부에서 간섭하지 않는 것입니다.<p>
 * 반환값을 검사하는 것은 객체에 대한 신뢰가 없다는 말입니다. 나중에 유지보수성이 크게 낮아집니다.<p>
 * 프로그램 코드는 다른 프로그래머가 유지보수를 할 때,<p>
 * null이 발생할 여지가 생기면 코드에 신뢰성이 떨어지니까 애초에 신뢰성이 떨어지지 않게 해야합니다.<p>
 * <p>
 * 빠르게 실패하기가 지켜지면 에러를 발견하고 즉시 보고하는 경우에만 안전성과 견고함을 얻을 수 있습니다.<p>
 * 더 빠르게 문제를 찾을수록 더 빠르게 실패하고, 결과적으로 전체적인 품질이 향상됩니다.<p>
 * 반대로 더 오래 숨길수록 문제는 더 커집니다.<p>
 * <p>
 * 빠르게 실패하면 소프트웨어가 멈추기 때문에 잘못되었다고 생각할 수 있습니다.<p>
 * 그래서 실패를 안전하게 하면 소프트웨어가 더 고가용성이 있다고 착각할 수 있습니다.<p>
 * 빠르게 실패해야하는 이유는 소프트웨어 안에 버그가 숨어있다가 소프트웨어를 망칠 수 있기 때문에,<p>
 * 버그를 빠르게 찾고 빠르게 수정하면, 더 빠른 유지보수가 가능합니다.<p>
 * 결국에는 소프트웨어를 안정적이고 견고하게 만들 수 있습니다.<p>
 */
class NeverReturnNull {

    private static class Data {
        private String title;

        public Data(String title) {
            this.title = title;
        }

        /**
         * null을 반환하는 잘못된 메서드 형태입니다.<p>
         * null이 반환되기 시작하면 이후에 title을 가지고 호출될 메서드가 NPE을 발생할 여지가 생깁니다.<p>
         * 결국 이 메서드가 반환하는 객체 String은 신뢰할 수 없습니다.<p>
         */
        public String title() {
            if (title == null || title.isBlank()) {
                return null;
            }
            return title;
        }

        /**
         * null을 반환하는 대신 예외로 처리하는 것에 대한 올바른 예시이다.<p>
         * '빠르게 실패하기 원칙(fail fast principle)'을 적용하지 못한 정책이 null을 반환하는 것이었습니다.<p>
         * 결론적으로 null을 반환하는 것은 잘못된 사용 형태입니다.<p>
         * 차라리 빠르게 실패하는 것이 이후에 치루어야할 비용을 줄일 수 있습니다.<p>
         */
        public void list(File dir) throws IOException {
            File[] files = dir.listFiles();
            if (files == null) {
                // JDK는 return null; 구현한다. 하지만 잘못된 사용이다.
                throw new IOException("Directory is absent.");
            }
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }
}

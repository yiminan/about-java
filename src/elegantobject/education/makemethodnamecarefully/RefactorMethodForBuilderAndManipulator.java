package elegantobject.education.makemethodnamecarefully;

import java.io.IOException;
import java.io.InputStream;
class RefactorMethodForBuilderAndManipulator {

    /**
     * 잘못 사용된 빌더 + 조정자 메서드
     * 메서드 하나에서 많은 작업을 하게되니 반환 값이 있는 조정자가 됩니다.
     * 조정자를 잘못된 사용법으로 사용하고 있습니다.
     */
    private static class WrongDocument {
        private InputStream content;

        int write(InputStream content) throws IOException {
            this.content = content;
            return content.read();
        }
    }

    /**
     * OutputPipe를 만들어서 빌더 메서드를 사용할 수 있습니다.
     * 빌더와 조정자를 분리하는데에 OutputPipe이 객체가 사용됩니다.
     */
    private static class ProperDocument {
        private final OutputPipe outputPipe;

        ProperDocument(InputStream outputPipe) {
            this.outputPipe = new OutputPipe(outputPipe);
        }

        OutputPipe output() {
            return outputPipe;
        }
    }

    /**
     * 객체로 개념을 작게 고립시켜서 유지보수성을 높게하고, 복잡성을 낮춥니다.
     */
    private static class OutputPipe {
        private InputStream content;

        OutputPipe(InputStream content) {
            write(content);
        }

        /**
         * 본연의 목적을 가진 조정자 메서드 분리 완료
         */
        void write(InputStream content) {
            this.content = content;
        }

        /**
         * 본연의 목적을 가진 빌더 메서드 분리 완료
         */
        int bytes() throws IOException {
            return content.read();
        }
    }
}

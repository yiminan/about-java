package elegantobject.retirement.useraii;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * "리소스 획득이 초기화(Resource Acquisition Is Initialization, RAII)을 사용해야합니다"<p>
 * <p>
 * RAII는 C++에 존재하는 강력한 기법이지만, Java에서는 GC로 사라진 개념입니다.<p>
 * Java에서도 RAII를 모방할 수 있지만, C++의 처리 방식이 훨씬 더 깔끔합니다.<p>
 * C++에서는 생성자가 객체를 생성하고 마지막에는 파괴자를 통해서 객체의 자원을 반납합니다.<p>
 * 객체라는 리소스가 살아있어야하는 시점은 객체가 사용되어 필요한 시점으로 강제해야합니다.<p>
 * 결론)<p>
 * 파일, 스트림, 데이터베이스 커넥션 등 실제 리소스를 사용하는 모든 곳에서 RAII를 사용할 것을 적극 추천합니다.
 */
class UseRAII {

    /**
     * AutoCloseable 인터페이스를 이용한 향상시킨 예외 처리
     */
    private static class Text implements AutoCloseable {
        private final File file;

        public Text(File file) {
            this.file = file;
        }

        @Override
        public void close() {
            this.file.deleteOnExit();
        }

        public byte[] content() throws IOException {
            return new FileInputStream(file).readAllBytes();
        }
    }

    /**
     * example1과 example2는 같은 로직입니다.<p>
     * 다만 Java7부터 지원하는 Closable을 구현한 코드가 example1입니다.
     */
    private static class TextFile {
        private final File file;

        public TextFile(File file) {
            this.file = file;
        }

        public byte[] example1() throws Exception {
            try (Text text = new Text(file)) {
                return text.content();
            } catch (IOException ex) {
                throw new Exception(ex);
            }
        }

        public byte[] example2() throws Exception {
            Text text = null;
            try {
                text = new Text(file);
                return text.content();
            } catch (IOException ex) {
                throw new Exception(ex);
            } finally {
                if (text != null) {
                    text.close();
                }
            }
        }
    }
}

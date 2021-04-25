package elegantobject.retirement.useraii;

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

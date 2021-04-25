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
}

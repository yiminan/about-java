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
}

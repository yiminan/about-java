package elegantobject.retirement.finalorabstract;

class FinalOrAbstract {

    private static class Document {
        private final File file;

        public Document(File file) {
            this.file = file;
        }

        public int length() {
            try {
                return this.content().length;
            } catch (Exception ex) {
                return 0;
            }
        }

        public byte[] content() throws Exception {
            try {
                return new FileInputStream(file).readAllBytes();
            } catch (IOException ex) {
                throw new Exception(ex);
            }
        }
    }

    /**
     * description)<p>
     * 이 EncryptedDocument에서는 Document를 상속받고 있는데,<p>
     * 여기서 문제는 EncryptedDocument로 지정된 file 생성자를 통해서 초기화되었는데,<p>
     * 오버라이딩된 content를 호출하게되면 EncryptedDocument의 length가 호출되어야하는데,<p>
     * 복호화된 Document의 길이에 대한 결과가 반환됩니다.<p>
     * 여기서 문제는 content는 오버라이딩으로 어찌 넘어갔는데, length는 오버라이딩되지 않았기때문입니다.<p>
     * 큰 문제가 발생하게 된 것입니다. 여기서 직관적으로 문제가 있습니다.<p>
     * 부모의 코드에 자식이 접근이 가능하기 때문에 부모와 자식이 구분이 안가는 클래스가 됩니다.<p>
     * 상속이 OOP의 도구에서 유지보수성의 골칫거리가 되는 지점이 이 지점입니다.<p>
     * <p>
     * solution)<p>
     * - 클래스와 메서드를 'final or abstract' 둘 중 하나로만 제한한다면 문제가 발생하지 않습니다.<p>
     * <p>
     * 기본적으로 클래스가 가질 수 있는 신분에는 세 가지가 있습니다.<p>
     * 1. final // 사용자 관점에서 'black box', 상속 불가능, 독립적, 오버라이딩 불가능<p>
     * 2. abstract // 사용자 관점에서 'glass box', 아직 클래스가 아님, 오버라이딩 할 수 있지만 모두 final하다.<p>
     * 3. final or abstract 둘 다 아님 // 'black box'도 'glass box'도 아닌 사용하면 안되는 상태<p>
     */
    private static class EncryptedDocument extends Document {

        public EncryptedDocument(File file) {
            super(file);
        }

        @Override
        public byte[] content() throws Exception {
            // 로직 재정의가 가능하다.
            return super.content();
        }
    }
}

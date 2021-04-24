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

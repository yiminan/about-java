package elegantobject.retirement.finalorabstract;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

class GoodFinalAbstractClassOrMethod {

    private static final class DocumentWithFinal {
        private final File file;

        public DocumentWithFinal(File file) {
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

    private interface DocumentWithInterface {
        int length();

        byte[] content() throws Exception;
    }

    private static final class DefaultDocument implements DocumentWithInterface {
        private final File file;

        public DefaultDocument(File file) {
            this.file = file;
        }

        @Override
        public int length() {
            try {
                return this.content().length;
            } catch (Exception ex) {
                return 0;
            }
        }

        @Override
        public byte[] content() throws Exception {
            try {
                return new FileInputStream(file).readAllBytes();
            } catch (IOException ex) {
                throw new Exception(ex);
            }
        }
    }

    private static final class EncryptedDocument implements DocumentWithInterface {
        private final DocumentWithInterface plain;

        public EncryptedDocument(DocumentWithInterface plain) {
            this.plain = plain;
        }

        @Override
        public int length() {
            return plain.length();
        }

        @Override
        public byte[] content() throws Exception {
            byte[] raw = this.plain.content();
            return raw;// Content.decrypt(raw); 이 지점에서 복호화된 content를 반환한다.
        }
    }
}

package elegantobject.retirement.finalorabstract;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

class GoodFinalClassOrMethodWithAbstractClass {

    /**
     * abstract class 예시
     */
    private static abstract class Document {
        public final int length() {
            try {
                return this.content().length;
            } catch (Exception ex) {
                return 0;
            }
        }

        public abstract byte[] content() throws Exception;
    }

    /**
     * Document를 상속해서 사용하므로써 오버라이딩이 가능한 content()와 상속한 length()를 사용 가능
     */
    private static final class DefaultDocument extends Document {
        private final File file;

        public DefaultDocument(File file) {
            this.file = file;
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

    /**
     * Document를 상속해서 사용하므로써 오버라이딩이 가능한 content()와 상속한 length()를 사용 가능
     */
    private static final class EncryptedDocument extends Document {
        private final Document plain;

        public EncryptedDocument(Document plain) {
            this.plain = plain;
        }

        @Override
        public byte[] content() throws Exception {
            byte[] raw = this.plain.content();
            return raw;// Content.decrypt(raw); 이 지점에서 복호화된 content를 반환한다.
        }
    }
}

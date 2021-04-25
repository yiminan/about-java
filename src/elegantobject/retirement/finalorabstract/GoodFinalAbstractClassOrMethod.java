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
}

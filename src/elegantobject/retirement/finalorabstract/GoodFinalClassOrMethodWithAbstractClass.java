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
}

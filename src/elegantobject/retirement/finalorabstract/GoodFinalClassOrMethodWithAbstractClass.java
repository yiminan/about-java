package elegantobject.retirement.finalorabstract;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * "상속의 문제를 없애면서 상속을 활용할 수 있는 abstract class"<p>
 * <p>
 * 1) '상속해서 사용하지만 수정할 수 없는 메서드' // final class의 상속 불가능 보완<p>
 * 2) '오버라이드로 내용을 정의해야하는 메서드' // class 상속의 장점<p>
 * 두 가지를 다 사용할 수 있다.<p>
 * 결론)<p>
 * final class의 단점인 상속 불가능을 필요한 경우 상속 가능으로 바꾸어주고,<p>
 * 상속하면 발생하는 부모 클래스의 코드를 자식 클래스에서 오버라이딩으로 수정하므로써 생기는 문제점을,<p>
 * abstract 메서드 선언으로 수정 가능한 메서드를 지정하므로써 문제가 발생하지 않게 합니다.
 */
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

package elegantobject.retirement.finalorabstract;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * "final class는 상속이 안되기 때문에 interface를 사용해서 해결해보는 예시"<p>
 * <p>
 * final class를 만들면, 블랙박스로 만들어서 상속에서 발생할 수 있는 문제에 대해서 유지보수성이 뛰어납니다.<p>
 * final 사용이 유지보수성에 좋은 이유는 상속 불가입니다. 애초에 상속이 발생시킬 문제의 원인을 없애버립니다.<p>
 * 이 과정에서 상속 과정에서 상속받은 자식 클래스에서 부모 클래스의 소스를 수정할 여지 자체가 없어져버린 것입니다.<p>
 * 하지만 문제가 있습니다. final class는 상속을 전혀 사용할 수 없는 것입니다.<p>
 * 그래서 상속하지 못하는 문제를 해결하기 위해서 interface를 사용합니다.<p>
 */
class GoodFinalClassOrMethodWithInterface {

    /**
     * 상속할 수 없는 블랙박스인 final class 예시
     */
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

    /**
     * final class의 상속하지 못하는 문제를 해결하기 위해 캡슐화를 위한 interface 예시
     */
    private interface DocumentWithInterface {
        int length();

        byte[] content() throws Exception;
    }

    /**
     * 상속의 문제를 해결하기 위한 interface 사용<p>
     * 필요한 시점에 부모 클래스 상속을 대신해서 오버라이딩으로 캡슐화해서 사용합니다.<p>
     * 부모의 소스를 수정할 여지가 사라집니다.<p>
     * 그리고 final class로 상속 여지를 다시 한 번 없애주면 완전히 확장이 불가능합니다.<p>
     * 즉, 상속의 문제를 제거하고 final class의 블랙박스로써 독립적인 class로도 인정됩니다.
     */
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

    /**
     * 상속의 문제를 제거한 예시<p>
     * 필요할 떄, interface를 구현하고 final class로 확장을 막아서 사용할 수 있습니다.
     */
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

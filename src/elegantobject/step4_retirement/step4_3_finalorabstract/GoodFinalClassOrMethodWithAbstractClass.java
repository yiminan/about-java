package elegantobject.step4_retirement.step4_3_finalorabstract;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * "상속의 문제를 없애면서 상속을 활용할 수 있는 abstract class"<p>
 * <p>
 * 모든 클래스를 final이나 abstract로 만든다면 상속을 사용할 일이 거의 없습니다.<p>
 * <p>
 * 그러면 상속이 적절한 경우는 언제인가?<p>
 * - 클래스의 행동을 확장(extend)하지 않고, 정제(refine)할 때입니다.<p>
 * - 확장(extend)? 새로운 행동을 추가해서 기존의 행동을 부분적으로 보완하는 일<p>
 * - 정제(refine)? 부분적으로 불완전한 행동을 완전하게 만드는 일<p>
 * 확장이 아닌 정제를 사용할 수 있는 경우가 상속이 필요한 시점입니다.<p>
 * <p>
 * 아래 예시들은 abstract를 사용해서 정제(refine)을 하는 작업입니다.<p>
 * 1) '상속해서 사용하지만 수정할 수 없는 메서드' // final class의 상속 불가능 보완<p>
 * 2) '오버라이드로 내용을 정의해야하는 메서드' // class 상속의 장점<p>
 * 두 가지를 다 사용할 수 있다.<p>
 * <p>
 * 결론)<p>
 * final class의 단점인 상속 불가능을 필요한 경우 상속 가능으로 바꾸어주고,<p>
 * 상속하면 발생하는 부모 클래스의 코드를 자식 클래스에서 오버라이딩으로 수정하므로써 생기는 문제점을,<p>
 * abstract 메서드 선언으로 수정 가능한 메서드를 지정하므로써 문제가 발생하지 않게 합니다.
 * <p>
 * Java를 비롯한 많은 언어에서 final, abstract 어느 쪽도 해당하지 않는 클래스와 메서드를 허용하는 것은 실수입니다.<p>
 * 우리는 클래스와 메서드의 설계 의도를 명확하게 표현해야합니다.
 */
class GoodFinalClassOrMethodWithAbstractClass {

    /**
     * abstract class 예시
     */
    private static abstract class Document {
        // 상속하여 사용하는 메서드, 재정의가 불가능해서 상속의 단점에 해당하지 않는 부분
        public final int length() {
            try {
                return this.content().length;
            } catch (Exception ex) {
                return 0;
            }
        }

        // 정제(refine)하는 메서드
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

package elegantobject.retirement.doalwayschainingexception;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

class DoAlwaysChainingException {

    /**
     * 다음 메서드는 '예외 되던지기(rethrowing)' 예시입니다.<p>
     */
    public int length(File file) throws Exception {
        try {
            return content(file).length;
        } catch (IOException ex) {
            // IOException을 잡은 후, 다시 Exception이라는 큰 비눗방울로 되던지는 작업
            throw new Exception("", ex);
        }
    }

    public byte[] content(File file) throws IOException {
        byte[] array = new byte[1000];
        new FileInputStream(file).read(array);
        return array;
    }
}

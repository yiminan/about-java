package elegantobject.step4_retirement.throwonlycheckedexception;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * "항상 예외를 체이닝해야합니다"<p>
 * 예외 되던지기를 사용해서 발생할 수 있는 여러 예외 종류를 하나의 큰 예외로 보이게 해야합니다.<p>
 * '예외 되던지기'란? 예외를 내부에서 잡아서, 새로운 예외로 다시 던지는 것<p>
 * try catch 문에서 catch를 이용하면 문제를 발생시켰던 낮은 수준의 근본 원인을 소프트웨어의 높은 수준으로 올릴 수 있습니다.<p>
 * 발생한 예외 객체를 반드시 예외 되던지기를 하는 예외에 담아서 보내줘야합니다.<p>
 * 항상 예외를 체이닝하고 절대로 원래 예외를 무시하지 말아야합니다.<p>
 * 각각의 메서드는 발생할 수 있는 모든 예외를 잡은 후, 예외를 체이닝해서 다시 던져야합니다.<p>
 *
 */
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

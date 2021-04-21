package elegantobject.retirement.throwonlycheckedexception;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * "체크된 예외(checked exception)만 던져야 합니다"
 * 대부분의 객체지향 언어들은 언체크 예외만 제공하지만,
 * Java는 두 종류(checked or unchecked exception)의 예외를 모두 제공합니다.
 * Ruby, C#, Python, Scala를 포함한 대부분의 언어들은 언체크 예외만 사용할 수 있습니다.
 */
class ThrowOnlyCheckedException {

    /**
     * 체크된 예외를 사용해서 구현된 메서드
     * 체크된 예외를 사용한 경우)
     * - 메서드 시그니처의 마지막에 throws 'unchecked exception'을 넣습니다.
     * - try ~ catch 문으로 처리하지 않으면, 메서드를 호출한 상위 레벨로 예외가 전파(escalating)됩니다.
     */
    public byte[] content(File file) throws IOException {
        byte[] array = new byte[1000];
        new FileInputStream(file).read(array);
        return array;
    }
}

package com.example.aboutjava.elegantobject.step4_retirement.step4_2_throwonlycheckedexception;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * "체크된 예외(checked exception)만 던져야 합니다"<p>
 * <p>
 * 대부분의 객체지향 언어들은 언체크 예외만 제공하지만,<p>
 * Java는 두 종류(checked or unchecked exception)의 예외를 모두 제공합니다.<p>
 * Ruby, C#, Python, Scala를 포함한 대부분의 언어들은 언체크 예외만 사용할 수 있습니다.<p>
 * <p>
 * 메서드를 설계할 때,<p>
 * 1. 모든 예외를 잡아서 안전한 메서드를 만들지 (fail safe)<p>
 * 2. 상위로 문제를 전파할지 (fail fast가 가능)<p>
 * 를 명확하게 선택해야 합니다.<p>
 * 가능하면 상위 레벨로 예외를 전파하는 것이 좋습니다.<p>
 */
class ThrowOnlyCheckedException {

    /**
     * 체크된 예외를 사용해서 구현된 메서드<p>
     * 체크된 예외를 사용한 경우)<p>
     * - 메서드 시그니처의 마지막에 throws 'unchecked exception'을 넣습니다.<p>
     * - try ~ catch 문으로 처리하지 않으면, 메서드를 호출한 상위 레벨로 예외가 전파(escalating)됩니다.<p>
     */
    public byte[] content(File file) throws IOException {
        byte[] array = new byte[1000];
        new FileInputStream(file).read(array);
        return array;
    }

    /**
     * 체크된 예외와 언체크 예외로 구현된 메서드<p>
     * - 언체크 예외는 메서드 시그니처 옆에 예외를 선언하지 않습니다.<p>
     */
    public int length(File file) throws IOException {
        if (!file.exists()) {
            throw new IllegalArgumentException(
                    "File doesn't exist."
            );
        }
        return content(file).length;
    }

    /**
     * 예외를 try ~ catch로 잡아서 실패를 안전하게 처리합니다.<p>
     * 하지만, 분명 실패한 부분을 인식하고 수정이 필요한데 소프트웨어는 이상없이 잘돌아갑니다.<p>
     * 결국 신뢰할 수 없는 메서드가 됩니다.<p>
     * 예외를 되도록 잡아서 안전하게 실패하기를 기반으로 처리하면 안됩니다.<p>
     */
    public int length2(File file) {
        try {
            return content(file).length;
        } catch (IOException ex) {
            return 0;
        }
    }
}

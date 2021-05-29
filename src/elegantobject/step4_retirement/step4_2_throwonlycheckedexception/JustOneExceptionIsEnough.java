package elegantobject.step4_retirement.step4_2_throwonlycheckedexception;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * "하나의 예외 타입만으로도 충분합니다"<p>
 * <p>
 * '절대 복구하지 않기'와 '항상 체이닝하기'에서 설명한 내용에 동의한다면,<p>
 * 예외 타입이 중복기능(redundant feature)인 이유를 이해할 수 있습니다.<p>
 * 예외는 다시 던지기 위해서만 잡습니다. 그렇기때문에 예외의 실제 타입에 대해서는 신경 쓸 필요가 없습니다.<p>
 * 예외가 상위로 전파되는 도중에는 예외를 잡을 일이 없습니다.<p>
 * 예외는 반드시 예외를 체이닝한 후 다시 던지기 위해서입니다.
 */
class JustOneExceptionIsEnough {

    public void example() {
        try {
            fileInputStream("a.jpg");
            age("12");
        } catch (Exception ex) {
            System.out.println(String.format("example message: %s", ex.getMessage()));
        }
    }

    private FileInputStream fileInputStream(String fileName) throws Exception {
        try {
            return new FileInputStream(fileName);
        } catch (IOException ex) {
            throw new Exception(String.format("This file(%s) can't open to stream.", fileName));
        }
    }

    private int age(String age) throws Exception {
        try {
            return Integer.parseInt(age);
        } catch (NumberFormatException ex) {
            throw new Exception(String.format("Invalid age %s", age));
        }
    }

}

package elegantobject.step4_retirement.throwonlycheckedexception;

/**
 * "예외 후 복구는 단 한 번만 해야합니다"<p>
 * <p>
 * 예외 후, '복구(recovering)'는 '빠르게 실패하기'와 '안전하게 실패하기' 사이 충돌을 다른 각도에서 바라본 것입니다.<p>
 * '빠르게 실패하가'에서는 복구라는 개념 자체가 존재하지 않습니다.<p>
 * 예외 후 복구는 '흐름 제어를 위한 예외 사용(using exceptions for flow control)'이라는 안티패턴과 같습니다.<p>
 * 예외를 복구하는 해서 사용하는 것은 null을 반환하는 안티패턴과 유사합니다.<p>
 * 무조건 예외를 잡아서는 안된다는 주장은 옳지 않습니다. 딱 한 번은 복구해야합니다.<p>
 * 복구를 해야하는 한 번의 지점은 되도록 다른 소스에 영향을 미치지 않는 최상위 수준에서 복구하는 것이 좋습니다.<p>
 * <p>
 * 결론)<p>
 * 되도록이면 '항상 예외를 잡고, 체이닝하고, 다시 던진다. 그리고 최상위 수준 복구 지점에서 한 번만 복구한다'가 가장 좋은 방법입니다.
 */
class RecoveryJustOneTimeAfterException {

    /**
     * 예외 후, 복구 예시<p>
     */
    public int age(String text) {
        int age;
        try {
            age = parsedInteger(text);
        } catch (Exception ex) {
            age = -1;// 예외 후, 최상위 수준 복구 지점에서 복구 예시
        }
        return age;
    }

    private int parsedInteger(String text) throws Exception {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException ex) {
            throw new Exception(ex);
        }
    }
}

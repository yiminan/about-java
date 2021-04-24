package elegantobject.retirement.throwonlycheckedexception;

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

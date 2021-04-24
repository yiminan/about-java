package elegantobject.retirement.throwonlycheckedexception;

class RecoveryJustOneTimeAfterException {

    private int parsedInteger(String text) throws Exception {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException ex) {
            throw new Exception(ex);
        }
    }
}

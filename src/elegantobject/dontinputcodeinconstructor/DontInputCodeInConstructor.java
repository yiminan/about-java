package elegantobject.dontinputcodeinconstructor;

public class DontInputCodeInConstructor {
    static class InvalidCash {
        private final int dollars;

        public InvalidCash(String dollars) {
            this.dollars = Integer.parseInt(dollars);
        }
    }
}

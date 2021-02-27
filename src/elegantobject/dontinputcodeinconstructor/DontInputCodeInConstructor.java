package elegantobject.dontinputcodeinconstructor;

public class DontInputCodeInConstructor {
    static class InvalidCash {
        private final int dollars;

        public InvalidCash(String dollars) {
            this.dollars = Integer.parseInt(dollars);
        }
    }

    static class ValidCash {
        private final Number dollars;

        public ValidCash(String dollars) {
            this.dollars = new StringAsInteger(dollars);
        }

        interface Number {
            int intValue();
        }
    }

    static class StringAsInteger implements ValidCash.Number {

        private final String source;

        public StringAsInteger(String source) {
            this.source = source;
        }

        @Override
        public int intValue() {
            return Integer.parseInt(this.source);
        }
    }
}

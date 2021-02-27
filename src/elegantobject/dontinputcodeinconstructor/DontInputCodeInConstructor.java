package elegantobject.dontinputcodeinconstructor;

public class DontInputCodeInConstructor {
    static class InvalidCash {
        private final int dollars;

        // 값이 바로 변환되어 셋팅되는 생성자
        public InvalidCash(String dollars) {
            this.dollars = Integer.parseInt(dollars);
        }

        public int getDollars() {
            return dollars;
        }
    }

    static class ValidCash {
        private final Number dollars;

        // 생성자는 값을 셋팅만 하고, 필요한 시점에 변환해서 가져와서 사용한다.
        // 부 생성자
        public ValidCash(String dollars) {
            this(new StringAsInteger(dollars));
        }

        // 주 생성자
        public ValidCash(Number dollars) {
            this.dollars = dollars;
        }

        }
    }

    interface Number {
        int intValue();
    }

    static class StringAsInteger implements Number {

        private final String source;

        public StringAsInteger(String source) {
            this.source = source;
        }

        // 필요한 시점에 source를 변환해서 사용한다.
        @Override
        public int intValue() {
            return Integer.parseInt(this.source);
        }
    }
}

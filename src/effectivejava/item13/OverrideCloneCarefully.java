package effectivejava.item13;

/**
 * "clone 재정의는 주의해서 진행하라."<p>
 */
class OverrideCloneCarefully {

    private static final class PhoneNumber {
        private final String number;

        public PhoneNumber(String number) {
            this.number = number;
        }

        @Override
        public String toString() {
            return "PhoneNumber{" +
                    "number='" + number + '\'' +
                    '}';
        }
    }
}

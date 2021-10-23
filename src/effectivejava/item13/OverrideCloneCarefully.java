package effectivejava.item13;

/**
 * "clone 재정의는 주의해서 진행하라."<p>
 */
class OverrideCloneCarefully {

    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber("010-1234-5678");
        PhoneNumber copyPhoneNumber = (PhoneNumber) phoneNumber.clone();
        System.out.println(copyPhoneNumber);
    }

    private static final class PhoneNumber implements Cloneable {
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

        @Override
        protected Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }
}

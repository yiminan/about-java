package elegantobject.education.donotusepublicconstant;

class DoNotUsePublicConstant {

    /**
     * 이 퍼블릭 상수를 사용하는 모든 객체의 결합도는 높아지고, 응집도는 낮아집니다.
     */
    private static class WrongPublicConstant {
        public static final String EOL = "\r\n";
    }

    private static class WrongExampleCar {
        void print() {
            System.out.println("This is car." + WrongPublicConstant.EOL);
        }
    }

    private static class WrongExampleBus {
        void print() {
            System.out.println("This is bus." + WrongPublicConstant.EOL);
        }
    }

    /**
     * 여기까지 위 예시는 퍼블릭 상수를 하나 사용하면서 코드의 중복도는 낮추었지만,
     * 높은 결합도와 낮은 응집도를 구현하고 있습니다. 잘못된 구현입니다.
     * <p>
     * 여기서 부터는 객체를 이용해서 잘 구현된 퍼블릭 상수의 리팩토링 예시입니다.
     */

    private static class GoodPrivateConstant {
        private static final String EOL_FORMAT = "%s" + "\r\n";

        private final String origin;

        GoodPrivateConstant(String origin) {
            this.origin = origin;
        }

        @Override
        public String toString() {
            return String.format(EOL_FORMAT, origin);
        }
    }

    private static class GoodExampleCar {
        void print() {
            System.out.println(new GoodPrivateConstant("This is car."));
        }
    }

    private static class GoodExampleBus {
        void print() {
            System.out.println(new GoodPrivateConstant("This is bus."));
        }
    }
}

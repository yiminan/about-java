package elegantobject.step2_education.donotusepublicconstant;

/**
 * "퍼블릭 상수(Public Constant)를 사용하지 않습니다"<p>
 * <p>
 * 객체들은 내부의 어떤 것도 공유해서는 안됩니다. 독립적이고, 닫혀(cloded)있어야 합니다.<p>
 * 'public static final' 프로퍼티는 객체 사이에 데이터를 공유하기 좋습니다.<p>
 * 결국 퍼블릭 상수는 다른 객체와 내부 내용을 공유하는 용도로 사용되어지게 됩니다.<p>
 * 퍼블릭 상수를 공유하면서 코드 중복이라는 문제는 잡았지만,<p>
 * 결합도(coupling)이 높아지고, 응집도(cohesion)이 낮아지게 됩니다.<p>
 * OOP와 역행하는 방향입니다.<p>
 * <p>
 * 애초에 퍼블릭 상수(Public Constant)를 만들면 안됩니다.<p>
 * 해결책은 상수라는 데이터를 공유하지 말고, 새로운 클래스 객체를 만들어서 기능을 공유해야합니다.<p>
 * 기능을 공유하는 객체는 계약(contract)를 통해 추가된 것이며,<p>
 * 계약에 따라 행동하며 내부에 계약의 의미를 캡슐화합니다.<p>
 * 결합된 계약은 언제는 분리가 가능하기에 유지보수성이 높습니다.<p>
 * <p>
 * 결론)<p>
 * - 클래스의 퍼블릭 상수를 다른 클래스에게 공유하면 안됩니다.<p>
 * - Enum 클래스도 퍼블릭 상수로 사용하면 안됩니다. 결국 Enum 클래스도 내부 상수를 외부로 공유하면 안됩니다.<p>
 */
class DoNotUsePublicConstant {

    public static void main(String[] args) {
        // 잘못 구현된 퍼블릭 상수를 사용한 객체의 메서드 호출
        WrongExampleBus wrongExampleBus = new WrongExampleBus();
        WrongExampleCar wrongExampleCar = new WrongExampleCar();
        wrongExampleBus.print();// This is bus.
        wrongExampleCar.print();// This is car.

        // 잘 구현된 퍼블릭 상수를 사용한 객체의 메서드 호출
        GoodExampleBus goodExampleBus = new GoodExampleBus();
        GoodExampleCar goodExampleCar = new GoodExampleCar();
        goodExampleBus.print();// This is bus.
        goodExampleCar.print();// This is car.
    }

    /**
     * 이 퍼블릭 상수를 사용하는 모든 객체의 결합도는 높아지고, 응집도는 낮아집니다.<p>
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
     * 여기까지 위 예시는 퍼블릭 상수를 하나 사용하면서 코드의 중복도는 낮추었지만,<p>
     * 높은 결합도와 낮은 응집도를 구현하고 있습니다. 잘못된 구현입니다.<p>
     * <p>
     * 여기서 부터는 객체를 이용해서 잘 구현된 퍼블릭 상수의 리팩토링 예시입니다.<p>
     */

    private static class GoodPrivateConstant {
        // 다음과 같이 내부 프라이빗 상수를 선언하고, 객체가 랩핑해서 상수를 대체하는 기능으로 사용합니다.
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

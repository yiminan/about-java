package elegantobject.step3_employment.step3_2_dontusestaticmethod;

/**
 * "객체 대 컴퓨터 사고(object vs computer thinking)<p>
 * <p>
 * 컴퓨터는 우리가 명령어를 제공해줄 것을 기대하고, 우리가 제공한 명령어를 하나씩 순차적으로 실행합니다.<p>
 * 순차적으로 실행하는 작업의 장점은 프로그래머가 CPU가 명령어를 실행하는 방식처럼 작업을 지시할 수 있습니다.<p>
 * 이런 '순차적인(sequential) 사고 방식'을 'computer thinking'이라고 합니다.<p>
 * 이 순차적인 사고방식이 작은 프로그램에서는 문제가 없지만, 프로그램이 커지면 큰 문제점이 됩니다.<p>
 * 즉, 코드 간 시간적 결합도가 생기면서 유지보수에 큰 장애가 되기 때문입니다.<p>
 * <p>
 * '함수형, 논리형, 객체지향형 프로그래밍'이 '순차적인(절차적인) 프로그래밍'과 차별되는 점이 바로 'is a'입니다.<p>
 * 만약 순차적으로 프로그래밍을 하게되면 명령의 실행 흐름을 제어하는 것을 생각해야합니다.<p>
 * 하지만 객체지향 프로그래밍에서는 그저 객체만 정의하고 객체들이 필요할 때 스스로 상호작용하도록 제어를 위임합니다.<p>
 */
class ObjectVsComputerThinking {

    public static void main(String[] args) {
        /**
         * "잘못된 방식"<p>
         * 명령형 스타일로 컴퓨터 CPU에게 직접적으로 계산을 지시한다.<p>
         */
        int maxNumber = Math.max(5, 9);
        /**
         * "잘 사용된 방식"<p>
         * 선언형 스타일로 CPU에게 명령하지 않고 객체를 이용하여 값의 선언만 진행한다.<p>
         * 객체는 일단 생성이 되고 원하는 시점에 필요한 로직에 대한 권한을 위임받아서 사용합니다.<p>
         */
        Number max = new Max(new Integer(5), new Integer(9));
    }

    private static class Math {
        public static int max(int a, int b) {
            if (a > b) {
                return a;
            }
            return b;
        }
    }

    private static class Max implements Number {
        private final Number a;
        private final Number b;

        public Max(Number a, Number b) {
            this.a = a;
            this.b = b;
        }
    }

    private static class Integer implements Number {
        private final int value;

        public Integer(int value) {
            this.value = value;
        }
    }

    private interface Number {
    }
}

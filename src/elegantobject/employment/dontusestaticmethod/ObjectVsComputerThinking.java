package elegantobject.employment.dontusestaticmethod;

class ObjectVsComputerThinking {

    public static void main(String[] args) {
        // 명령형 스타일로 컴퓨터 CPU에게 직접적으로 계산을 지시한다.
        int maxNumber = Math.max(5, 9);
        // 선언형 스타일로 CPU에게 명령하지 않고 객체를 이용하여 값의 선언만 진행한다.
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

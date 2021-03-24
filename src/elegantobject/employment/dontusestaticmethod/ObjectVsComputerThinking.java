package elegantobject.employment.dontusestaticmethod;

class ObjectVsComputerThinking {
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

package elegantobject.employment.dontusestaticmethod;

class ObjectVsComputerThinking {
    private static class Integer implements Number {
        private final int value;

        public Integer(int value) {
            this.value = value;
        }
    }

    private interface Number {
    }
}

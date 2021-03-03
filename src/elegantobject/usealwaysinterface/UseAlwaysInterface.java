package elegantobject.usealwaysinterface;

class UseAlwaysInterface {
    private interface Cash {
        Cash multiply(int factor);
        int getCash();
    }

    private static class DefaultCash implements Cash {
        private final int dollars;

        public DefaultCash(int dollars) {
            this.dollars = dollars;
        }

        @Override
        public Cash multiply(int factor) {
            return new DefaultCash(this.dollars * factor);
        }

        @Override
        public int getCash() {
            return this.dollars;
        }
    }
}

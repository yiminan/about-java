package elegantobject.employment.dontusestaticmethod;

class FunctionalProgramming {
    
    private interface Number {
        int intValue();
    }

    private static class Max implements Number {
        private final int a;
        private final int b;

        public Max(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int intValue() {
            return Math.max(this.a, this.b);
        }
    }
}

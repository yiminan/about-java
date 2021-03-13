package elegantobject.education.makeaimmutableobject;

class AdvantageOfSideEffectFree {

    private static class MutableObjectCash {
        private int dollars;

        public MutableObjectCash(int dollars) {
            this.dollars = dollars;
        }

        public void multiply(int factor) {
            this.dollars *= factor;
        }

        @Override
        public String toString() {
            return "$" + dollars;
        }
    }
}

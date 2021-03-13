package elegantobject.education.makeaimmutableobject;

class AdvantageOfTemporalCoupling {

    private static class JavaBeansPatternCash {
        private int dollars;
        private int cents;

        public void setDollars(int dollars) {
            this.dollars = dollars;
        }

        public void setCents(int cents) {
            this.cents = cents;
        }

        @Override
        public String toString() {
            return String.format("$%d.%d", dollars, cents);
        }
    }
}

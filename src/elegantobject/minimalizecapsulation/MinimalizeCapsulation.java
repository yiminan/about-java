package elegantobject.minimalizecapsulation;

public class MinimalizeCapsulation {
    static class Cash {
        private final Integer dollars;
        private final Integer cents;
        private final String currency;

        public Cash(Integer dollars, Integer cents, String currency) {
            this.dollars = dollars;
            this.cents = cents;
            this.currency = currency;
        }
    }
}

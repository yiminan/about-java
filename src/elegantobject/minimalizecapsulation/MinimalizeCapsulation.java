package elegantobject.minimalizecapsulation;

import java.util.Objects;

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cash cash = (Cash) o;
            return Objects.equals(dollars, cash.dollars) && Objects.equals(cents, cash.cents) && Objects.equals(currency, cash.currency);
        }

        @Override
        public int hashCode() {
            return Objects.hash(dollars, cents, currency);
        }
    }
}

package elegantobject.education.usefakeobjectinsteadofmockobject;

import org.junit.Assert;

class UseFakeObjectInsteadOfMockObject {

    public static void main(String[] args) {
        Exchange exchange = new Exchange.Fake();
        Cash dollar = new Cash(exchange, 500);
        Cash euro = dollar.in("EUR");
        Assert.assertEquals(euro.cents(), 617);
    }

    private static class Cash {
        private final Exchange exchange;
        private final int cents;

        public Cash(Exchange exchange, int cents) {
            this.exchange = exchange;
            this.cents = cents;
        }

        public Cash in(String currency) {
            return new Cash(this.exchange,
                    (int) (this.cents * this.exchange.rate("USD", currency))
            );
        }

        public int cents() {
            return cents;
        }
    }

    private interface Exchange {
        float rate(String origin, String target);

        final class Fake implements Exchange {
            @Override
            public float rate(String origin, String target) {
                return 1.2345F;
            }
        }
    }
}

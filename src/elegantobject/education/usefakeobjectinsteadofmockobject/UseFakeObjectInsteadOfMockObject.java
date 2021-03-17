package elegantobject.education.usefakeobjectinsteadofmockobject;

class UseFakeObjectInsteadOfMockObject {
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

package elegantobject.education.usefakeobjectinsteadofmockobject;

import org.junit.Assert;

class UseFakeObjectInsteadOfMockObject {

    public static void main(String[] args) {
        /**
         * Mock 객체를 사용한 테스트
         */
//        Exchange exchange = Mockito.mock(Exchange.class);
//        Mockito.doReturn(1.15)
//                .when(exchange)
//                .rate("USD", "EUR");
//        Cash dollar = new Cash(exchange, 500);
//        Cash euro = dollar.in("EUR");
//        Assert.assertEquals(euro.cents(), 617);
        /**
         * Fake 객체를 사용한 테스트
         */
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
        float rate(String target);

        float rate(String origin, String target);

        final class Fake implements Exchange {
            @Override
            public float rate(String target) {
                return this.rate("USD", target);
            }

            @Override
            public float rate(String origin, String target) {
                return 1.2345F;
            }
        }
    }
}

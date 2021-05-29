package elegantobject.step2_education.usefakeobjectinsteadofmockobject;

import org.junit.Assert;

/**
 * "Mock 객체 대신 Fake 객체를 사용합니다"<p>
 * <p>
 * 중요) Mocking 대신 Interface 안에 Fake 클래스를 만들어 사용해야 합니다.<p>
 * <p>
 * 전통적인 접근방식은 Mocking입니다.<p>
 * 모킹에 관해 자세히 설명하는 이유는 모킹이 왜 나쁜 프랙티스인지 이유를 알아야하기 때문입니다.<p>
 * Fake class를 사용하면 테스트를 더 짧게 만들 수 있어서 유지보수성이 향상됩니다.<p>
 * <p>
 * + Mocking 객체 사용 단점<p>
 * Mocking은 가정(assumption)을 사실(fact)로 전환시키기 때문에 단위 테스트를 유지보수하기 어렵게 만듭니다.<p>
 * Mock 객체로 스터빙(stubbing)을 하면 가정을 기반하여 내용을 사실을 만들어버리기 때문에 문제가 발생합니다.<p>
 * 가정이 문제가 되는 이유는 실제 객체의 구현 내용이 바뀌었는데, 가정이 사실이 되어버리면 실제 객체와 Mock의 테스트 내용이 불일치하게됩니다.<p>
 * 즉, 클래스 내용이 실제 변경되면 테스트가 실패되어져야합니다. Mock을 사용하면 변경되어도 실패하지 않을 수 있습니다. 불일치 문제입니다.<p>
 * Mock을 이용한 테스트와 실제 객체가 불일치하면 테스트에 대한 신뢰가 떨어질 수 있습니다.<p>
 * <p>
 * + Fake 객체 사용 장점<p>
 * Fake 객체를 만들어서 사용하게 되면, 실제 구현된 클래스를 기반으로 하고 있기 때문에 실제 코드가 바뀌면 Fake 클래스도 수정해야합니다.<p>
 * 즉, 실제 코드와 테스트 코드의 신뢰성을 유지할 수 있습니다. 실제 코드가 기능적 변경이 없이는 테스트도 깨지지 않습니다.<p>
 * 이 지점에서 Mocking이 Fake와 비교했을 때 나쁜 프랙티스라는 것을 알게 됩니다.<p>
 * 페이크 클래스는 실제 인터페이스와 직접 연관되기 때문에 설계할 때부터 깊은 고민을 유도하는 장점을 가집니다.<p>
 */
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

        /**
         * 인터페이스를 구현한 Fake 객체
         */
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

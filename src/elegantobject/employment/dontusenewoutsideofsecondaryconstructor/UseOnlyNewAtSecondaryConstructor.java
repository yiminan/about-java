package elegantobject.employment.dontusenewoutsideofsecondaryconstructor;

 */
class UseOnlyNewAtSecondaryConstructor {

    /**
     * 부 생성자를 통해서 내부에 exchange 프로퍼티 객체를 주입하여 사용하면,
     * 하드코딩된 내부 의존성을 개선할 수 있다.
     * 개선된 점은 의존성을 제어하는 주체가 InjectionCash 객체가 아닌 프로그래머가 됩니다.
     */
    private static class InjectionCash {
        private final int dollars;
        private final Exchange exchange;

        /**
         * 부 생성자
         */
        public InjectionCash() {
            this(0);
        }

        /**
         * 부 생성자
         */
        public InjectionCash(int dollars) {
            this(dollars, new NYSE());
        }

        /**
         * 주 생성자
         */
        public InjectionCash(int dollars, Exchange exchange) {
            this.dollars = dollars;
            this.exchange = exchange;
        }

        public float euro() {
            return exchange.rate("USD", "EUR") * dollars;
        }
    }

    /**
     * 내부에 new로 객체를 하드코딩하여 의존성이 문제가 되는 Cash
     * 의존성 제어의 주체가 HardCodingCash 객체가 됩니다.
     */
    private static class HardCodingCash {
        private final int dollars;

        public HardCodingCash(int dollars) {
            this.dollars = dollars;
        }

        public float euro() {
            /**
             * 이 부분에서 환율을 제공하는 NYSE 객체를 하드코딩으로 사용합니다.
             * 만약 사용되는 환율 서버가 바뀌거나 객체가 바뀌는 경우에는 내부 코드가 변경되어야합니다.
             * 근본적인 문제는 new 연산자를 사용하는 것이고, 결국 문제가 되는 부분입니다.
             */
            return new NYSE().rate("USD", "EUR") * dollars;
        }
    }

    private static class NYSE implements Exchange {
        @Override
        public float rate(String origin, String target) {
            if ("EUR".equals(origin)) {
                switch (target) {
                    case "USD":
                        return 1.19F;
                }
            }
            if ("USD".equals(origin)) {
                switch (target) {
                    case "EUR":
                        return 0.84F;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    private interface Exchange {
        float rate(String origin, String target);
    }
}

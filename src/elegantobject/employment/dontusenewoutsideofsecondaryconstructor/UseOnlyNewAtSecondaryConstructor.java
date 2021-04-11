package elegantobject.employment.dontusenewoutsideofsecondaryconstructor;

 */
class UseOnlyNewAtSecondaryConstructor {

    private static class HardCodingCash {
        private final int dollars;

        public HardCodingCash(int dollars) {
            this.dollars = dollars;
        }

        public float euro() {
            /**
             * 이 부분에서 환율을 제공하는 NYSE 객체를 하드코딩으로 사용합니다.
             * 만약 사용되는 환율 서버가 바뀌거나 객체가 바뀌는 경우에는 내부 코드가 변경되어야합니다.
             * 결국 문제가 되는 부분입니다.
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

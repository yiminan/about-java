package elegantobject.education.useshortinterfaceusingbysmartclass;

class UseShortInterfaceUsingBySmartClass {

    private interface WrongExchange {
        /**
         * float rate(String origin, String target) 메서드만 있어도 충분합니다.
         * 이 중복 기능을 하는 float rate(String target) 메서드는 필요없습니다.
         * 중복 기능을 제공하는 이 메서드를 없애고 기능은 그대로 제공하기 위해서 Smart Class / Decorator Class를 구현합니다.
         */
        float rate(String target);

        float rate(String origin, String target);
    }

    private interface Exchange {
        float rate(String origin, String target);

        /**
         * "Smart Class"
         * 사용 이유)
         * - Smart class를 인터페이스와 같이 제공해야하는 이유는 인터페이스를 구현하는 서로 다른 클래스 안에 동일한 기능을 반복 구현하지 않기 위함입니다.
         * - 필요없는 float rate(String target); 를 중복을 제거하기 위해서 사용하는 Smart 클래스입니다.
         * - 스마트 클래스에 기능을 추가하면서 크기는 늘어나지만, 인터페이스는 높은 응집도를 유지할 수 있습니다.
         */
        final class Smart {
            private final Exchange origin;

            public Smart(Exchange origin) {
                this.origin = origin;
            }

            public float toUsd(String source) {
                return this.origin.rate(source, "USD");
            }

            public float eurToUsd() {
                return this.toUsd("EUR");
            }
        }

        /**
         * "Decorator Class with Smart Class"
         * 사용 이유)
         * - Decorator를 사용하면 Smart Class와 동일하지만 인터페이스를 오바라이드 구현하여 Smart Class를 더 강력하게 만듦니다.
         * - Smart Class와 Decorator Class의 차이는 Smart Class가 더 메서드 구현의 자유도가 높다는 것입니다.
         * - Smart Class의 장점인 메서드 구현 자유도와 Decorator Class의 오버라이드 제약으로 인터페이스 추상 메서드의 기능 강화가 가능합니다.
         */
        final class Decorator implements Exchange {
            private final Exchange origin;

            public Decorator(Exchange origin) {
                this.origin = origin;
            }

            @Override
            public float rate(String source, String target) {
                final float rate;
                if (source.equals(target)) {
                    rate = 1.0F;
                    return rate;
                }
                rate = this.origin.rate(source, target);
                return rate;
            }

            public float toUsd(String source) {
                return this.origin.rate(source, "USD");
            }
        }
    }

    /**
     * NYSE(New York Stock Exchange)
     * = 환율 제공 거래소
     * 최종적으로 float rate(String target);를 구현하지 않아도 되는 구현 클래스
     */
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
}

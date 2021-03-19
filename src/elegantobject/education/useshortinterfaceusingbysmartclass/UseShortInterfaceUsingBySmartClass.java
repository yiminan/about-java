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

            public Fast(Exchange orgin) {
                this.orgin = orgin;
            }

            @Override
            public float rate(String source, String target) {
                final float rate;
                if (source.equals(target)) {
                    rate = 1.0f;
                    return rate;
                }
                rate = this.orgin.rate(source, target);
                return rate;
            }

            public float toUsd(String source) {
                return this.orgin.rate(source, "USD");
            }
        }
    }
}

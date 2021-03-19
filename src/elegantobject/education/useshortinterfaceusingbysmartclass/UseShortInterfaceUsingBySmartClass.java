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

        final class Fast implements Exchange {
            private final Exchange orgin;

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

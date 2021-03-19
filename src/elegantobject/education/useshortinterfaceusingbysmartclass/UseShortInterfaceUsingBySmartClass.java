package elegantobject.education.useshortinterfaceusingbysmartclass;

class UseShortInterfaceUsingBySmartClass {

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

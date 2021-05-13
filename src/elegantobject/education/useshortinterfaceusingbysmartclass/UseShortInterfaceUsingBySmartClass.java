package elegantobject.education.useshortinterfaceusingbysmartclass;

/**
 * "짧은 인터페이스를 유지하고, 스마트 클래스를 만들어서 사용해야합니다"<p>
 * <p>
 * 올바르게 설계된 견고하고, 응집도가 높은 클래스는 적은 수의 public 메서드만 포함합니다.<p>
 * 클래스를 작게 만드는 것이 중요한 것처럼, 인터페이스를 작게 만드는 것은 훨씬 더 중요합니다.<p>
 * 두 개의 인터페이스에 각 5개 추상 메서드가 선언되어있으면, '두 개의 인터페이스를 구현하는 클래스'는 총 10개의 메서드를 구현해야합니다.<p>
 * 이 '두 개의 인터페이스를 구현하는 클래스'는 좋은 클래스라고 볼 수 없습니다.<p>
 * 결국 SRP(Single Responsibility Principle)을 위반하는 클래스가 만들어지게 됩니다.<p>
 * 인터페이스에서 중복되는 굳이 필요없는 추상 메서드는 선언하지 않아야합니다. 이럴 떄 사용하는 것이 Smart Class 입니다.<p>
 * <p>
 * 기본적으로 인터페이스를 짧게 만들고, Smart Class를 인터페이스와 함께 배포함으로써 공통 기능을 추출하고 코드 중복을 제거할 수 있습니다.<p>
 * Smart Class를 강화하는 Decorator Class도 존재합니다.<p>
 * Decorator Class는 인터페이스 구현체의 로직을 강화하는 로직을 적용한 메서드를 구현할 수 있습니다.<p>
 */
class UseShortInterfaceUsingBySmartClass {

    public static void main(String[] args) {
        System.out.println(new Exchange.Smart(new NYSE()).eurToUsd());// 1.19
        System.out.println(new Exchange.Decorator(new NYSE()).rate("USD", "USD"));// 1.0
    }

    private interface WrongExchange {
        /**
         * float rate(String origin, String target) 메서드만 있어도 충분합니다.<p>
         * 이 중복 기능을 하는 float rate(String target) 메서드는 필요없습니다.<p>
         * 중복 기능을 제공하는 이 메서드를 없애고 기능은 그대로 제공하기 위해서 Smart Class / Decorator Class를 구현합니다.<p>
         */
        float rate(String target);

        float rate(String origin, String target);
    }

    private interface Exchange {
        float rate(String origin, String target);

        /**
         * "Smart Class"<p>
         * 사용 이유)<p>
         * - Smart class를 인터페이스와 같이 제공해야하는 이유는 인터페이스를 구현하는 서로 다른 클래스 안에 동일한 기능을 반복 구현하지 않기 위함입니다.<p>
         * - 필요없는 float rate(String target); 를 중복을 제거하기 위해서 사용하는 Smart 클래스입니다.<p>
         * - 스마트 클래스에 기능을 추가하면서 크기는 늘어나지만, 인터페이스는 높은 응집도를 유지할 수 있습니다.<p>
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
         * "Decorator Class with Smart Class"<p>
         * 사용 이유)<p>
         * - Decorator를 사용하면 Smart Class와 동일하지만 인터페이스를 오바라이드 구현하여 Smart Class를 더 강력하게 만듦니다.<p>
         * - Smart Class와 Decorator Class의 차이는 Smart Class가 더 메서드 구현의 자유도가 높다는 것입니다.<p>
         * - Smart Class의 장점인 메서드 구현 자유도와 Decorator Class의 오버라이드 제약으로 인터페이스 추상 메서드의 기능 강화가 가능합니다.<p>
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
     * NYSE(New York Stock Exchange)<p>
     * = 환율 제공 거래소<p>
     * 최종적으로 float rate(String target);를 구현하지 않아도 되는 구현 클래스<p>
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

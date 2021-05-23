package elegantobject.birth.dontinputcodeinconstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * "생성자에 코드를 넣으면 안됩니다"<p>
 * <p>
 * 원칙)<p>
 * - 생성자에는 코드가 없어야하고, 전달된 인자는 건들면 안됩니다.<p>
 * - OOP에서 인스턴스화(instantiation)이란 더 작은 객체들을 조합해서(compose) 더 큰 객체를 만드는 것을 의미합니다.<p>
 * - 객체의 초기화에 코드가 존재하지 않으면 성능이 최적화되고 객체의 생성 속도가 빨라집니다. 필요하지 않은 파싱 시간을 아끼게 되어서 성능이 향상되는 것입니다.<p>
 * - 필요한 시점에 파싱을 하게되면 오히려 계속 파싱해야하는 경우도 생깁니다. 이 경우에는 캐시를 구현해서 최초 한 번만 파싱하도록 합니다.<p>
 * <p>
 * 올바르게 설계된 객체지향 소프트웨어를 살펴보면 다음과 같습니다.<p>
 * ex) App app = new App(new Data(), new Screen());<p>
 * app.run();<p>
 * App은 App이 해야할 고유의 run()만 수행하고, 내부 필드 생성은 외부에서 파라미터로 전달됩니다.<p>
 * <p>
 * 결론)<p>
 * "객체를 인스턴스화하는 동안에는 객체를 만드는 일(build) 이외에는 어떤 일도 수행하지 않습니다. 객체는 게으를수록 좋습니다."<p>
 */
class DontInputCodeInConstructor {

    public static void main(String[] args) {
        final String dollars = "10";

        /**
         * 장점: 객체 초기화 시, 최초 한 번 필드 값을 파싱하고 셋팅하기에 중복 파싱할 필요 없음
         * 단점: 객체 필드 값을 사용하지 않는 경우에도 객체 초기화 시, 파싱해야하기 때문에 성능 최적화 불리
         */
        InvalidCash invalidCash = new InvalidCash(dollars);
        System.out.println(invalidCash.getDollars()); // int value : 10
        System.out.println(invalidCash.getDollars()); // int value : 10

        /**
         * 장점: 객체 초기화 시, 필드 값을 파싱하지 않기 때문에 객체의 성능 최적화에 유리
         * 단점: 객체 초기화 시, 필드 값을 파싱되지 않기 때문에 값을 불러올 때마다 중복 파싱해야해서 성능 최적화에 불리
         */
        ValidCash validCash = new ValidCash(dollars);
        System.out.println(validCash.getDollars().intValue()); // int value : 10
        System.out.println(validCash.getDollars().intValue()); // int value : 10

        /**
         * 장점: (1) 객체 초기화 시, 필드 값을 파싱하지 않음 (2) 필드 값을 사용할 때도 최초 한 번만 파싱 으로 성능 최적화
         */
        CachedValidCash cachedValidCash = new CachedValidCash(dollars);
        System.out.println(cachedValidCash.getDollars().intValue()); // int value : 10
        System.out.println(cachedValidCash.getDollars().intValue()); // int value : 10
    }

    private static class InvalidCash {

        private final int dollars;

        /**
         * "주 생성자"
         * 주 생성자 내에서 dollar를 연산을 통해서 셋팅하는 것은 잘못된 방법
         */
        public InvalidCash(String dollars) {
            this.dollars = Integer.parseInt(dollars);
        }

        public int getDollars() {
            return dollars;
        }
    }

    private static class ValidCash {

        private final Number dollars;

        /**
         * "부 생성자"
         * - 주 생성자를 이용한다.
         * - 연산은 없고, 객체에 선언하는 형식으로만 한다.
         * - 필요한 시점에 객체 안에서 연산 과정을 진행한다.
         */
        public ValidCash(String dollars) {
            this(new StringAsInteger(dollars));
        }

        /**
         * "주 생성자"
         */
        public ValidCash(Number dollars) {
            this.dollars = dollars;
        }

        public Number getDollars() {
            return dollars;
        }
    }

    private static class CachedValidCash {

        private final Number dollars;

        /**
         * "부 생성자"
         * - 주 생성자를 이용한다.
         * - 연산은 없고, 객체에 선언하는 형식으로만 한다.
         * - 필요한 시점에 객체 안에서 연산 과정을 진행한다.
         */
        public CachedValidCash(String dollars) {
            this(new CachedNumber(new StringAsInteger(dollars)));
        }

        /**
         * "주 생성자"
         */
        public CachedValidCash(Number dollars) {
            this.dollars = dollars;
        }

        public Number getDollars() {
            return dollars;
        }
    }

    private interface Number {
        int intValue();
    }

    private static class StringAsInteger implements Number {

        private final String source;

        public StringAsInteger(String source) {
            this.source = source;
        }

        // 필요한 시점에 source를 변환해서 사용한다.
        @Override
        public int intValue() {
            return Integer.parseInt(this.source);
        }
    }

    private static class CachedNumber implements Number {

        private final Number origin;
        private final List<Integer> cached = new ArrayList<>(1);

        public CachedNumber(Number number) {
            this.origin = number;
        }

        // 캐싱이 안되어있으면 최초 한 번 캐싱하고,
        // 캐싱이 되어있으면, 캐시 값을 반환
        @Override
        public int intValue() {
            if (this.cached.isEmpty()) {
                this.cached.add(this.origin.intValue());
            }
            return this.cached.get(0);
        }
    }
}

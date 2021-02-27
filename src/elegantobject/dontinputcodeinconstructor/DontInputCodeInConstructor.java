package elegantobject.dontinputcodeinconstructor;

public class DontInputCodeInConstructor {

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

    static class InvalidCash {
        private final int dollars;

        // 값이 바로 변환되어 셋팅되는 생성자
        public InvalidCash(String dollars) {
            this.dollars = Integer.parseInt(dollars);
        }

        public int getDollars() {
            return dollars;
        }
    }

    static class ValidCash {
        private final Number dollars;

        // 생성자는 값을 셋팅만 하고, 필요한 시점에 변환해서 가져와서 사용한다.
        // 부 생성자
        public ValidCash(String dollars) {
            this(new StringAsInteger(dollars));
        }

        // 주 생성자
        public ValidCash(Number dollars) {
            this.dollars = dollars;
        }

        public Number getDollars() {
            return dollars;
        }
    }

    static class CachedValidCash {
        private final Number dollars;

        // 생성자는 값을 셋팅만 하고, 필요한 시점에 변환해서 가져와서 사용한다.
        // 부 생성자
        public CachedValidCash(String dollars) {
            this(new CachedNumber(new StringAsInteger(dollars)));
        }

        // 주 생성자
        public CachedValidCash(Number dollars) {
            this.dollars = dollars;
        }

        public Number getDollars() {
            return dollars;
        }
    }

    interface Number {
        int intValue();
    }

    static class StringAsInteger implements Number {

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

    static class CachedNumber implements Number {

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

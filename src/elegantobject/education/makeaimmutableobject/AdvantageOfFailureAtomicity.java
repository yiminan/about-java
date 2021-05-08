package elegantobject.education.makeaimmutableobject;

/**
 * "불변 객체로 원자성 보장할 수 있습니다"<p>
 * <p>
 * 원자성은 데이터의 반영은 "All or Nothing"을 가지는 성질입니다.<p>
 * 가변 객체는 중간에 데이터가 수정되다가 예외가 발생하면, 데이터의 정합성을 보장할 수 없습니다.<p>
 * 불변 객체는 내부의 어떤 것도 수정할 수 없고, 새로운 객체가 생성되기 때문에 예외에 대한 데이터 정합성을 보장합니다.<p>
 * 물론 가변 객체도 원자성을 보장받게 구현할 수는 있습니다. 하지만 불변 객체는 원자성을 기본적으로 가집니다.<p>
 */
class AdvantageOfFailureAtomicity {

    private static class MutableCash {
        private int dollars;
        private int cents;

        public void multiply(int factor) {
            this.dollars *= factor;// 부분 데이터 수정
            if (true) {
                throw new RuntimeException("객체의 연산 도중 예외 발생");
            }
            this.cents *= factor;// 예외 발생으로 인해 수정 누락
        }
    }

    private static class ImmutableCash {
        private final int dollars;
        private final int cents;

        public ImmutableCash(int dollars, int cents) {
            this.dollars = dollars;
            this.cents = cents;
        }

        public ImmutableCash multiply(int factor) {
            if (true) {
                throw new RuntimeException("객체의 연산 도중 예외 발생");
            }
            return new ImmutableCash(this.dollars * factor, this.cents * factor);// 원자성 보장
        }
    }
}

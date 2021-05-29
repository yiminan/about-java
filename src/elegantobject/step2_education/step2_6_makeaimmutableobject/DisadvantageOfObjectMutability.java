package elegantobject.step2_education.step2_6_makeaimmutableobject;

import java.util.Objects;

/**
 * "가변성이 없는 불변 객체"<p>
 * <p>
 * 불변 객체에는 객체의 가변성 문제가 없습니다.<p>
 * 가변 객체는 내용물이 변경될 수 있어서 비즈니스 로직에서 변경되면,<p>
 * 객체 사용시점에 객체의 내용물을 보장할 수 없습니다.<p>
 * <p>
 * 불변객체를 사용하면, 객체 내용물에 대한 가변성을 애초에 없애버립니다.<p>
 * 결국, 객체의 내용물을 보장받을 수 있는 이점을 가집니다.<p>
 */
class DisadvantageOfObjectMutability {

    public static void main(String[] args) {
        MutableCash five = new MutableCash(5);
        MutableCash ten = new MutableCash(10);
        five.multiply(2);
        System.out.println(five.equals(ten));// true

        ImmutableCash _five = new ImmutableCash(5);
        ImmutableCash _ten = _five.multiply(2);
        System.out.println(_five.equals(_ten));// false
    }

    /**
     * 가변 클래스 예시
     */
    private static class MutableCash {
        private int dollars;

        public MutableCash(int dollars) {
            this.dollars = dollars;
        }

        public void multiply(int factor) {
            this.dollars *= factor;
        }

        @Override
        public String toString() {
            return "$" + dollars;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MutableCash that = (MutableCash) o;
            return dollars == that.dollars;
        }

        @Override
        public int hashCode() {
            return Objects.hash(dollars);
        }
    }

    /**
     * 불변 클래스 예시
     */
    private static class ImmutableCash {
        private final int dollars;

        public ImmutableCash(int dollars) {
            this.dollars = dollars;
        }

        public ImmutableCash multiply(int factor) {
            return new ImmutableCash(this.dollars * factor);
        }

        @Override
        public String toString() {
            return "$" + dollars;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ImmutableCash that = (ImmutableCash) o;
            return dollars == that.dollars;
        }

        @Override
        public int hashCode() {
            return Objects.hash(dollars);
        }
    }
}

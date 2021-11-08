package effectivejava.item17;

import java.util.Objects;

/**
 * "변경 가능성을 최소화해야합니다"<p>
 * <p>
 * 불변 클래스는 인스턴스의 내부 값을 수정할 수 없는 클래스이다.<p>
 * 불변 인스턴스 내부 정보는 고정되어 객체가 파괴되는 순간까지 절대 달라지지 않습니다.<p>
 * ex) {@link String}, {@link java.math.BigInteger}, {@link java.math.BigDecimal}, etc.<p>
 * <p>
 * 불변 클래스의 장점<p>
 * 불변 클래스는 초기화 이후에 변경하지 못하므로 가변 클래스보다 설계하고 구현하기 쉽니다.<p>
 * 불변 클래스는 Thread Safe 합니다.<p>
 * <p>
 * 불변 클래스 작성 다섯 가지 규칙<p>
 * 1.객체의 상태를 변경하는 setter 역할의 메서드를 제공하지 않는다.<p>
 * 2.클래스를 확장할 수 없도록 해야한다. final class 또는 다른 방법도 존재한다.<p>
 * 3.클래스의 모든 필드는 final을 선언해준다.<p>
 * 4.클래스의 모든 필드의 접근 지정자를 private으로 선언해준다.<p>
 * 5.자신 클래스 외에는 내부 가변 컴포넌트에 접근하지 못하게 해야한다.<p>
 * <p>
 * 불변 객체는 단순합니다. 불변 객체는 생성된 시점의 상태를 파괴될 때까지 그대로 간직합니다.<p>
 * 불변 객체는 안심하고 공유가 가능한 객체를 만들 수 있습니다.<p>
 * 불변 객체끼리는 클래스 내부 데이터를 공유해서 연산을 구현할 수도 있습니다.<p>
 */
class MinimizeThePossibilityOfChange {

    public static void main(String[] args) {
        System.out.println(Operand.ONE.plus(Operand.ZERO));// Operand{number=1}
        System.out.println(Operand.ONE.plus(new Operand(0)));// Operand{number=1}
        System.out.println(new Operand(1).plus(Operand.ZERO));// Operand{number=1}
        System.out.println(new Operand(1).plus(new Operand(0)));// Operand{number=1}
    }

    private static final class Operand {
        public static final Operand ZERO = new Operand(0);
        public static final Operand ONE = new Operand(1);

        private final int number;

        Operand(int number) {
            this.number = number;
        }

        Operand plus(Operand operand) {
            return new Operand(this.number + operand.number);
        }

        Operand minus(Operand operand) {
            return new Operand(this.number - operand.number);
        }

        Operand times(Operand operand) {
            return new Operand(this.number * operand.number);
        }

        Operand dividedBy(Operand operand) {
            return new Operand(this.number / operand.number);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Operand operand = (Operand) o;
            return number == operand.number;
        }

        @Override
        public int hashCode() {
            return Objects.hash(number);
        }

        @Override
        public String toString() {
            return "Operand{" +
                    "number=" + number +
                    '}';
        }
    }
}

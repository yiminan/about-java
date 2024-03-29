package com.example.aboutjava.effectivejava.item17;

import java.util.Objects;

/**
 * "Item 17 - 변경 가능성을 최소화해야합니다"<p>
 * <p>
 * 불변 클래스는 인스턴스의 내부 값을 수정할 수 없는 클래스이다.<p>
 * 불변 인스턴스 내부 정보는 고정되어 객체가 파괴되는 순간까지 절대 달라지지 않습니다.<p>
 * ex) {@link String}, {@link java.math.BigInteger}, {@link java.math.BigDecimal}, etc.<p>
 * <p>
 * 불변 클래스의 장점<p>
 * - 불변 클래스는 초기화 이후에 변경하지 못하므로 가변 클래스보다 설계하고 구현하기 쉽니다.<p>
 * - 불변 클래스는 Thread Safe 합니다.<p>
 * <p>
 * 불변 클래스의 단점<p>
 * - 값이 달라지면 독립된 객체로 만들어야하는데, 객체 생성비용이 상당히 크다.<p>
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
 * 불변 객체는 그 자체로 실패 원자성을 제공합니다.<p>
 * <p>
 * 결론)<p>
 * 클래스는 항상 꼭 필요한 경우가 아니라면 불변이어야 한다.<p>
 * 불변으로 만들 수 없는 클래스라도 변경할 수 있는 부분을 최소한으로 줄여야합니다.<p>
 * 다른 합당한 이유가 아니라면 모든 필드는 'private final'이어야 합니다.<p>
 * 생성자는 불변식 설정이 모두 완료된, 초기화가 완벽히 끝난 상태의 객체를 생성해야 합니다.<p>
 */
class MinimizeThePossibilityOfChange {

    static final class Operand {
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

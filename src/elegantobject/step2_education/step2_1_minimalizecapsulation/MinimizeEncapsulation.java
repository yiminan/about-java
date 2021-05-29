package elegantobject.step2_education.step2_1_minimalizecapsulation;

import java.util.Objects;

/**
 * "가능하면 적은 내용물을 캡슐화시켜야합니다."<p>
 * <p>
 * 원칙)<p>
 * - 최대 4개인 내용물을 가진 객체를 캡슐화하는 것을 권장합니다.<p>
 * - ==를 사용하지 않고 항상 equals() 메서드를 오버라이드해서 사용해야합니다.<p>
 * <p>
 * 하나의 클래스 안에 많은 내용이 들어가면, 코드 복잡도 Up, 유지보수 Hard 합니다.<p>
 * OOP는 작은 객체로 캡슐화해서 객체 간 협력이 가능하게 하는 기법입니다.<p>
 * OOP로 구현된 객체는 고수준의 행동을 하기 위해서 함께 동작하는 객체들의 집합체(Aggregation)입니다.<p>
 * 즉, OOP의 목표는 낮은 결합도와 높은 응집도를 실현하는 것입니다.<p>
 * 단일책임의원칙(SRP)를 최대한 지키는 선에서 작은 캡슐화를 구현해야합니다.<p>
 * Java는 동일한 내용을 가지는 객체를 비교해봤을 때, '==' 동일성 비교에서 다른 결과를 가집니다. 이 부분은 C++에게 물려받은 Java의 설계적 결함입니다.<p>
 * 그래서 'equals()'라는 메서드를 이용해서 동등성을 비교합니다.<p>
 * 4개 이하의 객체 구성을 해야 직관적이고, 쉽게 이해할 수 있는 최대 한계를 넘어서지 않습니다.<p>
 * 될 수 있으면 작은 객체로 구성하는 것이 올바른 객체의 구성입니다.<p>
 * Java의 설계적 결함을 해결하기 위해서 '=='연상자를 사용하지 말고, 항상 'equals()'메서드를 오버라이드해서 사용해야합니다.<p>
 */
class MinimizeEncapsulation {

    public static void main(String[] args) {
        int dollars = 10;
        int cents = 93;
        String currency = "USD";
        Cash cash1 = new Cash(dollars, cents, currency);
        Cash cash2 = new Cash(dollars, cents, currency);

        System.out.println(cash1 == cash2);// false
        System.out.println(cash1.equals(cash2));// true
    }

    private static class Cash {
        private final Integer dollars;
        private final Integer cents;
        private final String currency;

        public Cash(Integer dollars, Integer cents, String currency) {
            this.dollars = dollars;
            this.cents = cents;
            this.currency = currency;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cash cash = (Cash) o;
            return Objects.equals(dollars, cash.dollars) && Objects.equals(cents, cash.cents) && Objects.equals(currency, cash.currency);
        }

        @Override
        public int hashCode() {
            return Objects.hash(dollars, cents, currency);
        }
    }
}

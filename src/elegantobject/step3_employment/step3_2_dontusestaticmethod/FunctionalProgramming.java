package elegantobject.step3_employment.step3_2_dontusestaticmethod;

import java.util.Arrays;
import java.util.Optional;

/**
 * "함수형 프로그래밍"<p>
 * <p>
 * 객체의 크기가 작고, 상태가 변하지 않으며 정적 메서드도 포함하지 않는다면,<p>
 * 함수형 프로그래밍(functional programming, FP)을 활용하는 편이 더 낫다라는 이야기가 나옵니다.<p>
 * 하지만<p>
 * (1) OOP가 표현력이 더 좋고, 객체와 메서드를 조합할 수 있습니다.<p>
 * (2) FP는 함수만 제공합니다.<p>
 * 최근에는 Java8에서 람다 표현식이 제공되어 편리하지만, OOP에서 더욱 멀어져서 견고함을 약화시킵니다.<p>
 */
class FunctionalProgramming {

    public static void main(String[] args) {
        Number declarativeMax = new Max(5, 6);

        Optional<Integer> functionalMax = Arrays.asList(5, 6)
                .stream()
                .max(Integer::compare);

        System.out.println(declarativeMax.intValue() == functionalMax.get());
    }

    private interface Number {
        int intValue();
    }

    private static class Max implements Number {
        private final int a;
        private final int b;

        public Max(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int intValue() {
            return Math.max(this.a, this.b);
        }
    }
}

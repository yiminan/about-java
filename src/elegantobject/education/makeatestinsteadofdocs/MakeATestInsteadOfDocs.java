package elegantobject.education.makeatestinsteadofdocs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * "문서화를 작성하는 대신 테스트를 만들어야 합니다"
 * 문서화는 유지보수에 있어 중요한 구성요소(component)입니다. 중요하다는 것이 문서를 무조건 만들어야한다는 이야기는 아닙니다.
 * 핵심은 유지보수를 위해서는 어떤 수단이든 사용해야한다는 이야기입니다.
 *
 * 코드의 수준은 비즈니스 도메인, 프로그래밍 언어, 디자인 패턴, 알고리즘을 거의 이해하지 못하는 주니어 프로그래머의 눈높이어야 합니다.
 * 나쁜 프로그래머는 복잡한 코드를 짭니다. 훌륭한 프로그래머는 단순한 코드를 짭니다.
 * 이상적인 코드는 스스로를 설명하기 때문에 어떤 추가 문서도 필요하지 않습니다.
 * 나쁜 코드는 문서화를 작성하도록 유도합니다.
 * 좋은 클래스는 목적이 명확하고, 작고, 설계가 우아합니다.
 * 코드를 문서화하는 대신 코드를 깔끔하게(clean) 만들기 바랍니다.
 *
 * 문서화 대신 테스트를 만들어야합니다.
 * 단위 테스트는 클래스의 일부이지 독립된 개체(entity)가 아닙니다.
 * 깔끔하고 유지보수 가능한 단위 테스트를 추가하면, 클래스를 더 깔끔하게 만들 수 있고, 유지 보수성을 향상시킬 수 있습니다.
 * 단위 테스트가 곧 문서화입니다.
 * 단위 테스트는 클래스의 사용 방법을 보여주는데 반해, 문서는 이해하기 어려운 이야기를 들려줍니다.
 */
class MakeATestInsteadOfDocs {

    /**
     * 좋은 설계의 예시
     */
    public static void main(String[] args) {
        Department department = new Department();
        Employee jeff = department.employee("Jeff");
        jeff.giveRaise(new Cash(6_000));
        if (jeff.performance() < 3.5) {
            jeff.fire();
        }
    }

    /**
     * 좋은 클래스 설계 예시를 위해서 클래스의 껍데기만 구현하였습니다.
     */
    private static class Department {

        public Employee employee(String name) {
            return new Employee(name);
        }
    }

    /**
     * 좋은 클래스 설계 예시를 위해서 클래스의 껍데기만 구현하였습니다.
     */
    private static class Employee {
        public Employee(String name) {
        }

        public void giveRaise(Cash cash) {
        }

        public int performance() {
            return 1;
        }

        public void fire() {
        }
    }

    private static class Cash {
        private final int dollars;

        public Cash(int dollars) {
            this.dollars = dollars;
        }

        public Cash plus(Cash cash) {
            return new Cash(this.dollars + cash.dollars);
        }

        public Cash mul(int factor) {
            return new Cash(this.dollars * factor);
        }
    }

    /**
     * 문서화 대신 다음처럼 테스트를 만들어야합니다.
     */
    private static class MakeATestInsteadOfDocsTest {
        @Test
        void summarizes() {
            assertEquals(
                    new Cash(8),
                    new Cash(5).plus(new Cash(3))
            );
        }

        @Test
        void deducts() {
            assertEquals(
                    new Cash(-4),
                    new Cash(7).plus(new Cash(-11))
            );
        }

        @Test
        void multiplies() {
            assertEquals(
                    new Cash(6),
                    new Cash(2).mul(3)
            );
        }
    }
}

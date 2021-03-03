package elegantobject.usealwaysinterface;

/**
 * "인터페이스를 사용해서 결합도를 낮춰라"
 * 객체는 살아있는 유기체입니다. 다른 유기체들과 커뮤니케이션하여 작업을 지원하고, 반대로 지원도 받습니다.
 * OOP에서 객체는 어떤 형태로든 결합되게 되어있습니다.
 * 하지만 결합을 하다보면 갯수도 많아지고 나중에 강한 결합도 때문에 문제가 발생하게 됩니다.
 * 강한 결합도는 유지보수를 어렵게 하기 때문에 객체의 결합도를 낮추는 인터페이스를 사용해야합니다.
 * 그렇다고 인터페이스와 결합이 사라지는건 아니기 때문에 결합도를 낮추는 것이지 없애는 것은 아닙니다.
 * 즉, 인터페이스는 "느슨한 결합(Loose coupling)"을 구현하는 것입니다.
 */
class UseAlwaysInterface {
    public static void main(String[] args) {
        Cash cash = new DefaultCash(10);
        Employee employee = new Employee(cash);
        System.out.println(employee.getSalary());
    }

    /**
     * Cash를 사용하는 객체는 Cash에 명시되어있는 기능을 '계약(Contract)'으로 보장받습니다.
     * Cash를 사용하는 객체는 구현 방법에 대해서는 관심없습니다.
     * Cash를 구현하는 구현체는 인터페이스에 명시되어있는 메서드 이외에는 public 메서드를 구현해서는 안됩니다.
     */
    private interface Cash {
        Cash multiply(int factor);

        int getCash();
    }

    /**
     * 인터페이스 "Cash"의 구현체 "DefaultCash"는 서비스로써 다른 구현 내용의 구현체로 경쟁하고 교체 사용될 수 있습니다.
     * 위와 같이 경쟁과 유연한 결합 관계를 갖는 것을 "느슨한 결합도(Loose coupling)"을 갖는다고 합니다.
     */
    private static class DefaultCash implements Cash {
        private final int dollars;

        public DefaultCash(int dollars) {
            this.dollars = dollars;
        }

        @Override
        public Cash multiply(int factor) {
            return new DefaultCash(this.dollars * factor);
        }

        @Override
        public int getCash() {
            return this.dollars;
        }
    }

    private static class Employee {
        private static final int FULL_TIME_WEIGHT = 2;
        private final Cash salary;// 위임(Delegation)방식으로 OCP를 구현해서 객체간 결합도를 낮출 수 있다.

        public Employee(Cash salary) {
            this.salary = salary;
        }

        public int getSalary() {
            return salary.multiply(FULL_TIME_WEIGHT).getCash();
        }
    }
}

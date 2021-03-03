package elegantobject.usealwaysinterface;

class UseAlwaysInterface {
    public static void main(String[] args) {
        Cash cash = new DefaultCash(10);
        Employee employee = new Employee(cash);
        System.out.println(employee.getSalary());
    }

    private interface Cash {
        Cash multiply(int factor);
        int getCash();
    }

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
        private final Cash salary;

        public Employee(Cash salary) {
            this.salary = salary;
        }

        public int getSalary() {
            return salary.multiply(FULL_TIME_WEIGHT).getCash();
        }
    }
}

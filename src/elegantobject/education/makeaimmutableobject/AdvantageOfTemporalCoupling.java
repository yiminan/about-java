package elegantobject.education.makeaimmutableobject;

class AdvantageOfTemporalCoupling {

    public static void main(String[] args) {
        JavaBeansPatternCash javaBeansPatternCash = new JavaBeansPatternCash();
        javaBeansPatternCash.setDollars(29);
        // 시간에 따라서 결과가 달라질 수 있는 객체 내용 때문에 코드의 시간적 결합도를 가진다.
        System.out.println(javaBeansPatternCash);//$29.0
        javaBeansPatternCash.setCents(95);
        System.out.println(javaBeansPatternCash);//$29.0

        // 불변 객체는 인스턴스 초기화와 객체 내용의 초기화가 동시에 진행되기 때문에 시간적 결합도가 존재하지 않는다.
        ImmutableObjectCash immutableObjectCash = new ImmutableObjectCash(29, 95);
        System.out.println(immutableObjectCash);//$29.95
    }

    private static class JavaBeansPatternCash {
        private int dollars;
        private int cents;

        public void setDollars(int dollars) {
            this.dollars = dollars;
        }

        public void setCents(int cents) {
            this.cents = cents;
        }

        @Override
        public String toString() {
            return String.format("$%d.%d", dollars, cents);
        }
    }

    private static class ImmutableObjectCash {
        private final int dollars;
        private final int cents;

        public ImmutableObjectCash(int dollars, int cents) {
            this.dollars = dollars;
            this.cents = cents;
        }

        @Override
        public String toString() {
            return String.format("$%d.%d", dollars, cents);
        }
    }
}

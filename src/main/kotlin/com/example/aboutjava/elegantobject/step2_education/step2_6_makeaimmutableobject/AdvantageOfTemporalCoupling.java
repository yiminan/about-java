package com.example.aboutjava.elegantobject.step2_education.step2_6_makeaimmutableobject;

/**
 * "불변객체를 사용하여 시간적 결합(Temporal Coupling)을 제거합니다"<p>
 * <p>
 * JavaBeans 패턴을 사용하면, 가변 객체를 인스턴스화(Instantiation)하고 내용을 초기화(Initialization) 합니다.<p>
 * 가변 객체가 인스턴스화 되었을 때는 내부 프로퍼티가 NULL로 초기화되고, setter를 이용해서 프로퍼티 값을 초기화합니다.<p>
 * 절차에 따라서 객체는 코드라인의 제일 하단에서 최종 객체가 정해지게 됩니다. 결국 절차지향이기 때문에 OOP라고 할 수 없습니다.<p>
 * 결국 프로그래머는 유지보수 과정에서 코드의 절차적이고 시간적인 결합을 고려해야하는 단점을 가지게 됩니다.<p>
 * <p>
 * Immutable Object를 사용하면, 인스턴스화 & 내용의 초기화를 항상 동시에 진행합니다.<p>
 * 불변 객체를 이용하면 견고한 객체를 사용하여 중간에 객체가 변경될 수 있는 여지를 없앨 수 있습니다.<p>
 */
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

    /**
     * 시간적 결합도를 가진 JavaBeans 패턴 클래스
     * 절차지향적
     */
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

    /**
     * 시간적 결합도를 제거한 ImmutableObject 클래스
     * OOP
     */
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

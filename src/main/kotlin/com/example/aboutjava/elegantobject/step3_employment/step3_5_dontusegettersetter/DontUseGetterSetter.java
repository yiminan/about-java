package com.example.aboutjava.elegantobject.step3_employment.step3_5_dontusegettersetter;

/**
 * "getter와 setter를 안티패턴이고, 사용하면 안됩니다"
 * <p>
 * getter와 setter를 사용하게되면 그 객체는 가변 객체가 됩니다.
 * 그리고 단순 자료 구조(data structure)가 됩니다.
 * struct는 단순한 데이터 가방(data bag)이 됩니다.
 * <p>
 * 클래스는 다릅니다. 어떤 식으로든 멤버에게 직접 접근하는 것을 허용하지 않습니다.
 * 객체에서 만들어진 행동 메서드의 내용은 호출하는 입장에서는 어떤 방식으로 동작하는지 알 수 없고,
 * 어떻게 동작하는 지 알 수 없습니다. 이것이 OOP가 지향하는 '캡슐화'라는 개념입니다.
 * 단지, 객체의 행동만 호출할 뿐입니다.
 * <p>
 * 자료구조는 투명(glass box)이고, 객체는 불투명(black box)입니다.
 * 자료구조는 수동적이고, 객체는 능동적입니다.
 * 자료구조는 죽어있고, 객체는 살아있습니다.
 * <p>
 * 모든 프로그래밍(절차적/함수형/객체지향/...) 스타일의 핵심 목표는 가시성의 범위를 축소하고,
 * 사물을 단순화시키는 것입니다.
 * 객체지향적이고 선언형 스타일을 유지하기 위해서는, 데이터를 객체 안에 감추고 외부에 노출하면 안됩니다.
 * <p>
 * 근본적으로 getter, setter는 객체 내부의 데이터를 전달하는 역할을 하기 때문에 캡슐화를 위반합니다.
 * 겉으로만 메서드를 통해서 접근하는 것 같지만, 결국에는 내부 데이터를 전달해주는 역할을 하기 때문입니다.
 * <p>
 * 데이터를 찾아서 값을 직접 셋팅하는 뜻의 setter를 절대 사용하면 안됩니다.
 * 데이터를 찾아서 그대로 전달해주는 뜻의 getter를 절대 사용하면 안됩니다.
 */
class DontUseGetterSetter {

    public static void main(String[] args) {
        int dollars = 10;

        CashForDataStructure cashForDataStructure = new CashForDataStructure();
        cashForDataStructure.setDollars(dollars);

        CashForOop cashForOop = new CashForOop(dollars);

        System.out.println(cashForDataStructure.getDollars() == cashForOop.dollars());//true
    }

    /**
     * getter와 setter를 사용한 단순 자료 구조(data structure)
     */
    private static class CashForDataStructure {
        private int dollars;

        /**
         * "dollars를 찾아서 가져옵니다"라는 뜻의 메서드입니다.
         * 사용하면 안됩니다.
         */
        public int getDollars() {
            return dollars;
        }

        /**
         * "dollars를 찾아서 셋팅합니다"라는 뜻의 메서드입니다.
         * 사용하면 안됩니다.
         */
        public void setDollars(int dollars) {
            this.dollars = dollars;
        }
    }

    /**
     * 불변 객체
     */
    private static class CashForOop {
        private final int value;

        public CashForOop(int value) {
            this.value = value;
        }

        /**
         * "객체에서 dollars를 만들어서 제공합니다"
         * 내부 데이터를 가져오기보다는 객체의 행동을 존중합니다.
         */
        public int dollars() {
            return value;
        }
    }
}

package elegantobject.step2_education.step2_6_makeaimmutableobject;

/**
 * "불변 객체 사용하여 가변 객체의 사이드 이펙트를 제거한다"<p>
 * <p>
 * 가변 객체는 객체가 수정될 여지가 있습니다. 결국 개발자가 객체를 잘못 다룰 가능성이 존재합니다.<p>
 * 하지만 불변 객체를 사용하면 중간에 객체가 수정될 가능성은 없습니다. 객체의 불변을 보장하여 신뢰있는 객체를 사용할 수 있습니다.<p>
 */
class AdvantageOfSideEffectFree {

    public static void main(String[] args) {
        MutableObjectCash five = new MutableObjectCash(5);
        printDoubleDollars(five);// $10 // 메서드 내부에서 객체를 사용하고 나면 다음 객체 사용시 문제가 될 수 있다.
        System.out.println(five);// $5를 생각했지만 $10가 나오는 사이드 이펙트가 발생한다.
    }

    private static class MutableObjectCash {
        private int dollars;

        public MutableObjectCash(int dollars) {
            this.dollars = dollars;
        }

        public void multiply(int factor) {
            this.dollars *= factor;
        }

        @Override
        public String toString() {
            return "$" + dollars;
        }
    }

    private static void printDoubleDollars(MutableObjectCash cash) {
        cash.multiply(2); // Cash를 출력하기 위해서 Cash를 변경 이후에 사이드 이팩트가 날 수 있다.
        System.out.println(cash);
    }
}

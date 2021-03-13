package elegantobject.education.makeaimmutableobject;

class AdvantageOfSideEffectFree {

    public static void main(String[] args) {
        MutableObjectCash five = new MutableObjectCash(5);
        printDoubleDollars(five);// $10 // 메서드 내부에서 객체를 사용하고 나면 다음 객체 사용시 문제가 될 수 있다.
        System.out.println(five);// $5를 생각했지만 $10가 나오는 사이드 이팩트가 발생한다.
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

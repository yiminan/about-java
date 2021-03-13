package elegantobject.education.makeaimmutableobject;

class AdvantageOfSideEffectFree {

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

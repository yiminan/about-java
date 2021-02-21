package elegantobject.dontuseer;

public class DontUseEr {

    public static void main(String[] args) {
        final int dollar = 10;
        // 무엇을 하는지(what he does)보다
        CashFormatter cashFormatter = new CashFormatter(dollar);
        cashFormatter.format();// $ 10
        // 무엇인지(what he is)로 객체를 만들어야 한다.
        Cash cash = new Cash(dollar);
        cash.usd();// $ 10
    }

    static class CashFormatter {
        private final int dollars;

        CashFormatter(int dlr) {
            this.dollars = dlr;
        }

        public String format() {
            return String.format("$ %d", this.dollars);
        }
    }

    static class Cash {
        private final int dollars;

        Cash(int dlr) {
            this.dollars = dlr;
        }

        public String usd() {
            return String.format("$ %d", this.dollars);
        }
    }
}

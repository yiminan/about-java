package elegantobject.birth.dontuseer;

/**
 * 클래스는 객체의 팩토리입니다.
 * new 키워드도 static method
 * 클래스의 이름은 무엇을 하는지(what he does)보다 무엇인지(what he is)로 객체를 만들어야 합니다.
 * 무엇을 하는지로 이름을 짓다보면 -er, -or과 같은 접미사가 붙게 됩니다. 이 접미사는 사용하면 안좋습니다.
 * ex) Handler, Writer, Reader, Validator
 * 예외도 물론 존재합니다. 처음에는 무엇을 하는지로 만들어졌다가 무엇인지로 변한 단어들입니다.
 * ex) Computer, User
 * 객체는 캡슐화된 데이터의 대표자입니다. 스스로 상태를 가지고, 행위가 가능해야합니다.
 * PrimerFinder(X) => PrimerNumber(O)
 */
class DontUseEr {

    public static void main(String[] args) {
        final int dollar = 10;
        // 무엇을 하는지(what he does)보다
        CashFormatter cashFormatter = new CashFormatter(dollar);
        cashFormatter.format();// $ 10
        // 무엇인지(what he is)로 객체를 만들어야 한다.
        Cash cash = new Cash(dollar);
        cash.usd();// $ 10
    }

    private static class CashFormatter {
        private final int dollars;

        CashFormatter(int dlr) {
            this.dollars = dlr;
        }

        public String format() {
            return String.format("$ %d", this.dollars);
        }
    }

    private static class Cash {
        private final int dollars;

        Cash(int dlr) {
            this.dollars = dlr;
        }

        public String usd() {
            return String.format("$ %d", this.dollars);
        }
    }
}

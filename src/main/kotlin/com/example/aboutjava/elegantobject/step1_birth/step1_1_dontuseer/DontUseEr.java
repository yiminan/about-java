package com.example.aboutjava.elegantobject.step1_birth.step1_1_dontuseer;

/**
 * "클래스의 이름으로 -er로 끝나는 이름을 사용하면 안됩니다"<p>
 * <p>
 * 클래스는 객체의 팩토리입니다.<p>
 * - 클래스 : 객체를 인스턴스로 만들기 위한 설계도<p>
 * - 객체 : 클래스가 선언만 된 실체, '캡슐화된 데이터의 대표자'<p>
 * - 인스턴스 : 클래스로 선언된 객체에 리소스가 할당된 실체<p>
 * <p>
 * new 키워드는 클래스의 정적 메서드(static method)입니다.<p>
 * 흔히 아는 팩토리 패턴과 new 연산자는 개념적으로 동일합니다.<p>
 * 물론 팩토리 패턴이 new 연산자보다 더 유연하고 좋습니다.<p>
 * <p>
 * 클래스 이름을 짓는 방법<p>
 * - 클래스의 이름은 무엇을 하는지(what he does)보다 무엇인지(what he is)로 객체를 만들어야 합니다.<p>
 * - 무엇을 하는지로 이름을 짓다보면 -er, -or과 같은 접미사가 붙게 됩니다. 이 접미사는 사용하면 안좋습니다.<p>
 * <p>
 * ex) Handler, Writer, Reader, Validator<p>
 * 예외도 물론 존재합니다. 처음에는 무엇을 하는지로 만들어졌다가 무엇인지로 변한 단어들입니다.<p>
 * ex) Computer, User<p>
 * 객체는 캡슐화된 데이터의 대표자입니다. 스스로 상태를 가지고, 행위가 가능해야합니다.<p>
 * PrimerFinder(X) => PrimerNumber(O)<p>
 * <p>
 * 클래스의 가장 안좋은 이름 예시는 유틸클래스입니다. Util, Utils로 끝나는 클래스입니다.
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

    /**
     * 잘못된 사용 예시
     */
    private static class CashFormatter {
        private final int dollars;

        CashFormatter(int dlr) {
            this.dollars = dlr;
        }

        public String format() {
            return String.format("$ %d", this.dollars);
        }
    }

    /**
     * 좋은 사용 예시
     */
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

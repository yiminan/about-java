package elegantobject.birth.useprimaryconstructor;

/**
 * "생성자 하나를 주 생성자로 사용합니다"<p>
 * <p>
 * 응집도가 높은 올바른 클래스는 많은 constructor과 적은 method로 구성됩니다.<p>
 * 생성자를 여러개 만들다보면 객체의 인스턴스 변수가 셋팅되어야하는 부분은 동일합니다.<p>
 * 주 생성자(primary constructor)를 한 개로 만들어서 변수가 셋팅되는 생성자를 한 개로 지정합니다.<p>
 * 생성자도 메서드와 마찬가지로 재사용성을 높이고 유연성을 향상시킬 수 있습니다.<p>
 * 객체의 동일한 행위에 대한 메서드를 많이 만들게 되면 '단일 책임 원칙'에 위배됩니다.<p>
 * 부 생성자(secondary constructor)를 사용해서 오버라이딩이 가능하게 하고, 주 생성자를 사용하면 '단일 책임 원칙'를 지킬 수 있습니다.<p>
 * constructor가 많아지면 유연성이 향상됩니다.<p>
 * 주 생성자는 부 생성자 마지막에 위치시키고, 주 생성자를 this()로 부 생성자에서 사용하면, 유효성 로직도 주 생성자에만 위치시켜야합니다.<p>
 * <p>
 * 결론)<p>
 * 주 생성자(primary constructor)를 사용하고, 주 생성자를 통해서만 내부 프로퍼티를 초기화해야합니다. 그렇게 부 생성자를 사용하게 됩니다.<p>
 *
 * @see <a href="https://velog.io/@wannte/%EA%B0%9D%EC%B2%B4-%EC%83%9D%EC%84%B1%EC%8B%9C-%EC%9C%A0%ED%9A%A8%EC%84%B1-%EA%B2%80%EC%82%AC%EC%97%90-%EA%B4%80%ED%95%98%EC%97%AC">객체 생성시 유효성 검사에 관하여</a>
 */
class UsePrimaryConstructor {

    public static void main(String[] args) {
        Cash secondaryCash1 = new Cash(1.0F);
        Cash secondaryCash2 = new Cash("1.0");
        Cash primaryCash = new Cash(1L);
    }

    private static class Cash {
        private final int dollars;

        // 부 생성자
        Cash(float dlr) {
            this((int) dlr);
        }

        // 부 생성자
        Cash(String dlr) {
            this(Integer.parseInt(dlr));
        }

        // 주 생성자 - 부 생성자에서 사용되어 재사용성 UP
        Cash(int dlr) {
            validate(dlr);
            this.dollars = dlr;
        }

        private void validate(int dlr) {
            if (dlr > 0) {
                throw new IllegalArgumentException(String.format("invalid dollar %d", dlr));
            }
        }
    }
}

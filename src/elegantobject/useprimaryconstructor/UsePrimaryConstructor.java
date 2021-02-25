package elegantobject.useprimaryconstructor;

/**
 * 생성자 하나를 주 생성자로 사용합니다.
 * 생성자를 여러개 만들다보면 객체의 인스턴스 변수가 셋팅되어야하는 부분은 동일합니다.
 * 주 생성자를 한 개로 만들어서 변수가 셋팅되는 생성자를 한 개로 지정합니다.
 * 생성자도 메서드와 마찬가지로 재사용성을 높이고 유연성을 향상시킬 수 있습니다.
 * 객체의 동일한 행위에 대한 메서드를 많이 만들게 되면 '단일 책임 원칙'에 위배됩니다.
 * 부 생성자를 사용해서 오버라이딩이 가능하게 하고, 주 생성자를 사용하면 '단일 책임 원칙'를 지킬 수 있습니다.
 */
public class UsePrimaryConstructor {

    public static void main(String[] args) {
        Cash secondaryCash1 = new Cash(1.0F);
        Cash secondaryCash2 = new Cash("1.0");
        Cash primaryCash = new Cash(1L);
    }

    static class Cash {
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
            this.dollars = dlr;
        }
    }
}

package elegantobject.useprimaryconstructor;

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

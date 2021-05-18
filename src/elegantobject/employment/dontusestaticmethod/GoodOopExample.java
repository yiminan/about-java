package elegantobject.employment.dontusestaticmethod;

/**
 * "절차지향적 코드가 객체 지향이 되는 변화"<p>
 * <p>
 * 객체지향 프로그래밍이란 더 작은 객체들을 기반으로 더 큰 객체들을 조합하는 작업입니다.<p>
 * 정적 메서드를 포함하는 작은 객체들을 조합해서 더 큰 객체를 만들 수가 업습니다.<p>
 * 정적 메서드는 합성(composition)이라는 아이디어와 대치됩니다.<p>
 * 그래서 OOP에서 정적 메서드를 사용하면 안됩니다.<p>
 * 결론적으로, 유지보수성을 위해서는 소프트웨어 어디에서도 static 키워드를 사용하면 안됩니다.<p>
 */
class GoodOopExample {
    public static void main(String[] args) {
        Client client = new Client(21);
        /**
         * "절차지향 코드"
         */
        float rate;
        if (client.age() > 65) {
            rate = 2.5F;
        } else {
            rate = 3.0F;
        }
        /**
         * "객체지향 코드"
         */
        float rate2 = new If(
                new GreaterThan(new AgeOf(client), 65),
                2.5F, 3.0F
        ).result();

        /**
         * 결과
         * rate: 3.00 , rate2: 3.00
         */
        System.out.println(String.format("rate: %.2f , rate2: %.2f", rate, rate2));
    }

    private static class If {
        private final GreaterThan greaterThan;
        private final float trueValue;
        private final float falseValue;

        public If(GreaterThan greaterThan, float trueValue, float falseValue) {
            this.greaterThan = greaterThan;
            this.trueValue = trueValue;
            this.falseValue = falseValue;
        }

        public float result() {
            if (greaterThan.right()) {
                return trueValue;
            }
            return falseValue;
        }
    }

    private static class GreaterThan {
        private final AgeOf ageOf;
        private final int comparedAge;

        public GreaterThan(AgeOf ageOf, int comparedAge) {
            this.ageOf = ageOf;
            this.comparedAge = comparedAge;
        }

        public boolean right() {
            return ageOf.age() > comparedAge;
        }
    }

    private static class AgeOf {
        private final int age;

        public AgeOf(Client client) {
            this.age = client.age();
        }

        public int age() {
            return age;
        }
    }

    private static class Client {
        private final int age;

        public Client(int age) {
            this.age = age;
        }

        public int age() {
            return age;
        }
    }
}

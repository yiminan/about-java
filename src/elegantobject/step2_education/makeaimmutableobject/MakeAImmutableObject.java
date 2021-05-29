package elegantobject.step2_education.makeaimmutableobject;

/**
 * "불변 객체(Immutable Object)로 만들어야합니다"<p>
 * <p>
 * 불변 객체(Immutable Object)란?<p>
 * - 인스턴스를 생성하면, 상태를 변경할 수 없는 객체를 불변 객체라고 합니다.<p>
 * - 불변 클래스로 만든 불변 객체는 크기가 작고 응집력이 높고, 결합력이 낮고, 유지보수가 쉽게 만들수 있습니다.<p>
 * - 불변 객체에서 내부 프로퍼티를 final 키워드를 사용해서 생성자 외부에서 프로퍼티 값을 수정할 경우 컴파일 타임 에러를 발생합니다.<p>
 * - 불변 객체가 내부 프로퍼티를 수정하게되면 새로운 인스턴스를 만들어서 반환해야합니다.<p>
 * <p>
 * 불변 객체가 가변 객체보다 더 좋다고 이야기하는 것이 아닙니다.<p>
 * 이야기의 요지는 "가변 객체의 생성은 절대 금지해야 합니다." 입니다.<p>
 * <p>
 * 가변 객체를 써야하는 경우가 있는데 그 예시 중에 하나는 지연 로딩(Lazy Loading)입니다.<p>
 * 지연 로딩은 필요한 데이터를 이후에 필요한 시점에 채워서 사용하는 방법입니다.<p>
 * 현재 Java에서는 불변 객체를 사용하면서 지연로딩을 사용하는 방법은 없습니다.<p>
 */
class MakeAImmutableObject {

    public static void main(String[] args) {
        MutableCash five = new MutableCash(5);
        five.multiply(10);
        System.out.println(five);// $50

        ImmutableCash _five = new ImmutableCash(5);
        ImmutableCash _fifty = _five.multiply(10);
        System.out.println(_fifty);// $50
    }

    /**
     * 가변 클래스 예시
     */
    private static class MutableCash {
        private int dollars;

        public MutableCash(int dollars) {
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

    /**
     * 불변 클래스 예시
     */
    private static class ImmutableCash {
        private final int dollars;

        public ImmutableCash(int dollars) {
            this.dollars = dollars;
        }

        public ImmutableCash multiply(int factor) {
            return new ImmutableCash(this.dollars * factor);
        }

        @Override
        public String toString() {
            return "$" + dollars;
        }
    }
}

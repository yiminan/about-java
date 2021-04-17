package elegantobject.retirement.neverreturnnull;

/**
 * "절대 null을 반환하지 마세요"
 * 메서드의 파라미터에 null을 전달하는 것은 매우 안좋은 방법입니다.
 * 마찬가지로 메서드가 null을 반환하는 것도 절대 안됩니다.
 * 반환된 객체가 null이면 객체를 사용하면서 NPE가 발생할 수 있기 때문에,
 * 해당 메서드를 신뢰할 수 없습니다. 그래서 null을 반환하면 안됩니다.
 * 객체가 만든 반환 값을 의심하고 결과에 대한 확인 코드가 들어간다면 OOP를 위반하는 일입니다.
 * <p>
 * 객체는 자신만의 생명주기/행동/상태를 가지는 살아있는 유기체입니다.
 * 변수는 객체에게 붙여진 별명입니다. 이 변수가 null이라면 객체는 신뢰가 없어집니다.
 * '객체의 신뢰'라는 것은 객체 스스로 행동에 대해서 전적으로 책임지고, 외부에서 간섭하지 않는 것입니다.
 * 반환값을 검사하는 것은 객체에 대한 신뢰가 없다는 말입니다. 나중에 유지보수성이 크게 낮아집니다.
 * 프로그램 코드는 다른 프로그래머가 유지보수를 할 때,
 * null이 발생할 여지가 생기면 코드에 신뢰성이 떨어지니까 애초에 신뢰성이 떨어지지 않게 해야합니다.
 */
class NeverReturnNull {

    private static class Data {
        private String title;

        public Data(String title) {
            this.title = title;
        }

        /**
         * null을 반환하는 잘못된 메서드 형태입니다.
         * null이 반환되기 시작하면 이후에 title을 가지고 호출될 메서드가 NPE을 발생할 여지가 생깁니다.
         * 결국 이 메서드가 반환하는 객체 String은 신뢰할 수 없습니다.
         */
        public String title() {
            if (title == null || title.isBlank()) {
                return null;
            }
            return title;
        }
    }
}

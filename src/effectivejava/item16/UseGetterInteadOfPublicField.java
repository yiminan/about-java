package effectivejava.item16;

/**
 * "public 클래스에서는 public 필드가 아닌 접근자 메서드를 사용해야합니다"<p>
 */
class UseGetterInteadOfPublicField {

    private static class InvalidPoint {
        public double x;
        public double y;
    }
}

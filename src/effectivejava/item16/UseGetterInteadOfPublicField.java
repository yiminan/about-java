package effectivejava.item16;

/**
 * "public 클래스에서는 public 필드가 아닌 접근자 메서드를 사용해야합니다"<p>
 * 기본적으로 내부 인스턴스 필드는 private을 적용하고, 필드의 내용을 변경하거나, 가져올땐 public setter, getter를 사용합니다.<p>
 */
class UseGetterInteadOfPublicField {

    /**
     * public class로 지정해서 사용한다면 절대 내부 가변 필드를 public으로 노출해서는 안된다.
     */
    private static class InvalidPoint {
        public double x;
        public double y;
    }

    private static class ValidPoint {
        private double x;
        private double y;

        public ValidPoint(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }
    }

    private static class ImmutablePoint {
        private final double x;
        private final double y;

        public ImmutablePoint(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }
}

package effectivejava.item16;

/**
 * "public 클래스에서는 public 필드가 아닌 접근자 메서드를 사용해야합니다"<p>
 */
class UseGetterInteadOfPublicField {

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
}

package elegantobject.education.makeaimmutableobject;
class DisadvantageOfIdentityMutability {
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
}

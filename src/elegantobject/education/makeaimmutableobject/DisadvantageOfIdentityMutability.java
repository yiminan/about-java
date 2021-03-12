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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MutableCash that = (MutableCash) o;
            return dollars == that.dollars;
        }

        @Override
        public int hashCode() {
            return Objects.hash(dollars);
        }
    }
}

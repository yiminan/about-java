package elegantobject.employment.dontusestaticmethod;

class FunctionalProgramming {

    public static void main(String[] args) {
        Number declarativeMax = new Max(5, 6);

        Optional<Integer> functionalMax = Arrays.asList(5, 6)
                .stream()
                .max(Integer::compare);

        System.out.println(declarativeMax.intValue() == functionalMax.get());
    }

    private interface Number {
        int intValue();
    }

    private static class Max implements Number {
        private final int a;
        private final int b;

        public Max(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int intValue() {
            return Math.max(this.a, this.b);
        }
    }
}

package effectivejava.item10.equivalence_relation;

/**
 * "동치관계(equivalence relation)의 대칭성(symmetry)"
 * - 두 객체는 서로에 대한 동치 여부에 똑같이 답해야 한다.<p>
 * - 반사성(reflexivity)과 달리 대칭성(symmetry) 요건은 자칫하면 어길 수 있다.<p>
 * -
 */
class SymmetryForEquicalenceRelation {

    public static void main(String[] args) {
        InvalidSymmetry is = new InvalidSymmetry("Ryan");
        String name = "ryan";
        System.out.println(is.equals(name));// true
    }

    private static class InvalidSymmetry {
        private final String name;

        public InvalidSymmetry(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof InvalidSymmetry)
                return name.equalsIgnoreCase(((InvalidSymmetry) obj).name);
            if (obj instanceof String)
                return name.equalsIgnoreCase((String) obj);
            return false;
        }
    }
}

package effectivejava.item10.equivalence_relation;

/**
 * "리스코프 치환 원칙 위배"한 equals() 예시<p>
 */
class InvalidLiskovSubstitutionPrinciple extends Point {

    public InvalidLiskovSubstitutionPrinciple(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Point p = (Point) obj;
        return p.x == x && p.y == y;
    }
}

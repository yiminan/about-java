package com.example.aboutjava.effectivejava.item10;

/**
 * "리스코프 치환 원칙 위배"한 equals() 예시<p>
 */
class InvalidLiskovSubstitutionPrinciple {

    private final int x;
    private final int y;

    public InvalidLiskovSubstitutionPrinciple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        InvalidLiskovSubstitutionPrinciple p = (InvalidLiskovSubstitutionPrinciple) obj;
        return p.x == x && p.y == y;
    }
}

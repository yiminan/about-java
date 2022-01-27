package com.example.aboutjava.effectivejava.item10;

import java.util.ArrayList;
import java.util.List;

/**
 * "동치관계(equivalence relation)의 대칭성(symmetry)"
 * - 두 객체는 서로에 대한 동치 여부에 똑같이 답해야 한다.<p>
 * - 반사성(reflexivity)과 달리 대칭성(symmetry) 요건은 자칫하면 어길 수 있다.<p>
 */
class SymmetryForEquivalenceRelation {

    private static class Symmetry {
        private final String name;

        public Symmetry(String name) {
            this.name = name;
        }

        /**
         * 대칭성 위반 equals 예시
         */
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Symmetry)
                return name.equalsIgnoreCase(((Symmetry) obj).name);
            if (obj instanceof String)
                return name.equalsIgnoreCase((String) obj);
            return false;
        }

        /**
         * 대칭성 적용 예시
         * 대칭성을 지키기 위해서 String 케이스를 비교하는 부분을 없애버립니다.
         */
//        @Override
//        public boolean equals(Object obj) {
//            return obj instanceof Symmetry && ((Symmetry) obj).name.equalsIgnoreCase(name);
//        }
    }
}

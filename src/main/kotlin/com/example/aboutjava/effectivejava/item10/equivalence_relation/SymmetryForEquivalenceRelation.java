package com.example.aboutjava.effectivejava.item10.equivalence_relation;

import java.util.ArrayList;
import java.util.List;

/**
 * "동치관계(equivalence relation)의 대칭성(symmetry)"
 * - 두 객체는 서로에 대한 동치 여부에 똑같이 답해야 한다.<p>
 * - 반사성(reflexivity)과 달리 대칭성(symmetry) 요건은 자칫하면 어길 수 있다.<p>
 */
class SymmetryForEquivalenceRelation {

    public static void main(String[] args) {
        Symmetry is = new Symmetry("Ryan");
        String name = "ryan";
        /**
         * "대칭성 위반"
         * 대칭성인 서로 equals()를 호출했을때 결과물이 다르다.
         * 대칭성 위반인 부분을 대칭성을 만족하게 바꾸어주어야한다.
         */
        System.out.println(is.equals(name));// true
        System.out.println(name.equals(is));// false
        /**
         * "컬렉션 대칭성 위반 비교 예시"
         * 일단 Oracle JDK의 List는 대칭성을 잘 지켜준다.
         * 하지만 이는 구현하기 나름이다. 꼭 JDK마다 확인해주어야하는 경우가 생긴다.
         * 애초에 대칭성을 지키면서 구현해야합니다.
         */
        List<Symmetry> iss = new ArrayList<>();
        iss.add(is);
        System.out.println(iss.contains(is));//true
    }

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
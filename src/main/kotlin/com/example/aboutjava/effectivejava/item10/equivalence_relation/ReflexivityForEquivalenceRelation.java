package com.example.aboutjava.effectivejava.item10.equivalence_relation;

import java.util.Arrays;
import java.util.List;

/**
 * "동치관계(equivalence relation)의 반사성(reflexivity)"<p>
 * - 단순히 객체는 자기 자신과 같아야한다는 것<p>
 * - 일부러 어기지 않는 이상 객체는 자기 자신과 같을 수 밖에 없다.<p>
 * - 반사성을 어기면 컬렉션에 객체를 넣고, contains 메서드를 호출하면 false를 내보내게 됩니다.<p>
 */
class ReflexivityForEquivalenceRelation {
    public static void main(String[] args) {
        Member member = new Member("Ryan");
        if (member.equals(member)) {
            System.out.println("Member is member.");
        }
        List<Member> members = Arrays.asList(member);
        if (members.contains(member)) {
            System.out.println("Member contains in members.");
        }
    }

    private static class Member {
        private final String name;

        private Member(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            return this == o;// 같은 객체인 경우에는 같아야한다.(반사성)
        }
    }
}

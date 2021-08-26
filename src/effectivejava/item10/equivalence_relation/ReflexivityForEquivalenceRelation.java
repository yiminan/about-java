package effectivejava.item10.equivalence_relation;

import java.util.Arrays;
import java.util.List;

/**
 * "동치관계(equivalence relation)의 반사성(reflexivity)"<p>
 * -
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

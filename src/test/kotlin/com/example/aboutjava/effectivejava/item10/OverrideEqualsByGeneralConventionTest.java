package com.example.aboutjava.effectivejava.item10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static com.example.aboutjava.effectivejava.item10.ReflexivityForEquivalenceRelation.Member;
import static com.example.aboutjava.effectivejava.item10.SymmetryForEquivalenceRelation.Symmetry;
import static com.example.aboutjava.effectivejava.item10.TransitivityForEquivalenceRelation.Color;
import static com.example.aboutjava.effectivejava.item10.TransitivityForEquivalenceRelation.ColorPoint;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Item 10 - equals 는 일반 규약을 지켜 재정의 해야 한다.")
@DataJpaTest
class OverrideEqualsByGeneralConventionTest {

    @Autowired
    private UserRepository userRepository;

    @DisplayName("equals 재정의가 필요하지 않은 경우 - entity")
    @Test
    void dontNeedEqualsWithEntity() {
        // when
        User ryan1 = new User("Ryan");
        User ryan2 = new User("Ryan");
        userRepository.save(ryan1);
        userRepository.save(ryan2);
        // then
        assertThat(ryan1).isNotSameAs(ryan2);
    }

    @DisplayName("equals 재정의가 필요하지 않은 경우 - thread")
    @Test
    void dontNeedEqualsWithThread() {
        // when
        Thread thread1 = new Thread("thread");
        Thread thread2 = new Thread("thread");
        // then
        assertThat(thread1).isNotSameAs(thread2);
    }

    @DisplayName("동치관계(equivalence relation)의 반사성(reflexivity) 예시")
    @Test
    void equalsWithReflexivity() {
        // given
        Member member = new Member("Ryan");
        // when & then
        assertThat(member).isEqualTo(member);
        // given
        List<Member> members = List.of(member);
        // when & then
        assertThat(members).contains(member);
    }

    @DisplayName("동치관계(equivalence relation)의 대칭성(symmetry) 예시")
    @Test
    void equalsWithSymmetry() {
        // given
        Symmetry is = new Symmetry("Ryan");
        String name = "ryan";
        // when & then
        /**
         * "대칭성 위반"
         * 대칭성인 서로 equals()를 호출했을때 결과물이 다르다.
         * 대칭성 위반인 부분을 대칭성을 만족하게 바꾸어주어야한다.
         */
        assertThat(is.equals(name)).isTrue();
        assertThat(name.equals(is)).isFalse();
        /**
         * "컬렉션 대칭성 위반 비교 예시"
         * 일단 Oracle JDK의 List는 대칭성을 잘 지켜준다.
         * 하지만 이는 구현하기 나름이다. 꼭 JDK마다 확인해주어야하는 경우가 생긴다.
         * 애초에 대칭성을 지키면서 구현해야합니다.
         */
        List<Symmetry> iss = new ArrayList<>();
        iss.add(is);
        assertThat(iss.contains(is)).isTrue();
    }

    @DisplayName("동치관계(equivalence relation)의 추이성(transitivity)")
    @Test
    void equalsWithTransitivity() {
        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
        // when & then
        // p1 -> p2
        assertThat(p1.equals(p2)).isTrue();
        // p2 -> p3
        assertThat(p2.equals(p3)).isTrue();
        // p1 -> p3 추이성 위배
        assertThat(p1.equals(p3)).isFalse();
    }
}

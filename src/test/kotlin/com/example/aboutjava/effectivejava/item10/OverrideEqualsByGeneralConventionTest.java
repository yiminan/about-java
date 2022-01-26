package com.example.aboutjava.effectivejava.item10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static com.example.aboutjava.effectivejava.item10.ReflexivityForEquivalenceRelation.Member;
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
}

package com.example.aboutjava.effectivejava.item14;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Item 14 - Comparable을 구현할지 고려해야합니다.")
class ConsiderWhetherToImplementComparableTest {

    @DisplayName("Comparable 를 구현한 구현체 TreeSet 형태 구현")
    @Test
    void exampleTreeSetWithComparable() {
        // given
        Set<String> strings = new TreeSet<>();
        // when
        Collections.addAll(strings, "B", "C", "A");
        // then
        /**
         * String은 {@link Comparable}을 구현한 구현체입니다.<p>
         * compareTo를 통해서 단순 동치성 비교에 더해 순서까지 비교할 수 있습니다.<p>
         */
        assertThat(strings).hasToString("[A, B, C]");// [A, B, C]
    }
}

package com.example.aboutjava.effectivejava.item17;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.aboutjava.effectivejava.item17.MinimizeThePossibilityOfChange.Operand;
import static org.assertj.core.api.Assertions.assertThat;

class MinimizeThePossibilityOfChangeTest {

    @DisplayName("변경 가능성을 최소화 시켜줄 수 있는 불변 인스턴스 사용")
    @Test
    void useImmutableInstanceMinimizedPossibilityOfChange() {
        // given
        Operand one = new Operand(1);
        Operand two = new Operand(2);
        // when
        Operand three = one.plus(two);
        // then
        assertThat(three).isEqualTo(new Operand(3));
    }
}

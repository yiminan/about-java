package com.example.aboutjava.effectivejava.item17;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.BitSet;

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

    @DisplayName("불변 객체를 사용하여 내용 변경시 새로 생성하는 불변 객체 예시")
    @Test
    void showExampleImmutableInstance() {
        // given
        BigInteger moby = BigInteger.valueOf(10L);
        // when & then
        assertThat(moby).isNotSameAs(moby.flipBit(0));
    }

    @DisplayName("가변 동반 클래스로 생성된 객체를 재활용하는 예시")
    @Test
    void useMutableCompanionInstance() {
        // given
        BitSet five = BitSet.valueOf(new long[]{1L, 2L});
        int beforeHashCode = five.hashCode();
        // when
        five.flip(0);// 가변 클래스 사용(동일 인스턴스 재활용)
        // then
        assertThat(five.hashCode()).isNotEqualTo(beforeHashCode);
    }
}

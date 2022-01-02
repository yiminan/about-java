package com.example.aboutjava.effectivejava.item4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class UsePrivateConstructorToBlockInstantiationTest {

    @DisplayName("인스턴스화가 불가능한 유틸 클래스 예외 발생")
    @Test
    void usePrivateConstructorToBlockInstantiation() {
        // when & then
        assertThatExceptionOfType(AssertionError.class).isThrownBy(
                UsePrivateConstructorToBlockInstantiation.ExampleUtility::new
        );
    }
}

package com.example.aboutjava.effectivejava.item4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("Item 4 - 인스턴스화를 막으려거든 private 생성자를 사용하라")
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

package com.example.aboutjava.effectivejava.item24;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

class MakeMemberClassWithStaticTest {
    @DisplayName("정적 클래스 사용 예시")
    @ParameterizedTest
    @EnumSource(MakeMemberClassWithStatic.Calculator.Operation.class)
    void useStaticClassForMemberClass(MakeMemberClassWithStatic.Calculator.Operation operation) {
        assertThat(operation).isNotNull();
    }
}

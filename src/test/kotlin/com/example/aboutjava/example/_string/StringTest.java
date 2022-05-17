package com.example.aboutjava.example._string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("`String` 의 사용법을 학습하기 위한 테스트")
class StringTest {
    @DisplayName("String의 concat(): 문자열 합치기")
    @Test
    void concat() {
        assertThat("ab".concat("cd")).isEqualTo("abcd");
    }

    @DisplayName("String의 반복 문자 생성")
    @Test
    void repeat() {
        assertThat("-".repeat(2)).isEqualTo("--");
    }
}

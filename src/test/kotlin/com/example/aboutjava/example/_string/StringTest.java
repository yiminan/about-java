package com.example.aboutjava.example._string;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("String의 비어있는지 여부 확인")
    @ParameterizedTest
    @EmptySource
    void isEmpty(String input) {
        assertThat(input).isEmpty();
    }

    @DisplayName("String의 공백 문자 또는 empty 문자 여부 확인")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void isBlank(String input) {
        assertThat(input).isBlank();
    }

    @DisplayName("String의 Upper case 적용")
    @Test
    void toUpperCase() {
        assertThat("apple".toUpperCase()).isEqualTo("APPLE");
    }

    @DisplayName("String의 Lower case 적용")
    @Test
    void toLowerCase() {
        assertThat("HOUSE".toLowerCase()).isEqualTo("house");
    }
}

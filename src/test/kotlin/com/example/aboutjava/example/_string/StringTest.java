package com.example.aboutjava.example._string;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @DisplayName("문자열의 인덱스를 통한 문자 찾기")
    @Test
    void charAt() {
        assertThat("banana".charAt(0)).isEqualTo('b');
    }

    @DisplayName("문자열의 문자를 통한 인덱스 찾기")
    @Test
    void indexOf() {
        assertThat("Bear".indexOf("e")).isEqualTo(1);
    }

    @DisplayName("문자열 해당 인덱스 위치의 문자 아스키 코드 번호 찾기")
    @ParameterizedTest
    @CsvSource(value = {"A,65", "B,66", "C,67"})
    void codePointAt(String character, int asciiCode) {
        assertThat(character.codePointAt(0)).isEqualTo(asciiCode);
    }

    @DisplayName("문자열의 앞 뒤에 나타나는 공백 제거")
    @ParameterizedTest
    @ValueSource(strings = {" hello", "hello ", " hello "})
    void trim(String input) {
        assertThat(input.trim()).isEqualTo("hello");
    }
}

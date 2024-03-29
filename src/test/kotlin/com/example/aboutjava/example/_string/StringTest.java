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

    @DisplayName("정규식 X ,문자열의 특정 문자 교체")
    @Test
    void replace() {
        assertThat("world".replace("ld", "d")).isEqualTo("word");
    }

    @DisplayName("정규식을 이용한 패턴에 맞는 문자열 교체")
    @ParameterizedTest
    @CsvSource(value = {"^w,b,borld"})
    void replaceAll(String regex, String replacement, String result) {
        assertThat("world".replaceAll(regex, replacement)).isEqualTo(result);
    }

    @DisplayName("정규식을 이용한 패턴에 맞는 처음부터 문자열 교체")
    @Test
    void replaceFirst() {
        assertThat("world".replaceFirst("w", "b")).isEqualTo("borld");
    }

    @DisplayName("시작 인덱스를 통해서 문자열 자르기")
    @ParameterizedTest
    @CsvSource(value = {"0,abcd", "1,bcd", "2,cd", "3,d"})
    void substringWithBeginIndex(int beginIndex, String result) {
        assertThat("abcd".substring(beginIndex)).isEqualTo(result);
    }

    @DisplayName("문자열에 해당하는 문자가 존재하는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"a,true", "ab,true", "bc,true", "e,false"})
    void contains(String matchChar, boolean result) {
        assertThat("abcd".contains(matchChar)).isEqualTo(result);
    }

    @DisplayName("리터럴 문자와 생성자 String 동등성 판단")
    @Test
    void newStringWithLiteral() {
        assertThat("Plane").isEqualTo(new String("Plane"));
    }

    @DisplayName("리터럴 문자와 생성자 String 인스턴스가 다른지 확인")
    @Test
    void isSameAs() {
        assertThat("Plane").isNotSameAs(new String("Plane"));
    }

    @DisplayName("문자열의 마지막이 해당 문자에 해당하는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"o,true", "t,false", "lo,true"})
    void endsWith(String suffix, boolean hasSuffix) {
        assertThat("hello".endsWith(suffix)).isEqualTo(hasSuffix);
    }

    @DisplayName("문자열의 동등성 확인")
    @ParameterizedTest
    @ValueSource(strings = {"APPLE", "BEER", "CAR", "apple"})
    void equals(String input) {
        assertThat(input.equals(input)).isTrue();
    }

    @DisplayName("문자열을 비교하여 더 앞선 문자열이 무엇인지 비교")
    @ParameterizedTest
    @CsvSource(value = {"a,b,-1", "b,a,1", "a,a,0"})
    void compareTo(String control, String test, int result) {
        assertThat(control.compareTo(test)).isEqualTo(result);
    }
}

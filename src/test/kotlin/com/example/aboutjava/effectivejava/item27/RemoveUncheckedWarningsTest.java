package com.example.aboutjava.effectivejava.item27;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Item 27 - 비검사 경고를 제거해야 합니다.")
class RemoveUncheckedWarningsTest {
    @DisplayName("비검사 경고 발생 예시")
    @Test
    void makeUncheckedWarnings() {
        // given & when
        Set<String> names = new HashSet();
        // then
        assertThat(names).isNotNull();
    }

    @DisplayName("비검사 경고 제거 예시")
    @Test
    void removeUncheckedWarnings() {
        // given & when
        Set<String> names = new HashSet<>();
        // then
        assertThat(names).isNotNull();
    }

    @DisplayName("비검사 경고 발생 시, @SuppressWarnings(\"unchecked\"를 사용해서 경고를 숨기는 경우")
    @Test
    void makeUncheckedWarningsWithAnnotation() {
        // given & when
        @SuppressWarnings("unchecked")
        Set<String> names = new HashSet();
        // then
        assertThat(names).isNotNull();
    }
}

package com.example.aboutjava.example.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringExampleTest {
    @DisplayName("concat 사용 예시")
    @Test
    void concat() {
        // given
        String abc = "ABC";
        String de = " DE";
        // when
        String abc_de = abc.concat(de);
        // then
        assertThat(abc_de).isEqualTo("ABC DE");
    }
}

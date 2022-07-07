package com.example.aboutjava.example._boolean;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Boolean의 사용 예시를 보기 위한 테스트")
class BooleanTest {

    @DisplayName("Boolean의 equals가 null을 비교하여 false로 내보낼 수 있는지 여부 확인")
    @ParameterizedTest
    @NullAndEmptySource
    void equalsByNullTest(String input) {
        // when & then
        assertThat(Boolean.FALSE.equals(input)).isFalse();
    }

    @DisplayName("Boolean의 비교를 위한 compareTo 활용")
    @ParameterizedTest
    @CsvSource(value = {"true,0", "false,1"})
    void compareTo(boolean value, int result) {
        assertThat(Boolean.TRUE.compareTo(value)).isEqualTo(result);
    }
}

package com.example.aboutjava.example._boolean;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Boolean의 사용 예시를 보기 위한 테스트")
class BooleanTest {

    @DisplayName("Boolean의 equals가 null을 비교하여 false로 내보낼 수 있는지 여부 확인")
    @Test
    void equalsByNullTest() {
        // when & then
        assertThat(Boolean.FALSE.equals(null)).isTrue();
    }
}

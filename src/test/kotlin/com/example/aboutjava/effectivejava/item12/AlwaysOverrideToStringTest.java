package com.example.aboutjava.effectivejava.item12;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.aboutjava.effectivejava.item12.AlwaysOverrideToString.PhoneNumber;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Item 12 - toString method 는 항상 재정의 해야 합니다.")
class AlwaysOverrideToStringTest {

    @DisplayName("toString 을 재 정의한 instance")
    @Test
    void instanceOverridingToString() {
        // given
        PhoneNumber ryanPhone = new PhoneNumber("010-1234-5678");
        // when & then
        assertThat(ryanPhone.toString()).hasToString("PhoneNumber{number='010-1234-5678'}");
    }
}

package com.example.aboutjava.effectivejava.item13;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.aboutjava.effectivejava.item13.OverrideCloneCarefully.PhoneNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("Item 13 - clone 재정의는 주의해서 진행하라.")
class OverrideCloneCarefullyTest {

    @DisplayName("clone의 재정의가 문제 없는 경우")
    @Test
    void cloneWithGoodOverride() {
        // given
        PhoneNumber phoneNumber = new PhoneNumber("010-1234-5678");
        // when
        PhoneNumber copyPhoneNumber = (PhoneNumber) phoneNumber.clone();
        // then
        assertAll(
                () -> assertThat(phoneNumber).isNotSameAs(copyPhoneNumber),
                () -> assertThat(phoneNumber).isEqualTo(copyPhoneNumber)
        );
    }
}

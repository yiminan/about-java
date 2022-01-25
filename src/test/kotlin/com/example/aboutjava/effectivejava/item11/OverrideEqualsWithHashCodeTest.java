package com.example.aboutjava.effectivejava.item11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.example.aboutjava.effectivejava.item11.OverrideEqualsWithHashCode.PhoneNumberWithDefaultHashCode;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Item 11 - equals 를 재정의 할 때는 hashCode 도 재정의 해야 합니다")
class OverrideEqualsWithHashCodeTest {

    @DisplayName("Example for object with default hashCode")
    @Test
    void equalsObjectWithDefaultHashCode() {
        // given
        String ryan = "Ryan";
        String ryanPhoneNumber = "010-1234-5678";
        PhoneNumberWithDefaultHashCode phoneNumber = new PhoneNumberWithDefaultHashCode(ryanPhoneNumber);
        Map<PhoneNumberWithDefaultHashCode, String> phoneNumbers = new HashMap<>();
        // when
        phoneNumbers.put(phoneNumber, ryan);
        // then
        assertThat(phoneNumbers.get(new PhoneNumberWithDefaultHashCode(ryanPhoneNumber))).isNull();
        assertThat(ryan.equals(phoneNumbers.get(new PhoneNumberWithDefaultHashCode(ryanPhoneNumber)))).isFalse();
    }
}

package com.example.aboutjava.example.pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PatternExampleTest {
    // email 유효 검사 또는 suffix '_suspended' 까지 허용
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9._+-]+@[A-Za-z0-9.-]+[.][A-Za-z]{2,6}(_suspended)?$");

    @DisplayName("유효한 Email 검증 예시")
    @Test
    void validateValidEmail() {
        // given
        String email = "ryan.an@gmail.com";
        // when
        boolean isEmail = EMAIL_PATTERN.matcher(email).find();
        // then
        assertThat(isEmail).isTrue();
    }

    @DisplayName("유효한 Email 검증 예시 with suffix `_suspended`")
    @Test
    void validateValidEmailWithSuffix_suspended() {
        // given
        String email = "ryan.an@gmail.com_suspended";
        // when
        boolean isEmail = EMAIL_PATTERN.matcher(email).find();
        // then
        assertThat(isEmail).isTrue();
    }

    @DisplayName("matcher의 파라미터에 null이 들어온 경우, 예외 발생")
    @Test
    void exceptionPatternMatcherWithNull() {
        // when & then
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> EMAIL_PATTERN.matcher(null).find());
    }

    @DisplayName("유효한 Email 검증 예시 with suffix `_suspended`")
    @Test
    void validateInvalidEmails() {
        // given
        List<String> emails = Arrays.asList("ryan.an**@gmail.com", "120938", "ryan.an@gmail");
        // when
        List<Boolean> isEmails = emails.stream()
                .map(EMAIL_PATTERN::matcher)
                .map(Matcher::find)
                .collect(Collectors.toList());
        // then
        assertThat(isEmails).containsOnly(false);
    }
}

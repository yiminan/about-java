package com.example.aboutjava.example.pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class PatternExampleTest {
    // email 유효 검사 또는 suffix '_suspended' 까지 허용
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9._+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}(_suspended)?$");

    @DisplayName("유효한 Email 검증 예시 with suffix `_suspended`")
    @Test
    void validateValidEmailWithSuffix_suspended() {
        boolean isEmail = EMAIL_PATTERN.matcher("ryan.an@gmail.com_suspended").find();
        // then
        assertThat(isEmail).isTrue();
    }
}

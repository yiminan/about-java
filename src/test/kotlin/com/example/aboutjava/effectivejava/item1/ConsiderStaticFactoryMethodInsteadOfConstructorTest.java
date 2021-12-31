package com.example.aboutjava.effectivejava.item1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class ConsiderStaticFactoryMethodInsteadOfConstructorTest {

    @DisplayName("1개 파라미터로 호출되는 클래스 타입을 반환하는 정적 팩토리 메서드")
    @Test
    void from() {
        // given
        Instant now = Instant.now();
        // when
        Date nowDate = Date.from(now);
        // then
        assertThat(nowDate).isEqualTo(new Date(now.toEpochMilli()));
    }
}

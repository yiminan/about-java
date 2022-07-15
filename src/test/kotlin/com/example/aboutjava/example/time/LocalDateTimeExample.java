package com.example.aboutjava.example.time;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LocalDateTimeExample {

    @DisplayName("LocalDateTime으로 현재 시간")
    @Test
    void now() {
        java.time.LocalDateTime now = java.time.LocalDateTime.now();

        assertThat(now).isInstanceOf(java.time.LocalDateTime.class);
    }

    @DisplayName("ZoneOffset과 ZoneId를 이용한 Instant 생성")
    @Test
    void createInstantByZoneOffsetOrZoneId() {
        java.time.LocalDateTime now = java.time.LocalDateTime.now();
        /**
         * UTC를 기준으로 시간을 표현해줍니다.
         */
        Instant utcPlus9DateTime = now.toInstant(ZoneOffset.of("+09:00"));
        /**
         * Summer Time을 고려해서 해당 나라의 시간을 표시해주는 장점이 있습니다.
         * Summer Time과 관계 없는 지역의 시간은 ZoneOffset과 같은 결과를 내어줍니다.
         */
        Instant asiaSeoulDateTime = now.atZone(ZoneId.of("Asia/Seoul")).toInstant();

        assertThat(utcPlus9DateTime).isEqualTo(asiaSeoulDateTime);
    }

    @DisplayName("LocalDateTime 에서 N년을 추가")
    @Test
    void plusYears() {
        int plusYear = 10;
        java.time.LocalDateTime now = java.time.LocalDateTime.now();

        LocalDateTime nowPlus10Years = now.plusYears(plusYear);

        assertThat(nowPlus10Years.getYear()).isEqualTo(now.getYear() + plusYear);
    }
}

package com.example.aboutjava.effectivejava.item1;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;

class ConsiderStaticFactoryMethodInsteadOfConstructorTest {

    @Test
    void adsjfklsdf() {
        /**
         * "from"
         * - from이 호출되는 클래스 타입을 반환하는 정적 팩토리 메서드
         * - 1개 파라미터를 전달받는 경우
         */
        Date nowDate = Date.from(Instant.now());
    }
}

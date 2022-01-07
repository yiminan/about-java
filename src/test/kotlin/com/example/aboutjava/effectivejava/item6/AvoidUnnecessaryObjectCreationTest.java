package com.example.aboutjava.effectivejava.item6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Item 6 - 불필요한 객체 생성을 피해야합니다")
class AvoidUnnecessaryObjectCreationTest {

    @DisplayName("String 을 생성자와 상수풀에 선언해서 사용하는 방식 차이")
    @Test
    void declareStringByConstructorOrConstantPool() {
        // when
        String s1 = new String("example");
        String s2 = new String("example");
        // then
        assertThat(s1).isNotSameAs(s2);
        // when
        String s3 = "example";
        String s4 = "example";
        // then
        assertThat(s3).isSameAs(s4);
    }

    @DisplayName("Boolean 을 생성자와 상수풀에 선언해서 사용하는 방식 차이")
    @Test
    void declareBooleanByConstructorOrConstantPool() {
        // when
        Boolean b1 = new Boolean("false");
        Boolean b2 = new Boolean("false");
        // then
        assertThat(b1).isNotSameAs(b2);
        // when
        Boolean b3 = Boolean.valueOf("true");
        Boolean b4 = Boolean.valueOf("true");
        // then
        assertThat(b3).isSameAs(b4);
    }
}

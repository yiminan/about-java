package com.example.aboutjava.effectivejava.item2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.aboutjava.effectivejava.item2.ConsiderABuilderWhenIHaveManyParameters.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ConsiderABuilderWhenIHaveManyParametersTest {

    @DisplayName("점층적 생성자 패턴(telescoping constructor pattern)")
    @Test
    void telescopingConstructorPattern() {
        // when
        TelescopingConstructorPattern actual1 = new TelescopingConstructorPattern("firstName", "lastName");
        TelescopingConstructorPattern actual2 = new TelescopingConstructorPattern("firstName", "lastName", 32, "man", "test@gmail.com");
        // then
        assertAll(
                () -> assertThat(actual1).isNotNull(),
                () -> assertThat(actual2).isNotNull()
        );
    }
}

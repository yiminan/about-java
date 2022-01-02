package com.example.aboutjava.effectivejava.item3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.aboutjava.effectivejava.item3.GuaranteeSingletonWithPrivateConstructorOrEnum.SingletonByPublicStaticFinalField;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class GuaranteeSingletonWithPrivateConstructorOrEnumTest {

    @DisplayName("'public static final' field를 만들어서 사용하는 방식")
    @Test
    void singletonByPublicStaticFinal() {
        // when
        SingletonByPublicStaticFinalField actual = SingletonByPublicStaticFinalField.INSTANCE;
        // then
        assertAll(
                () -> assertThat(actual).isNotNull(),
                () -> assertThat(actual).isInstanceOf(SingletonByPublicStaticFinalField.class)
        );
    }
}

package com.example.aboutjava.effectivejava.item3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.aboutjava.effectivejava.item3.GuaranteeSingletonWithPrivateConstructorOrEnum.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("Item 3 - private 생성자나 열거 타입으로 싱글턴임을 보증하라")
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

    @DisplayName("'static factory' method를 만들어서 사용하는 방식")
    @Test
    void singletonByStaticFactoryMethod() {
        // when
        SingletonByStaticFactoryMethod actual = SingletonByStaticFactoryMethod.getINSTANCE();
        // then
        assertAll(
                () -> assertThat(actual).isNotNull(),
                () -> assertThat(actual).isInstanceOf(SingletonByStaticFactoryMethod.class)
        );
    }

    @DisplayName("'static factory' method를 만들어서 사용하는 방식")
    @Test
    void singletonByEnum() {
        // when
        SingletonByEnum actual = SingletonByEnum.INSTANCE;
        // then
        assertAll(
                () -> assertThat(actual).isNotNull(),
                () -> assertThat(actual).isInstanceOf(SingletonByEnum.class)
        );
    }
}

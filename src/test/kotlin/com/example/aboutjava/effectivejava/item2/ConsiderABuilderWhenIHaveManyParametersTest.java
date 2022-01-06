package com.example.aboutjava.effectivejava.item2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.aboutjava.effectivejava.item2.ConsiderABuilderWhenIHaveManyParameters.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("Item 2 - 생성자에 매개변수가 많다면 빌더를 고려해라")
class ConsiderABuilderWhenIHaveManyParametersTest {

    @DisplayName("점층적 생성자 패턴(telescoping constructor pattern)")
    @Test
    void telescopingConstructorPattern() {
        // when
        TelescopingConstructorPattern actual1 = new TelescopingConstructorPattern("firstName", "lastName");
        TelescopingConstructorPattern actual2 = new TelescopingConstructorPattern("Ryan", "An", 32, "man", "test@gmail.com");
        // then
        assertAll(
                () -> assertThat(actual1).isNotNull(),
                () -> assertThat(actual2).isNotNull()
        );
    }

    @DisplayName("자바빈즈 패턴(javaBeans pattern)")
    @Test
    void javaBeansPattern() {
        // when
        JavaBeansPattern actual = new JavaBeansPattern();
        actual.setFirstName("Ryan");
        actual.setLastName("An");
        actual.setAge(32);
        actual.setSex("man");
        actual.setEmail("test@gmail.com");
        // then
        assertThat(actual).isNotNull();
    }

    @DisplayName("빌더 패턴(builder pattern)")
    @Test
    void builderPattern() {
        // when
        BuilderPattern actual = new BuilderPattern
                .Builder("Ryan", "An", "test@gmail.com")
                .age(32).sex("man").build();
        // then
        assertThat(actual).isNotNull();
    }

    @DisplayName("빌더 패턴(builder pattern)")
    @Test
    void examplesForBuilderPattern() {
        // when
        MrPizza mrPizza = new MrPizza.Builder(MrPizza.Size.SMALL)
                .addTopping(Pizza.Topping.SAUSAGE).addTopping(Pizza.Topping.ONION)
                .build();
        DominoPizza dominoPizza = new DominoPizza.Builder()
                .addTopping(Pizza.Topping.ONION).sauceInside().build();
        // then
        assertAll(
                () -> assertThat(mrPizza).isNotNull(),
                () -> assertThat(dominoPizza).isNotNull()
        );
    }
}

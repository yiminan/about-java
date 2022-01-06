package com.example.aboutjava.effectivejava.item5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.aboutjava.effectivejava.item5.InjectDependencyObjectInsteadOfDirectNotation.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Item 5 - 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라")
class InjectDependencyObjectInsteadOfDirectNotationTest {

    @DisplayName("정적 유틸리티를 잘못 사용한 예 - 유연하지 않고 테스트하기 어렵다.")
    @Test
    void injectDependencyObjectInsteadOfDirectNotationByUtilClass() {
        // when
        String dictionaryName = SpellChecker2.dictionaryName();
        // then
        assertThat(dictionaryName).isEqualTo("oxfordDictionary");
    }

    @DisplayName("싱글턴을 잘못 사용한 예 = 유연하지 않고 테스트하기 어렵다.")
    @Test
    void injectDependencyObjectInsteadOfDirectNotationWithSingletonClass() {
        // given
        SpellChecker3 spellChecker3 = SpellChecker3.INSTANCE;
        // when
        String dictionaryName = spellChecker3.dictionaryName();
        // then
        assertThat(dictionaryName).isEqualTo("oxfordDictionary");
    }

    @DisplayName("자원을 직접 명시하지 말고 의존 객체 주입을 사용해야합니다")
    @Test
    void injectDependencyObjectInsteadOfDirectNotation() {
        // given
        Lexicon oxfordDictionary = new OxfordDictionary();
        // when
        SpellChecker spellChecker = new SpellChecker(oxfordDictionary);
        String dictionaryName = spellChecker.dictionaryName();
        // then
        assertThat(dictionaryName).isEqualTo("oxfordDictionary");
    }

    @DisplayName("자원을 직접 명시하지 말고 의존 객체 주입을 사용해야합니다 - 함수형 인터페이스로 람다 사용")
    @Test
    void injectDependencyObjectInsteadOfDirectNotationWithLambda() {
        // when
        SpellChecker spellChecker = new SpellChecker(() -> "oxfordDictionary");
        String dictionaryName = spellChecker.dictionaryName();
        // then
        assertThat(dictionaryName).isEqualTo("oxfordDictionary");
    }
}

package com.example.aboutjava.effectivejava.item5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.aboutjava.effectivejava.item5.InjectDependencyObjectInsteadOfDirectNotation.*;
import static org.assertj.core.api.Assertions.assertThat;

class InjectDependencyObjectInsteadOfDirectNotationTest {

    @DisplayName("잘못된 유틸 클래스 사용 형태의 객체 주입 형태")
    @Test
    void injectDependencyObjectInsteadOfDirectNotationWithDirectInstance() {
        // when
        String dictionaryName = SpellChecker2.dictionaryName();
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

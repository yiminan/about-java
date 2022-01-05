package com.example.aboutjava.effectivejava.item5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.aboutjava.effectivejava.item5.InjectDependencyObjectInsteadOfDirectNotation.OxfordDictionary;
import static com.example.aboutjava.effectivejava.item5.InjectDependencyObjectInsteadOfDirectNotation.SpellChecker;
import static com.example.aboutjava.effectivejava.item5.InjectDependencyObjectInsteadOfDirectNotation.Lexicon;
import static org.assertj.core.api.Assertions.assertThat;

class InjectDependencyObjectInsteadOfDirectNotationTest {

    @DisplayName("자원을 직접 명시하지 말고 의존 객체 주입을 사용해야합니다")
    @Test
    void injectDependencyObjectInsteadOfDirectNotation() {
        // given
        Lexicon oxfordDictionary = new OxfordDictionary();
        // when
        SpellChecker spellChecker = new SpellChecker(oxfordDictionary);
        String foundIndex = spellChecker.foundIndex("apple");
        // then
        assertThat(foundIndex).isNotEmpty();
    }
}

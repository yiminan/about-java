package effectivejava.item5;

import java.util.Objects;

/**
 * "자원을 직접 명시하지 말고 의존 객체 주입을 사용해야합니다"<p>
 * <p>
 */
class InjectDependencyObjectInsteadOfDirectNotation {

    public static void main(String[] args) {
        SpellChecker spellChecker = new SpellChecker(new OxfordDictionary());
        spellChecker.foundIndex("apple");
    }

    /**
     * 의존 객체 주입을 사용한 올바른 예시
     */
    private static class SpellChecker {

        private final Lexicon dictionary;

        public SpellChecker(Lexicon dictionary) {
            this.dictionary = Objects.requireNonNull(dictionary);
        }

        public String foundIndex(String spell) {
            return dictionary.foundIndex(spell);
        }
    }

    private interface Lexicon {
        String foundIndex(String spell);
    }

    private static class OxfordDictionary implements Lexicon {
        @Override
        public String foundIndex(String spell) {
            /**
             * spell을 이용해서 index 찾기
             */
            return "index";
        }
    }

    /**
     * 정적 유틸리티를 잘못 사용한 예 - 유연하지 않고 테스트하기 어렵다.
     */
    private static class SpellChecker2 {
        private static final Lexicon dictionary = new OxfordDictionary();

        private SpellChecker2() {
        }
    }
}

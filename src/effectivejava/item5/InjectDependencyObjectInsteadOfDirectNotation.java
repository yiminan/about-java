package effectivejava.item5;

import java.util.Objects;

/**
 * "자원을 직접 명시하지 말고 의존 객체 주입을 사용해야합니다"<p>
 * <p>
 */
class InjectDependencyObjectInsteadOfDirectNotation {

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
}

package com.example.aboutjava.effectivejava.item5;

import java.util.Objects;

/**
 * "자원을 직접 명시하지 말고 의존 객체 주입을 사용해야합니다"<p>
 * <p>
 * 사용하는 자원에 따라 동작이 달라지는 클래스에는 정적 유틸리티 클래스나 싱글턴 방식이 적합하지 않습니다.<p>
 * 인스턴스를 생성할 때 생성자에 필요한 자원을 넘겨주는 방식을 사용하면 IoC(Inversion of Control)이 가능합니다.<p>
 * 장점)<p>
 * - 내부 코드에 의존도와 결합도를 높이지 않고, '객체 유연성', '테스트 용이성'을 높여줍니다.<p>
 * - 인스턴스 사용 시점에 의존 객체가 주입되고, 불변 객체를 유지할 수 있습니다.<p>
 * 단점)<p>
 * - 의존성이 수천 개나 되는 큰 프로젝트에서는 코드를 복잡하게 만듭니다.
 * - 물론 Dagger, Guice, Spring 같은 의존 객체 주입 프레임워크를 사용하면 해결할 수 있습니다.<p>
 * 결론)<p>
 * - 클래스가 내부적으로 하나 이상의 자원에 의존하고, 그 자원이 클래스 동작에 영향을 준다면 싱글턴, 정적 유틸리티 클래스는 사용하지 않는게 좋습니다.<p>
 * - 필요한 자원은 '생성자', '정적 팩터리', '빌더'를 사용해서 넘겨주는게 좋습니다.<p>
 * - 의존 객체 주입(Dependency Injection)이라 하는 이 기법은 클래스의 유연성, 재사용성, 테스트 용이성을 개선해줍니다.<p>
 */
class InjectDependencyObjectInsteadOfDirectNotation {

    /**
     * 정적 유틸리티를 잘못 사용한 예 - 유연하지 않고 테스트하기 어렵다.
     */
    static class SpellChecker2 {
        private static final Lexicon dictionary = new OxfordDictionary();

        private SpellChecker2() {
        }

        public static String dictionaryName() {
            return dictionary.dictionaryName();
        }
    }

    /**
     * 싱글턴을 잘못 사용한 예 = 유연하지 않고 테스트하기 어렵다.
     */
    private static class SpellChecker3 {
        private final Lexicon dictionary = new OxfordDictionary();

        public static SpellChecker3 INSTANCE = new SpellChecker3();

        private SpellChecker3() {
        }
    }

    /**
     * 의존 객체 주입을 사용한 올바른 예시
     */
    static class SpellChecker {

        private final Lexicon dictionary;

        public SpellChecker(Lexicon dictionary) {
            this.dictionary = Objects.requireNonNull(dictionary);
        }

        public String dictionaryName() {
            return dictionary.dictionaryName();
        }
    }

    interface Lexicon {
        String dictionaryName();
    }

    static class OxfordDictionary implements Lexicon {
        @Override
        public String dictionaryName() {
            /**
             * spell을 이용해서 index 찾기
             */
            return "oxfordDictionary";
        }
    }
}

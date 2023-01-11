package com.example.aboutjava.effectivejava.item36;

import java.util.Set;

/**
 * Item 36 - 비트 필드 대신 EnumSet을 사용하라.<p>
 * <p>
 * 열거할 수 있는 타입을 한데 모아 집합 형태로 사용한다고 해도 비트 필드를 사용할 이유는 없다.<p>
 * EnumSet 클래스는 비트 필드를 대체할 만한 성능과 기능을 제공한다.<p>
 * EnumSet의 유일한 단점이라면 (자바 9까지는 아직) 불변 EnumSet을 만들 수 없다는 것이다.<p>
 * Collections.unmodifiableSet(EnumSet)을 사용하면 불변 EnumSet을 만들 수 있다.<p>
 */
class UseEnumSetInsteadOfBitField {

    /**
     * 비트 필드 열거 상수 - 구닥다리 기법!<p>
     */
    private static class OldText {

        public static final int STYLE_BOLD = 1 << 0;
        public static final int STYLE_ITALIC = 1 << 1;
        public static final int STYLE_UNDERLINE = 1 << 2;
        public static final int STYLE_STRIKETHROUGH = 1 << 3;

        public void applyStyles(int styles) {
            // ...
        }
    }

    /**
     * EnumSet - 비트 필드를 대체하는 현대적 기법!<p>
     */
    private static class NewText {

        public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}

        public void applyStyles(Set<Style> styles) {
            // ...
        }
    }
}

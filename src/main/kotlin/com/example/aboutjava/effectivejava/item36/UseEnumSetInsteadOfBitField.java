package com.example.aboutjava.effectivejava.item36;

import java.util.Set;

/**
 * Item 36 - 비트 필드 대신 EnumSet을 사용하라.<p>
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

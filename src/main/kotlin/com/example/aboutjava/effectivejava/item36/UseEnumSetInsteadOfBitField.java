package com.example.aboutjava.effectivejava.item36;

/**
 * Item 36 - 비트 필드 대신 EnumSet을 사용하라.<p>
 */
class UseEnumSetInsteadOfBitField {

    private class Text {
        public static final int STYLE_BOLD = 1 << 0;
        public static final int STYLE_ITALIC = 1 << 1;
        public static final int STYLE_UNDERLINE = 1 << 2;
        public static final int STYLE_STRIKETHROUGH = 1 << 3;

        public void applyStyles(int styles) {
            // ...
        }
    }
}

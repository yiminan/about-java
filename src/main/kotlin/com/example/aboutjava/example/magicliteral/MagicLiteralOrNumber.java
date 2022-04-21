package com.example.aboutjava.example.magicliteral;

class MagicLiteralOrNumber {
    /**
     * 1.매직 넘버를 상수로 만든 예시
     */
    static final class PositiveNumberWithConstant {

        private static final int MINIMUM_POSITIVE_NUMBER = 1; // 상수 선언

        private final int value;

        public PositiveNumberWithConstant(int value) {
            if (value < MINIMUM_POSITIVE_NUMBER) {
                throw new IllegalArgumentException(String.format("value(%d)는 0 또는 음수가 될 수 없습니다.", value));
            }
            this.value = value;
        }
    }

    /**
     * 2.매직 넘버를 메서드로 추출 고립시킨 예시
     */
    static final class PositiveNumberWithExtractedMethod {

        private final int value;

        public PositiveNumberWithExtractedMethod(int value) {
            if (isNotPositiveNumber(value)) { // 메서드 추출
                throw new IllegalArgumentException(String.format("value(%d)는 0 또는 음수가 될 수 없습니다.", value));
            }
            this.value = value;
        }

        private boolean isNotPositiveNumber(int value) {
            return value < 1;
        }
    }
}

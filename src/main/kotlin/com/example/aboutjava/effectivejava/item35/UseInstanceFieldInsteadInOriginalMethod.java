package com.example.aboutjava.effectivejava.item35;

/**
 * Item 35 - ordinal 인덱스 대신 인스턴스 필드를 사용하라.<p>
 * <p>
 * Enum의 API 문서를 보면 ordinal에 대해 이렇게 쓰여 있다.<p>
 * "대부분 프로그래머는 이 메서드를 쓸 일이 없다. <p>
 * 이 메서드는 EnumSet과 EnumMap 같이 열거 타입 기반의 범용 자료 구조에 쓸 목적으로 설계되었다."<p>
 * 따라서 이런 용도가 아니라면 ordinal 메서드는 절대 사용하지 말자.
 */
class UseInstanceFieldInsteadInOriginalMethod {

    /**
     * "잘못된 형태의 enum 사용 예" ordinal 메서드는 열거 타입 상수가 정의된 순서를 반환한다.<p> 동작은 하지만 유지보수에 끔찍하다.<p>
     */
    private enum BadCase {
        SOLO, DUET, TRIO, QUARTET, QUINTET,
        SEXTET, SEPTET, OCTET, DOUBLE_QUARTET,
        NONET, DECTET, TRIPLE_QUARTET;

        public int numberOfMusicians() {
            return ordinal() + 1;
        }
    }

    /**
     * "잘 사용된 형태의 enum 사용 예"
     */
    private enum GoodCase {
        SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5),
        SEXTET(6), SEPTET(7), OCTET(8), DOUBLE_QUARTET(8),
        NONET(9), DECTET(10), TRIPLE_QUARTET(12);

        private final int numberOfMusicians;

        GoodCase(int numberOfMusicians) {
            this.numberOfMusicians = numberOfMusicians;
        }

        public int numberOfMusicians() {
            return numberOfMusicians;
        }
    }
}

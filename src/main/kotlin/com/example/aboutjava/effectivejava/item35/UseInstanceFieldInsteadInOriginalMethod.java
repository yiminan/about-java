package com.example.aboutjava.effectivejava.item35;

/**
 * Item 35 - ordinal 인덱스 대신 인스턴스 필드를 사용하라.<p>
 * <p>
 */
public class UseInstanceFieldInsteadInOriginalMethod {

    /**
     * "잘못된 형태의 enum 사용 예" ordinal 메서드는 열거 타입 상수가 정의된 순서를 반환한다.<p> 동작은 하지만 유지보수에 끔찍하다.<p>
     */
    private enum BadCase {
        SOLO, DUET, TRIO, QUARTET, QUINTET,
        SEXTET, SEPTET, OCTET, NONET, DECTET;

        public int numberOfMusicians() {
            return ordinal() + 1;
        }
    }

    private enum GoodCase {
        SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5),
        SEXTET(6), SEPTET(7), OCTET(8), NONET(9), DECTET(10);

        private final int numberOfMusicians;

        GoodCase(int numberOfMusicians) {
            this.numberOfMusicians = numberOfMusicians;
        }

        public int numberOfMusicians() {
            return numberOfMusicians;
        }
    }
}

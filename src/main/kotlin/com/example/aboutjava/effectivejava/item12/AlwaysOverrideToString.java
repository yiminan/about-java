package com.example.aboutjava.effectivejava.item12;

/**
 * "Item 12 - toString method는 항상 재정의해야합니다."<p>
 * <p>
 * toString의 규약은 '모든 하위 클래스에서 이 메서드를 재정의하라'입니다.<p>
 * - toString을 잘 구현한 클래스는 사용하기 좋고, 디버깅하기 쉽습니다.<p>
 * - 실전에서 toString은 그 객체가 가진 주요 정보 모두를 반환하는게 좋습니다.<p>
 * - 정적 유틸리티 클래스는 toString을 제공할 이유가 없기 때문에 재정할 필요가 없다.<p>
 * - 열거 타입도 자바가 이미 좋은 toString을 제공하니 재정의할 필요가 없다.<p>
 * - 하위 클래스에서 공유해야할 표현이 있는 추상 클래스라면 재정의할 필요가 있다.<p>
 * - 대다수의 컬렉션 구현체는 추상 컬렉션의 클래스들의 toString을 상속해서 사용한다.<p>
 */
class AlwaysOverrideToString {

    public static void main(String[] args) {
        System.out.println(new PhoneNumber("010-1234-5678"));// PhoneNumber{number='010-1234-5678'}
        System.out.println(BookingClass.ECONOMY);// ECONOMY
    }

    private static final class PhoneNumber {
        private final String number;

        public PhoneNumber(String number) {
            this.number = number;
        }

        @Override
        public String toString() {
            return "PhoneNumber{" +
                    "number='" + number + '\'' +
                    '}';
        }
    }

    private enum BookingClass {
        ECONOMY, BUSINESS, FIRST;
    }
}

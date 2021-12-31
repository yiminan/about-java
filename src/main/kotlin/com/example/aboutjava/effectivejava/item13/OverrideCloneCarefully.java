package com.example.aboutjava.effectivejava.item13;

/**
 * "clone 재정의는 주의해서 진행하라."<p>
 * {@link Cloneable}을 확장해서 인터페이스를 만들어서도, 구현 클래스를 만들어서도 안됩니다.<p>
 * final 클래스라면 {@link Cloneable}를 구현해도 위험이 작지만, 성능적인 검토는 필요하다.<p>
 * 단, 배열에 대해서는 clone 메서드를 사용하는 것이 적절한 판단이 될 수 있다.<p>
 * 불변 객체를 만들어서 생성자와 팩터리 메서드를 이용하는게 가장 좋은 사용법이라고 볼 수 있다.<p>
 */
class OverrideCloneCarefully {

    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber("010-1234-5678");
        PhoneNumber copyPhoneNumber = (PhoneNumber) phoneNumber.clone();
        System.out.println(copyPhoneNumber);
    }

    private static final class PhoneNumber implements Cloneable {
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

        @Override
        protected Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }
}

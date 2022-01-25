package com.example.aboutjava.effectivejava.item11;

import java.util.HashMap;
import java.util.Objects;

/**
 * "equals를 재정의할때는 hashCode도 재정의해야합니다"<p>
 * hashCode를 재정의하지 않으면 일반 규약을 어기게 됩니다.<p>
 * 규약을 어긴 클래스의 인스턴스를 {@link HashMap}, {@link java.util.HashSet}와 같은 컬렉션의 원소로 사용할 때 문제를 일으킨다.<p>
 * <p>
 * Object의 equals, hashCode 규약<p>
 * 1.equals 비교에 사용되는 정보가 변경되지 않았다면, 애플리케이션 실행동안 객체의 hashCode는 여러번 호출해도 항상 같은 값을 반환해야한다.<p>
 * 2.equals로 두 객체가 비교되는데 같다면, hashCode 값도 같다.<p>
 * 3.equals가 두 객체를 다르게 판단해도, hashCode가 다른 값을 반환할 필요는 없다. 단, 다른 값을 반환해야 해시테이블의 성능이 좋아진다.<p>
 * <p>
 * hashCode 재정의를 잘못하게되면 문제가 되는 부분은 2번 규약이다. 즉, 논리적으로 같은 객체는 같은 해시코드를 반환해야 한다.<p>
 * hashCode가 제대로 재정의되지 않고 {@link java.util.Collection}에 인자로 들어간 객체는 서로 다른 hashCode를 반환한다.<p>
 * haschCode는 API 사용자에게 알려주지 않는게 좋다. 그래야 사용자가 이 값에 의존하지 않을 수 있다.<p>
 * 서로 다른 인스턴스도 되도록이면 다른 hashCode를 갖게 하는것이 좋다.<p>
 */
class OverrideEqualsWithHashCode {

    static final class PhoneNumberWithDefaultHashCode {
        private final String number;

        public PhoneNumberWithDefaultHashCode(String number) {
            this.number = number;
        }
    }

    static final class PhoneNumberWithOverrideHashCode {
        private final String number;

        public PhoneNumberWithOverrideHashCode(String number) {
            this.number = number;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PhoneNumberWithOverrideHashCode that = (PhoneNumberWithOverrideHashCode) o;
            return Objects.equals(number, that.number);
        }

        @Override
        public int hashCode() {
            return Objects.hash(number);
        }
    }
}

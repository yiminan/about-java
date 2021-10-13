package effectivejava.item11;

/**
 * "equals를 재정의할때는 hashCode도 재정의해야합니다"<p>
 * hashCode를 재정의하지 않으면 일반 규약을 어기게 됩니다.<p>
 * 규약을 어긴 클래스의 인스턴스를 {@link java.util.HashMap}, {@link java.util.HashSet}와 같은 컬렉션의 원소로 사용할 때 문제를 일으킨다.<p>
 * <p>
 * Object의 equals, hashCode 규약<p>
 * 1.equals 비교에 사용되는 정보가 변경되지 않았다면, 애플리케이션 실행동안 객체의 hashCode는 여러번 호출해도 항상 같은 값을 반환해야한다.<p>
 * 2.equals로 두 객체가 비교되는데 같다면, hashCode 값도 같다.<p>
 * 3.equals가 두 객체를 다르게 판단해도, hashCode가 다른 값을 반환할 필요는 없다. 단, 다른 값을 반환해야 해시테이블의 성능이 좋아진다.<p>
 */
class OverrideEqualsWithHashCode {
}

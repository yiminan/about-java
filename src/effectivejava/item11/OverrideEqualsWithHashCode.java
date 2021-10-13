package effectivejava.item11;

/**
 * "equals를 재정의할때는 hashCode도 재정의해야합니다"<p>
 * hashCode를 재정의하지 않으면 일반 규약을 어기게 됩니다.<p>
 * 규약을 어긴 클래스의 인스턴스를 {@link java.util.HashMap}, {@link java.util.HashSet}와 같은 컬렉션의 원소로 사용할 때 문제를 일으킨다.<p>
 */
class OverrideEqualsWithHashCode {
}

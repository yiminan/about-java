package effectivejava.item12;

/**
 * "toString method는 항상 재정의해야합니다."<p>
 * toString의 규약은 '모든 하위 클래스에서 이 메서드를 재정의하라'입니다.<p>
 * - toString을 잘 구현한 클래스는 사용하기 좋고, 디버깅하기 쉽습니다.<p>
 * - 실전에서 toString은 그 객체가 가진 주요 정보 모두를 반환하는게 좋습니다.<p>
 * - 정적 유틸리티 클래스는 toString을 제공할 이유가 없기 때문에 재정할 필요가 없다.<p>
 * - 열거 타입도 자바가 이미 좋은 toString을 제공하니 재정의할 필요가 없다.<p>
 */
class AlwaysOverrideToString {
}

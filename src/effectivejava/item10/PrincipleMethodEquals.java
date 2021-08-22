package effectivejava.item10;

/**
 * "equals 메서드를 재정의할 때는 반드시 일반 규약을 따라야 합니다."<p>
 * <p>
 * Object 명세에 적힌 일반 규약은 다음과 같다.<p>
 * 핵심) equals 메서드는 동치관계(equivalence relation)를 구현하며, 다음을 다섯가지를 만족해야한다.<p>
 * 1.반사성(reflexivity)<p>
 * - null이 아닌 모든 참조 값 x에 대해, x.equals(x)는 true이다.<p>
 * - 즉, 자기 참조 객체를 equals()로 비교하였을때는 true라는 것이다.<p>
 * 2.대칭성(symmetry)<p>
 * - null이 아닌 모든 참조 값 x, y에 대해, x.equals(y)가 true면 y.equals(x)도 true이다.<p>
 * 3.추이성(transitivity)<p>
 * - null이 아닌 모든 참조 값 x, y, z에 대해, x.equals(y)가 true이고, y.equals(z)가 true면, x.equals(z)는 true이다.<p>
 * 4.일관성(consistency)<p>
 * - null이 아닌 모든 참조 값 x, y에 대해, x.equals(y)를 반복해서 호출하면 항상 true를 반환하거나 항상 false를 반환한다.<p>
 * 5.null이 아님<p>
 * - null이 아닌 모든 참조 값 x에 대해, x.equals(null)은 false이다.<p>
 * <p>
 * 반드시 위의 규약은 지켜져야한다.<p>
 * 이유는 컬렉션 클래스를 포함한 많은 클래스는 전달받은 객체가 equals 규약을 지킨다고 가정하고 동작한다. 그렇기 때문에 지켜지지 않으면 오동작을 발생한다.<p>
 *
 */
class PrincipleMethodEquals {
}

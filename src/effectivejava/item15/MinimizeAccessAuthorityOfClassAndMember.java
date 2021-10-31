package effectivejava.item15;

/**
 * "클래스와 멤버의 접근권한을 최소화해야합니다."<p>
 * 잘 설계된 클래스는 내부 데이터와 구현정보를 외부에 대하여 캡슐화(은닉)시켰는지 입니다.<p>
 * <p>
 * 정보은닉의 장점<p>
 * 1.시스템 개발 속도를 높인다. 여러 컴포넌트를 병렬 개발이 가능하다.<p>
 * 2.시스템 관리 비용을 낮춘다. 각 컴포넌트를 빨리 파악하고 디버깅이 가능하고, 다른 컴포넌트 교체도 쉽다.<p>
 * 3.성능 최적화에 도움을 준다. 컴포넌트로 나누어져있기 때문에 해당 부분만 최적화하기 쉽다.<p>
 * 4.소프트웨어 재사용성을 높인다. 독자적인 컴포넌트 개발로 인해 다른 환경에서도 사용할 수 있다.<p>
 * 5.큰 시스템을 제작하는 난이도를 낮춰준다. 전체 시스템이 미완성이라도 개별 컴포넌트를 검증할 수 있다.<p>
 * <p>
 * 정보은닉을 위한 다양한 장치<p>
 * 1.클래스<p>
 * 2.인터페이스<p>
 * 3.멤버의 접근지정자<p>
 * <p>
 * 기본 원칙<p>
 * - 모든 클래스와 멤버의 접근성을 가능한 한 좁혀야 한다.<p>
 * - 가능한 접근 지정자는 private으로 선언해야 한다.<p>
 * <p>
 * 멤버의 접근 지정자<p>
 * 1.private : 선언된 톱 레벨 클래스에서만 접근 가능<p>
 * 2.default(package-private) : 선언된 클래스의 패키지 안에서만 접근 가능<p>
 * 3.protected : detault + 상속한 하위 클래스 에서 접근 가능<p>
 * 4.public : 모든 곳에서 접근 가능<p>
 */
class MinimizeAccessAuthorityOfClassAndMember {
}

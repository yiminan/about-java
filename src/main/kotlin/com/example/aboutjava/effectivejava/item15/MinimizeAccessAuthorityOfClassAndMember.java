package com.example.aboutjava.effectivejava.item15;

/**
 * "Item 15 - 클래스와 멤버의 접근권한을 최소화해야합니다."<p>
 * <p>
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
 * 3.protected : default + 상속한 하위 클래스 에서 접근 가능<p>
 * 4.public : 모든 곳에서 접근 가능<p>
 * <p>
 * class에서 접근 지정자 사용 방법<p>
 * 1.클래스의 공개 API를 세심히 설계한 후, 그외의 모든 멤버는 private으로 만들자.<p>
 * 2.이후 같은 패키지의 다른 클래스가 접근하는 멤버에 한하여, package-private(default)로 풀어준다.<p>
 * 3.protected를 적용하는 경우에는 공개범위가 넓어진다. 그래서 protected는 적으면 적을수록 좋다.<p>
 * 4.public class의 인스턴스 필드는 되도록 public이 되지않아야한다.<p>
 * 5.class 내부 public 인스턴스 필드는 'public final'을 사용해도 외부에 공유가 되기 때문에 스레드에 안전하지 않습니다.<p>
 * <p>
 * 결론)<p>
 * - 프로그램의 접근성은 가능한 최소화해야한다.<p>
 * - 필요한 부분만 public API를 설계해야한다.<p>
 * - public class는 상수용 public static final 필드 외에는 어떤한 필드도 가져서는 안된다.<p>
 * - public static final 필드가 참조하는 객체가 불변인지 확인해야한다. 배열과 같은 경우에는 디폴트가 수정이 가능하다.<p>
 */
class MinimizeAccessAuthorityOfClassAndMember {
}

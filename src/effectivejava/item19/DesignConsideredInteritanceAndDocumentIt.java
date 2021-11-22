package effectivejava.item19;

/**
 * "상속을 고려해서 설계하고 문서화해야한다. 그러지 않았다면 상속을 금지해야한다."<p>
 * <p>
 * 상속을 염두에 두지 않고 설계했고 상속할 때의 주의점도 문서화 해놓지 않은 '외부'클래스를 상속할 때의 위험을 경고했다.<p>
 * 여기서 '외부'란 프로그래머의 통제권 밖에 있어서 언제 어떻게 변경될지 모른다는 뜻이다.<p>
 * 우선, 메서드를 재정의하면 어떤 일이 일어나는지를 정확히 정리하여 문서로 남겨야 한다.<p>
 * 달리 말하면, 상속용 클래스는 재정의할 수 있는 메서드들을 내부적으로 어떻게 이용하는지 문서로 남겨야 한다.<p>
 * <p>
 * *재정의 가능한 메서드란? (1) 접근 지정자가 public 또는 protected (2) final 메서드가 아닌 메서드<p>
 * <p>
 * 클래스의 API로 공개된 메서드에서 클래스 자신의 또 다른 메서드를 호출할 수도 있다.<p>
 * (전 장의 addAll 예시) 그런데 재정의가 가능한 메서드라면 그 사실을 api 명세에 적시해야 한다.<p>
 * <p>
 * 문서화 방법<p>
 * "@implSpec" 사용 <p>
 * - 자기사용 패턴(self-use pattern)에 대해서도 문서에 남겨 다른 프로그래머에게 그 메서드를 올바르게 재정의 하는 방법을 알려야 한다.<p>
 * - 일반적인 문서화 주석은 해당 메서드와 클라이언트 사이의 관계를 설명<p>
 * - @implSpec 주석은 해당 메서드와 하위 클래스 사이의 관계를 설명하여, 하위 클래스들이 그 메서드를 상속하거나 super 키워드를 이용해 호출할 때 그 메서드가 어떻게 동작하는지를 명확히 인지하고 사용하게 해야 한다.<p>
 * - -tag "implSpec:a:Implementation Requirement" 스위치를 키지 않으면 @implSpec 태그를 무시한다<p>
 */
class DesignConsideredInteritanceAndDocumentIt {
}

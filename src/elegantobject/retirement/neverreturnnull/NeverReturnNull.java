package elegantobject.retirement.neverreturnnull;

/**
 * "절대 null을 반환하지 마세요"
 * 메서드의 파라미터에 null을 전달하는 것은 매우 안좋은 방법입니다.
 * 마찬가지로 메서드가 null을 반환하는 것도 절대 안됩니다.
 * 반환된 객체가 null이면 객체를 사용하면서 NPE가 발생할 수 있기 때문에,
 * 해당 메서드를 신뢰할 수 없습니다. 그래서 null을 반환하면 안됩니다.
 * 객체가 만든 반환 값을 의심하고 결과에 대한 확인 코드가 들어간다면 OOP를 위반하는 일입니다.
 */
class NeverReturnNull {
}

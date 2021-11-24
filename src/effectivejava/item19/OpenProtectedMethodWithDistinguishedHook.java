package effectivejava.item19;

/**
 * "Hook을 잘 선별하여, protected 메서드 형태로 공개할 수 있어야합니다"<p>
 * <p>
 * hook, protected 메서드 18장의 addAll에서 호출되는 add메서드 역시 좋은 예시일것 같다<p>
 * 상속을 위해 효율적으로 하위 클래스를 어려움 없이 만들 수 있게 하려면,<p>
 * 클래스의 내부 동작 과정 중간에 끼어들 수 있는 훅(hook)을 잘 선별하여 protected 메서드 형태로 공개해야 할 수도 있다.<p>
 */
class OpenProtectedMethodWithDistinguishedHook {
}

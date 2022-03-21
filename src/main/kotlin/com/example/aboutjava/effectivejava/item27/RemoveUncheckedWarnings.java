package com.example.aboutjava.effectivejava.item27;

/**
 * "Item 27 - 비검사 경고를 제거해야 합니다"<p>
 * <p>
 * 정리)<p>
 * 비검사 경고는 중요하기에 무시하면 안됩니다.<p>
 * 모든 비검사 경고는 런타임에 ClassCastException을 일으킬 수 있는 잠재적 가능성을 뜻하기 때문에 최선을 다해 제거해야합니다.<p>
 * 경고를 없앨 발법이 없다면, 그 코드가 타입 안전함을 증명하고 가능한 한 범위를 좁혀 @SuppressWarnings("unchecked")로 경고를 숨겨야합니다.<p>
 * 그런 다음 경고를 숨기기로 한 근거를 주석으로 남겨야합니다.<p>
 */
class RemoveUncheckedWarnings {
}

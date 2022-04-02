package com.example.aboutjava.effectivejava.item30;

import java.util.HashSet;
import java.util.Set;

/**
 * "Item 30 - 이왕이면 제네릭 메서드로 만들어라"<p>
 * <p>
 * 핵심 정리)<p>
 * 제네릭 타입과 마찬가지로, 클라이언트에서 입력 매개변수와 반환값을 명시적으로 형변환해야 하는 메서드보다 제네릭 메서드가 더 안전하며 사용도 쉽습니다.<p>
 * 타입과 마찬가지로, 메서드도 형변환 없이 사용할 수 있는 편이 좋으며, 많은 경우 그렇게 하려면 제네릭 메서드가 되어야 합니다.<p>
 * 역시 타입과 마찬가지로, 형변환을 해줘야 하는 기존 메서드는 제네릭하게 만들어야 합니다.<p>
 * 기존 클라이언트는 그대로 둔 채 새로운 사용자의 삶을 훨씬 편하게 만들어줍니다.<p>
 */
class MakeGenericMethodIfPossible {

    /**
     * Raw Type 사용 - 수용 불가하다.
     */
    private static Set union(Set s1, Set s2) {
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }

    private static <E> Set<E> union2(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }
}

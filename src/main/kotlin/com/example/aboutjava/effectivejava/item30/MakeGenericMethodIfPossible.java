package com.example.aboutjava.effectivejava.item30;

import java.util.HashSet;
import java.util.Set;

/**
 * "Item 30 - 이왕이면 제네릭 메서드로 만들어라"<p>
 */
class MakeGenericMethodIfPossible {

    /**
     * Raw Type 사용 - 수용 불가하다.
     */
    public static Set union(Set s1, Set s2) {
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }
}

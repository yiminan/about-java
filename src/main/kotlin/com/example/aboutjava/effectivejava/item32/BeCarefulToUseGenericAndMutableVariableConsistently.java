package com.example.aboutjava.effectivejava.item32;

import java.util.List;

/**
 * Item 32 - 제네릭과 가변인수를 함께 쓸 때는 신중해야합니다.<p>
 * <p>
 * 가변인수는 메서드에 넘기는 인수의 개수를 클라이언트가 조절할 수 있게 해주는데, 구현 방식에 허점이 있다.<p>
 */
class BeCarefulToUseGenericAndMutableVariableConsistently {

    static void dangerous(List<String>... stringLists) {
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        objects[0] = intList; // 힙 오염 발생
        String s = stringLists[0].get(0); // ClassCastException
    }
}

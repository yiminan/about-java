package com.example.aboutjava.effectivejava.item32;

import java.util.List;

/**
 * Item 32 - 제네릭과 가변인수를 함께 쓸 때는 신중하라.<p>
 */
class BeCarefulToUseGenericAndMutableVariableConsistently {

    static void dangerous(List<String>... stringLists) {
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        objects[0] = intList; // 힙 오염 발생
        String s = stringLists[0].get(0); // ClassCastException
    }
}

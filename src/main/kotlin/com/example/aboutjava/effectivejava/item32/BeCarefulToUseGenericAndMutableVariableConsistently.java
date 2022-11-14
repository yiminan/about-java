package com.example.aboutjava.effectivejava.item32;

import java.util.List;

/**
 * Item 32 - 제네릭과 가변인수를 함께 쓸 때는 신중해야합니다.<p>
 * <p>
 * 가변인수는 메서드에 넘기는 인수의 개수를 클라이언트가 조절할 수 있게 해주는데, 구현 방식에 허점이 있다.<p>
 * 가변인수 메서드를 호출하면 가변인수를 담기 위한 배열이 자동으로 하나 만들어진다.<p>
 * 메서드를 선언할 때 실체화 불가 타입으로 varargs 매개변수를 선언하면 컴파일러가 경고를 보낸다.<p>
 * 가변인수 메서드를 호출할 때도 varargs 매개변수가 실체화 불가 타입으로 추론되면, 그 호출에 대해서도 경고를 낸다.<p>
 * 제네릭 타입 시스템이 약속한 타입 안전성을 유지시키야하는데, '제네릭과 varargs 를 혼용하면 타입 안전성이 깨집니다.'<p>
 * 타입 안전성이 깨지니 제네릭 varargs 배열 매개변수에 값을 저장하는 것은 안전하지 않습니다.<p>
 */
class BeCarefulToUseGenericAndMutableVariableConsistently {
    static void dangerous(List<String>... stringLists) {
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        objects[0] = intList; // 힙 오염 발생
        String s = stringLists[0].get(0); // ClassCastException
    }

    /**
     * Non-Safety: 자신의 제네릭 매개변수 배열의 참조를 노출한다.
     */
    static <T> T[] toArray(T... args) {
        return args;
    }
}
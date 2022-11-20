package com.example.aboutjava.effectivejava.item32;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Item 32 - 제네릭과 가변인수를 함께 쓸 때는 신중해야합니다.<p>
 * <p>
 * 가변인수는 메서드에 넘기는 인수의 개수를 클라이언트가 조절할 수 있게 해주는데, 구현 방식에 허점이 있다.<p> 가변인수 메서드를 호출하면 가변인수를 담기 위한 배열이 자동으로 하나 만들어진다.<p> 메서드를 선언할 때 실체화 불가 타입으로 varargs
 * 매개변수를 선언하면 컴파일러가 경고를 보낸다.<p> 가변인수 메서드를 호출할 때도 varargs 매개변수가 실체화 불가 타입으로 추론되면, 그 호출에 대해서도 경고를 낸다.<p> 제네릭 타입 시스템이 약속한 타입 안전성을 유지시키야하는데, '제네릭과 varargs
 * 를 혼용하면 타입 안전성이 깨집니다.'<p> 타입 안전성이 깨지니 제네릭 varargs 배열 매개변수에 값을 저장하는 것은 안전하지 않습니다.<p>
 */
class BeCarefulToUseGenericAndMutableVariableConsistently {

    public static void main(String[] args) {
        // 컴파일은 문제없지만, 실행하려면 ClassCastException이 발생합니다.
        String[] attributes = pickTwo("좋은", "빠른", "저렴한");
    }

    static void dangerous(List<String>... stringLists) {
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        objects[0] = intList; // 힙 오염 발생
        String s = stringLists[0].get(0); // ClassCastException
    }

    /**
     * Non-Safety: 자신의 제네릭 매개변수 배열의 참조를 노출합니다.
     */
    static <T> T[] toArray(T... args) {
        return args;
    }

    /**
     * T 타입 인수 3개를 받아 그중 2개를 무작위로 골라 담은 배열을 반환합니다. 제네릭 가변인수를 받는 toArray 메서드를 호출한다는 점만 빼면, 위험하지 않고 경고도 내지 않을 것입니다.
     */
    static <T> T[] pickTwo(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0:
                return toArray(a, b);
            case 1:
                return toArray(a, c);
            case 2:
                return toArray(b, c);
        }
        throw new AssertionError(); // 도달할 수 없다.
    }

    /**
     * 제네릭 varargs 매개변수를 안전하게 사용하는 메서드
     */
    @SafeVarargs
    static <T> List<T> flatten(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }
        return result;
    }
}

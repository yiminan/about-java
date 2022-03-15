package com.example.aboutjava.effectivejava.item26;

import java.util.Collection;
import java.util.Collections;

/**
 * "Item 26 - Raw Type 은 사용하지 말아야합니다"<p>
 * <p>
 * 클래스와 인터페이스 선언에 타입 매개변수(type parameter)가 쓰이면, 제네릭 클래스 혹은 제네릭 인터페이스라 한다.<p>
 * 제네릭 클래스와 제네릭 인터페이스를 통틀어 제네릭 타입(generic type)이라고 합니다.<p>
 * 예를 들어, List&#60;String&#62; 의 String은 매개변수화 타입입니다. List는 Raw Type 입니다.<p>
 */
class DontUseRawType {

    /**
     * 잘못된 Collection의 Raw Type 선언
     */
    private final Collection empties = Collections.EMPTY_LIST;
}

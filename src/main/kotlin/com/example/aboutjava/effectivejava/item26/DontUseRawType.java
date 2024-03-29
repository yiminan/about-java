package com.example.aboutjava.effectivejava.item26;

import java.util.Collection;
import java.util.List;

/**
 * "Item 26 - Raw Type 은 사용하지 말아야합니다"<p>
 * <p>
 * 클래스와 인터페이스 선언에 타입 매개변수(type parameter)가 쓰이면, 제네릭 클래스 혹은 제네릭 인터페이스라 한다.<p>
 * 제네릭 클래스와 제네릭 인터페이스를 통틀어 제네릭 타입(generic type)이라고 합니다.<p>
 * 예를 들어, List&#60;String&#62; 의 String은 매개변수화 타입입니다. List는 Raw Type 입니다.<p>
 * Raw Type 의 코드를 실행하면 타입이 안맞아도 컴파일이 진행됩니다.<p>
 * 오류는 가능한 한 발생 즉시, 이상적으로 컴파일할 때 발견하는 것이 좋습니다.<p>
 * Raw Type 을 쓰게 되면 제네릭이 주는 Type Safe와 Expression 을 모두 잃게 됩니다.<p>
 * <p>
 * 그러면 애초에 써서는 안되는 Raw Type 을 사용할 수 있게 만들었을까?<p>
 * Generic 이 나오기 전까지 Raw Type 을 사용했는데, 그 코드까지 호환하여 사용할 수 있게 허용하였습니다.<p>
 * <p>
 * 정리)<p>
 * Raw Type 은 Runtime Exception 이 발생할 수 있으니 사용하면 안됩니다.<p>
 * Raw Type 은 Generic 이 나오기 전 코드의 호환용입니다.<p>
 * 예를 들어, Set&#60;Object&#62; , Set&#60;?&#62; 는 안전하지만, Raw Type Set 은 안전하지 않습니다.<p>
 */
class DontUseRawType {

    /**
     * 잘못된 Collection의 Raw Type 선언
     * 이 코드를 사용하면 실수로 다른 제네릭 타입이 들어가서 Compile Time 까지 가는 것을 막아주지 못합니다.
     */
    private final Collection namesWithRawType = List.of("Ryan", "June");

    /**
     * 제대로된 Collection의 Parameterized Type 선언
     * 컴파일 타임에 바로 코드의 잘못된 모습을 찾을 수 있습니다.
     */
    private final Collection<String> namesWithParameterizedType = List.of("Ryan", "June");
}

package com.example.aboutjava.effectivejava.item1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;
import java.util.EnumSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ConsiderStaticFactoryMethodInsteadOfConstructorTest {

    @DisplayName("1개 파라미터로 호출되는 클래스 타입을 반환하는 정적 팩토리 메서드")
    @Test
    void from() {
        // given
        Instant now = Instant.now();
        // when
        Date nowDate = Date.from(now);
        // then
        assertAll(
                () -> assertThat(nowDate).isInstanceOf(Date.class),
                () -> assertThat(nowDate).isEqualTo(new Date(now.toEpochMilli()))
        );
    }

    @DisplayName("2개 이상 파라미터로 호출되는 클래스 타입을 반환하는 정적 팩토리 메서드")
    @Test
    void of() {
        // when
        EnumSet<Type> types = EnumSet.of(Type.VIP, Type.BUSINESS, Type.ECONOMY);
        // then
        assertAll(
                () -> assertThat(types).isInstanceOf(EnumSet.class),
                () -> assertThat(types).isNotNull()
        );
    }

//        EnumSet types = EnumSet.of(Type.VIP, Type.GENERAL);
//
//        /**
//         * "valueOf"
//         * - "from", "of"에서 조금 더 자세하게 네이밍한 정적 팩토리 메서드
//         */
//        BigInteger maxIntValue = BigInteger.valueOf(Integer.MAX_VALUE);
//
//        /**
//         * "instance" or "getInstance"
//         * - 매개변수를 받는다면, 매개변수로 명시한 인스턴스를 반환하지만, 같은 인스턴스를 보장하진 않습니다.
//         * - 같은 인스턴스를 보장하지 않는 이유는 이미 생성된 인스턴스를 싱글턴 패턴과 같이 재사용할 수 있습니다.
//         */
//        StackWalker stackWalker = StackWalker.getInstance();
//
//        /**
//         * "create" or "newInstance"
//         * - "instance" or "getInstance"와 같다. 차이점은 매번 새로운 인스턴스를 생성합니다.
//         */
//        List<String> strings = (List<String>) Array.newInstance(String.class, 10);
//
//        /**
//         * "get[Type]"
//         * - 다른 클래스 인스턴스를 반환하는 경우 사용합니다.
//         * - "getInstance"와 같습니다.
//         * - [Type]은 팩터리 메서드가 반환할 객체의 타입입니다.
//         */
//        FileStore testFile = Files.getFileStore(Path.of("/home/test.txt"));
//
//        /**
//         * "new[Type]"
//         * - 다른 클래스 인스턴스를 반환하는 경우 사용합니다.
//         * - "newInstance"와 같습니다.
//         * - [Type]은 팩터리 메서드가 반환할 객체의 타입입니다.
//         */
//        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("/home/test.txt"));
//
//        /**
//         * "type"
//         * - "get[Type]", "new[Type]"의 간결화된 버전입니다.
//         * - get, new만 네이밍에서 제거되었습니다.
//         */
//        List<Integer> integers = Collections.unmodifiableList(Arrays.asList(1, 2));
//    }
}

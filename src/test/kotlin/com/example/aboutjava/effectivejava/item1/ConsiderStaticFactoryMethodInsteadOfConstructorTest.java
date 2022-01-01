package com.example.aboutjava.effectivejava.item1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.*;

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

    @DisplayName("from, of 에서 조금 더 자세하게 네이밍한 정적 팩토리 메서드")
    @Test
    void valueOf() {
        // when
        BigInteger zeroIntValue = BigInteger.valueOf(0);
        // then
        assertAll(
                () -> assertThat(zeroIntValue).isInstanceOf(BigInteger.class),
                () -> assertThat(zeroIntValue).isEqualTo(BigInteger.ZERO)
        );
    }

    @DisplayName("매개변수를 받으면, 매개변수로 명시한 인스턴스를 반환하지만, 같은 인스턴스를 보장하진 않는 정적 팩토리 메서드")
    @Test
    void getInstanceOrInstance() {
        // given
        StackWalker stackWalker = StackWalker.getInstance();
        // when
        assertThat(stackWalker).isInstanceOf(StackWalker.class);
    }

    @DisplayName("instance or getInstance 와 같다. 다른 점은 매번 새로운 인스턴스를 생성하는 정적 팩토리 메서드")
    @Test
    void createOrNewInstance() {
        // when
        String[] strings = (String[]) Array.newInstance(String.class, 10);
        // then
        assertThat(strings).isInstanceOf(String[].class);
    }

    @DisplayName("다른 클래스 인스턴스를 반환하는 경우 사용. 'getInstance'와 같습니다. [ClassType]은 팩터리 메서드가 반환할 객체의 타입입니다.")
    @Test
    void getClassType() throws IOException {
        // when
        FileStore fileStore = Files.getFileStore(Path.of("test.txt"));
        // then
        assertThat(fileStore).isInstanceOf(FileStore.class);
    }

    @DisplayName("다른 클래스 인스턴스를 반환하는 경우 사용. 'newInstance'와 같습니다. [ClassType]은 팩터리 메서드가 반환할 객체의 타입입니다.")
    @Test
    void newClassType() throws IOException {
        // when
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("test.txt"));
        // then
        assertThat(bufferedReader).isInstanceOf(BufferedReader.class);
    }

    @DisplayName("다른 클래스 인스턴스를 반환하는 경우 사용. get[ClassType], new[ClassType]의 간결화된 버전입니다.")
    @Test
    void classType() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        // when
        List<Integer> integers = Collections.unmodifiableList(numbers);
        // then
        assertThat(integers).isInstanceOf(List.class);
    }
}

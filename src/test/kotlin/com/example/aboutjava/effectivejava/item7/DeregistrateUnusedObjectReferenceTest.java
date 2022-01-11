package com.example.aboutjava.effectivejava.item7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class DeregistrateUnusedObjectReferenceTest {

    @DisplayName("Array element 의 null 참조가 풀리지 않은 경우, 메모리 누수")
    @Test
    void usageArrayInCaseOfMemoryLeak() {
        // given
        Stack stack = new Stack();
        IntStream.rangeClosed(1, 4)
                .forEach(stack::push);
        // when
        stack.pop();
        // then
        assertThat(stack.sizeForObjectReference()).isEqualTo(4);
    }

    @DisplayName("메모리가 누수가 되는 Array 사용 형태")
    @Test
    void usageArrayInCaseOfNonMemoryLeak() {
        // given

        // when

        // then

    }
}

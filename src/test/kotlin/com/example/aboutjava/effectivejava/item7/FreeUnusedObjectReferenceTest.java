package com.example.aboutjava.effectivejava.item7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class FreeUnusedObjectReferenceTest {

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

    @DisplayName("Array element 의 null 참조가 풀린 경우, 메모리 GC")
    @Test
    void usageArrayInCaseOfNonMemoryLeak() {
        // given
        Stack stack = new Stack();
        IntStream.rangeClosed(1, 4)
                .forEach(stack::push);
        // when
        stack.popWithoutMemoryLeak();
        // then
        assertThat(stack.sizeForObjectReference()).isEqualTo(3);
    }
}

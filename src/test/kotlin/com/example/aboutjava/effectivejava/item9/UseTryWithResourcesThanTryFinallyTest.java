package com.example.aboutjava.effectivejava.item9;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Item 9 - try-finally보다는 try-with-resources를 사용해야합니다.")
class UseTryWithResourcesThanTryFinallyTest {

    @DisplayName("보완이 필요한 try-finally 사용 예시")
    @Test
    void useTryFinally() throws IOException {
        // given
        String testFileName = "test.txt";
        // when
        String firstLine = ExampleForTryFinally.firstLineOfFile(testFileName);
        // then
        assertThat(firstLine).isEqualTo("test");
    }
}

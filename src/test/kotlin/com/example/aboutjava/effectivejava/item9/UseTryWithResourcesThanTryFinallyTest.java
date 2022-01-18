package com.example.aboutjava.effectivejava.item9;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Item 9 - try-finally보다는 try-with-resources를 사용해야합니다.")
class UseTryWithResourcesThanTryFinallyTest {

    @DisplayName("보완이 필요한 try-finally 사용 예시")
    @Test
    void useFirstLineOfFileWithTryFinally() throws IOException {
        // given
        String testFileName = "test.txt";
        // when
        String firstLine = ExampleForTryFinally.firstLineOfFile(testFileName);
        // then
        assertThat(firstLine).isEqualTo("test");
    }

    @DisplayName("보완이 필요한 try-finally 사용 예시")
    @Test
    void useCopyWithTryFinally() throws IOException {
        // given
        String testFileName = "test.txt";
        String copyTestFileName = "copy_test.txt";
        // when
        ExampleForTryFinally.copy(testFileName, copyTestFileName);
        String firstLine = ExampleForTryFinally.firstLineOfFile(copyTestFileName);
        // then
        assertThat(firstLine).isEqualTo("test");
    }

    @DisplayName("개선된 try-with-resources")
    @Test
    void useTryWithResources() {
        // given
        String testFileName = "test.txt";
        // when
        String firstLine = ExampleForTryWithResources.firstLineOfFile(testFileName, "test");
        // then
        assertThat(firstLine).isEqualTo("test");
    }
}

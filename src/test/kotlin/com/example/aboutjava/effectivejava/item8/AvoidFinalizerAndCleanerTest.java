package com.example.aboutjava.effectivejava.item8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Item 8 - finalizer와 cleaner 사용을 피하라")
@ExtendWith(OutputCaptureExtension.class)
class AvoidFinalizerAndCleanerTest {

    @DisplayName("객체 finalize() 는 객체가 gc 대상일 때 호출 되기 때문에, 매번 호출을 보장 하지 않는다.")
    @Test
    void finalizeInCaseOfTargetObjectWithGc(CapturedOutput capturedOutput) {
        // given
        FinalizerUsage finalizerUsage = new FinalizerUsage();
        // when
        finalizerUsage.hello();
        System.gc();
        // then
        assertThat(capturedOutput.toString()).hasToString("hello()");
    }

    @DisplayName("AutoCloseable 을 구현한 객체는 try~ 사용시 자동 close 가 호출 되고 자원을 회수할 수 있다.")
    @Test
    void closeInCaseOfObjectWithAutoCloseableInTry(CapturedOutput capturedOutput) {
        // when
        // {@link AutoCloseable}이 구현된 객체를 try ~ with resources로 사용하면, 자동으로 close 메서드가 호출이 가능합니다.
        try (Room myRoom = new Room(7)) {
            System.out.println("try()");
        }
        // then
        assertThat(capturedOutput.toString()).hasToString("try()\nclose()\nState.run()\n");
    }

    @DisplayName("AutoCloseable 을 구현한 객체는 try~ 를 사용하지 않으면 close 는 호출되지 않고, 자원을 회수할 수 없다.")
    @Test
    void closeInCaseOfObjectWithAutoCloseable(CapturedOutput capturedOutput) {
        // when
        new Room(99);
        // then
        assertThat(capturedOutput.toString()).hasToString("");
    }
}

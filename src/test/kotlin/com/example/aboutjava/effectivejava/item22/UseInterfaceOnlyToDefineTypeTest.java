package com.example.aboutjava.effectivejava.item22;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Item 22 - 인터페이스는 타입을 정의하는 용도로만 사용해야합니다")
class UseInterfaceOnlyToDefineTypeTest {
    @DisplayName("인터페이스로 상수를 사용하는 잘못된 사용 예시")
    @Test
    void dontUseConstantByInterface() {
        assertThat(UseInterfaceOnlyToDefineType.InvalidInterface.ONE).isOne();
    }
}

package com.example.aboutjava.example._interface.tostring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("인터페이스의 예시를 보기위한 테스트")
class InterfaceToStringTest {
    @DisplayName("구현 클래스에서 toString()을 상속하고 있는지 여부 확인")
    @Test
    void useToStringWithInterfaceTest() {
        // given
        Animal lion = new Lion();
        Animal bear = new Bear();
        // when & then
        assertThat(lion).hasToString("Lion");
        assertThat(bear).hasToString("Bear");
    }
}

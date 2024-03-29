package com.example.aboutjava.example._interface.tostring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Interface 의 예시를 보기 위한 테스트")
class InterfaceToStringTest {

    @DisplayName("구현 클래스에서 toString()을 상속하고 있는지 여부 확인")
    @Test
    void useToStringWithInterfaceTest() {
        // when & then
        assertThat((Animal) new Lion()).hasToString("Lion");
        assertThat((Animal) new Bear()).hasToString("Bear");
    }
}

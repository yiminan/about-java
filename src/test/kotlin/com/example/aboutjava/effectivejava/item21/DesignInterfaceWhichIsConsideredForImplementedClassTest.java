package com.example.aboutjava.effectivejava.item21;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.aboutjava.effectivejava.item21.DesignInterfaceWhichIsConsideredForImplementedClass.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Item 21 - 인터페이스는 구현하는 쪽을 생각해 설계해야합니다")
class DesignInterfaceWhichIsConsideredForImplementedClassTest {

    @DisplayName("디폴트 메서드를 사용하는 형태보다는 구현체에서 직접 구현하는 방법")
    @Test
    void useImplementationThanDefaultMethodInInterface() {
        // given
        DefaultTestable studentTest = new StudentWithOverrideRest();
        // when & then
        assertThat(studentTest.rest()).isEqualTo("게임을 한다.");
    }

    @DisplayName("디폴트 메서드를 사용하는 추천하지 않는 방법")
    @Test
    void dontUseImplementationWithDefaultMethodInInterface() {
        // given
        DefaultTestable studentTest = new StudentWithDefaultRest();
        // when & then
        assertThat(studentTest.rest()).isEqualTo("그냥 쉰다.");
    }
}

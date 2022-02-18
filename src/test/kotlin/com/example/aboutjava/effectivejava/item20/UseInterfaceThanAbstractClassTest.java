package com.example.aboutjava.effectivejava.item20;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.aboutjava.effectivejava.item20.UseInterfaceThanAbstractClass.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("Item 20 - 추상 클래스보다는 인터페이스를 우선하라")
class UseInterfaceThanAbstractClassTest {

    @DisplayName("기존 클래스에도 손쉽게 새로운 인터페이스를 사용 구현")
    @Test
    void useClassWithInterfaceEasily() {
        // given
        User user = new User("nickName", 25);
        // when
        int isSame = user.compareTo(new User("nickName", 25));
        // then
        assertThat(isSame).isZero();
    }

    @DisplayName("인터페이스는 믹스인(mixin) 정의에 안성맞춤이다.")
    @Test
    void useClassWithMixinInterfaces() {
        // given
        Singer singerIu = new IU();// 가수이면서,
        SongWriter songWriterIu = (SongWriter) singerIu;// 작곡가이다.
        // when
        AudioClip audioClip = singerIu.sing(songWriterIu.compose(1));
        // then
        assertThat(audioClip).isNotNull();
    }

    @DisplayName("래퍼 클래스 관용구와 함께 사용하면 기능을 향상시키는 안전하고 강력한 수단이 됩니다.")
    @Test
    void useWrapperClassWithInterface() {
        // when
        Coffee iceAmericano = new IceAmericano();
        Coffee iceLatte = new IceLatte();
        // then
        assertAll(
                () -> assertThat(iceAmericano).isNotNull(),
                () -> assertThat(iceLatte).isNotNull()
        );
    }
}

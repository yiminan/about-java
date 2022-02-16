package com.example.aboutjava.effectivejava.item20;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.aboutjava.effectivejava.item20.UseInterfaceThanAbstractClass.*;
import static com.example.aboutjava.effectivejava.item20.UseInterfaceThanAbstractClass.User;
import static org.assertj.core.api.Assertions.assertThat;

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
        Singer singerIu = new IU();
        SongWriter songWriterIu = (SongWriter) singerIu;
        // when
        Singer.AudioClip audioClip = singerIu.sing(songWriterIu.compose(1));
        // then
        assertThat(audioClip).isNotNull();
    }
}

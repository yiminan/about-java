package com.example.aboutjava.effectivejava.item28;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Item 28 - 배열보다는 리스트를 사용합니다.")
class UseListThanArrayTest {
    @DisplayName("배열을 사용하여, 런타임에 실패하는 경우")
    @Test
    void failAtRuntimeWithArray() {
        // given
        Object[] objects = new Long[1];
        // when & then
        Assertions.assertThatExceptionOfType(ArrayStoreException.class)
                .isThrownBy(() -> objects[0] = "타입이 달라 넣을 수 없다.");
    }

    @DisplayName("제네릭을 사용하여, 컴파일타임에 실패하는 경우")
    @Test
    void failAtCompiletimeWithGeneric() {
        // given
//        List<Object> objects = new ArrayList<Long>();
        // when
//        objects.add("타입이 달아 넣을 수 없다.");
    }
}

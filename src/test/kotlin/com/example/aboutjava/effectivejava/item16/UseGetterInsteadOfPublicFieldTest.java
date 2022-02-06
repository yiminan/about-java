package com.example.aboutjava.effectivejava.item16;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.aboutjava.effectivejava.item16.UseGetterInsteadOfPublicField.*;
import static org.assertj.core.api.Assertions.assertThat;

class UseGetterInsteadOfPublicFieldTest {

    @DisplayName("Thread Safe 하지 않은 public 인스턴스 필드를 사용하는 경우")
    @Test
    void usePublicInstanceFieldWithNonThreadSafe() {
        // given
        PointWithPublicInstanceField point = new PointWithPublicInstanceField();
        // when
        point.x = 1;
        point.y = 2;
        // then
        assertThat(point.x).isEqualTo(1);
        assertThat(point.y).isEqualTo(2);
    }

    @DisplayName("Thread Safe 하지 않는 Mutable Instance 를 사용하는 경우")
    @Test
    void useMutableInstanceWithNonThreadSafe() {
        // given
        MutablePoint point = new MutablePoint(0, 0);
        // when
        point.setX(1);
        point.setY(2);
        // then
        assertThat(point).isEqualTo(new MutablePoint(1, 2));
    }
}

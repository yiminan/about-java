package com.example.aboutjava.example.pattern.strategypattern;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("전략 패턴을 사용한 차 테스트")
class CarTest {

    @Test
    void move() {
        Car car = new Car();
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void stop() {
        Car car = new Car();
        car.move(() -> false);
        assertThat(car.getPosition()).isZero();
    }
}

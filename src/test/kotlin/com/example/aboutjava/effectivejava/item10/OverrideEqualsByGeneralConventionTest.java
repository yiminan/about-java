package com.example.aboutjava.effectivejava.item10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Item 10 - equals 는 일반 규약을 지켜 재정의 해야 한다.")
@DataJpaTest
class OverrideEqualsByGeneralConventionTest {

    @Autowired
    private UserRepository userRepository;
}

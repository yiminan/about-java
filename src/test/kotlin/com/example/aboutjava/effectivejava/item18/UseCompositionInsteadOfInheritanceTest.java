package com.example.aboutjava.effectivejava.item18;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Item 18 - 상속보다는 컴포지션(구성)을 사용해야합니다")
class UseCompositionInsteadOfInheritanceTest {

    @DisplayName("상속으로 구현된 Set 의 요소 추가시 잘못된 요소 추가 예시")
    @Test
    void dontUseClassWithInheritance() {
        // given
        UseCompositionInsteadOfInheritance.MyHashSet<String> myHashSet = new UseCompositionInsteadOfInheritance.MyHashSet<>();
        List<String> addNumbers = List.of("1", "2", "3");
        // when
        myHashSet.addAll(addNumbers);
        // then
        assertThat(myHashSet.getAddCount()).isNotEqualTo(addNumbers.size());// 예상 3, 실제 6
    }

}

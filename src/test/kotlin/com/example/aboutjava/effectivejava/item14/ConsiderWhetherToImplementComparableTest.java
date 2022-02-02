package com.example.aboutjava.effectivejava.item14;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import static com.example.aboutjava.effectivejava.item14.ConsiderWhetherToImplementComparable.Book;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Item 14 - Comparable을 구현할지 고려해야합니다.")
class ConsiderWhetherToImplementComparableTest {

    @DisplayName("Comparable 를 구현한 구현체 TreeSet<String> 사용")
    @Test
    void exampleTreeSetWithString() {
        // given
        Set<String> strings = new TreeSet<>();
        // when
        Collections.addAll(strings, "B", "C", "A");
        // then
        /**
         * String은 {@link Comparable}을 구현한 구현체입니다.<p>
         * compareTo를 통해서 단순 동치성 비교에 더해 순서까지 비교할 수 있습니다.<p>
         */
        assertThat(strings).hasToString("[A, B, C]");// [A, B, C]
    }

    @DisplayName("Comparable 를 구현한 구현체 TreeSet<Book> 사용")
    @Test
    void exampleTreeSetWithCustomClass() {
        // given
        Set<Book> books = new TreeSet<>();
        // when
        Collections.addAll(
                books,
                new Book("An Apple"), new Book("Creative Idea"), new Book("Beyond Today")
        );
        // then
        assertThat(books).hasToString("[Book{name='An Apple'}, Book{name='Beyond Today'}, Book{name='Creative Idea'}]");
    }

    @DisplayName("Comparable 를 구현한 구현체 String[] 사용")
    @Test
    void exampleStringArrayWithComparable() {
        // given
        String[] alphabet = new String[] {"C", "A", "B"};
        // when
        Arrays.sort(alphabet);
        // then
        assertThat(String.join(",", alphabet)).isEqualTo("A,B,C");
    }
}

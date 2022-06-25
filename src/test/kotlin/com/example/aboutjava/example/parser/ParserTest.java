package com.example.aboutjava.example.parser;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParserTest {

    @DisplayName("yml 형식의 Key,Value를 객체로 변경")
    @ParameterizedTest
    @ValueSource(strings = {"name:Ryan\nage:20\nsex:M", "{name:Ryan\nage:20\nsex:M}", "{name: Ryan\nage: 20\nsex: M}"})
    void convertKeyValueForYmlToObject(String ymlKeyValues) {
        ymlKeyValues = ymlKeyValues.replaceAll("[ {}]+", "");

        Map<String, String> map = Arrays.stream(ymlKeyValues.split("[\\n]+"))
                .collect(Collectors.toMap(a -> a.substring(0, a.indexOf(":")), a -> a.substring(a.indexOf(":") + 1), (a1, b) -> b));

        ObjectMapper objectMapper = new ObjectMapper();
        assertThat(objectMapper.convertValue(map, Person.class)).isEqualTo(new Person("Ryan", 20, "M"));
    }

    private static class Person {

        private final String name;
        private final int age;
        private final String sex;

        @JsonCreator
        public Person(@JsonProperty("name") String name, @JsonProperty("age") int age, @JsonProperty("sex") String sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Person person = (Person) o;
            return age == person.age && Objects.equals(name, person.name) && Objects.equals(sex, person.sex);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, sex);
        }
    }
}

package com.example.aboutjava.example.parser;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParserTest {

    @DisplayName("yml 형식의 Key,Value를 특정 객체 인스턴스로 변경")
    @ParameterizedTest
    @ValueSource(strings = {"name:Ryan\nage:20\nsex:M", "{name:Ryan\nage:20\nsex:M}", "{name: Ryan\nage: 20\nsex: M}"})
    void convertKeyValueForYmlToObject(String ymlKeyValues) {
        ymlKeyValues = ymlKeyValues.replaceAll("[ |{}]+", "");

        Map<String, String> map = Arrays.stream(ymlKeyValues.split("[\\n]+"))
                .collect(Collectors.toMap(a -> a.substring(0, a.indexOf(":")), a -> a.substring(a.indexOf(":") + 1), (a1, b) -> b));

        ObjectMapper objectMapper = new ObjectMapper();
        assertThat(objectMapper.convertValue(map, Person.class)).isEqualTo(new Person("Ryan", 20, "M"));
    }
}

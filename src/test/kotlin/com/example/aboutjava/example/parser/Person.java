package com.example.aboutjava.example.parser;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

class Person {

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

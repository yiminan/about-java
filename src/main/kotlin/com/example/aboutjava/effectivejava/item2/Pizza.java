package com.example.aboutjava.effectivejava.item2;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

abstract class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        /**
         * 하위 클래스는 이 메서드를 재정의(overriding)하여 하위 객체의 "this"를 반환하도록 해야합니다.
         */
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}

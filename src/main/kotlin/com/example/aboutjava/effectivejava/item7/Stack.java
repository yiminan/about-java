package com.example.aboutjava.effectivejava.item7;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Objects;

public class Stack {
    private static final int DEFAULT_INITIAL_CAPACITY = 3;

    private Object[] elements;
    private int index = 0;

    public Stack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[index++] = e;
    }

    public Object pop() {
        if (index == 0)
            throw new EmptyStackException();
        return elements[--index];
    }

    public Object popWithoutMemoryLeak() {
        if (index == 0)
            throw new EmptyStackException();
        Object result = elements[--index];
        elements[index] = null;// 다 쓴 참조 해제
        return result;
    }

    public int sizeForObjectReference() {
        return (int) Arrays.stream(elements)
                .filter(Objects::nonNull)
                .count();
    }

    private void ensureCapacity() {
        if (elements.length == index)
            this.elements = Arrays.copyOf(elements, index + 1);
    }
}

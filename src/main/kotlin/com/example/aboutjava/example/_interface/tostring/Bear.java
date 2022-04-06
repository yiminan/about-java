package com.example.aboutjava.example._interface.tostring;

class Bear implements Animal {
    @Override
    public String toString() {
        return Bear.class.getSimpleName();
    }
}

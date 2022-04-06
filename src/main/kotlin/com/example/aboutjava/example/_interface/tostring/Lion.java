package com.example.aboutjava.example._interface.tostring;

class Lion implements Animal {
    @Override
    public String toString() {
        return Lion.class.getSimpleName();
    }
}

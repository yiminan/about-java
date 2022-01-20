package com.example.aboutjava.example.threadsleep;

import java.util.stream.IntStream;

class ThreadSleep {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10).forEach(v -> {
            System.out.println(v);
            sleep();
        });
    }

    private static void sleep() {
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

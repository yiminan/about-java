package com.example.aboutjava.effectivejava.item8;

import java.lang.ref.Cleaner;

class ExampleCleaner {

    private static class Adult {
        public static void main(String[] args) {
            /**
             * {@link AutoCloseable}이 구현된 객체를 try ~ with resources로 사용하면, 자동으로 close 메서드가 호출이 가능합니다.
             */
            try (Room myRoom = new Room(7)) {
                System.out.println("Hi~");
            }
            /**
             * Hi~
             * Room Clean
             */
        }
    }

    private static class Teenager {
        /**
         * {@link AutoCloseable}이 구현된 객체라도 try ~ with resources로 사용되지 않으면, close 메서드가 호출되지 않습니다.
         */
        public static void main(String[] args) {
            new Room(99);
            System.out.println("Anyway~");
            // System.gc();
        }
        /**
         * Anyway~
         */
    }
}

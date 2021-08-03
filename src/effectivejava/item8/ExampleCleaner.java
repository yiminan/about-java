package effectivejava.item8;

import java.lang.ref.Cleaner;

class ExampleCleaner {

    private static class Adult {
        public static void main(String[] args) {
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
        public static void main(String[] args) {
            new Room(99);
            System.out.println("Anyway~");
        }
        /**
         * Anyway~
         */
    }

    private static class Room implements AutoCloseable {
        // Room 인스턴스를 참조해서는 순환참조가 발생하므로 State는 static class 정의
        private static final Cleaner cleaner = Cleaner.create();

        // 방의 상태, cleanable과 공유한다.
        private final State state;
        // cleanable 객체, 수거 대상이 되면 방을 청소한다.
        private final Cleaner.Cleanable cleanable;

        public Room(int numJunkPiles) {
            state = new State(numJunkPiles);
            cleanable = cleaner.register(this, state);
        }

        @Override
        public void close() {
            cleanable.clean();
        }

        private static class State implements Runnable {
            // 방(Room) 안의 쓰레기 수
            int numJunkPiles;

            State(int numJunkPiles) {
                this.numJunkPiles = numJunkPiles;
            }

            /**
             * close 메서드나 cleaner가 호출한다.
             */
            @Override
            public void run() {
                System.out.println("Room Clean");
                numJunkPiles = 0;
            }
        }
    }
}

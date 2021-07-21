package effectivejava.item8;

import java.lang.ref.Cleaner;

/**
 * "finalizer와 cleaner 사용을 피하라"<p>
 * <p>
 * Java는 두 가지 객체 소멸자를 제공합니다.<p>
 * 1.Finalizer<p>
 * - 실행을 예측할 수 없고, 상황에 따라 위험할 수 있어서 일반적으로 불필요합니다.<p>
 * 2.Cleaner<p>
 * - finalizer보다는 덜 위험하지만, 여전히 예측할 수 없고, 느리고, 일반적으로 불필요합니다.<p>
 */
class AvoidFinalizerAndCleaner {

    public static class FinalizerExample {

        /**
         * 객체 사용 이후에 호출될 지 여부를 보장하지 못한다.
         */
        @Override
        protected final void finalize() throws Throwable {
            System.out.println("Clean up");
        }

        public void hello() {
            System.out.println("hello()");
        }
    }

    private static class SampleRunner {

        public static void main(String[] args) {
            SampleRunner runner = new SampleRunner();
            runner.run();
//            System.gc();
        }

        private void run() {
            FinalizerExample finalizerExample = new FinalizerExample();
            finalizerExample.hello();
        }
    }

    private static class Room implements AutoCloseable {
        // Room 인스턴스를 참조해서는 순환참조가 발생하므로 State는 static class 정의
        private static final Cleaner cleaner = Cleaner.create();

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
    }
}

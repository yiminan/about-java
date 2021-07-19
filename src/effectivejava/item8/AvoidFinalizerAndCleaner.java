package effectivejava.item8;

import java.lang.ref.Cleaner;

/**
 * "finalizer와 cleaner 사용을 피하라"<p>
 * <p>
 * Java는 두 가지 객체 소멸자를 제공합니다.<p>
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
}

package effectivejava.item8;

import java.lang.ref.Cleaner;

/**
 * "finalizer와 cleaner 사용을 피하라"<p>
 * <p>
 * Java는 두 가지 객체 소멸자를 제공합니다.<p>
 */
class AvoidFinalizerAndCleaner {

    public class FinalizerExample {

        @Override
        protected final void finalize() throws Throwable {
            System.out.println("Clean up");
        }

        public void hello() {
        }
    }

    public class SampleRunner {

        public static void main(String[] args) {
            SampleRunner runner = new SampleRunner();
            runner.run();
        }

        priavte void run() {
            FinalizerExample finalizerExample = new FinalizerExample();
            finalizerExample.hello();
        }
    }
}

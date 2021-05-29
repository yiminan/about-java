package elegantobject.step2_education.makeaimmutableobject;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * "불변 객체는 스레드 안정성(Thread Safety)를 가진다"<p>
 * 병렬 스레드에서 객체를 실행하면, 가변 객체와 불변 객체의 스레드 안정성을 확인해볼 수 있습니다.<p>
 * <p>
 * 물론 가변 객체를 synchronized를 사용해서 명시적으로 스레드 안정성을 구현할 수는 있습니다.<p>
 * 다만, 명식적으로 synchronized를 사용하면, 성능상 비용이 발생합니다.<p>
 * 각각 스레드가 해당하는 객체를 사용하기 위해서는 객체가 다른 스레드로 해방될 때까지 기다려야합니다.<p>
 * 각 스레드는 객체를 배타적으로 락킹(locking)합니다. 즉, 해당 객체가 해제될 때까지 무조건 기다려야합니다.<p>
 * 데드락(dead lock)이 발생하여, 해결 알고리즘을 제어를 구현해야하는 단점도 존재합니다.<p>
 * 이러한 이유로 가변객체보다는 불변 객체를 사용할 것을 추천합니다.<p>
 * <p>
 * 결과<p>
 * - 가변 객체 : 스레드가 객체의 내용을 공유하기 때문에 어떤 결과가 나올지 매번 달라집니다.<p>
 * - 가변 객체 with synchronized : 객체별를 스레드별 고립시켜서 데이터가 공유되지 않습니다. 정확한 결과가 나옵니다. 단, 성능상 단점이 존재<p>
 * - 불변 객체 : 객체별로 내용물이 변경될 여지가 없고 내용이 갱신되면 새로운 객체가 생성되기 때문에 정확한 결과가 나옵니다. 성능상 이점도 존재<p>
 */
class AdvantageOfThreadSafety {
    private static final int TEST_SAMPLE_COUNT = 3;

    public static void main(String[] args) {
        executeNonThreadSafetyCase();
        executeNonThreadSafetyWithSyncCase();
        executeThreadSafetyCase();
    }

    private static void executeNonThreadSafetyCase() {
        final NonThreadSafetyCash nonThreadSafetyCash = new NonThreadSafetyCash(10, 45);
        CountDownLatch start = new CountDownLatch(1);
        Callable<Object> script = () -> {
            start.await();
            nonThreadSafetyCash.multiply(2);
            System.out.println("NonThreadSafety " + nonThreadSafetyCash);
            return null;
        };
        final ExecutorService svc = Executors.newCachedThreadPool();
        IntStream.rangeClosed(1, TEST_SAMPLE_COUNT).forEach(i -> svc.submit(script));
        start.countDown();

        svc.shutdown();
    }

    private static void executeNonThreadSafetyWithSyncCase() {
        final NonThreadSafetyCashWithSync nonThreadSafetyCashWithSync = new NonThreadSafetyCashWithSync(10, 45);
        CountDownLatch start = new CountDownLatch(1);
        Callable<Object> script = () -> {
            start.await();
            nonThreadSafetyCashWithSync.multiply(2);
            System.out.println("NonThreadSafetyWithSync " + nonThreadSafetyCashWithSync);
            return null;
        };
        final ExecutorService svc = Executors.newCachedThreadPool();
        IntStream.rangeClosed(1, TEST_SAMPLE_COUNT).forEach(i -> svc.submit(script));
        start.countDown();

        svc.shutdown();
    }

    private static void executeThreadSafetyCase() {
        final ImmutableObjectCash tenFortyFive = new ImmutableObjectCash(10, 45);
        CountDownLatch start = new CountDownLatch(1);
        Callable<Object> script = () -> {
            start.await();
            ImmutableObjectCash twentyNinety = tenFortyFive.multiply(2);
            System.out.println("ThreadSafety " + twentyNinety);
            return null;
        };
        final ExecutorService svc = Executors.newCachedThreadPool();
        IntStream.rangeClosed(1, TEST_SAMPLE_COUNT).forEach(i -> svc.submit(script));
        start.countDown();

        svc.shutdown();
    }

    private static class NonThreadSafetyCash {
        private int dollars;
        private int cents;

        public NonThreadSafetyCash(int dollars, int cents) {
            this.dollars = dollars;
            this.cents = cents;
        }

        public void multiply(int factor) {
            this.dollars *= factor;
            this.cents *= factor;
        }

        @Override
        public String toString() {
            return String.format("$%d.%d", dollars, cents);
        }
    }

    private static class NonThreadSafetyCashWithSync {
        private int dollars;
        private int cents;

        public NonThreadSafetyCashWithSync(int dollars, int cents) {
            this.dollars = dollars;
            this.cents = cents;
        }

        public void multiply(int factor) {
            synchronized (this) {
                this.dollars *= factor;
                this.cents *= factor;
            }
        }

        @Override
        public String toString() {
            return String.format("$%d.%d", dollars, cents);
        }
    }

    private static class ImmutableObjectCash {
        private final int dollars;
        private final int cents;

        public ImmutableObjectCash(int dollars, int cents) {
            this.dollars = dollars;
            this.cents = cents;
        }

        public ImmutableObjectCash multiply(int factor) {
            return new ImmutableObjectCash(this.dollars * factor, this.cents * factor);
        }

        @Override
        public String toString() {
            return String.format("$%d.%d", dollars, cents);
        }
    }
}

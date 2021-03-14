package elegantobject.education.makeaimmutableobject;

class AdvantageOfThreadSafety {
    private static void executeNonThreadSafetyCase() {
        final NonThreadSafetyCash nonThreadSafetyCash = new NonThreadSafetyCash(10,45);
        CountDownLatch start = new CountDownLatch(1);
        Callable<Object> script = () -> {
            start.await();
            nonThreadSafetyCash.multiply(2);
            System.out.println(nonThreadSafetyCash);
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

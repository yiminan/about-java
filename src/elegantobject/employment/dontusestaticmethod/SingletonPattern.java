package elegantobject.employment.dontusestaticmethod;

class SingletonPattern {
    /**
     * 미리 인스턴스를 생성해두고 사용하는 싱글톤 클래스 예시
     */
    private static class EagerSingletonMath {
        // 단, 하나의 인스턴스만 생성해둡니다.
        private static EagerSingletonMath SINGLE_INSTANCE = new EagerSingletonMath();
        private int result;

        // Math의 인스턴스를 생성하지 못하게 private생성자로 막아둡니다.
        private EagerSingletonMath() {
        }

        // 이미 생성된 인스턴스를 반환 받아 사용할 수 있습니다.
        public static EagerSingletonMath getInstance() {
            return EagerSingletonMath.SINGLE_INSTANCE;
        }

        public int max(int a, int b) {
            if (a < b) {
                return b;
            }
            return a;
        }

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }
    }

    /**
     * 인스턴스를 나중에 필요한 시점에 생성하고 사용하는 싱글톤 클래스 예시
     */
    private static class LazySingletonMath {
        // 단, 하나의 인스턴스만 생성해둡니다.
        private static LazySingletonMath SINGLE_INSTANCE = null;
        private int result;

        // Math의 인스턴스를 생성하지 못하게 private생성자로 막아둡니다.
        private LazySingletonMath() {
        }

        // 이미 생성된 인스턴스를 반환 받아 사용할 수 있습니다.
        public static LazySingletonMath getInstance() {
            if (SINGLE_INSTANCE == null) {
                synchronized (LazySingletonMath.class) {
                    SINGLE_INSTANCE = new LazySingletonMath();
                }
            }
            return SINGLE_INSTANCE;
        }

        public int max(int a, int b) {
            if (a < b) {
                return b;
            }
            return a;
        }

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }
    }

    /**
     * UtilityMath 클래스는 유틸리티 클래스의 대표적인 예입니다.
     */
    private static class UtilityMath {
        private UtilityMath() {
        }

        public static int max(int a, int b) {
            if (a < b) {
                return b;
            }
            return a;
        }
    }
}

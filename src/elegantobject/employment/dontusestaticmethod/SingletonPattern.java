package elegantobject.employment.dontusestaticmethod;

class SingletonPattern {
    /**
     * SingletonMath 클래스는 싱글톤의 대표적인 예입니다.
     * SingletonMath 클래스의 인스턴스는 오직 하나만 존재할 수 있고, 유일한 인스턴스의 이름은 INSTANCE입니다.
     * 싱글톤 클래스는 객체 인스턴스화 시킬 수 없습니다.
     * 인스턴스화된 객체는 getInstance를 호출하고 반환 받아서 사용 가능합니다.
     */
    private static class SingletonMath {
        // 단, 하나의 인스턴스만 생성해둡니다.
        private static SingletonMath INSTANCE = new SingletonMath();

        // Math의 인스턴스를 생성하지 못하게 private생성자로 막아둡니다.
        private SingletonMath() {
        }

        // 이미 생성된 인스턴스를 반환 받아 사용할 수 있습니다.
        public static SingletonMath getInstance() {
            return SingletonMath.INSTANCE;
        }

        public static void setInstance(SingletonMath instance) {
            INSTANCE = instance;
        }

        public int max(int a, int b) {
            if (a < b) {
                return b;
            }
            return a;
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

    private static class SingletonUser {
        private static SingletonUser INSTANCE = new SingletonUser();
        private String name;

        private SingletonUser() {
        }

        public static SingletonUser getInstance() {
            return SingletonUser.INSTANCE;
        }

        public static void setInstance(SingletonUser user) {
            INSTANCE = user;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

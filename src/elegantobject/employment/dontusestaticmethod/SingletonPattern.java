package elegantobject.employment.dontusestaticmethod;

/**
 * "싱글톤(Singleton) 패턴"<p>
 * <p>
 * 싱글톤 패턴은 정적 메서드 대신 사용할 수 있는 매우 유명한 개념입니다.<p>
 * 실제로 싱글톤 안에는 하나의 정적 메서드가 존재하며, 싱글톤의 형태는 일반적인 객체와 거의 유사합니다.<p>
 * 하지만 일반 객체와는 매우 다릅니다.<p>
 * 싱글톤은 유명한 디자인 패턴이고, 안티 패턴입니다.<p>
 * 싱글톤 클래스와 유틸리티 클래스는 정확히 동일한 일을 수행합니다.<p>
 * 더욱이 유틸리티 클래스는 로직을 분리할 수 없는 하드코딩된 의존성을 가집니다.<p>
 * 그러면 왜 동일한 일을 하는데, 싱글톤 패턴을 사용하게 될까요?<p>
 * - 싱글톤은 상태를 캡슐화시킬 수 있습니다. 하지만 상태를 유지하기 위해서 싱글톤을 사용하진 않습니다. 유틸리티 클래스로도 상태를 저장할 수 있습니다.<p>
 * 그래도 싱글톤도 유틸리티 클래스보다 낫다고 하지만 여전히 안티패턴이고 형편없는 개념입니다.<p>
 * 논리적인/기술적인 관점에서 싱글톤은 전역 변수 그 이상도 그 이하도 아닙니다.<p>
 * OOP에는 전역 범위(global scope)는 없습니다. 전역 변수를 위한 자리도 없습니다.<p>
 * <p>
 * 전역 변수의 사용 반대에도 불구하고, Java에서 전역변수를 사용할 수 있는 방법을 발견했고, 그 결과가 싱글톤입니다.<p>
 * 싱글톤은 객체지향 패러다임을 잘못 사용한 예이고, 오직 정적 메서드 때문에 만들어서 사용하게된 속임수입니다.<p>
 * 절대, 유틸리티 클래스, 싱글톤 클래스를 사용하면 안됩니다.<p>
 * <p>
 * 정적 유틸리티 클래스 X => 싱글톤 클래스 X => 캡슐화를 이용한 OOP 클래스 O<p>
 */
class SingletonPattern {

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        System.out.println(EagerSingletonMath.getInstance().max(a, b) == UtilityMath.max(a, b));// true
    }

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

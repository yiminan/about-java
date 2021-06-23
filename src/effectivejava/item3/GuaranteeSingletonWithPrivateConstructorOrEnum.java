package effectivejava.item3;

/**
 * "private 생성자나 Enum 타입으로 싱글턴임을 보증해야합니다"<p>
 * 싱글턴(singleton)이란 인스턴스를 오직 하나만 생성할 수 있는 클래스를 말한다.<p>
 * 싱글턴의 예는 '무상태 객체'나 '설계상 유일해야하는 시스템 컴포넌트'에서 사용입니다.<p>
 * 무상태(stateless) 객체 : 내부 필드로 상태값을 가지고 있지 않은 객체<p>
 * 설계상 유일해야하는 시스템 컴포넌트 : 스프링 bean과 같은 시스템에 유일해야하는 컴포넌트<p>
 * 클래스를 싱글턴으로 만들면 이를 사용하는 클라이언트를 테스트하기 힘들어집니다.<p>
 * 인터페이스로 구현된 싱글턴이 아닌 경우에는 싱글턴 인스턴스를 테스트에서 mock으로 구현하기 힘듭니다.<p>
 * 싱글턴을 만드는 보통 방식)<p>
 * 공통) 클래스 생성자를 private으로 감추어두고, 내부 field로 publid static 멤버를 하나 마련하여 사용<p>
 * 1) 'public static final' field를 만들어서 사용하는 방식<p>
 * 2) 'static factory' method를 만들어서 사용하는 방식<p>
 */
class GuaranteeSingletonWithPrivateConstructorOrEnum {

    public static void main(String[] args) {
        System.out.println(SingletonByPublicStaticFinalField.INSTANCE);
        System.out.println(SingletonByStaticFactoryMethod.getINSTANCE());
    }

    /**
     * 1) 'public static final' field를 만들어서 사용하는 방식
     */
    private static class SingletonByPublicStaticFinalField {
        public static final SingletonByPublicStaticFinalField INSTANCE = new SingletonByPublicStaticFinalField();

        private SingletonByPublicStaticFinalField() {
        }
    }

    /**
     * 2) 'static factory' method를 만들어서 사용하는 방식
     */
    private static class SingletonByStaticFactoryMethod {
        private static final  SingletonByStaticFactoryMethod INSTANCE = new SingletonByStaticFactoryMethod();

        private SingletonByStaticFactoryMethod() {
        }

        public static SingletonByStaticFactoryMethod getINSTANCE() {
            return INSTANCE;
        }
    }
}

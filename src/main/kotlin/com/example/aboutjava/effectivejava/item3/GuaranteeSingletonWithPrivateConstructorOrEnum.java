package com.example.aboutjava.effectivejava.item3;

/**
 * "private 생성자나 Enum 타입으로 싱글턴임을 보증해야합니다"<p>
 * <p>
 * 싱글턴(singleton)이란 인스턴스를 오직 하나만 생성할 수 있는 클래스를 말한다.<p>
 * 싱글턴의 예는 '무상태 객체'나 '설계상 유일해야하는 시스템 컴포넌트'에서 사용입니다.<p>
 * 무상태(stateless) 객체 : 내부 필드로 상태값을 가지고 있지 않은 객체<p>
 * 설계상 유일해야하는 시스템 컴포넌트 : 스프링 bean과 같은 시스템에 유일해야하는 컴포넌트<p>
 * 클래스를 싱글턴으로 만들면 이를 사용하는 클라이언트를 테스트하기 힘들어집니다.<p>
 * 인터페이스로 구현된 싱글턴이 아닌 경우에는 싱글턴 인스턴스를 테스트에서 mock으로 구현하기 힘듭니다.<p>
 * <p>
 * 싱글턴을 만드는 보통 방식)<p>
 * 공통) 클래스 생성자를 private으로 감추어두고, 내부 field로 publid static 멤버를 하나 마련하여 사용<p>
 * <p>
 * 1. 'public static final' field를 만들어서 사용하는 방식<p>
 * 1.1. 명확한 public static final field를 참조하기 때문에 싱글턴임이 명확하다.<p>
 * 1.2. 싱글턴 클래스를 간결하게 만들 수 있다.<p>
 * <p>
 * 2. 'static factory' method를 만들어서 사용하는 방식<p>
 * 2.1. 메서드로 싱글턴 인스턴스를 반환하기 때문에 API 코드 변경 없이 싱글턴이 아니게 변경이 가능합니다. 예를 들면, 쓰레드별 인스턴스를 제공이 가능합니다.<p>
 * 2.2. 정적 팩터리를 제네릭 싱글턴 팩토리로 만들 수 있습니다.<p>
 * 2.3. 정적 팩토리의 메서드 참조를 공급자(Supplier)로 사용할 수 있다는 점입니다. ex) User::getInstance -> Supplier&lt;User&gt;<p>
 * <p>
 * - 굳이 위에 나열한 장점이 필요없으면 'public static final' field를 사용하는 것이 좋다.<p>
 * - 싱글턴을 직렬화 해서 사용하려면, Serializable를 구현한다고 선언하는 것으로는 부족합니다.<p>
 * - 모든 인스턴스 field는 transient로 선언하고, readResolve 메서드를 제공해야합니다.<p>
 * - 만약 그렇게하지 않으면, 매번 역직렬화시 새로운 인스턴스가 생성되어서 반환됩니다. 즉, 싱글턴 구현이 되지 않는 것입니다.<p>
 * <p>
 * 3. enum 타입을 사용한 방식<p>
 * - '1. 'public static final' field를 만들어서 사용하는 방식' 과 비슷하지만, 더 간결하고, 추가 노력 없이 직렬화가 가능합니다.<p>
 * - 아주 복잡한 직렬화나 리플렉션 공격에도 제 2의 인스턴스를 방지합니다.<p>
 * - 원소가 하나뿐인 열거 타입이 싱글턴을 만드는 것이 가장 좋은 방법입니다.<p>
 * - class 싱글톤은 멀티 스레드 환경에서 2개 이상 인스턴스가 발생할 수 있지만, enum은 애초에 불가능하고, serialization / thread-safe을 보장합니다.<p>
 * - 단, 만들려는 싱글턴이 Enum 외의 클래스를 상속해야 한다면 이 방법은 사용할 수 없습니다. Enum은 애초에 클래스를 상속하지 못하기 때문입니다.<p>
 * - @see <a href='https://getter-setter.com/2019/07/31/class-%EC%8B%B1%EA%B8%80%ED%86%A4-vs-enum-%EC%8B%B1%EA%B8%80%ED%86%A4/'>예시</a><p>
 */
class GuaranteeSingletonWithPrivateConstructorOrEnum {

    public static void main(String[] args) {
        /**
         * 1. 'public static final' field를 만들어서 사용하는 방식
         */
        System.out.println(SingletonByPublicStaticFinalField.INSTANCE);
        /**
         * 2. 'static factory' method를 만들어서 사용하는 방식
         */
        System.out.println(SingletonByStaticFactoryMethod.getINSTANCE());
        /**
         * 3. enum 타입을 사용한 방식
         */
        System.out.println(SingletonByEnum.INSTANCE);
        System.out.println(SingletonByEnum.INSTANCE.getInstance());
    }

    /**
     * 1. 'public static final' field를 만들어서 사용하는 방식
     */
    private static class SingletonByPublicStaticFinalField {
        public static final SingletonByPublicStaticFinalField INSTANCE = new SingletonByPublicStaticFinalField();

        private SingletonByPublicStaticFinalField() {
        }
    }

    /**
     * 2. 'static factory' method를 만들어서 사용하는 방식
     */
    private static class SingletonByStaticFactoryMethod {
        private static final SingletonByStaticFactoryMethod INSTANCE = new SingletonByStaticFactoryMethod();

        private SingletonByStaticFactoryMethod() {
        }

        public static SingletonByStaticFactoryMethod getINSTANCE() {
            return INSTANCE;
        }
    }

    /**
     * 3. enum 타입을 사용한 방식
     */
    private enum SingletonByEnum {
        // 1. 'public static final' field를 만들어서 사용하는 방식
        INSTANCE("Initial class info");

        private String information;

        SingletonByEnum(String information) {
            this.information = information;
        }

        // 2. 'static factory' method를 만들어서 사용하는 방식
        public SingletonByEnum getInstance() {
            return INSTANCE;
        }
    }
}

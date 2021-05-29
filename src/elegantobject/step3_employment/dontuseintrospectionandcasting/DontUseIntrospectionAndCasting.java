package elegantobject.step3_employment.dontuseintrospectionandcasting;

import java.util.Collection;

/**
 * "인트로스펙션과 캐스팅을 사용하지 않습니다"
 * 예를 들면, Java instanceOf 연산자와 Class.cast() 메서드를 통해서 런타임에 인트로스펙션하면 안됩니다.
 * 타입 인트로스펙션은 리플렉션(reflection)이라는 포괄적인 용어의 기법 중 하나입니다.
 * 리플렉션은 메서드, 명령어, 구문, 클래스, 객체, 타입 등을 쉽게 변경할 수 있습니다.
 * 매우 강력한 기법이지만 OOP에서는 사용해서는 안되는 유지보수에 안좋은 너저분한 기법입니다.
 * 타입 인트로스펙션은 타입에 따라 객체를 차별하기 때문에 OOP의 기본 사상을 훼손시킵니다.
 * 객체는 호출한 메서드의 빌더나 조정자에 따라서 정해진 역할을 해야합니다.
 * 하지만 타입 인트로스펙션을 사용하게 되면 입력 인자에 따라서 객체는 전혀 다른 행동을 할 수 있습니다.
 * 객체는 전달되는 타입에 대한 차별없이 본인이 맡은 임무에 충실해야합니다.
 * 여기에서는 코드 안에서 타입별 차별을 가지지 않게 메서드 오버로딩(method overloading)을 사용합니다.
 * 결론)
 * Java의 'instanceof 연산자'나 '클래스 캐스팅'을 사용하는 것은 안티패턴이기 때문에 사용해서는 안됩니다.
 * Java나 다른 OOP 언어에서는 리플렉션 기능을 제공하고 있지만, 소프트웨어에 도움이 되지 않는 기능입니다.
 */
class DontUseIntrospectionAndCasting {

    private static class WrongCase {
        /**
         * 런타임 환경에서 객체의 타입이 조사되는 것자체가 클래스 타입과의 결합도가 높아집니다.
         * 기술적 관점에서 이러한 결합도는 옳지 않습니다. 유지보수에 악영향을 미치게됩니다.
         * 타입이 에초에 나뉘어서 메서드가 작성되어야합니다.
         * 클래스 캐스팅도 마찬가지로 전달된 인자와 높은 결합도를 가진 코드가 됩니다.
         */
        public <T> int size(Iterable<T> items) {
            if (items instanceof Collection) {
                return Collection.class.cast(items).size();
            }
            int size = 0;
            for (T item : items) {
                ++size;
            }
            return size;
        }
    }

    /**
     * 전달되는 인자는 객체 타입별로 메서드 오버로딩(method overloading)으로 분리된 메서드를 생성해야합니다.
     * 각 메서드는 인자별로 객체의 행동을 차별하지 않고, 본연의 목적을 달성할 수 있습니다.
     * 크게 다른 것 같지만, 오버로딩을 사용했기 때문에 Java는 타입을 자동으로 찾아서 해당하는 메서드를 실행합니다.
     */
    private static class GoodCase {
        public <T> int size(Collection<T> items) {
            return items.size();
        }

        public <T> int size(Iterable<T> items) {
            int size = 0;
            for (T item : items) {
                ++size;
            }
            return size;
        }
    }
}

package elegantobject.employment.dontuseintrospectionandcasting;

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

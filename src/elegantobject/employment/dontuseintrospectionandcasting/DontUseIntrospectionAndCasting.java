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
}

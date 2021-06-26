package effectivejava.item3;

import java.io.Serializable;

class SingletonWithSameInstance implements Serializable {

    private static final class MySingleton {
        private static final MySingleton INSTANCE = new MySingleton();

        private MySingleton() {
        }

        public static MySingleton getINSTANCE() {
            return INSTANCE;
        }

        /**
         * readResolve 메서드를 정의하면서 싱글턴을 보장한다.
         */
        private Object readResolve() {
            // INSTANCE를 반환으로 싱글턴을 보장한다.
            return INSTANCE;
        }

    }
}

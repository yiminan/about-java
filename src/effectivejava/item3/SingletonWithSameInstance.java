package effectivejava.item3;

import java.io.*;

class SingletonWithSameInstance {

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

    private static final class TestSerializer {
        public byte[] serialize(Object instance) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            try (bos; ObjectOutputStream oos = new ObjectOutputStream(bos)) {
                oos.writeObject(instance);
            } catch (Exception e) {
            }
            return bos.toByteArray();
        }

        public Object deserialize(byte[] serializedData) {
            ByteArrayInputStream bis = new ByteArrayInputStream(serializedData);
            try (bis; ObjectInputStream ois = new ObjectInputStream(bis)) {
                return ois.readObject();
            } catch (Exception e) {
            }
            return null;
        }
    }
}

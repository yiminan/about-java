package effectivejava.item3;

import java.io.*;

class SingletonWithSameInstance {

    public static void main(String[] args) {
        TestSerializer testSerializer = new TestSerializer();

        MySingletonWithReadResolve instanceWithReadResolve = MySingletonWithReadResolve.getINSTANCE();
        MySingletonWithReadResolve rebuiltInstanceWithReadResolve =
                (MySingletonWithReadResolve) testSerializer.deserialize(testSerializer.serialize(instanceWithReadResolve));
        System.out.println("1." + (instanceWithReadResolve == rebuiltInstanceWithReadResolve));// 1.true
        System.out.println("2." + (instanceWithReadResolve.equals(rebuiltInstanceWithReadResolve)));// 2.true
    }

    private static final class MySingletonWithReadResolve implements Serializable {
        private static final MySingletonWithReadResolve INSTANCE = new MySingletonWithReadResolve();

        private MySingletonWithReadResolve() {
        }

        public static MySingletonWithReadResolve getINSTANCE() {
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

    private static final class MySingletonWithoutReadResolve implements Serializable {
        private static final MySingletonWithoutReadResolve INSTANCE = new MySingletonWithoutReadResolve();

        private MySingletonWithoutReadResolve() {
        }

        public static MySingletonWithoutReadResolve getINSTANCE() {
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

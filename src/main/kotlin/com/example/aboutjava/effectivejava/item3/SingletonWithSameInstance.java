package com.example.aboutjava.effectivejava.item3;

import java.io.*;

/**
 * 싱글턴 클래스의 객체를 직렬화 후, 역직렬화 했을 때 싱글턴이 사용되는지 여부 확인 예시<p>
 *
 * @see <a href=https://madplay.github.io/post/what-is-readresolve-method-and-writereplace-method>자바 직렬화: readResolve</a>
 */
class SingletonWithSameInstance {

    public static void main(String[] args) {
        TestSerializer testSerializer = new TestSerializer();

        /**
         * {@link Serializable}과 Method "readResolve"를 구현하여 싱글턴을 구현한 예시
         */
        MySingletonWithReadResolve instanceWithReadResolve = MySingletonWithReadResolve.getINSTANCE();
        MySingletonWithReadResolve rebuiltInstanceWithReadResolve =
                (MySingletonWithReadResolve) testSerializer.deserialize(testSerializer.serialize(instanceWithReadResolve));
        System.out.println("1." + (instanceWithReadResolve == rebuiltInstanceWithReadResolve));// 1.true
        System.out.println("2." + (instanceWithReadResolve.equals(rebuiltInstanceWithReadResolve)));// 2.true

        /**
         * {@link Serializable}만 구현되어 싱글턴을 구현하지 못한 예시
         */
        MySingletonWithoutReadResolve instanceWithoutReadResolve = MySingletonWithoutReadResolve.getINSTANCE();
        MySingletonWithoutReadResolve rebuiltInstanceWithoutReadResolve =
                (MySingletonWithoutReadResolve) testSerializer.deserialize(testSerializer.serialize(instanceWithoutReadResolve));
        System.out.println("3." + (instanceWithoutReadResolve == rebuiltInstanceWithoutReadResolve));// 3.false
        System.out.println("4." + (instanceWithoutReadResolve.equals(rebuiltInstanceWithoutReadResolve)));// 3.false
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

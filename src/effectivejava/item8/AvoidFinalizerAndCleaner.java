package effectivejava.item8;

import java.lang.ref.Cleaner;

/**
 * "finalizer와 cleaner 사용을 피하라"<p>
 * <p>
 * Java는 두 가지 객체 소멸자를 제공합니다.<p>
 * 1.Finalizer<p>
 * - 실행을 예측할 수 없고, 상황에 따라 위험할 수 있어서 일반적으로 불필요합니다.<p>
 * - finalizer 스레드는 다른 Application 스레드보다 우선순위가 낮아서 즉각 실행될 기회를 보장하지 않습니다.<p>
 * 2.Cleaner<p>
 * - finalizer보다는 덜 위험하지만, 여전히 예측할 수 없고, 느리고, 일반적으로 불필요합니다.<p>
 * - cleaner는 자신을 수행할 스레드를 제어할 수 있어서 좋지만 여전히 백그라운드에서 수행되고 Garbage Collector의 통제하에 즉각 실행 보장이 없습니다.<p>
 * <p>
 * Java의 finalizer와 cleaner는 C++의 destructor과는 다른 개념입니다.<p>
 * C++의 destructor는 비메모리자원을 회수하는 용도로 쓰입니다.<p>
 * Java는 try-with-resources와 try-finally를 사용해서 해결합니다.<p>
 * <p>
 * finalizer/cleaner의 단점<p>
 * (1) finalizer/cleaner는 GC를 발생하고 나서 실행하는 속도가 심각하게 느린 성능 문제를 가집니다.<p>
 * - finalizer/cleaner는 즉시 수행된다는 보장이 없습니다.<p>
 * - 상태를 영구적으로 수정하는 작업에서는 절대 finalizer/cleaner에 의존해서는 안됩니다. 예시는 "데이터베이스 공유 자원의 영구 Lock 해제"가 있습니다.<p>
 * - {@link AutoCloseable}을 구현한 객체를 try-with-resources를 사용하여 Garbage Collector가 수거하는 시간은 짧다.<p>
 * (2) finalizer를 사용한 클래스는 finalizer 공격에 노출되면 심각한 보안 문제를 일으킵니다.<p>
 * - finalizer의 공격 원리는 생성자나 직렬화 과정에서 예외를 발생시켜서, 객체에서 악의적인 하위 클래스의 finalizer가 수행되게 만듭니다.<p>
 * - 잘못된 객체가 만들어지는 것을 미리 예방하여 예외를 던지는 방법으로 막을 수 있지만, finalizer가 선언되면 호출되기 때문에 문제를 일으킵니다.<p>
 * - final이 아닌 클래스를 finalizer 공격으로부터 방어하려면 아무 구현 내용이 없는 finalize() 메서드를 만들고 final로 선언합니다.<p>
 * <p>
 * finalizer/cleaner의 단점을 해결하는 방법<p>
 * - {@link AutoCloseable}를 구현해주고, 클라이언트에서 인스턴스를 다 쓰고 나면 close 메서드를 호출한다.<p>
 * - 일반적으로 예외가 발생해도 제대로 종료되도록 try-with-resources를 사용해야 한다.<p>
 * - close 메서드는 객체가 더 이상 유효하지 않음을 필드에 기록하고, 다른 메서드는 이 필드를 검사해서 객체가 닫힌 후에 호출되면 {@link IllegalStateException}를 던진다.<p>
 * <p>
 * cleaner & finalizer의 쓰임<p>
 * 1.지원의 소유자가 close 메서드를 호출하지 않는 것을 대비한 안전망 역할<p>
 * - cleaner/finalizer가 즉시 호출되리라는 보장은 없지만, cleaner/finalizer를 사용해서 자원 회수를 늦게라도 해주는게 안하는 것보다 낫다.<p>
 * - 안전망에 대한 필요성을 검증하고 cleaner/finalizer를 사용해야한다.<p>
 * 2.네이티브 피어(native peer)와 연결된 객체에서 안전망 역할<p>
 * - 네이티브 피어란? 일반 자바 객체가 네이티브 메서드를 통해 기능을 위임한 네이티브 객체를 말합니다.<p>
 * - 네이티브 피어가 사용하는 자원을 즉시 회수해야 한다면 cleaner/finalizer의 close()를 사용한다.<p>
 * - <a href="https://www.baeldung.com/jni">native를 구현하는 JNI(Java Native Interface)</a><p>
 * - 우리가 사용하는 자바 라이브러리는 99.9% 이상이 maven central에서 가져옵니다. 사실 우리가 JNI를 쓸 일은 거의 없습니다.<p>
 * <p>
 * 결론)
 * - cleaner(Java 8까지는 finalizer)는 안전망 역할이나 중요하지 않은 네이티브 자원 회수용으로만 사용해야한다.<p>
 * - cleaner(finalizer)를 사용하는 경우에는 자원회수의 불확실성과 성능 저하에 유의해야한다.<p>
 */
class AvoidFinalizerAndCleaner {

    private static class SampleRunner {

        public static void main(String[] args) {
            SampleRunner runner = new SampleRunner();
            runner.run();
//            System.gc();
        }

        private void run() {
            FinalizerExample finalizerExample = new FinalizerExample();
            finalizerExample.hello();
        }
    }

    public static class FinalizerExample {

        /**
         * 객체 사용 이후에 호출될 지 여부를 보장하지 못한다.
         */
        @Override
        protected final void finalize() throws Throwable {
            System.out.println("Clean up");
        }

        public void hello() {
            System.out.println("hello()");
        }
    }
}

package effectivejava.item8;

/**
 * "finalizer와 cleaner 사용을 피하라"<p>
 * <p>
 */
class AvoidFinalizerAndCleaner {

    /**
     * "Finalizer"
     * finalize()는 객체가 JVM에게 GC 대상이 될 때 호출됩니다.
     * 객체가 없어지기 전에 다른 연관 자원을 정리하려는 의도로 생긴 메서드입니다.
     * 하지만 이 메서드는 java9+ 부터 Deprecated 되었습니다.
     * 오류/시점/성능/수행성을 보장하지 못하며 수행되지 않거나 Lock으로 프로그램 전체가 Block될 수 있습니다.
     * java9은 대안으로 Cleaner를 지원하게 되었습니다.
     */
    @Override
    protected void finalize() {
        // 구현 내용
    }
}

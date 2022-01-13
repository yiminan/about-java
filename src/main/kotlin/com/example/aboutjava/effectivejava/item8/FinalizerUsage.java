package com.example.aboutjava.effectivejava.item8;

class FinalizerUsage {
    /**
     * 객체가 gc 대상이 아니면, 객체 사용 이후에 호출될 지 여부를 보장하지 못한다.
     */
    @Override
    protected void finalize() {
        System.out.print("finalize()");
    }

    public void hello() {
        System.out.print("hello()");
    }
}

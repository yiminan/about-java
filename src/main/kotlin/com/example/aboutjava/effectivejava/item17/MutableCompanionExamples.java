package com.example.aboutjava.effectivejava.item17;

import java.math.BigInteger;
import java.util.BitSet;

/**
 * "가변 동반(Mutable Companion) 클래스 예시"<p>
 */
class MutableCompanionExamples {
    public static void main(String[] args) {
        /**
         * 가변 동반 클래스로 생성된 객체를 재활용하는 예시
         */
        BitSet five = BitSet.valueOf(new long[]{1L, 2L});
        five.flip(0);// 가변 클래스 사용
        System.out.println(five);
    }
}

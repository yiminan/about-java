package effectivejava.item17;

import java.math.BigInteger;
import java.util.BitSet;

/**
 * "가변 동반(Mutable Companion) 클래스 예시"<p>
 */
class MutableCompanionExamples {
    public static void main(String[] args) {
        // 불변 객체를 사용하여 내용 변경시 새로 생성하는 불변 객체 로직
        BigInteger moby = BigInteger.valueOf(10L);
        // 새롭게 객체를 만들기 때문에 다른 객체가 생성된다.
        System.out.println(moby == moby.flipBit(0));// false
    }
}

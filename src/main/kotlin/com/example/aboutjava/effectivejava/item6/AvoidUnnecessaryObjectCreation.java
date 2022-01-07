package com.example.aboutjava.effectivejava.item6;

import java.util.regex.Pattern;

/**
 * "불필요한 객체 생성을 피해야합니다"<p>
 * <p>
 * 똑같은 기능의 객체는 매번 새로 생성하기보다는 재사용하는 편이 나을 때가 많습니다.<p>
 * <p>
 * 1. String는 생성자 말고 리터럴 선언이 재사용됩니다.<p>
 * - 다만, Java에서는 리터럴로 새롭게 선언해도 내용이 같으면, String 객체를 재생성하지 않습니다.<p>
 * - 그래서 리터럴로 사용하는 것이 재사용성을 극대화할 수 있습니다.<p>
 * - {@link String}<p>
 * <p>
 * 2. Boolean, Integer, Long과 같은 내부에 미리 정의된 생성 객체를 재사용합니다.<p>
 * - 팩터리 매서드를 만들어서 객체 내부에 미리 생성된 반환 객체를 재사용할 수 있습니다.<p>
 * - 생성자를 사용하면, 객체를 무제한 재생성합니다. 그래서 Boolean의 경우 생성자가 deprecated 되었습니다.<p>
 * - {@link Boolean}<p>
 * <p>
 * 3. 비싼 객체는 재사용한다.<p>
 * - 메서드를 사용하다보면 로컬 변수로 객체 선언되고 매번 GC 대상이 됩니다.<p>
 * - 대체로 클래스 변수로 객체 선언해서 재사용하는 것이 좋습니다.<p>
 * - {@link RomanNumerals}<p>
 * <p>
 * 4. Auto-boxing을 피합니다.<p>
 * - Auto-boxing은 primitive type과 boxing type을 섞어서 연산할 때 자동으로 타입 변환을 해주는 것을 말합니다.<p>
 * - 연산을 할 땐, Boxing 타입을 사용하기보다 primitive 타입을 사용해서 의도치 않은 Auto-boxing을 없애줍니다.<p>
 * <p>
 * 이번 item은 단순히 "객체 생성은 비싸니 피해야 한다"로 오해하면 안됩니다.<p>
 * 요즘 JVM은 GC에 큰 부담을 느끼지 않습니다. 가벼운 객체는 재사용이 없어도 크게 성능상 문제는 없습니다.<p>
 * DB Connection은 워낙 무겁기 때문에 Pool에 만들어 객체를 재사용하는편이 좋습니다.<p>
 * <p>
 * 이번 item은 방어적 복사(defensive copy)와 대조적입니다.<p>
 * 이번 item은 "기존 객체를 재사용해야 한다면 새로운 객체를 만들지마라"이고, 방어적 복사는 "새로운 객체를 만들어야 한다면 기존 객체를 재사용하지 마라"<p>
 * 방어적 복사가 필요한 상황에서 객체를 재사용했을 떄의 피해가, 필요 없는 객체를 반복 생성했을 때의 피해보다 훨씬 큽니다.<p>
 * 방어적 복사에 실패하면 언제 터져 나올지 모르는 버그와 보안 구멍으로 이어지지만, 불필요한 객체 생성은 그저 코드 형태와 성능에만 영향을 줍니다.<p>
 */
class AvoidUnnecessaryObjectCreation {

    private static void exampleBoolean() {
        Boolean b1 = Boolean.valueOf("true");
        Boolean b2 = Boolean.valueOf("true");
        Boolean b3 = new Boolean("false");
        Boolean b4 = new Boolean("false");
        System.out.println(String.format("Boolean 생성자 생성 %b", b1 == b2));
        System.out.println(String.format("Boolean 정적 팩토리 메서드 생성 %b", b3 == b4));
    }

    /**
     * 생성 비용이 비싼 객체를 로컬 변수로 사용하는 경우
     */
    private static boolean isRomanNumeral(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    /**
     * 생성 비용이 비싼 객체를 반복해서 사용하는 경우
     * 클래스 변수로 캐싱하여 재사용합니다.
     */
    private static class RomanNumerals {
        private static final Pattern ROMAN = Pattern.compile(
                "^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$"
        );

        static boolean isRomanNumeral(String s) {
            return ROMAN.matcher(s).matches();
        }
    }

    /**
     * 의도치 않은 Auto-boxing이 진행되는 경우
     */
    private static long sum() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;// Long 타입인 sum에 primitive long 타입이 더해질 때마다 Auto-boxing이 됩니다.
        }
        return sum;
    }
}

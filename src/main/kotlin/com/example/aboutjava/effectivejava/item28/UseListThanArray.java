package com.example.aboutjava.effectivejava.item28;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * "Item 28 - 배열보다는 리스트를 사용해야 합니다"<p>
 * <p>
 * 배열과 제네릭 타입에는 중요한 차이가 있습니다.<p>
 * 배열 - 공변(함께 변한다), 제네릭 - 불공변(함께 변하지 않는다)<p>
 * Sub가 Super의 하위 타입이라면 배열 Sub[]는 배열 Super[]의 하위 타입이 된다.<p>
 * 핵심 정리)<p>
 * 배열과 제네릭에는 매우 다른 타입 규칙이 적용됩니다. 배열은 공변이고 실체화되는 반면, 제네릭은 불공변이고 타입 정보가 소거됩니다.<p>
 * 그 결과 배열은 런타임에는 타입 안전하지만 컴파일타임에는 그렇지 않습니다. 제네릭은 반대입니다.<p>
 * 둘을 섞어 쓰다가 컴파일 오류나 경고를 만나면, 가장 먼저 배열을 리스트로 대체하는 방법을 적용해야합니다.<p>
 */
class UseListThanArray {
    private static class ChooserWithArr {
        private final Object[] choiceArray;

        ChooserWithArr(Collection choice) {
            this.choiceArray = choice.toArray();
        }

        public Object choose() {
            Random rnd = ThreadLocalRandom.current();
            return choiceArray[rnd.nextInt(choiceArray.length)];
        }
    }

    private static class ChooserWithList {

    }
}

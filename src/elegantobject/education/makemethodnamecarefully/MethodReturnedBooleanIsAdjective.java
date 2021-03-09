package elegantobject.education.makemethodnamecarefully;

/**
 * "Boolean 값을 결과로 반환하는 메서드"
 * Boolean을 반환하는 메서드의 경우에는 예외로 둡니다.
 * 값을 반환하기 때문에 빌더에 속하지만, 가독성 측면에서 형용사로 지어야 합니다.
 * 다만, 읽을 때는 앞에 is를 붙여서 자연스러운 문장이 될 수 있도록 합니다.
 * 왜 메서드를 특별하게 취급해야하는가?
 * 논리 구성자(logical construct)로 사용하기 때문입니다.
 * if(name.empty()) {}
 * 와 같은 방식으로 사용되기 때문입니다.
 *
 * 정리)
 * 메서드는 빌더나 조정자, 둘 중 하나여야 합니다.
 * 결코 빌더인 동시에 조정자이면 안됩니다.
 * 다만, boolean 값을 방환하는 빌더는 형용사로 예외로 둡니다.
 */
class MethodReturnedBooleanIsAdjective {

    /**
     * 잘못 사용된 boolean method 예시
     * 자주 사용되고 있지만 잘못 네이밍된 메서드 이름
     */
    private interface WrongBooleanMethod {

        boolean equals(Object obj);

        boolean exists();
    }

    /**
     * 좋은 boolean method 예시
     */
    private interface GoodBooleanMethod {

        /**
         * 잘못된 boolean equals(Object obj); 는 다음과 같이 변환한다. A is equal to obj.
         */
        boolean equalTo(Object obj);

        /**
         * 잘못된 boolean exists(); 는 다음과 같이 변환한다. A is present.
         */
        boolean present();

        boolean empty();

        boolean readable();

        boolean negative();
    }
}

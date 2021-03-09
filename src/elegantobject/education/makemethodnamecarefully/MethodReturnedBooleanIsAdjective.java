package elegantobject.education.makemethodnamecarefully;

class MethodReturnedBooleanIsAdjective {

    /**
     * 잘못 사용된 boolean method 예시
     * 자주 사용되고 있지만 잘못 네이밍된 메서드 이름
     */
    private interface WrongBooleanMethod {

        boolean equals(Object obj);

        boolean exists();
    }

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

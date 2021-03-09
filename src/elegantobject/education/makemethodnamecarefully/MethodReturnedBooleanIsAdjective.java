package elegantobject.education.makemethodnamecarefully;

class MethodReturnedBooleanIsAdjective {

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

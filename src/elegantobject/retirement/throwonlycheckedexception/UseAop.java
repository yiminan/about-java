package elegantobject.retirement.throwonlycheckedexception;

import java.io.IOException;
class UseAop {

    /**
     * 잘사용된 재시도 예시
     * AOP annotation을 사용해서 횡단 관심사인 재시도 코드를 분리
     */
    @RetryOnFailure(attempts = 3)
    public String content2() throws IOException {
        return http();
    }

    /**
     * 잘못된 재시도 예시
     */
    public String content() throws IOException {
        int attempt = 0;
        while(true) {
            try {
                return http();
            } catch (IOException ex) {
                if(attempt >= 2) {
                    throw ex;
                }
            }
        }
    }

    private String http() throws IOException {
        /**
         * http로 요청해서 원하는 내용을 가져와서 반환한다.
         * 원하는 내용이 없으면 예외 발생
         */
        return "";
    }

    /**
     * 단순 AOP Annotation 예시, 실제 AOP로 대체되어야한다.
     */
    private @interface RetryOnFailure {
        int attempts();
    }
}

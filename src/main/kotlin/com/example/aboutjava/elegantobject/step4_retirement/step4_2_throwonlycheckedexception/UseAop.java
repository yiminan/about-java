package com.example.aboutjava.elegantobject.step4_retirement.step4_2_throwonlycheckedexception;

import java.io.IOException;

/**
 * "관점-지향 프로그래밍을 사용하세요"<p>
 * <p>
 * 가끔은 예외가 발생한 코드를 다시 시도해야하는 경우도 있습니다.<p>
 * 코드를 유형별로 분리하면,<p>
 * 1) 핵심 관심사 // 비즈니스 로직<p>
 * 2) 횡단 관심사 // 비즈니스를 돕는 로직<p>
 * 로 나눌 수 있습니다.<p>
 * 횡단 관심사는 트랜잭션 관리처럼 매번 반복되고, 분리가 가능한 부분을 이야기합니다.<p>
 */
class UseAop {

    /**
     * 잘사용된 재시도 예시<p>
     * AOP annotation을 사용해서 횡단 관심사인 재시도 코드를 분리<p>
     */
    @RetryOnFailure(attempts = 3)
    public String content2() throws IOException {
        return http();
    }

    /**
     * 잘못된 재시도 예시<p>
     */
    public String content() throws IOException {
        int attempt = 0;
        while (true) {
            try {
                return http();
            } catch (IOException ex) {
                if (attempt >= 2) {
                    throw ex;
                }
            }
        }
    }

    private String http() throws IOException {
        /**
         * http로 요청해서 원하는 내용을 가져와서 반환한다.<p>
         * 원하는 내용이 없으면 예외 발생<p>
         */
        return "";
    }

    /**
     * 단순 AOP Annotation 예시, 실제 AOP로 대체되어야한다.<p>
     */
    private @interface RetryOnFailure {
        int attempts();
    }
}

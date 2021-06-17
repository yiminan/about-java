package example.time;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;

class LocalDateTimeExample {
    public static void main(String[] args) {
        /**
         * UTC를 기준으로 시간을 표현해줍니다.
         */
        Instant utcPlus9 = new LocalDateTime().instant(ZoneOffset.of("+09:00"));
        /**
         * Summer Time을 고려해서 해당 나라의 시간을 표시해주는 장점이 있습니다.
         * Summer Time과 관계 없는 지역의 시간은 ZoneOffset과 같은 결과를 내어줍니다.
         */
        Instant seoulTime = new LocalDateTime().instant(ZoneId.of("Asia/Seoul"));

        System.out.println(utcPlus9);
        System.out.println(seoulTime);
    }

    private static class LocalDateTime {
        private final java.time.LocalDateTime now = java.time.LocalDateTime.now();

        public Instant instant(ZoneOffset zoneOffset) {
            return now.toInstant(zoneOffset);
        }

        public Instant instant(ZoneId zoneId) {
            return now.atZone(zoneId).toInstant();
        }
    }
}

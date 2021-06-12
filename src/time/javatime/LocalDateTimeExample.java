package time.javatime;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;

class LocalDateTimeExample {
    public static void main(String[] args) {
        Instant utcPlus9 = new LocalDateTime().instant(ZoneOffset.of("+09:00"));
        Instant seoulTime = new LocalDateTime().instant(ZoneId.of("Asia/Seoul"));
        System.out.println(utcPlus9.equals(seoulTime));
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

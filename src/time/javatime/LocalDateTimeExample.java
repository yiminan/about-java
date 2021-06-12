package time.javatime;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;

class LocalDateTimeExample {
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

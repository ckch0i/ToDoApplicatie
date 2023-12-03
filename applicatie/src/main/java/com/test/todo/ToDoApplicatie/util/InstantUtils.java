package com.test.todo.ToDoApplicatie.util;

import io.micrometer.common.util.StringUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public final class InstantUtils {

    private InstantUtils() {
    }

    public static String zetInstantOmNaarString(Instant instant) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZoneId.systemDefault());
        return formatter.format(instant);
    }

    public static Instant zetStringOmNaarinstant(String dateTimeInString) {
        if (StringUtils.isBlank(dateTimeInString)){
            return null;
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());

        // Parse the date-time string to LocalDateTime as it does not have time-zone
        LocalDateTime ldt = LocalDateTime.parse(dateTimeInString, dtf);

        // Convert the LocalDateTime into ZonedDateTime of the given time-zone
        ZonedDateTime zdt = ldt.atZone(ZoneId.of("Europe/Paris"));

        // Convert the ZonedDateTime into Instant
        return zdt.toInstant();
    }

    public static boolean isInstantInHetVerleden(Instant instant){
        if (Objects.isNull(instant)){
            return false;
        }
        return instant.isBefore(Instant.now());
    }
}

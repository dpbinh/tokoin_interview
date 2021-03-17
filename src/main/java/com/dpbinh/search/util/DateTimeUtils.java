package com.dpbinh.search.util;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    public static OffsetDateTime parse(String value) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss XXX");
        try {
            OffsetDateTime offsetDateTime = OffsetDateTime.parse(value, dtf);
            return offsetDateTime;
        } catch (Exception e) {}

        return null;
    }
}

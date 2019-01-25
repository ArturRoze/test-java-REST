package com.app.utils;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class DateConverterUtil {

    public static Timestamp convertStringDateToTimestamp(String incomeDate) {
        Instant instant = DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(incomeDate, Instant::from);
        return Timestamp.from(instant);
    }
}

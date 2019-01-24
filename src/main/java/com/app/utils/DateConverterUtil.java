package com.app.utils;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class DateConverterUtil {

    public static Timestamp convertStringDateToTimestamp(String incomeDate) {
        OffsetDateTime parsedDateTime = OffsetDateTime.parse(incomeDate, DateTimeFormatter.ISO_ZONED_DATE_TIME);
        return Timestamp.from(parsedDateTime.toInstant());
    }
}

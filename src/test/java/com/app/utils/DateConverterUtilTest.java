package com.app.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DateConverterUtilTest {

    @Test
    public void convertStringDateToTimestamp() {

        //arrange
        String stringDate = "2018-09-19T13:12:21.136263+03:00";

        //action
        Instant instant = DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(stringDate, Instant::from);
        Timestamp timestamp = DateConverterUtil.convertStringDateToTimestamp(stringDate);

        //assert
        assertEquals("2018-09-19T10:12:21.136263Z", instant.toString());
        assertEquals(instant, timestamp.toInstant());
    }
}
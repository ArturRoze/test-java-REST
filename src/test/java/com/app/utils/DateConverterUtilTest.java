package com.app.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DateConverterUtilTest {

    @Test
    public void convertStringDateToTimestamp() {

        //arrange
        String stringDate = "2018-09-19T13:12:21.136263+03:00";

        //action
        Timestamp timestamp = DateConverterUtil.convertStringDateToTimestamp(stringDate);

        //assert
        assertEquals(timestamp.toString(), stringDate);
    }
}
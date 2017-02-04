/*
 * Copyright 2017 Peer to Park.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.peertopark.java.dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hector
 */
public class DatesTest {

    public DatesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of now method, of class Dates.
     */
    @Test
    public void testNow() {
        Date result = Dates.now();
        assertNotNull(result);
    }

    @Test
    public void testConvert() {
        Date date = Dates.now();
        assertNotNull(date);
        DateTime dateTime = Dates.convert(date);
        assertNotNull(dateTime);
        assertEquals(date, dateTime.toDate());
    }

    /**
     * Test of getSecondsFromMillis method, of class Dates.
     */
    @Test
    public void testGetSecondsFromMillis() {
        long millis = 1000;
        long seconds = Dates.getSecondsFromMillis(millis);
        long expected = 1;
        assertEquals(expected, seconds);
        millis = 60000;
        seconds = Dates.getSecondsFromMillis(millis);
        expected = 60;
        assertEquals(expected, seconds);
    }

    @Test
    public void testFromStringWithFormat() throws ParseException {
        Date date = Dates.fromStringWithFormat("yyyy-MM-dd", "2016-02-08");
        assertNotNull(date);
    }

    @Test
    public void testBeforeOrEquals() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");

        Date fromDate = dateFormat.parse("05-01-2016 00:00");
        Date untilDate = dateFormat.parse("03-01-2016 00:00");
        assertFalse(Dates.beforeOrEquals(untilDate, fromDate));

        fromDate = dateFormat.parse("04-01-2016 00:00");
        untilDate = dateFormat.parse("07-02-2016 00:00");
        assertTrue(Dates.beforeOrEquals(untilDate, fromDate));

        fromDate = dateFormat.parse("05-01-2016 00:00");
        untilDate = dateFormat.parse("05-01-2016 00:00");
        assertTrue(Dates.beforeOrEquals(untilDate, fromDate));
    }

    @Test
    public void testBefore() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");

        Date fromDate = dateFormat.parse("05-01-2016 00:00");
        Date untilDate = dateFormat.parse("03-01-2016 00:00");
        assertFalse(Dates.before(untilDate, fromDate));

        fromDate = dateFormat.parse("04-01-2016 00:00");
        untilDate = dateFormat.parse("07-02-2016 00:00");
        assertTrue(Dates.before(untilDate, fromDate));

        fromDate = dateFormat.parse("05-01-2016 00:00");
        untilDate = dateFormat.parse("05-01-2016 00:00");
        assertFalse(Dates.before(untilDate, fromDate));
    }

    @Test
    public void testAfterOrEquals() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");

        Date fromDate = dateFormat.parse("05-01-2016 00:00");
        Date untilDate = dateFormat.parse("03-01-2016 00:00");
        assertTrue(Dates.afterOrEquals(untilDate, fromDate));

        fromDate = dateFormat.parse("04-01-2016 00:00");
        untilDate = dateFormat.parse("07-02-2016 00:00");
        assertFalse(Dates.afterOrEquals(untilDate, fromDate));

        fromDate = dateFormat.parse("05-01-2016 00:00");
        untilDate = dateFormat.parse("05-01-2016 00:00");
        assertTrue(Dates.afterOrEquals(untilDate, fromDate));

        DateTimeFormatter dateTimeFormat = DateTimeFormat.forPattern("dd-MM-yyyy HH:mm");

        DateTime fromDateTime = dateTimeFormat.parseDateTime("05-01-2016 00:00");
        DateTime untilDateTime = dateTimeFormat.parseDateTime("03-01-2016 00:00");
        assertTrue(Dates.afterOrEquals(untilDateTime, fromDateTime));

        fromDateTime = dateTimeFormat.parseDateTime("04-01-2016 00:00");
        untilDateTime = dateTimeFormat.parseDateTime("07-02-2016 00:00");
        assertFalse(Dates.afterOrEquals(untilDateTime, fromDateTime));

        fromDateTime = dateTimeFormat.parseDateTime("05-01-2016 00:00");
        untilDateTime = dateTimeFormat.parseDateTime("05-01-2016 00:00");
        assertTrue(Dates.afterOrEquals(untilDateTime, fromDateTime));
    }

    @Test
    public void testAfter() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");

        Date fromDate = dateFormat.parse("05-01-2016 00:00");
        Date untilDate = dateFormat.parse("03-01-2016 00:00");
        assertTrue(Dates.after(untilDate, fromDate));

        fromDate = dateFormat.parse("04-01-2016 00:00");
        untilDate = dateFormat.parse("07-02-2016 00:00");
        assertFalse(Dates.after(untilDate, fromDate));

        fromDate = dateFormat.parse("05-01-2016 00:00");
        untilDate = dateFormat.parse("05-01-2016 00:00");
        assertFalse(Dates.after(untilDate, fromDate));

        DateTimeFormatter dateTimeFormat = DateTimeFormat.forPattern("dd-MM-yyyy HH:mm");
        DateTime fromDateTime = dateTimeFormat.parseDateTime("05-01-2016 00:00");
        DateTime untilDateTime = dateTimeFormat.parseDateTime("03-01-2016 00:00");
        assertTrue(Dates.after(untilDateTime, fromDateTime));

        fromDateTime = dateTimeFormat.parseDateTime("04-01-2016 00:00");
        untilDateTime = dateTimeFormat.parseDateTime("07-02-2016 00:00");
        assertFalse(Dates.after(untilDateTime, fromDateTime));

        fromDateTime = dateTimeFormat.parseDateTime("05-01-2016 00:00");
        untilDateTime = dateTimeFormat.parseDateTime("05-01-2016 00:00");
        assertFalse(Dates.after(untilDateTime, fromDateTime));
    }

    @Test
    public void testCheckTwoDatesIfNotNull() {
        Date date = null;
        Date otherDate = null;
        assertFalse(Dates.checkTwoDatesIfNotNull(date, otherDate));
        date = Dates.now();
        assertFalse(Dates.checkTwoDatesIfNotNull(date, otherDate));
        otherDate = Dates.now();
        assertTrue(Dates.checkTwoDatesIfNotNull(date, otherDate));
    }

    @Test
    public void testAllNotNull() {
        Date oneDate = Dates.now();
        Date date = null;
        Date otherDate = null;
        assertFalse(Dates.allNotNull(oneDate, date, otherDate));
        date = Dates.now();
        assertFalse(Dates.allNotNull(oneDate, date, otherDate));
        otherDate = Dates.now();
        assertTrue(Dates.allNotNull(oneDate, date, otherDate));
    }

    @Test
    public void testAnyNull() {
        Date oneDate = null;
        Date date = null;
        Date otherDate = null;
        assertTrue(Dates.anyNull(oneDate, date, otherDate));

        oneDate = Dates.now();
        date = Dates.now();
        assertTrue(Dates.anyNull(oneDate, date, otherDate));

        otherDate = Dates.now();
        assertFalse(Dates.anyNull(oneDate, date, otherDate));
    }
    
    
    @Test
    public void testGetInterval() {
        DateTime fromDateTime = DateTime.now();
        DateTime untilDateTime = DateTime.now();
        Interval interval = Dates.getInterval(fromDateTime, untilDateTime);
        assertNotNull(interval);
        
        Date fromDate = Dates.now();
        Date untilDate = Dates.now();
        interval = Dates.getInterval(fromDate, untilDate);
        assertNotNull(interval);
    }
    
    
    @Test
    public void testGetDateInterval() throws ParseException {  
        Date now = Dates.now();      
        long fromDateLong = now.getTime();
        long untilDateLong = fromDateLong + Dates.DAYS_IN_MONTH;     
        long result = Dates.getDateInterval(fromDateLong, untilDateLong);
        assertEquals(Dates.DAYS_IN_MONTH, result);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date fromDate = dateFormat.parse("01-01-2016 00:00");
        Date untilDate = dateFormat.parse("01-01-2016 00:05");
        result = Dates.getDateInterval(fromDate, untilDate);
        assertEquals(Dates.FIVE_MIN_IN_MILLIS, result);
    }
    
    @Test
    public void testGetSecondsInDateInterval() throws ParseException {  
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date fromDate = dateFormat.parse("01-01-2016 00:00");
        Date untilDate = dateFormat.parse("01-01-2016 00:30");
        long result = Dates.getSecondsInDateInterval(fromDate, untilDate);
        assertEquals(Dates.THIRTY_MIN_IN_SECONDS, result);
    }

}

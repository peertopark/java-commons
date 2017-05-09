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

import com.peertopark.java.commons.utilities.Numbers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.DateTimeZone;
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


    @BeforeClass
    public static void setUpClass() {
        DateTimeZone.setDefault(DateTimeZone.UTC);
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
        assertFalse(Dates.notAfterOrEquals(untilDate, fromDate));

        fromDate = dateFormat.parse("04-01-2016 00:00");
        untilDate = dateFormat.parse("07-02-2016 00:00");
        assertFalse(Dates.afterOrEquals(untilDate, fromDate));
        assertTrue(Dates.notAfterOrEquals(untilDate, fromDate));

        fromDate = dateFormat.parse("05-01-2016 00:00");
        untilDate = dateFormat.parse("05-01-2016 00:00");
        assertTrue(Dates.afterOrEquals(untilDate, fromDate));
        assertFalse(Dates.notAfterOrEquals(untilDate, fromDate));

        DateTimeFormatter dateTimeFormat = DateTimeFormat.forPattern("dd-MM-yyyy HH:mm");

        DateTime fromDateTime = dateTimeFormat.parseDateTime("05-01-2016 00:00");
        DateTime untilDateTime = dateTimeFormat.parseDateTime("03-01-2016 00:00");
        assertTrue(Dates.afterOrEquals(untilDateTime, fromDateTime));
        assertFalse(Dates.notAfterOrEquals(untilDateTime, fromDateTime));

        fromDateTime = dateTimeFormat.parseDateTime("04-01-2016 00:00");
        untilDateTime = dateTimeFormat.parseDateTime("07-02-2016 00:00");
        assertFalse(Dates.afterOrEquals(untilDateTime, fromDateTime));
        assertTrue(Dates.notAfterOrEquals(untilDateTime, fromDateTime));

        fromDateTime = dateTimeFormat.parseDateTime("05-01-2016 00:00");
        untilDateTime = dateTimeFormat.parseDateTime("05-01-2016 00:00");
        assertTrue(Dates.afterOrEquals(untilDateTime, fromDateTime));
        assertFalse(Dates.notAfterOrEquals(untilDateTime, fromDateTime));
    }

    @Test
    public void testAfter() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");

        Date fromDate = dateFormat.parse("05-01-2016 00:00");
        Date untilDate = dateFormat.parse("03-01-2016 00:00");
        assertTrue(Dates.after(untilDate, fromDate));
        assertFalse(Dates.notAfter(untilDate, fromDate));

        fromDate = dateFormat.parse("04-01-2016 00:00");
        untilDate = dateFormat.parse("07-02-2016 00:00");
        assertFalse(Dates.after(untilDate, fromDate));
        assertTrue(Dates.notAfter(untilDate, fromDate));

        fromDate = dateFormat.parse("05-01-2016 00:00");
        untilDate = dateFormat.parse("05-01-2016 00:00");
        assertFalse(Dates.after(untilDate, fromDate));
        assertTrue(Dates.notAfter(untilDate, fromDate));

        DateTimeFormatter dateTimeFormat = DateTimeFormat.forPattern("dd-MM-yyyy HH:mm");
        DateTime fromDateTime = dateTimeFormat.parseDateTime("05-01-2016 00:00");
        DateTime untilDateTime = dateTimeFormat.parseDateTime("03-01-2016 00:00");
        assertTrue(Dates.after(untilDateTime, fromDateTime));
        assertFalse(Dates.notAfter(untilDateTime, fromDateTime));

        fromDateTime = dateTimeFormat.parseDateTime("04-01-2016 00:00");
        untilDateTime = dateTimeFormat.parseDateTime("07-02-2016 00:00");
        assertFalse(Dates.after(untilDateTime, fromDateTime));
        assertTrue(Dates.notAfter(untilDateTime, fromDateTime));

        fromDateTime = dateTimeFormat.parseDateTime("05-01-2016 00:00");
        untilDateTime = dateTimeFormat.parseDateTime("05-01-2016 00:00");
        assertFalse(Dates.after(untilDateTime, fromDateTime));
        assertTrue(Dates.notAfter(untilDateTime, fromDateTime));
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

        result = Dates.getDateInterval(untilDate, fromDate);
        assertEquals(-Dates.FIVE_MIN_IN_MILLIS, result);
    }

    @Test
    public void testGetSecondsInDateInterval() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date fromDate = dateFormat.parse("01-01-2016 00:00");
        Date untilDate = dateFormat.parse("01-01-2016 00:30");
        long result = Dates.getSecondsInDateInterval(fromDate, untilDate);
        assertEquals(Dates.THIRTY_MIN_IN_SECONDS, result);
    }

    @Test
    public void testAddSeconds() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
        Date date = dateFormat.parse("00:00");
        Date expectedDate = dateFormat.parse("01:00");
        int seconds = 60;
        Date addedDate = Dates.addSeconds(date, seconds);
        assertNotNull(addedDate);
        assertEquals(expectedDate, addedDate);

        seconds = 0;
        addedDate = Dates.addSeconds(date, seconds);
        assertNotNull(addedDate);
        assertEquals(date, addedDate);
    }

    @Test
    public void testAddSecondsLong() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
        Date date = dateFormat.parse("00:00");
        Date expectedDate = dateFormat.parse("01:00");

        long seconds = 60;
        Date addedDate = Dates.addSeconds(date, seconds);
        assertNotNull(addedDate);
        assertEquals(expectedDate, addedDate);

        seconds = 0;
        addedDate = Dates.addSeconds(date, seconds);
        assertNotNull(addedDate);
        assertEquals(date, addedDate);
    }

    @Test
    public void testRoundToMinutes() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = dateFormat.parse("00:00:35");
        Date expectedDate = dateFormat.parse("00:01:00");
        Date resultDate = Dates.roundToMinutes(date);
        assertEquals(expectedDate, resultDate);

        date = dateFormat.parse("00:00:25");
        expectedDate = dateFormat.parse("00:00:00");
        resultDate = Dates.roundToMinutes(date);
        assertEquals(expectedDate, resultDate);
    }

    @Test
    public void testGetSecondsInHalfInterval() throws ParseException {
        Date fromDate = Dates.now();
        long secondsResult = 300;
        Date untilDate = Dates.addSeconds(fromDate, 600);
        long secondsInterval = Dates.getSecondsInHalfInterval(fromDate, untilDate);
        assertEquals(secondsResult, secondsInterval);

        fromDate = Dates.now();
        untilDate = Dates.addSeconds(fromDate, 3600);
        secondsInterval = Dates.getSecondsInHalfInterval(fromDate, untilDate);
        secondsResult = 1800;
        assertEquals(secondsResult, secondsInterval);
    }

    @Test
    public void testAddDays() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date date = dateFormat.parse("05-01-2016 00:00");
        Date expectedDate = dateFormat.parse("06-01-2016 00:00");
        int days = 1;
        Date addedDate = Dates.addDays(date, days);
        assertNotNull(addedDate);
        assertEquals(expectedDate, addedDate);

        days = 0;
        addedDate = Dates.addSeconds(date, days);
        assertNotNull(addedDate);
        assertEquals(date, addedDate);
    }

    @Test
    public void testRemoveDays() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date date = dateFormat.parse("06-01-2016 00:00");
        Date expectedDate = dateFormat.parse("05-01-2016 00:00");
        int days = 1;
        Date addedDate = Dates.removeDays(date, days);
        assertNotNull(addedDate);
        assertEquals(expectedDate, addedDate);

        days = 0;
        addedDate = Dates.addSeconds(date, days);
        assertNotNull(addedDate);
        assertEquals(date, addedDate);
    }

    @Test
    public void testGetMonthsFromSeconds() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm");
        Date fromDate = dateFormat.parse("01-01-2016 00:00");
        Date untilDate = dateFormat.parse("08-01-2016 00:00");
        long secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        long months = Dates.getMonthsFromSeconds(secondsInterval);
        long expected = 0;
        assertEquals(expected, months);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("31-01-2016 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        months = Dates.getMonthsFromSeconds(secondsInterval);
        expected = 1;
        assertEquals(expected, months);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("01-03-2016 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        months = Dates.getMonthsFromSeconds(secondsInterval);
        expected = 2;
        assertEquals(expected, months);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("01-04-2016 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        months = Dates.getMonthsFromSeconds(secondsInterval);
        expected = 3;
        assertEquals(expected, months);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("01-08-2016 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        months = Dates.getMonthsFromSeconds(secondsInterval);
        expected = 7;
        assertEquals(expected, months);
    }

    @Test
    public void testRemoveMonthsFromSeconds() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm");
        Date fromDate = dateFormat.parse("01-01-2016 00:00");
        Date untilDate = dateFormat.parse("31-01-2016 00:00");
        long secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        long months = Dates.getMonthsFromSeconds(secondsInterval);
        long expected = 1;
        assertEquals(expected, months);
        long removedSeconds = Dates.removeMonthsFromSeconds(secondsInterval, months);
        expected = 0;
        assertEquals(expected, removedSeconds);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("31-01-2016 00:01");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        months = Dates.getMonthsFromSeconds(secondsInterval);
        expected = 1;
        assertEquals(expected, months);
        removedSeconds = Dates.removeMonthsFromSeconds(secondsInterval, months);
        expected = 60;
        assertEquals(expected, removedSeconds);
    }

    @Test
    public void testGetSecondsFromMonths() {
        int months = 1;
        long seconds = Dates.getSecondsFromMonths(months);
        long expected = Dates.SECONDS_IN_MONTH;
        assertEquals(expected, seconds);
        months = 2;
        seconds = Dates.getSecondsFromMonths(months);
        expected = 5184000;
        assertEquals(expected, seconds);
        months = 3;
        seconds = Dates.getSecondsFromMonths(months);
        expected = 7776000;
        assertEquals(expected, seconds);
    }

    @Test
    public void testRemoveWeeksFromSeconds() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm");
        Date fromDate = dateFormat.parse("01-01-2016 00:00");
        Date untilDate = dateFormat.parse("08-01-2016 00:00");
        long secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        long weeks = Dates.getWeeksFromSeconds(secondsInterval);
        long expected = 1;
        assertEquals(expected, weeks);
        long removedSeconds = Dates.removeWeeksFromSeconds(secondsInterval, weeks);
        expected = 0;
        assertEquals(expected, removedSeconds);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("15-01-2016 00:01");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        weeks = Dates.getWeeksFromSeconds(secondsInterval);
        expected = 2;
        assertEquals(expected, weeks);
        removedSeconds = Dates.removeWeeksFromSeconds(secondsInterval, weeks);
        expected = 60;
        assertEquals(expected, removedSeconds);
    }

    @Test
    public void testGetDaysFromSeconds() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm");
        Date fromDate = dateFormat.parse("01-01-2016 00:00");
        Date untilDate = dateFormat.parse("03-01-2016 00:00");
        long secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        long daysInterval = Dates.getDaysFromSeconds(secondsInterval);
        long daysResult = 2;
        assertEquals(daysResult, daysInterval);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("31-01-2016 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        daysInterval = Dates.getDaysFromSeconds(secondsInterval);
        daysResult = 30;
        assertEquals(daysResult, daysInterval);
        fromDate = dateFormat.parse("01-02-2015 00:00");
        untilDate = dateFormat.parse("01-03-2015 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        daysInterval = Dates.getDaysFromSeconds(secondsInterval);
        daysResult = 28;
        assertEquals(daysResult, daysInterval);
        fromDate = dateFormat.parse("01-02-2016 00:00");
        untilDate = dateFormat.parse("01-03-2016 00:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        daysInterval = Dates.getDaysFromSeconds(secondsInterval);
        daysResult = 29;
        assertEquals(daysResult, daysInterval);
    }

    @Test
    public void testGetSecondsFromDays() {
        long days = 1;
        long seconds = Dates.getSecondsFromDays(days);
        long expected = Dates.SECONDS_IN_DAY;
        assertEquals(expected, seconds);
        days = 14;
        seconds = Dates.getSecondsFromDays(days);
        expected = 1209600;
        assertEquals(expected, seconds);
        days = 30;
        seconds = Dates.getSecondsFromDays(days);
        expected = 2592000;
        assertEquals(expected, seconds);
    }

    @Test
    public void testRemoveDaysFromSeconds() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm");
        Date fromDate = dateFormat.parse("01-01-2016 00:00");
        Date untilDate = dateFormat.parse("02-01-2016 00:00");
        long secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        long days = Dates.getDaysFromSeconds(secondsInterval);
        long expected = 1;
        assertEquals(expected, days);
        long removedSeconds = Dates.removeDaysFromSeconds(secondsInterval, days);
        expected = 0;
        assertEquals(expected, removedSeconds);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("05-01-2016 00:01");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        days = Dates.getDaysFromSeconds(secondsInterval);
        expected = 4;
        assertEquals(expected, days);
        removedSeconds = Dates.removeDaysFromSeconds(secondsInterval, days);
        expected = 60;
        assertEquals(expected, removedSeconds);
    }

    @Test
    public void testGetSecondsFromHours() {
        long hours = 1;
        long expected = 3600;
        long result = Dates.getSecondsFromHours(hours);
        assertEquals(expected, result);

        hours = 2;
        expected = 7200;
        result = Dates.getSecondsFromHours(hours);
        assertEquals(expected, result);

        hours = 5;
        expected = 18000;
        result = Dates.getSecondsFromHours(hours);
        assertEquals(expected, result);
    }

    @Test
    public void testGetMinutesFromSeconds() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm");
        Date fromDate = dateFormat.parse("01-01-2016 00:00");
        Date untilDate = dateFormat.parse("01-01-2016 00:01");
        long secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        long minutes = Dates.getMinutesFromSeconds(secondsInterval);
        long expected = 1;
        assertEquals(expected, minutes);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("01-01-2016 00:10");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        minutes = Dates.getMinutesFromSeconds(secondsInterval);
        expected = 10;
        assertEquals(expected, minutes);
        fromDate = dateFormat.parse("01-01-2016 00:00");
        untilDate = dateFormat.parse("01-01-2016 02:00");
        secondsInterval = Dates.getSecondsInDateInterval(fromDate, untilDate);
        minutes = Dates.getMinutesFromSeconds(secondsInterval);
        expected = 120;
        assertEquals(expected, minutes);
    }

    @Test
    public void testGetHoursFromSeconds() {
        long seconds = 3600;
        long expected = 1;
        long result = Dates.getHoursFromSeconds(seconds);
        assertEquals(expected, result);

        seconds = 7200;
        expected = 2;
        result = Dates.getHoursFromSeconds(seconds);
        assertEquals(expected, result);

        seconds = 18000;
        expected = 5;
        result = Dates.getHoursFromSeconds(seconds);
        assertEquals(expected, result);
    }

    @Test
    public void testGetMonthsFromDays() {
        long days = 30;
        long expected = 1;
        long result = Dates.getMonthsFromDays(days);
        assertEquals(expected, result);

        days = 60;
        expected = 2;
        result = Dates.getMonthsFromDays(days);
        assertEquals(expected, result);

        days = 35;
        expected = 1;
        result = Dates.getMonthsFromDays(days);
        assertEquals(expected, result);
    }

    @Test
    public void testGetDaysFromMonths() {
        long months = 1;
        long expected = 30;
        long result = Dates.getDaysFromMonths(months);
        assertEquals(expected, result);

        months = 2;
        expected = 60;
        result = Dates.getDaysFromMonths(months);
        assertEquals(expected, result);
    }

    @Test
    public void testRemoveMonthsFromDays() {
        long months = 1;
        long days = 31;
        long expected = 1;
        long result = Dates.removeMonthsFromDays(days, months);
        assertEquals(expected, result);

        months = 2;
        days = 62;
        expected = 2;
        result = Dates.removeMonthsFromDays(days, months);
        assertEquals(expected, result);
    }

    @Test
    public void testFrom() {
        Long fromLong = Dates.now().getTime();
        Date date = Dates.from(fromLong);
        assertNotNull(date);
        
        String dateLongString = Dates.toLongString(date);
        Date resultDate = Dates.from(dateLongString);
        assertNotNull(resultDate);
        assertEquals(date, resultDate);
    }

    @Test
    public void testCheckIfDatesIntervalCollisionBetweenAnotherInterval() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        Date firstDateInIntervalToCompare = dateFormat.parse("05-01-2016 00:00:00");
        Date secondDateInIntervalToCompare = dateFormat.parse("10-01-2016 00:00:00");

        assertFalse(Dates.datesIntervalsOverlaps(null, null, null, null));
        assertFalse(Dates.datesIntervalsOverlaps(null, null, firstDateInIntervalToCompare, secondDateInIntervalToCompare));

        Date firstDateInInterval = dateFormat.parse("01-01-2016 00:00:00");
        Date secondDateInInterval = dateFormat.parse("04-01-2016 00:00:00");
        assertFalse(Dates.datesIntervalsOverlaps(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));

        firstDateInInterval = dateFormat.parse("11-01-2016 00:00:00");
        secondDateInInterval = dateFormat.parse("14-01-2016 00:00:00");
        assertFalse(Dates.datesIntervalsOverlaps(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));

        firstDateInInterval = dateFormat.parse("01-01-2016 00:00:00");
        secondDateInInterval = dateFormat.parse("05-01-2016 00:00:00");
        assertFalse(Dates.datesIntervalsOverlaps(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));

        firstDateInInterval = dateFormat.parse("10-01-2016 00:00:00");
        secondDateInInterval = dateFormat.parse("14-01-2016 00:00:00");
        assertFalse(Dates.datesIntervalsOverlaps(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));

        firstDateInInterval = dateFormat.parse("01-01-2016 00:00:00");
        secondDateInInterval = dateFormat.parse("08-01-2016 00:00:00");
        assertTrue(Dates.datesIntervalsOverlaps(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));

        firstDateInInterval = dateFormat.parse("08-01-2016 00:00:00");
        secondDateInInterval = dateFormat.parse("14-01-2016 00:00:00");
        assertTrue(Dates.datesIntervalsOverlaps(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));

        firstDateInInterval = dateFormat.parse("06-01-2016 00:00:00");
        secondDateInInterval = dateFormat.parse("09-01-2016 00:00:00");
        assertTrue(Dates.datesIntervalsOverlaps(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));

        firstDateInInterval = dateFormat.parse("05-01-2016 00:00:00");
        secondDateInInterval = dateFormat.parse("10-01-2016 00:00:00");
        assertTrue(Dates.datesIntervalsOverlaps(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));

        firstDateInInterval = dateFormat.parse("01-01-2016 00:00:00");
        secondDateInInterval = dateFormat.parse("14-01-2016 00:00:00");
        assertTrue(Dates.datesIntervalsOverlaps(firstDateInInterval, secondDateInInterval, firstDateInIntervalToCompare, secondDateInIntervalToCompare));
    }
    
    
    @Test
    public void testToLongMillis() {
        Date date = Dates.now();
        assertNotNull(date);
        long dateLong = Dates.toLongMillis(date);
        assertNotNull(dateLong);
        assertEquals(date.getTime(), dateLong);
    }
    
    @Test
    public void testToLongSeconds() {
        Date date = Dates.now();
        assertNotNull(date);
        long dateLong = Dates.toLongSeconds(date);
        assertNotNull(dateLong);
        assertEquals(Dates.getSecondsFromMillis(date.getTime()), dateLong);
    }
    
    
    @Test
    public void daysOfWeekInDateIntervalTest() {    
        DateTime startDate = Dates.build(2017, 1, 1);   
        DateTime endDate = Dates.build(2017, 1, 15);    
        List<DateTime> resultList = Dates.daysOfWeekInDateInterval(startDate, endDate, DateTimeConstants.FRIDAY);
        assertNotNull(resultList);
        assertEquals(Numbers.TWO, resultList.size());
    }
    
    
    @Test
    public void buildTest() {  
        DateTime expected = new DateTime(2017, 1, 18, 12, 30);
        DateTime result = Dates.build(2017, 1, 18, 12, 30);
        assertEquals(expected, result);
    }
    
    
    @Test
    public void buildDateTest() {  
        DateTime expected = new DateTime(2017, 1, 18, 12, 30);      
        Date result = Dates.buildDate(2017, 1, 18, 12, 30);
        assertEquals(expected.toDate(), result);
    }

}

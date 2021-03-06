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
import com.peertopark.java.commons.utilities.Objects;
import com.peertopark.java.dates.iterators.DayOfWeekIterator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;

/**
 *
 * @author hector
 */
public class Dates {

    public static final int SECONDS_IN_MONTH = 2592000;
    public static final int SECONDS_IN_WEEK = 604800;
    public static final int SECONDS_IN_DAY = 86400;
    public static final int SECONDS_IN_TWO_DAY = 172800;

    public static final int MINUTES_IN_HOUR = 60;
    public static final int SECONDS_IN_HOUR = 3600;

    public static final int SECONDS_IN_THREE_HOURS = 10800;

    public static final int DAYS_IN_MONTH = 30;

    public static final int FIVE_MIN_IN_MILLIS = 300000;
    public static final int THIRTY_MIN_IN_MILLIS = 1800000;
    public static final int THIRTY_MIN_IN_SECONDS = 1800;

    public static final int THIRTY_DAYS_IN_SECONDS = 2592000;

    /**
     * New Date
     *
     * @return {@link Date}
     */
    public static Date now() {
        return new Date();
    }
    
    
    /**
     * Constructs an instance from datetime field values using ISOChronology in the default time zone.
     * @param year
     * @param monthOfYear
     * @param dayOfMonth
     * @return {@link DateTime} 
     */
    public static DateTime build(int year, int monthOfYear, int dayOfMonth) {
        return new DateTime(year, monthOfYear, dayOfMonth, Numbers.ZERO, Numbers.ZERO);
    }
    
    /**
     * Constructs an instance from datetime field values using ISOChronology in the default time zone.
     * @param year
     * @param monthOfYear
     * @param dayOfMonth
     * @param hourOfDay
     * @param minuteOfHour
     * @return {@link DateTime} 
     */
    public static DateTime build(int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minuteOfHour) {
        return new DateTime(year, monthOfYear, dayOfMonth, hourOfDay, minuteOfHour);
    }
    
    
    /**
     * Constructs an instance from datetime field values using ISOChronology in the default time zone.
     * @param year
     * @param monthOfYear
     * @param dayOfMonth
     * @param hourOfDay
     * @param minuteOfHour
     * @return {@link Date} 
     */
    public static Date buildDate(int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minuteOfHour) {
        return from(build(year, monthOfYear, dayOfMonth, hourOfDay, minuteOfHour));
    }
    
    /**
     * Constructs an instance from datetime field values using ISOChronology in the default time zone.
     * @param year
     * @param monthOfYear
     * @param dayOfMonth
     * @return {@link Date} 
     */
    public static Date buildDate(int year, int monthOfYear, int dayOfMonth) {
        return buildDate(year, monthOfYear, dayOfMonth, Numbers.ZERO, Numbers.ZERO);
    }
    

    public static DateTime convert(Date date) {
        if (Objects.isNull(date)) {
            return null;
        } else {
            return new DateTime(date);
        }
    }

    public static DateTime convert(long time) {
        return new DateTime(time);
    }

    /**
     * Get seconds from milliseconds
     *
     * @param milliseconds Milliseconds value
     * @return long Seconds
     */
    public static long getSecondsFromMillis(long milliseconds) {
        return Duration.millis(milliseconds).getStandardSeconds();
    }

    /**
     * Transforma un Date en un String con el valor Long del Date.
     *
     * @param date Date
     * @return String
     */
    public static String toLongString(Date date) {
        if (Objects.isNull(date)) {
            return null;
        } else {
            return String.valueOf(date.getTime());
        }
    }
    
    public static Long toLongMillis(Date date) {
        if (Objects.isNull(date)) {
            return null;
        } else {
            return date.getTime();
        }
    }
    
    public static Long toLongSeconds(Date date) {
        if (Objects.isNull(date)) {
            return null;
        } else {
            return getSecondsFromMillis(date.getTime());
        }
    }

    public static Date fromStringWithFormat(String format, String stringFecha) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.parse(stringFecha);
    }

    public static Date fromStringWithFormat(String format, String stringFecha, TimeZone timeZone) throws ParseException {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat(format);
        formatoDelTexto.setTimeZone(timeZone);
        return formatoDelTexto.parse(stringFecha);
    }

    public static String toStringWithFormat(String format, Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    public static String toStringWithFormat(String format, Date date, TimeZone timeZone) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        formatter.setTimeZone(timeZone);
        return formatter.format(date);
    }

    /**
     * All dates not null
     *
     * @param dates
     * @return True if all dates not null
     */
    public static boolean allNotNull(Date... dates) {
        return ObjectUtils.allNotNull((Object[]) dates);
    }

    /**
     * All dates not null
     *
     * @param dates
     * @return True if all dates not null
     */
    public static boolean allNotNull(DateTime... dates) {
        return ObjectUtils.allNotNull((Object[]) dates);
    }

    public static boolean anyNull(Date... dates) {
        return !allNotNull(dates);
    }

    public static boolean anyNull(DateTime... dates) {
        return !allNotNull(dates);
    }

    public static boolean checkTwoDatesIfNotNull(Date fromDate, Date untilDate) {
        return allNotNull(fromDate, untilDate);
    }

    public static boolean afterOrEquals(Date dateToCompare, Date date) {
        return afterOrEquals(convert(dateToCompare), convert(date));
    }

    public static boolean afterOrEquals(DateTime dateToCompare, DateTime date) {
        if (allNotNull(dateToCompare, date)) {
            return date.isAfter(dateToCompare) || date.isEqual(dateToCompare);
        } else {
            return false;
        }
    }
    
    /**
     * Date is not after date
     * @param dateToCompare {@link Date} Date to compare
     * @param date {@link Date} Date
     * @return True if date is not after date 
     */
    public static boolean notAfterOrEquals(Date dateToCompare, Date date) {
        return !afterOrEquals(dateToCompare, date);
    }
    
    /**
     * Date is not after date
     * @param dateToCompare {@link DateTime} Date to compare
     * @param date {@link DateTime} Date
     * @return True if date is not after date 
     */
    public static boolean notAfterOrEquals(DateTime dateToCompare, DateTime date) {
        return !afterOrEquals(dateToCompare, date);
    }

    public static boolean after(Date dateToCompare, Date date) {
        return after(convert(dateToCompare), convert(date));
    }

    public static boolean after(DateTime dateToCompare, DateTime date) {
        if (allNotNull(dateToCompare, date)) {
            return date.isAfter(dateToCompare);
        } else {
            return false;
        }
    }
    
    
    /**
     * Date is not after date
     * @param dateToCompare {@link Date} Date to compare
     * @param date {@link Date} Date
     * @return True if date is not after date 
     */
    public static boolean notAfter(Date dateToCompare, Date date) {
        return !after(dateToCompare, date);
    }
    
    /**
     * Date is not after date
     * @param dateToCompare {@link DateTime} Date to compare
     * @param date {@link DateTime} Date
     * @return True if date is not after date 
     */
    public static boolean notAfter(DateTime dateToCompare, DateTime date) {
        return !after(dateToCompare, date);
    }

    public static boolean beforeOrEquals(Date dateToCompare, Date date) {
        return beforeOrEquals(convert(dateToCompare), convert(date));
    }

    public static boolean beforeOrEquals(DateTime dateToCompare, DateTime date) {
        if (allNotNull(dateToCompare, date)) {
            return date.isBefore(dateToCompare) || date.isEqual(dateToCompare);
        } else {
            return false;
        }
    }

    public static boolean before(Date dateToCompare, Date date) {
        return before(convert(dateToCompare), convert(date));
    }

    public static boolean before(DateTime dateToCompare, DateTime date) {
        if (allNotNull(dateToCompare, date)) {
            return date.isBefore(dateToCompare);
        } else {
            return false;
        }
    }

    public static long getDateInterval(Date fromDate, Date untilDate) {
        if (before(fromDate, untilDate)) {
            return Numbers.toNegative(Intervals.getInterval(untilDate, fromDate).toDurationMillis());
        } else {
            return Intervals.getInterval(fromDate, untilDate).toDurationMillis();
        }
    }

    public static long getDateInterval(long fromDate, long untilDate) {
        Interval interval = Intervals.getInterval(fromDate, untilDate);
        return interval.toDurationMillis();
    }


    public static long getSecondsInDateInterval(Date fromDate, Date untilDate) {
        return getSecondsFromMillis(getDateInterval(fromDate, untilDate));
    }

    public static DateTime addSeconds(DateTime date, int seconds) {
        if (Objects.nonNull(date)) {
            return date.plusSeconds(seconds);
        } else {
            return null;
        }
    }

    public static Date addSeconds(Date date, int seconds) {
        DateTime dateTime = addSeconds(convert(date), seconds);
        if (Objects.nonNull(dateTime)) {
            return dateTime.toDate();
        } else {
            return null;
        }
    }

    public static DateTime addSeconds(DateTime dateTime, long seconds) {
        return addSeconds(dateTime, Long.valueOf(seconds).intValue());
    }

    public static Date addSeconds(Date date, long seconds) {
        return addSeconds(date, Long.valueOf(seconds).intValue());
    }
    
    public static DateTime addHours(DateTime date, int hours) {
        if (Objects.nonNull(date)) {
            return date.plusHours(hours);
        } else {
            return null;
        }
    }

    public static Date addHours(Date date, int hours) {
        DateTime dateTime = addHours(convert(date), hours);
        if (Objects.nonNull(dateTime)) {
            return dateTime.toDate();
        } else {
            return null;
        }
    }

    public static DateTime addHours(DateTime dateTime, long hours) {
        return addHours(dateTime, Long.valueOf(hours).intValue());
    }

    public static Date addHours(Date date, long hours) {
        return addHours(date, Long.valueOf(hours).intValue());
    }
    
    
    public static DateTime addMinutes(DateTime date, int minutes) {
        if (Objects.nonNull(date)) {
            return date.plusMinutes(minutes);
        } else {
            return null;
        }
    }

    public static Date addMinutes(Date date, int minutes) {
        DateTime dateTime = addMinutes(convert(date), minutes);
        if (Objects.nonNull(dateTime)) {
            return dateTime.toDate();
        } else {
            return null;
        }
    }

    public static DateTime addMinutes(DateTime dateTime, long minutes) {
        return addMinutes(dateTime, Long.valueOf(minutes).intValue());
    }

    public static Date addMinutes(Date date, long minutes) {
        return addMinutes(date, Long.valueOf(minutes).intValue());
    }

    /**
     * Round date to minutes
     *
     * @param date
     * @return Date
     */
    public static Date roundToMinutes(Date date) {
        return roundSecure(date, Calendar.MINUTE);
    }

    public static Date roundSecure(Date date, int field) {
        if (Objects.nonNull(date)) {
            return DateUtils.round(date, field);
        } else {
            return null;
        }
    }

    public static long getSecondsInHalfInterval(Date fromDate, Date untilDate) {
        return Dates.getSecondsInDateInterval(fromDate, untilDate) / Numbers.TWO;
    }

    public static Date addDays(Date date, int days) {
        return DateUtils.addDays(date, days);
    }

    /**
     * Remove days
     *
     * @param date
     * @param days
     * @return Date
     */
    public static Date removeDays(Date date, int days) {
        return addDays(date, Numbers.toNegative(days));
    }

    public static long getMonthsFromSeconds(long seconds) {
        return Math.round(seconds / SECONDS_IN_MONTH);
    }

    public static long getSecondsFromMonths(long months) {
        return SECONDS_IN_MONTH * months;
    }

    private static long removeSeconds(long seconds, long secondsToRemove) {
        if (seconds >= secondsToRemove) {
            return seconds - secondsToRemove;
        } else {
            return seconds;
        }
    }

    public static long removeMonthsFromSeconds(long seconds, long months) {
        return removeSeconds(seconds, getSecondsFromMonths(months));
    }

    public static long getWeeksFromSeconds(long seconds) {
        return Math.round(seconds / SECONDS_IN_WEEK);
    }

    public static long getSecondsFromWeeks(long weeks) {
        return Math.round(SECONDS_IN_WEEK * weeks);
    }

    public static long removeWeeksFromSeconds(long seconds, long weeks) {
        return removeSeconds(seconds, getSecondsFromWeeks(weeks));
    }

    public static long getDaysFromSeconds(long seconds) {
        return Duration.standardSeconds(seconds).getStandardDays();
    }

    public static long getSecondsFromHours(long hours) {
        return Duration.standardHours(hours).getStandardSeconds();
    }

    /**
     * Get seconds fromDays
     *
     * @param days
     * @return long
     */
    public static long getSecondsFromDays(long days) {
        return Duration.standardDays(days).getStandardSeconds();
    }

    public static long removeDaysFromSeconds(long seconds, long days) {
        return removeSeconds(seconds, getSecondsFromDays(days));
    }

    /**
     * Get minutes from seconds
     *
     * @param seconds
     * @return long
     */
    public static long getMinutesFromSeconds(long seconds) {
        return Duration.standardSeconds(seconds).getStandardMinutes();
    }

    public static long getHoursFromSeconds(long seconds) {
        return Duration.standardSeconds(seconds).getStandardHours();
    }

    public static long getMonthsFromDays(long days) {
        return Math.round(days / DAYS_IN_MONTH);
    }

    public static long removeMonthsFromDays(long days, long months) {
        return removeSeconds(days, getDaysFromMonths(months));
    }

    public static long getDaysFromMonths(long months) {
        return Math.round(months * DAYS_IN_MONTH);
    }
    
    
    /**
     * Date from Long
     *
     * @param longDate
     * @return
     */
    public static Date from(String longDate) {
        if (Objects.isNull(longDate)) {
            return null;
        } else {
            return from(Long.valueOf(longDate));
        }
    }

    /**
     * Date from Long
     *
     * @param longDate
     * @return
     */
    public static Date from(Long longDate) {
        if (Objects.isNull(longDate)) {
            return null;
        } else {
            return new Date(longDate);
        }
    }
    
    
    public static Date from(DateTime dateTime) {
        if (Objects.isNull(dateTime)) {
            return null;
        } else {
            return new Date(dateTime.getMillis());
        }
    }

    /**
     * Check if date interval collision another date interval
     *
     * @param firstDateInInterval
     * @param secondDateInInterval
     * @param firsrDateInIntervalToCompare
     * @param secondDateInIntervalToCompare
     * @return True
     */
    public static boolean datesIntervalsOverlaps(Date firstDateInInterval, Date secondDateInInterval, Date firsrDateInIntervalToCompare, Date secondDateInIntervalToCompare) {
        if (Objects.allNotNull(firstDateInInterval, secondDateInInterval, firsrDateInIntervalToCompare, secondDateInIntervalToCompare)) {
            return Intervals.overlaps(Intervals.getInterval(firstDateInInterval, secondDateInInterval), Intervals.getInterval(firsrDateInIntervalToCompare, secondDateInIntervalToCompare));
        } else {
            return false;
        }
    }
    
    
    /**
     * Get a list of DateTime with the days of week in a datetime interval
     * @param startDate
     * @param endDate
     * @param dayOfWeek
     * @return List of DateTime
     */
    public static List<DateTime> daysOfWeekInDateInterval(DateTime startDate, DateTime endDate, int dayOfWeek) {
        List<DateTime> daysOfWeek = new ArrayList<DateTime>();
        DayOfWeekIterator iterator = DayOfWeekIterator.build(startDate, endDate, dayOfWeek);
        while (iterator.hasNext()) {
            daysOfWeek.add(iterator.next());
        }
        return daysOfWeek;
    }

}

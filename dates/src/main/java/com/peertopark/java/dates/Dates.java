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

import com.peertopark.java.commons.utilities.Objects;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.apache.commons.lang3.ObjectUtils;
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
     * @return
     */
    public static Date now() {
        return new Date();
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
     * @param fecha Date
     * @return String
     */
    public static String transformDateToLongString(Date fecha) {
        if (Objects.isNull(fecha)) {
            return null;
        } else {
            return String.valueOf(fecha.getTime());
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
        Interval interval = getInterval(fromDate, untilDate);
        return interval.toDurationMillis();
    }

    public static long getDateInterval(long fromDate, long untilDate) {
        Interval interval = getInterval(fromDate, untilDate);
        return interval.toDurationMillis();
    }
    
    public static Interval getInterval(Date fromDate, Date untilDate) {
        return new Interval(convert(fromDate), convert(untilDate));
    }
    
    
    public static Interval getInterval(DateTime fromDate, DateTime untilDate) {
        return new Interval(fromDate, untilDate);
    }
    
    public static Interval getInterval(long fromDate, long untilDate) {
        return new Interval(fromDate, untilDate);
    }

    public static long getSecondsInDateInterval(Date fromDate, Date untilDate) {
        return getSecondsFromMillis(getDateInterval(fromDate, untilDate));
    }

}

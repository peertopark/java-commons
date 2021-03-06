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
import static com.peertopark.java.dates.Dates.convert;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;

/**
 *
 * @author hector
 */
public class Intervals {

    public static Interval getInterval(Date fromDate, Date untilDate) {
        return new Interval(convert(fromDate), convert(untilDate));
    }

    public static Interval getInterval(DateTime fromDate, DateTime untilDate) {
        return new Interval(fromDate, untilDate);
    }

    public static Interval getInterval(long fromDate, long untilDate) {
        return new Interval(fromDate, untilDate);
    }

    public static Collection<Interval> split(Interval interval, Duration duration) {
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        long startMillis = interval.getStartMillis();
        long endMillis = interval.getEndMillis();  
        long chunks = interval.toDurationMillis() / duration.getMillis();
        for (int i = 0; i < chunks; i++) {
            long temporalEndMillis = startMillis + duration.getMillis();
            intervals.add(getInterval(startMillis, temporalEndMillis));
            startMillis = temporalEndMillis;
        }
        if (startMillis < endMillis) {
            intervals.add(getInterval(startMillis, endMillis));
        }
        return intervals;
    }
    
    public static boolean overlaps(Interval interval, Interval toCompare) {
        if (Objects.allNotNull(toCompare, interval)) {
            return toCompare.overlaps(interval);
        } else {
            return false;
        }
    }
    
    
    /**
     * Get a list of DateTime with the days of week in a datetime interval
     * @param interval
     * @param dayOfWeek
     * @return List of DateTime
     */
    public static List<DateTime> daysOfWeek(Interval interval, int dayOfWeek) {
        return Dates.daysOfWeekInDateInterval(interval.getStart(), interval.getEnd(), dayOfWeek);
    }
    
    
    public static boolean haveDayOfWeek(Interval interval, int dayOfWeek) {
        List<DateTime> list = daysOfWeek(interval, dayOfWeek);
        return !list.isEmpty();
    }

}

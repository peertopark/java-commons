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
package com.peertopark.java.dates.iterators;

import com.peertopark.java.commons.utilities.Numbers;
import com.peertopark.java.dates.Dates;
import java.util.Iterator;
import org.joda.time.DateTime;
import org.joda.time.Interval;

/**
 *
 * @author hector
 */
public class DayOfWeekIterator implements Iterator<DateTime> {
    
    private final DateTime endDate;
    
    private DateTime nextDate;
    
    public DayOfWeekIterator(DateTime startDate, DateTime endDate, int dayOfWeekToIterate){
        this.endDate = endDate;
        nextDate = startDate.withDayOfWeek(dayOfWeekToIterate);
        if (startDate.getDayOfWeek() > dayOfWeekToIterate) {
            nextDate = nextDate.plusWeeks(Numbers.ONE);
        }
    }
    
    public DayOfWeekIterator(Interval interval, int dayOfWeekToIterate){
       this(interval.getStart(), interval.getEnd(), dayOfWeekToIterate);
    }
    
    public static DayOfWeekIterator build(DateTime startDate, DateTime endDate, int dayOfWeekToIterate) {
        return new DayOfWeekIterator(startDate, endDate, dayOfWeekToIterate);
    }
    
    public static DayOfWeekIterator build(Interval interval, int dayOfWeekToIterate) {
        return new DayOfWeekIterator(interval, dayOfWeekToIterate);
    }
    
    
    @Override
    public boolean hasNext() {
        return Dates.notAfterOrEquals(endDate, nextDate);
    }

    @Override
    public DateTime next() {
        DateTime resultDate = nextDate;
        nextDate = nextDate.plusWeeks(Numbers.ONE);
        return resultDate;
    }
    
}

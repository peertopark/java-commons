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
import java.util.Collection;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
import org.joda.time.Interval;
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
public class IntervalsTest {
    
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

    @Test
    public void testGetInterval() {
        DateTime fromDateTime = DateTime.now();
        DateTime untilDateTime = DateTime.now();
        Interval interval = Intervals.getInterval(fromDateTime, untilDateTime);
        assertNotNull(interval);

        Date fromDate = Dates.now();
        Date untilDate = Dates.now();
        interval = Intervals.getInterval(fromDate, untilDate);
        assertNotNull(interval);
    }
    
    
    @Test
    public void testSplit() {
        DateTime fromDate = new DateTime(2017, 2, 24, 14, 0, 0);
        DateTime untilDate = new DateTime(2017, 5, 24, 14, 0, 0);
       
        Interval interval = Intervals.getInterval(fromDate, untilDate);
        Duration duration = Duration.standardSeconds(Dates.THIRTY_DAYS_IN_SECONDS);
        
        Collection<Interval> intervals = Intervals.split(interval, duration);
        assertNotNull(intervals);
        assertEquals(Numbers.THREE, intervals.size());
        
        fromDate = new DateTime(2017, 2, 24, 14, 0, 0);
        untilDate = new DateTime(2017, 6, 9, 18, 0, 0);
        interval = Intervals.getInterval(fromDate, untilDate);
        intervals = Intervals.split(interval, duration);
        assertNotNull(intervals);
        assertEquals(Numbers.FOUR, intervals.size());
        
        
        fromDate = new DateTime(2017, 1, 1, 14, 0, 0);
        untilDate = new DateTime(2017, 1, 31, 14, 0, 0);
        interval = Intervals.getInterval(fromDate, untilDate);
        intervals = Intervals.split(interval, duration);
        assertNotNull(intervals);
        assertEquals(Numbers.ONE, intervals.size());

        fromDate = new DateTime(2017, 1, 1, 14, 0, 0);
        untilDate = new DateTime(2017, 1, 31, 15, 0, 0);
        interval = Intervals.getInterval(fromDate, untilDate);
        intervals = Intervals.split(interval, duration);
        assertNotNull(intervals);
        assertEquals(Numbers.TWO, intervals.size());
        
        fromDate = new DateTime(2017, 1, 1, 14, 0, 0);
        untilDate = new DateTime(2017, 1, 31, 10, 0, 0);
        interval = Intervals.getInterval(fromDate, untilDate);
        intervals = Intervals.split(interval, duration);
        assertNotNull(intervals);
        assertEquals(Numbers.ONE, intervals.size());
    }
    
    @Test
    public void testOverlap() {
        DateTime compareFromDate = new DateTime(2017, 2, 1, 12, 0, 0);
        DateTime compareUntilDate = new DateTime(2017, 2, 10, 12, 0, 0);
        
        Interval compareInterval = Intervals.getInterval(compareFromDate, compareUntilDate);
        assertNotNull(compareInterval);
        System.out.println(compareInterval);
        
        DateTime fromDate = new DateTime(2017, 1, 1, 12, 0, 0);
        DateTime untilDate = new DateTime(2017, 2, 1, 12, 0, 0);
        Interval interval = Intervals.getInterval(fromDate, untilDate);
        assertFalse(Intervals.overlaps(interval, compareInterval));
        
        fromDate = new DateTime(2017, 2, 10, 12, 0, 0);
        untilDate = new DateTime(2017, 2, 20, 12, 0, 0);
        interval = Intervals.getInterval(fromDate, untilDate);
        assertFalse(Intervals.overlaps(interval, compareInterval));
        
        fromDate = new DateTime(2017, 1, 1, 12, 0, 0);
        untilDate = new DateTime(2017, 2, 1, 12, 0, 1);
        interval = Intervals.getInterval(fromDate, untilDate);
        assertTrue(Intervals.overlaps(interval, compareInterval));
        
        fromDate = new DateTime(2017, 2, 10, 11, 0, 50);
        untilDate = new DateTime(2017, 2, 20, 12, 0, 0);
        interval = Intervals.getInterval(fromDate, untilDate);
        assertTrue(Intervals.overlaps(interval, compareInterval));
        
        fromDate = new DateTime(2017, 1, 1, 12, 0, 0);
        untilDate = new DateTime(2017, 2, 8, 12, 0, 0);
        interval = Intervals.getInterval(fromDate, untilDate);
        assertTrue(Intervals.overlaps(interval, compareInterval));
        
        fromDate = new DateTime(2017, 2, 2, 13, 0, 0);
        untilDate = new DateTime(2017, 2, 8, 12, 0, 0);
        interval = Intervals.getInterval(fromDate, untilDate);
        assertTrue(Intervals.overlaps(interval, compareInterval));
        
        fromDate = new DateTime(2017, 2, 8, 11, 0, 50);
        untilDate = new DateTime(2017, 2, 20, 12, 0, 0);
        interval = Intervals.getInterval(fromDate, untilDate);
        assertTrue(Intervals.overlaps(interval, compareInterval));
    }
    
}

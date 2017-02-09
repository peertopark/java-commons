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
import java.util.Collection;
import java.util.Date;
import org.joda.time.DateTime;
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
    public void testSplit() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");    
        Date fromDate = dateFormat.parse("24-02-2017 14:00:00");
        Date untilDate = dateFormat.parse("25-05-2017 15:00:00");
       
        Interval interval = Intervals.getInterval(fromDate, untilDate);
        Duration duration = Duration.standardSeconds(Dates.THIRTY_DAYS_IN_SECONDS);
        
        Collection<Interval> intervals = Intervals.split(interval, duration);
        assertNotNull(intervals);
        assertEquals(Numbers.THREE, intervals.size());
        
        fromDate = dateFormat.parse("24-02-2017 14:00:00");
        untilDate = dateFormat.parse("09-06-2017 18:00:00");
        interval = Intervals.getInterval(fromDate, untilDate);
        intervals = Intervals.split(interval, duration);
        assertNotNull(intervals);
        assertEquals(Numbers.FOUR, intervals.size());
        
        fromDate = dateFormat.parse("01-01-2017 14:00:00");
        untilDate = dateFormat.parse("31-01-2017 14:00:00");
        interval = Intervals.getInterval(fromDate, untilDate);
        intervals = Intervals.split(interval, duration);
        assertNotNull(intervals);
        assertEquals(Numbers.ONE, intervals.size());
        
        fromDate = dateFormat.parse("01-01-2017 14:00:00");
        untilDate = dateFormat.parse("31-01-2017 15:00:00");
        interval = Intervals.getInterval(fromDate, untilDate);
        intervals = Intervals.split(interval, duration);
        assertNotNull(intervals);
        assertEquals(Numbers.TWO, intervals.size());
        
        fromDate = dateFormat.parse("01-01-2017 14:00:00");
        untilDate = dateFormat.parse("31-01-2017 10:00:00");
        interval = Intervals.getInterval(fromDate, untilDate);
        intervals = Intervals.split(interval, duration);
        assertNotNull(intervals);
        assertEquals(Numbers.ONE, intervals.size());
    }
    
}

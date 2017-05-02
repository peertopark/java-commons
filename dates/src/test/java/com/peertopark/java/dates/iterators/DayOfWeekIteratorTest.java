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

import com.peertopark.java.dates.Dates;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
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
public class DayOfWeekIteratorTest {
    
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
     * Test of hasNext method, of class DayOfWeekIterator.
     */
    @Test
    public void testHasNext() {
        DateTime startDate = Dates.build(2017, 1, 1);   
        DateTime endDate = Dates.build(2017, 1, 8);      
        DayOfWeekIterator iterator = DayOfWeekIterator.build(startDate, endDate, DateTimeConstants.FRIDAY);
        assertTrue(iterator.hasNext());
        
        endDate = Dates.build(2017, 1, 5);      
        iterator = DayOfWeekIterator.build(startDate, endDate, DateTimeConstants.FRIDAY);
        assertFalse(iterator.hasNext());
        
        endDate = Dates.build(2017, 1, 6);      
        iterator = DayOfWeekIterator.build(startDate, endDate, DateTimeConstants.FRIDAY);
        assertFalse(iterator.hasNext());
        
        endDate = Dates.build(2017, 1, 6, 12, 0);      
        iterator = DayOfWeekIterator.build(startDate, endDate, DateTimeConstants.FRIDAY);
        assertTrue(iterator.hasNext());
        
        startDate = Dates.build(2017, 1, 6);
        endDate = Dates.build(2017, 1, 8);      
        iterator = DayOfWeekIterator.build(startDate, endDate, DateTimeConstants.FRIDAY);
        assertTrue(iterator.hasNext());
        
        startDate = Dates.build(2017, 1, 6, 12, 0);
        endDate = Dates.build(2017, 1, 8);      
        iterator = DayOfWeekIterator.build(startDate, endDate, DateTimeConstants.FRIDAY);
        assertTrue(iterator.hasNext());
    }

    /**
     * Test of next method, of class DayOfWeekIterator.
     */
    @Test
    public void testNext() {
        DateTime startDate = Dates.build(2017, 1, 1);   
        DateTime endDate = Dates.build(2017, 1, 15);      
        DayOfWeekIterator iterator = DayOfWeekIterator.build(startDate, endDate, DateTimeConstants.FRIDAY);
        
        DateTime expResult = Dates.build(2017, 1, 6);      
        DateTime result = iterator.next();
        assertEquals(expResult, result);
        
        expResult = Dates.build(2017, 1, 13);      
        result = iterator.next();
        assertEquals(expResult, result);
    }
    
}

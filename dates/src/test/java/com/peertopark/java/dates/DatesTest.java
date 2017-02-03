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

import java.util.Date;
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

}

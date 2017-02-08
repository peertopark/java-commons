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
package com.peertopark.java.commons.utilities;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author blackleg
 */
public class NumbersTest {

    public NumbersTest() {
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

    @Test
    public void testRoundDouble() {
        double initial = 100.123;
        double compare = 100.12;
        double result = Numbers.simpleRoundDouble(initial);
        assertEquals(compare, result, 0.0);
        initial = 100.126;
        compare = 100.13;
        result = Numbers.simpleRoundDouble(initial);
        assertEquals(compare, result, 0.0);
        initial = 100.125;
        compare = 100.13;
        result = Numbers.simpleRoundDouble(initial);
        assertEquals(compare, result, 0.0);
    }

    @Test
    public void testRoundDoubleString() {
        double initial = 100.12345;
        String compare = "100.12";
        String result = Numbers.simpleRoundDoubleToString(initial);
        assertEquals(compare, result);
    }

    @Test
    public void testIntFromDouble() {
        double initial = 100.12;
        int compare = 100;
        int result = Numbers.intFromDouble(initial);
        assertEquals(compare, result);

    }

    @Test
    public void testDoubleFromInt() {
        int initial = 100;
        double compare = 100.0;
        double result = Numbers.doubleFromInt(initial);
        assertEquals(compare, result, 0.0);

    }

    @Test
    public void testIntegerFromDouble() {
        double initial = 123.123;
        Integer compare = 123;
        Integer result = Numbers.integerFromDouble(initial);
        assertEquals(compare, result);

    }

    @Test
    public void testRoundToMultiple() {
        int initial = 123;
        int compare = 125;
        int multiple = 5;
        int result = Numbers.roundToMultiple(initial, multiple);
        assertEquals(compare, result);

        initial = 4;
        compare = 5;
        multiple = 5;
        result = Numbers.roundToMultiple(initial, multiple);
        assertEquals(compare, result);
    }

    @Test
    public void testToNegativeInt() {
        int number = 1;
        int expected = -1;
        int result = Numbers.toNegative(number);
        assertEquals(expected, result);

        number = -1;
        result = Numbers.toNegative(number);
        assertEquals(expected, result);
    }
    
    @Test
    public void testToNegativeLong() {
        long number = 1;
        long expected = -1;
        long result = Numbers.toNegative(number);
        assertEquals(expected, result);

        number = -1;
        result = Numbers.toNegative(number);
        assertEquals(expected, result);
    }

}

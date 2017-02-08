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
 * @author hector
 */
public class RandomMakerTest {

    public RandomMakerTest() {
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
     * Test of between method, of class RandomMaker.
     */
    @Test
    public void testBetween_int_int() {
        int min = 0;
        int max = 10;
        int result = RandomMaker.between(min, max);
        assertTrue(result >= min && result <= max);
        
        min = -10;
        max = 10;
        result = RandomMaker.between(min, max);
        assertTrue(result >= min && result <= max);
        
        min = -20;
        max = -10;
        result = RandomMaker.between(min, max);
        assertTrue(result >= min && result <= max);

    }
    
    @Test
    public void testBetween_long_long() {
        long min = 0l;
        long max = 10l;
        long result = RandomMaker.between(min, max);
        assertTrue(result >= min && result <= max);
        
        min = -10l;
        max = 10l;
        result = RandomMaker.between(min, max);
        assertTrue(result >= min && result <= max);
        
        min = -20l;
        max = -10l;
        result = RandomMaker.between(min, max);
        assertTrue(result >= min && result <= max);

    }


    /**
     * Test of between method, of class RandomMaker.
     */
    @Test
    public void testBetween_double_double() {
        double min = 0.0;
        double max = 10.0;
        double result = RandomMaker.between(min, max);
        assertTrue(result >= min && result <= max);
        
        min = -10.0;
        max = 10.0;
        result = RandomMaker.between(min, max);
        assertTrue(result >= min && result <= max);
        
        min = -15.0;
        max = -10.0;
        result = RandomMaker.between(min, max);
        assertTrue(result >= min && result <= max);
    }

    /**
     * Test of getBoolean method, of class RandomMaker.
     */
    @Test
    public void testGetBoolean() {
        Boolean result = RandomMaker.getBoolean();
        assertNotNull(result);
    }

}

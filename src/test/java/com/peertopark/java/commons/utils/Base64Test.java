/*
 * Copyright 2016 Peer to Park.
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
package com.peertopark.java.commons.utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hector Espert
 */
public class Base64Test {
    
    public Base64Test() {
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
     * Test of encode method, of class Base64.
     */
    @Test
    public void testEncode() {
        String string = "manuela:1234";
        String expResult = "bWFudWVsYToxMjM0";
        String result = Base64.encode(string);
        assertNotNull(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of decode method, of class Base64.
     */
    @Test
    public void testDecode() {
        String string = "bWFudWVsYToxMjM0";
        String expResult = "manuela:1234";
        String result = Base64.decode(string);
        assertNotNull(result);
        assertEquals(expResult, result);
    }
    
}

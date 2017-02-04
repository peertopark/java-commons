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
public class StringsTest {
    
    public StringsTest() {
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
     * Test of checkIfIsEmptyOrNull method, of class Strings.
     */
    @Test
    public void testCheckIfIsEmptyOrNull() {
        String test = "Pepe";
        assertFalse(Strings.checkIfIsEmptyOrNull(test));
        test = "";
        assertTrue(Strings.checkIfIsEmptyOrNull(test));
        test = null;
        assertTrue(Strings.checkIfIsEmptyOrNull(test));
    }

    /**
     * Test of checkIfIsNotEmptyOrNull method, of class Strings.
     */
    @Test
    public void testCheckIfIsNotEmptyOrNull() {
        String test = "Pepe";
        assertTrue(Strings.checkIfIsNotEmptyOrNull(test));
        test = "";
        assertFalse(Strings.checkIfIsNotEmptyOrNull(test));
        test = null;
        assertFalse(Strings.checkIfIsNotEmptyOrNull(test));
    }
    
    
    @Test
    public void testCapitalize() {
        String test = "prueba";
        String expected = "Prueba";
        String result = Strings.capitalize(test);
        assertEquals(expected, result);
 
    }
    
    @Test
    public void testGetFirstLetter() {
        String test = "prueba";
        String expected = "p";
        String result = Strings.getFirstLetter(test);
        assertEquals(expected, result);
    }
    
    @Test
    public void testGetCapitalizeFirstLetter() {
        String test = "prueba";
        String expected = "P";
        String result = Strings.getCapitalizeFirstLetter(test);
        assertEquals(expected, result);
    }
    
}

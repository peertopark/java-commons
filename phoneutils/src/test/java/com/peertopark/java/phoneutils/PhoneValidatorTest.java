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
package com.peertopark.java.phoneutils;

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
public class PhoneValidatorTest {
    
    public PhoneValidatorTest() {
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
     * Test of validatePhone method, of class Validator.
     */
    @Test
    public void testValidateSpanishMobilePhone() {
        String phone = "630627272";
        assertTrue(PhoneValidator.validateSpanishMobilePhone(phone));
        phone = "730627272";
        assertTrue(PhoneValidator.validateSpanishMobilePhone(phone));
        phone = "34730627272";
        assertTrue(PhoneValidator.validateSpanishMobilePhone(phone));
        phone = "+34730627272";
        assertTrue(PhoneValidator.validateSpanishMobilePhone(phone));
        phone = "+35730627272";
        assertFalse(PhoneValidator.validateSpanishMobilePhone(phone));
        phone = "55555";
        assertFalse(PhoneValidator.validateSpanishMobilePhone(phone));
        phone = "Pepe";
        assertFalse(PhoneValidator.validateSpanishMobilePhone(phone));
    }
    
}

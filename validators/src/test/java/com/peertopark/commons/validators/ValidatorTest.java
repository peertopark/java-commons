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
package com.peertopark.commons.validators;

import org.apache.commons.validator.routines.RegexValidator;
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
public class ValidatorTest {
    
    public ValidatorTest() {
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
    public void testGetRegexValidator() {
        RegexValidator regexValidator = Validator.getRegexValidator("^[0-9]+$");
        assertNotNull(regexValidator);
    }
    
    @Test
    public void testGetRegexValidatorNotCaseSensitive() {
        RegexValidator regexValidator = Validator.getRegexValidatorNotCaseSensitive("^[0-9]+$");
        assertNotNull(regexValidator);
    }
    
    @Test
    public void testStringMaxLength() {
        assertTrue(Validator.stringMaxLength("", 0));
        assertTrue(Validator.stringMaxLength("123456", 6));
        assertTrue(Validator.stringMaxLength("12345", 6));
        assertFalse(Validator.stringMaxLength("1234567", 6));
    }
    
    @Test
    public void testStringMinLength() {
        assertTrue(Validator.stringMinLength("", 0));
        assertTrue(Validator.stringMinLength("123456", 6));
        assertTrue(Validator.stringMinLength("1234567", 6));
        assertFalse(Validator.stringMinLength("12345", 6));
    }
    
    @Test
    public void testValidateEmail() {
        String email = "developers@peertopark.com";
        assertTrue(Validator.validateEmail(email));
    }
    
}

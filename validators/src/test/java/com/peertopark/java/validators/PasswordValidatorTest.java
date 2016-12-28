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
package com.peertopark.java.validators;

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
public class PasswordValidatorTest {
    
    public PasswordValidatorTest() {
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
    public void testValidatePassword() {
        assertTrue(PasswordValidator.validate("12345678"));
        assertFalse(PasswordValidator.validate("asdf"));
        assertTrue(PasswordValidator.validate("012345678901234"));
        assertFalse(PasswordValidator.validate("0123456789012345"));
        assertTrue(PasswordValidator.validate("1234asdf"));
        assertFalse(PasswordValidator.validate("1234añçf"));
        
        PasswordValidator.setPasswordMinLength(2);
        PasswordValidator.setPasswordMaxLength(20);
        PasswordValidator.setPasswordRegex(".");
        assertTrue(PasswordValidator.validate("12345678"));
        assertTrue(PasswordValidator.validate("123"));
        assertFalse(PasswordValidator.validate("a"));
        assertTrue(PasswordValidator.validate("añ/|"));
    }
    
}

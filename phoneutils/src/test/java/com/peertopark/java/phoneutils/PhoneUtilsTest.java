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

import com.google.i18n.phonenumbers.Phonenumber;
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
public class PhoneUtilsTest {

    public PhoneUtilsTest() {
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
    public void testFormatWithCode() {
        String expected = "34630627272";

        String phone = PhoneUtils.formatWithCode("630627272", "ES");
        assertNotNull(phone);
        assertEquals(expected, phone);

        phone = PhoneUtils.formatWithCode("630627272");
        assertNotNull(phone);
        assertEquals(expected, phone);

        phone = PhoneUtils.formatWithCode("34630627272");
        assertNotNull(phone);
        assertEquals(expected, phone);

        phone = PhoneUtils.formatWithCode("+34630627272");
        assertNotNull(phone);
        assertEquals(expected, phone);

        phone = PhoneUtils.formatWithCode("+34 630 62 72 72");
        assertNotNull(phone);
        assertEquals(expected, phone);
    }

}

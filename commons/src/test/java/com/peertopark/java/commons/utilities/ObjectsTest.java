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

import com.peertopark.java.commons.objects.Login;
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
public class ObjectsTest {
    
    public ObjectsTest() {
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
     * Test of nonNull method, of class Objects.
     */
    @Test
    public void testNonNull_Object() {
        Object object = null;
        boolean expResult = false;
        boolean result = Objects.nonNull(object);
        assertEquals(expResult, result);
        object = new Login();
        expResult = true;
        result = Objects.nonNull(object);
        assertEquals(expResult, result);
    }

    /**
     * Test of isNull method, of class Objects.
     */
    @Test
    public void testIsNull() {
        Object object = null;
        boolean expResult = true;
        boolean result = Objects.isNull(object);
        assertEquals(expResult, result);
        object = new Login();
        expResult = false;
        result = Objects.isNull(object);
        assertEquals(expResult, result);
    }

    /**
     * Test of nonNull method, of class Objects.
     */
    @Test
    public void testNonNull_Object_Object() {
        Object objectOne = null;
        Object objectTwo = null;
        assertFalse(Objects.nonNull(objectOne, objectTwo));       
        objectOne = new Object();
        assertFalse(Objects.nonNull(objectOne, objectTwo));       
        objectTwo = new Object();
        assertTrue(Objects.nonNull(objectOne, objectTwo));       
        objectOne = null;
        assertFalse(Objects.nonNull(objectOne, objectTwo));
    }
    
}

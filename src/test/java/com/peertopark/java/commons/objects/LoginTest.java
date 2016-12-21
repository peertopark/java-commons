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
package com.peertopark.java.commons.objects;

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
public class LoginTest {
    
    public LoginTest() {
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
    public void testReadBasic() {
        String basicAuth = "Basic bWFudWVsYToxMjM0";
        Login login = new Login();
        login.readBasic(basicAuth);
        assertNotNull(login.getUser());
        assertNotNull(login.getPasswd());
        assertEquals("manuela", login.getUser());
        assertEquals("1234", login.getPasswd());
    }
    
    @Test
    public void testFromBasicAuth() {
        String basicAuth = "Basic bWFudWVsYToxMjM0";
        Login login = Login.fromBasicAuth(basicAuth);
        assertNotNull(login.getUser());
        assertNotNull(login.getPasswd());
        assertEquals("manuela", login.getUser());
        assertEquals("1234", login.getPasswd());
    }
    
    @Test
    public void testToBasicAuth() {
        String user = "manuela";
        String password = "1234";
        String basicAuthExpected = "Basic bWFudWVsYToxMjM0";
        Login login = Login.newLogin(user, password);
        String basicAuth = login.toBasicAuth();
        assertNotNull(basicAuth);
        assertEquals(basicAuthExpected, basicAuth);
        
    }
    
}

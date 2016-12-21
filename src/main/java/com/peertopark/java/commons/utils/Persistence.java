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

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Hector Espert
 */
public class Persistence {

    public static final String URL = "javax.persistence.jdbc.url";
    public static final String USER = "javax.persistence.jdbc.user";
    public static final String PASSWORD = "javax.persistence.jdbc.password";

    public static Map makeBasicProperties(String url, String user, String password) {
        Map properties = new HashMap<Object, Object>();
        properties.put(Persistence.URL, url);
        properties.put(Persistence.USER, user);
        properties.put(Persistence.PASSWORD, password);
        return properties;
    }

}

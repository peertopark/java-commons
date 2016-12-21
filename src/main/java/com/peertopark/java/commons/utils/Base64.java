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

import es.blackleg.java.utilities.Objects;
import javax.xml.bind.DatatypeConverter;
import org.apache.commons.lang3.JavaVersion;
import org.apache.commons.lang3.SystemUtils;

/**
 *
 * @author Hector Espert
 */
public class Base64 {
    
    public static String encode(String string) {
        if (Objects.isNull(string)) {
            return null;
        } else if (!SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_8)) {
            return DatatypeConverter.printBase64Binary(string.getBytes());
        } else {
            return java.util.Base64.getEncoder().encodeToString(string.getBytes());
        }
    }
    
    public static String decode(String string) {
        byte[] decoded;
        if (Objects.isNull(string)) {
            return null;
        } else if (!SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_8)) {
            decoded = DatatypeConverter.parseBase64Binary(string);
        } else {
            decoded = java.util.Base64.getDecoder().decode(string);
        }
        return new String(decoded);
    }
    
}

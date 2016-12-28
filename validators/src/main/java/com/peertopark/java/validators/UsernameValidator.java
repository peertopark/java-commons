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

/**
 *
 * @author hector
 */
public class UsernameValidator extends Validator {
    
    private static final int USERNAMEMINLENGTH = 4;
    private static final int USERNAMEMAXLENGTH = 15;
    private static final String USERNAMEREGEX = "^[a-z0-9]{%d,%d}$";
    
    public static boolean validate(String username) {
        return validateStringWithPattern(username, makeUserRegex());
    }
    
    private static String makeUserRegex() {
        return String.format(USERNAMEREGEX, USERNAMEMINLENGTH, USERNAMEMAXLENGTH);
    }
    
    
}

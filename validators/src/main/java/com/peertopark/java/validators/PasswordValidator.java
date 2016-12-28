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
public class PasswordValidator extends Validator{

    private static int passwordMinLength = 8;
    private static int passwordMaxLength = 15;
    private static final String PASSWORD_BASE_REGEX = "^%s{%d,%d}$";
    private static String passwordRegex = "[a-z0-9]";
    
    public static boolean validate(String password) {
       return validateStringWithPattern(password, makePasswordRegex());
    }
    
    private static String makePasswordRegex() {
        return String.format(PASSWORD_BASE_REGEX, passwordRegex, passwordMinLength, passwordMaxLength);
    }

    public static int getPasswordMinLength() {
        return passwordMinLength;
    }

    public static void setPasswordMinLength(int passwordMinLength) {
        PasswordValidator.passwordMinLength = passwordMinLength;
    }

    public static int getPasswordMaxLength() {
        return passwordMaxLength;
    }

    public static void setPasswordMaxLength(int passwordMaxLength) {
        PasswordValidator.passwordMaxLength = passwordMaxLength;
    }

    public static String getPasswordRegex() {
        return passwordRegex;
    }

    public static void setPasswordRegex(String passwordRegex) {
        PasswordValidator.passwordRegex = passwordRegex;
    }

}

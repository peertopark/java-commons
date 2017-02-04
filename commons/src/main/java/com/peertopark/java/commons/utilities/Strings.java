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

/**
 *
 * @author hector
 */
public class Strings {

    public static final String EMPTY = "";

    /**
     * Check if string is null or empty
     *
     * @param string The string
     * @return boolean
     */
    public static boolean checkIfIsEmptyOrNull(String string) {
        return Objects.isNull(string) || string.isEmpty();

    }

    /**
     * Check if string is not null and not empty
     *
     * @param string The string
     * @return boolean
     */
    public static boolean checkIfIsNotEmptyOrNull(String string) {
        return !Strings.checkIfIsEmptyOrNull(string);
    }

    public static String capitalize(String string) {
        if (Strings.checkIfIsEmptyOrNull(string)) {
            return string;
        } else {
            return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
        }
    }

    public static String getFirstLetter(String string) {
        if (Strings.checkIfIsEmptyOrNull(string)) {
            return string;
        } else {
            return string.substring(0, 1);
        }
    }

    public static String getCapitalizeFirstLetter(String string) {
        if (Strings.checkIfIsEmptyOrNull(string)) {
            return string;
        } else {
            return getFirstLetter(string).toUpperCase();
        }
    }

    public static String removeStringInString(String string, String remove) {
        if (Strings.checkIfIsEmptyOrNull(string)) {
            return string;
        } else {
            return string.replaceAll(remove, EMPTY);
        }
    }

}

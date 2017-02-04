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

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author blackleg
 */
public class Currencies {

    public static NumberFormat getCurrencyFormat() {
        return NumberFormat.getCurrencyInstance();
    }

    public static NumberFormat getCurrencyFormat(Locale locale) {
        return NumberFormat.getCurrencyInstance(locale);
    }

    /**
     * Transform double to currency locale
     *
     * @param locale The currency locale
     * @param number The number to format
     * @return String
     */
    public static String getCurrencyString(Locale locale, double number) {
        return getCurrencyFormat(locale).format(number);
    }

    /**
     * Transform long to currency locale
     *
     * @param locale The currency locale
     * @param number The number to format
     * @return String
     */
    public static String getCurrencyString(Locale locale, long number) {
        return getCurrencyFormat(locale).format(number);
    }

}

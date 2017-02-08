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

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author hector
 */
public class Numbers {

    public static final double ZERODOUBLE = 0.0;
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int MINUSONE = -1;
    public static final int TWO = 2;
    public static final int MINUSTWO = -2;

    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;
    public static final int SEVEN = 7;
    public static final int EIGHT = 8;
    public static final int NINE = 9;
    public static final int TEN = 10;
    public static final int ELEVEN = 11;
    public static final int TWELVE = 12;
    public static final int THIRTEEN = 13;
    public static final int FOURTEEN = 14;
    public static final int FIVETEEN = 15;
    public static final int SIXTEEN = 16;
    public static final int SEVENTEEN = 17;
    public static final int EIGHTTEEN = 18;
    public static final int NINETEEN = 19;

    public static final int TWENTY = 20;
    public static final int TWENTY_ONE = 21;
    public static final int TWENTY_TWO = 22;
    public static final int TWENTY_THREE = 23;
    public static final int TWENTY_FOUR = 24;
    public static final int TWENTY_FIVE = 25;
    public static final int TWENTY_SIX = 26;
    public static final int TWENTY_SEVEN = 27;
    public static final int TWENTY_EIGHT = 28;
    public static final int TWENTY_NINE = 29;

    public static final int THIRTY = 30;
    public static final int THIRTY_ONE = 31;

    public static final int SIXTY = 60;

    public static final int ONE_HUNDRED = 100;
    public static final double ONE_HUNDRED_DOUBLE = 100.0;
    public static final int ONETHOUSAND = 1000;

    public static DecimalFormat getDecimalFormat() {
        return new DecimalFormat();
    }

    public static DecimalFormat getDecimalFormat(String format) {
        return new DecimalFormat(format);
    }

    /**
     * Simple round double to string
     *
     * @param number A double number
     * @return Rounded double string
     */
    public static String simpleRoundDoubleToString(double number) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        numberFormat.setMaximumFractionDigits(TWO);
        numberFormat.setMinimumFractionDigits(TWO);
        return numberFormat.format(number);
    }

    public static BigDecimal getBitDecimal(double number) {
        return new BigDecimal(number);
    }

    public static BigDecimal getBigDecimalWithScale(double number, int scale) {
        return getBitDecimal(number).setScale(scale, RoundingMode.HALF_UP);
    }

    /**
     * Simple round double
     *
     * @param number A double number
     * @return Rounded double
     */
    public static double simpleRoundDouble(double number) {
        return simpleRoundDouble(number, TWO);
    }

    /**
     * Simple round double
     *
     * @param number A double number
     * @param scale
     * @return Rounded double
     */
    public static double simpleRoundDouble(double number, int scale) {
        return getBigDecimalWithScale(number, scale).doubleValue();
    }

    /**
     * Convierte un double a un int
     *
     * @param number
     * @return
     */
    public static int intFromDouble(double number) {
        return Double.valueOf(number).intValue();
    }

    /**
     *
     * @param number
     * @return
     */
    public static Integer integerFromDouble(double number) {
        return intFromDouble(number);
    }

    public static double doubleFromInt(int number) {
        return Integer.valueOf(number).doubleValue();
    }

    /**
     * Round to the next multiple
     *
     * @param number
     * @param multiple
     * @return
     */
    public static int roundToMultiple(double number, int multiple) {
        return Math.toIntExact(Math.round(number / multiple) * multiple);
    }

    /**
     * Round to the next multiple
     *
     * @param number
     * @param multiple
     * @return
     */
    public static int roundToMultiple(int number, int multiple) {
        return roundToMultiple(doubleFromInt(number), multiple);
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }

    public static boolean isNegative(double number) {
        return number < 0;
    }

    /**
     * Return if number is higher than number to compare
     *
     * @param numberToCompare
     * @param number
     * @return True if number is higher than number to compare
     */
    public static boolean isHigherThan(Double numberToCompare, Double number) {
        return number > numberToCompare;
    }

    public static int toNegative(int number) {
        if (isNegative(number)) {
            return number;
        } else {
            return -number;
        }
    }
    
    public static long toNegative(long number) {
        if (isNegative(number)) {
            return number;
        } else {
            return -number;
        }
    }

}

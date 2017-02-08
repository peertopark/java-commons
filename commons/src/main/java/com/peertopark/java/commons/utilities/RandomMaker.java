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

import org.apache.commons.lang3.RandomUtils;

/**
 *
 * @author hector
 */
public class RandomMaker {

    public static int between(int min, int max) {
        if (min > max) {
            int aux = min;
            min = max;
            max = aux;
        }
        int startRange = min;
        if (startRange < Numbers.ZERO) {
            startRange = Numbers.ZERO;
        }      
        int endRange = Math.abs(max);
        if (max <= Numbers.ZERO) {
            endRange = Math.abs(min);
        }      
        int numale;
        do {
            numale = RandomUtils.nextInt(startRange, endRange + Numbers.ONE);
            if (RandomUtils.nextBoolean()) {
                numale = -numale;
            }
        } while (numale < min || numale > max);
        return numale;
    }

    public static long between(long min, long max) {
        if (min > max) {
            long aux = min;
            min = max;
            max = aux;
        }
        long startRange = min;
        if (startRange < Numbers.ZERO) {
            startRange = Numbers.ZERO;
        }      
        long endRange = Math.abs(max);
        if (max <= Numbers.ZERO) {
            endRange = Math.abs(min);
        }      
        long numale;
        do {
            numale = RandomUtils.nextLong(startRange, endRange + Numbers.ONE);
            if (RandomUtils.nextBoolean()) {
                numale = -numale;
            }
        } while (numale < min || numale > max);
        return numale;
    }

    public static double between(double min, double max) {
        if (min > max) {
            double aux = min;
            min = max;
            max = aux;
        }
        double numale;
        do {
            numale = RandomUtils.nextDouble(Numbers.ZERO, Math.abs(max)) * (max - min) + min;
            if (RandomUtils.nextBoolean()) {
                numale = -numale;
            }
        } while (numale < min || numale > max);
        return numale;
    }

    public static Boolean getBoolean() {
        return RandomUtils.nextBoolean();
    }

}

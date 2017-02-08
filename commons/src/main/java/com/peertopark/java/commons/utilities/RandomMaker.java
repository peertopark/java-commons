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

import java.util.Random;
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
        Random aleatorio = new Random();
        int numale;
        do {
            numale = aleatorio.nextInt(max + 1);
            if (aleatorio.nextBoolean()) {
                numale = -numale;
            }
        } while (numale < min);
        return numale;
    }

    public static long between(long min, long max) {
        if (min > max) {
            long aux = min;
            min = max;
            max = aux;
        }
        Random aleatorio = new Random();
        long numale;
        do {
            numale = aleatorio.nextLong();
            if (aleatorio.nextBoolean()) {
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
        Random aleatorio = new Random();
        double numale;
        do {
            numale = aleatorio.nextDouble() * (max - min) + min;
            if (aleatorio.nextBoolean()) {
                numale = -numale;
            }
        } while (numale < min || numale > max);
        return numale;
    }

    public static Boolean getBoolean() {
        return RandomUtils.nextBoolean();
    }

}

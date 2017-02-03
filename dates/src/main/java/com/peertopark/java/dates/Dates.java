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
package com.peertopark.java.dates;

import com.peertopark.java.commons.utilities.Objects;
import java.util.Date;
import org.joda.time.Duration;

/**
 *
 * @author hector
 */
public class Dates {
    
    public static final int SECONDS_IN_MONTH = 2592000;
    public static final int SECONDS_IN_WEEK = 604800;
    public static final int SECONDS_IN_DAY = 86400;
    public static final int SECONDS_IN_TWO_DAY = 172800;

    public static final int MINUTES_IN_HOUR = 60;
    public static final int SECONDS_IN_HOUR = 3600;

    public static final int SECONDS_IN_THREE_HOURS = 10800;

    public static final int DAYS_IN_MONTH = 30;
    
    public static final int FIVE_MIN_IN_MILLIS = 300000;
    public static final int THIRTY_MIN_IN_MILLIS = 1800000;
    public static final int THIRTY_MIN_IN_SECONDS = 1800;
    
    public static final int THIRTY_DAYS_IN_SECONDS = 2592000;
    
    
    /**
     * New Date
     *
     * @return
     */
    public static Date now() {
        return new Date();
    }
    
    
    /**
     * Get seconds from milliseconds
     *
     * @param milliseconds Milliseconds value
     * @return long Seconds
     */
    public static long getSecondsFromMillis(long milliseconds) {
        return Duration.millis(milliseconds).getStandardSeconds();
    }
    
    
    /**
     * Transforma un Date en un String con el valor Long del Date.
     *
     * @param fecha
     * @return
     */
    public static String transformDateToLongString(Date fecha) {
        if (Objects.isNull(fecha)) {
            return null;
        } else {
            return String.valueOf(fecha.getTime());
        }
    }
    
}

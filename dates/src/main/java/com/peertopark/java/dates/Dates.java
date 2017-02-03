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

import java.util.Date;
import org.joda.time.Duration;

/**
 *
 * @author hector
 */
public class Dates {
    
    
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
    
}

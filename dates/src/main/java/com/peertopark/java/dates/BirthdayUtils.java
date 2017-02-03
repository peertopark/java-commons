/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peertopark.java.dates;

import com.peertopark.java.commons.utilities.Numbers;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.Period;


/**
 *
 * @author hector
 */
public class BirthdayUtils {
    
    public static final int SPANISHADULT = 18;

    public static Date randomBrithday() {
        DateTime dateTime = DateTime.now();
        dateTime.minusYears(Numbers.THIRTY);
        return dateTime.toDate();
    }
    
    public static long randomBrithdaySeconds() {
        return Dates.getSecondsFromMillis(randomBrithday().getTime());
    }
    
    public static boolean isAdultInSpain(Date actualDate, Date birthday) {
        return isAdult(actualDate, birthday, SPANISHADULT);
    }
   
    public static boolean isAdult(Date actualDate, Date birthday, int yearsForAdult) {
        Period period = new Period(birthday.getTime(), actualDate.getTime());
        return period.getYears() >= yearsForAdult;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peertopark.java.commons.utilities;

import es.blackleg.java.utilities.Dates;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author hector
 */
public class DateUtils {
    
    public static final int SPANISHADULT = 18;

    public static Date dateNacimientoActualMayorDeEdad() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -25);
        return calendar.getTime();
    }
    
    public static long longSecondsFromNacimientoActualMayorDeEdad() {
        return Dates.getSecondsFromMillis(dateNacimientoActualMayorDeEdad().getTime());
    }
    
    public static boolean isAdultInSpain(Date actualDate, Date birthday) {
        return isAdult(Dates.toLocalDate(actualDate), Dates.toLocalDate(birthday), SPANISHADULT);
    }
    
    public static boolean isAdult(Date actualDate, Date birthday, int yearsForAdult) {
        return isAdult(Dates.toLocalDate(actualDate), Dates.toLocalDate(birthday), yearsForAdult);
    }
    
    public static boolean isAdult(LocalDate actualDate, LocalDate birthday, int yearsForAdult) {
        Period period = Period.between(birthday, actualDate);
        return period.getYears() >= yearsForAdult;
    }

}

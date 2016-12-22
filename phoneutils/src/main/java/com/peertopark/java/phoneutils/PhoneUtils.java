/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peertopark.java.phoneutils;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

/**
 *
 * @author hector
 */
public class PhoneUtils {
    
    public static final  String ESCODE = "ES";

    public static PhoneNumber getPhone(String phone, String code) throws NumberParseException {
        return PhoneNumberUtil.getInstance().parse(phone, code);
    }
    
    public static String formatWithCode(String phone) {
        return formatWithCode(phone, ESCODE);
    }

    public static String formatWithCode(String phone, String code) {
        try {
            PhoneNumber phoneNumber = getPhone(phone, code);
            return String.format("%s%s", phoneNumber.getCountryCode(), phoneNumber.getNationalNumber());
        } catch (NumberParseException ex) {
            return null;
        }
    }
    
}

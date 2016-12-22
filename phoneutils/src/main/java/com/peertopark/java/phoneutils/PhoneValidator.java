/*
 * Copyright 2016 Peer to Park.
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
package com.peertopark.java.phoneutils;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

/**
 *
 * @author hector
 */
public class PhoneValidator {

    /**
     * Valida un telefono movil de España Validate spanish mobile phone
     *
     * @param phone
     * @return
     */
    public static boolean validateSpanishMobilePhone(String phone) {
        return validateMobilePhone(phone, PhoneUtils.ESCODE);
    }

    /**
     * Validate mobile phone number
     *
     * @param phone
     * @param code
     * @return
     */
    public static boolean validateMobilePhone(String phone, String code) {
        return validatePhone(phone, code, PhoneNumberUtil.PhoneNumberType.MOBILE);
    }

    /**
     * Validate phone number
     *
     * @param phone Phone number
     * @param code Country Code
     * @param phoneNumberType Phone Type
     * @return True if number is valid
     */
    public static boolean validatePhone(String phone, String code, PhoneNumberUtil.PhoneNumberType phoneNumberType) {
        try {
            PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
            Phonenumber.PhoneNumber phoneNumber = phoneUtil.parse(phone, code);
            return phoneUtil.isValidNumberForRegion(phoneNumber, code) && phoneUtil.getNumberType(phoneNumber) == phoneNumberType;
        } catch (NumberParseException ex) {
            return false;
        }
    }

}

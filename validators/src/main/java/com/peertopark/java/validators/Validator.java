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
package com.peertopark.java.validators;

import es.blackleg.java.utilities.Objects;
import org.apache.commons.validator.routines.DateValidator;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.RegexValidator;
import org.apache.commons.validator.routines.UrlValidator;


/**
 *
 * @author Hector Espert
 */
public class Validator {
    
    public static final String ALFANUMERICSPACEREGEX = "^[a-zA-Z0-9 ]+$";
    
    public static RegexValidator getRegexValidator(String pattern) {
        return new RegexValidator(pattern, true);
    }
    
    public static RegexValidator getRegexValidatorNotCaseSensitive(String pattern) {
        return new RegexValidator(pattern, false);
    }
    
    public static boolean validateStringWithPattern(String string, String pattern) {
        return getRegexValidator(pattern).isValid(string);
    }
    
    public static boolean stringMaxLength(String string, int length) {
        return Objects.nonNull(string) &&  string.length() <= length;
    }
    
    public static boolean stringMinLength(String string, int length) {
        return Objects.nonNull(string) &&  string.length() >= length;
    }
    
    public static boolean validateDate(String date, String format) {
        return getDateValidator().isValid(date, format);
    }
    
    public static DateValidator getDateValidator() {
        return new DateValidator();
    }
    
    public static EmailValidator getEmailValidator() {
        return EmailValidator.getInstance();
    }
    
    public static boolean validateEmail(String email)  {
        return getEmailValidator().isValid(email); 
    }
    
    public static boolean stringLength(String string, int minLength, int maxLength) {
        return stringMinLength(string, minLength) && stringMaxLength(string, maxLength);
    }
    
    public static boolean onlyAlfaNumericOrSpace(String alfaNumeric) {
        return validateStringWithPattern(alfaNumeric, ALFANUMERICSPACEREGEX);
    }
    
    /**
     * Valdiate a URl
     * @param url
     * @return true is valid url
     */
    public static boolean validateUrl(String url) {
        UrlValidator urlValidator = UrlValidator.getInstance();
        return urlValidator.isValid(url);
    }
    
}

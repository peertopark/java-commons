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
package com.peertopark.java.commons.objects;

import com.peertopark.java.commons.interfaces.LoginInterface;
import com.peertopark.java.commons.utilities.Base64;
import es.blackleg.java.utilities.Numbers;
import es.blackleg.java.utilities.Objects;
import es.blackleg.java.utilities.Strings;

/**
 *
 * @author Hector Espert
 */
public class Login implements LoginInterface {
    
    private static final String BASICFILTER = "[B|b]asic ";
    private static final String BASICCONSTRUCTOR = "Basic %s";
    private static final String AUTHSTRINGCONSTRUCTOR = "%s:%s";
    
    private String user;
    private String passwd;

    public Login() {
    }

    public Login(String login, String passwd) {
        this.user = login;
        this.passwd = passwd;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String getPasswd() {
        return passwd;
    }

    @Override
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public static Login newLogin() {
        return new Login();
    }
    
    public static Login newLogin(String login, String passwd) {
        return new Login(login, passwd);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Login other = (Login) obj;
        if ((this.user == null) ? (other.user != null) : !this.user.equals(other.user)) {
            return false;
        }
        if ((this.passwd == null) ? (other.passwd != null) : !this.passwd.equals(other.passwd)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.user != null ? this.user.hashCode() : 0);
        hash = 97 * hash + (this.passwd != null ? this.passwd.hashCode() : 0);
        return hash;
    }

    
    
    @Override
    public void readBasic(String basicAuth) {
        if (Objects.nonNull(basicAuth)) {
            String cleanAuthString = removeBasicString(basicAuth);
            String decodedString = decodeBasicAuthString(cleanAuthString);
            String[] splitString = splitDecodedString(decodedString);
            readSplitString(splitString);
        }
    }
    
    private String removeBasicString(String basicAuth) {
        return basicAuth.replaceFirst(BASICFILTER, "");
    }
    
    private String decodeBasicAuthString(String basicAuth) {
        return Base64.decode(basicAuth);
    }
    
    private String[] splitDecodedString(String decodedString) {
        if (Objects.isNull(decodedString)) {
            return new String [Numbers.ZERO];
        } else {
            return decodedString.split(":", Numbers.TWO);
        }
    }
    
    private void readSplitString(String[] splitString) {
        if (splitString.length >= Numbers.TWO) {
            setPasswd(splitString[Numbers.ONE]);
        }
        if (splitString.length >= Numbers.ONE) {
            setUser(splitString[Numbers.ZERO]);
        }
    }  
    
    
    public static Login fromBasicAuth(String basicAuth) {
        Login login = Login.newLogin();
        login.readBasic(basicAuth);
        return login;
    }
    
    @Override
    public String toBasicAuth() {
        String authString = buildAuthString();
        String encodedAuthString = encodeAuthString(authString);
        return String.format(BASICCONSTRUCTOR, encodedAuthString);
    }
    
    
    private String encodeAuthString(String authString) {
        if (Objects.nonNull(authString)) {
            return Base64.encode(authString);
        } else {
            return "";
        }
    }
    
    private String buildAuthString() {
        if (Strings.checkIfIsNotEmptyOrNull(user) && Strings.checkIfIsNotEmptyOrNull(passwd)) {
            return String.format(AUTHSTRINGCONSTRUCTOR, user, passwd);
        } else {
            return ":";
        }
    }
    
}

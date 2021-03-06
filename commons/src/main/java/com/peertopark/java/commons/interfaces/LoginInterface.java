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
package com.peertopark.java.commons.interfaces;

/**
 *
 * @author Hector Espert
 */
public interface LoginInterface {

    public String getUser();

    public void setUser(String user);

    public String getPasswd();

    public void setPasswd(String passwd);

    /**
     * Transform login interface in Basic Auth String
     *
     * @return String Basic Auth Intergace
     */
    public String toBasicAuth();

    /**
     * Read Basic Auth String
     *
     * @param basicAuth Basic Auth String
     */
    public void readBasic(String basicAuth);

}

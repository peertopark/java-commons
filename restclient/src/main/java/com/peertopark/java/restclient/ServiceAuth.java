/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peertopark.java.restclient;

import com.peertopark.java.commons.objects.Login;


/**
 *
 * @author hector
 */
public class ServiceAuth extends Login {


    public ServiceAuth() {
        super();
    }

    public ServiceAuth(String auth, String passwd) {
        super(auth, passwd);
    }

    public static ServiceAuth newInstance() {
        return new ServiceAuth();
    }
    
    public static ServiceAuth newInstance(String auth, String passwd) {
        return new ServiceAuth(auth, passwd);
    }
    
}

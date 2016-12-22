/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peertopark.java.restclient;

/**
 *
 * @author hector
 */
public abstract class RestWorker extends Worker {
    
    private final ServiceClient serviceClient;

    public RestWorker() {
        this.serviceClient = ServiceClient.newInstance();
    }
    
    public RestWorker(ServiceAuth serviceAuth) {
        this.serviceClient = ServiceClient.newInstance(serviceAuth);
    }

    protected ServiceClient getServiceClient() {
        return serviceClient;
    }
    
    protected void initClient() {
        serviceClient.open();
    }
    
    protected void closeClient() {
        serviceClient.close();
    }
    
    protected void initClient(Integer timeout) {
        initClient();
        getServiceClient().setTimeOut(timeout);
    }

}

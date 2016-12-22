/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peertopark.java.restclient;

import es.blackleg.java.utilities.Objects;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

/**
 *
 * @author hector
 */
public class ServiceClient {

    private Client serviceClient;
    private ServiceAuth serviceAuth;

    public ServiceClient() {
    }

    public ServiceClient(ServiceAuth serviceAuth) {
        this.serviceAuth = serviceAuth;
    }

    /**
     * Open the client
     */
    public void open() {
        if (Objects.isNull(serviceClient)) {
            serviceClient = ClientBuilder.newClient();
        }
        if (Objects.nonNull(serviceAuth)) {
            serviceClient.register(makeAuth(serviceAuth));
        }
    }

    /**
     * Close client
     */
    public void close() {
        if (Objects.nonNull(serviceClient)) {
            serviceClient.close();
            serviceClient = null;
        }
    }

    public void setAndroidFriendly() {
        register(AndroidFriendlyFeature.build());
    }

    public boolean isOpen() {
        return Objects.nonNull(serviceClient);
    }

    /**
     * Register a object
     *
     * @param object
     */
    public void register(Object object) {
        if (Objects.nonNull(serviceClient)) {
            serviceClient.register(object);
        }
    }

    public void setAuth(ServiceAuth serviceAuth) {
        if (Objects.nonNull(serviceClient)) {
            serviceClient.register(makeAuth(serviceAuth));
        }
    }

    /**
     * Set property
     *
     * @param property
     * @param object
     */
    public void setProperty(String property, Object object) {
        if (Objects.nonNull(serviceClient)) {
            serviceClient.property(property, object);
        }
    }
    
    /**
     * Set client timeout
     * @param timeout Integer milliseconds
     */
    public void setTimeOut(Integer timeout) {
        setConnectionTimeOut(timeout);
        setReadTimeOut(timeout);
    }

    public void setConnectionTimeOut(Integer timeout) {
        if (Objects.nonNull(timeout)) {
            setProperty(ClientProperties.CONNECT_TIMEOUT, timeout);
        }
    }

    public void setReadTimeOut(Integer timeout) {
        if (Objects.nonNull(timeout)) {
            setProperty(ClientProperties.READ_TIMEOUT, timeout);
        }
    }

    /**
     * Get a WebTarget from Client
     *
     * @param targetUrl The service url
     * @param targetPath The service path
     * @return
     */
    public WebTarget getWebtarget(String targetUrl, String targetPath) {
        return serviceClient.target(targetUrl).path(targetPath);
    }

    /**
     * Get a WebTarget from Client
     *
     * @param targetUrl
     * @return
     */
    public WebTarget getWebtarget(String targetUrl) {
        return serviceClient.target(targetUrl);
    }

    public static ServiceClient newInstance() {
        return new ServiceClient();
    }

    public static ServiceClient newInstance(ServiceAuth auth) {
        return new ServiceClient(auth);
    }

    private HttpAuthenticationFeature makeAuth(ServiceAuth serviceAuth) {
        return HttpAuthenticationFeature.basic(serviceAuth.getUser(), serviceAuth.getPasswd());
    }

}

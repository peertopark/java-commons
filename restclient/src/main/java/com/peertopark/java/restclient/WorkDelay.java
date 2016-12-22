/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peertopark.java.restclient;

import es.blackleg.java.utilities.Numbers;
import es.blackleg.java.utilities.RandomMaker;

/**
 *
 * @author hector
 */
public class WorkDelay {
    
    private int mindelayseconds;
    private int maxdelayseconds;

    public WorkDelay() {
        this.mindelayseconds = Numbers.ZERO;
        this.maxdelayseconds = Numbers.ZERO;
    }

    public WorkDelay(int mindelayseconds, int maxdelayseconds) {
        this.mindelayseconds = mindelayseconds;
        this.maxdelayseconds = maxdelayseconds;
    }

    public int getMindelayseconds() {
        return mindelayseconds;
    }

    public void setMindelayseconds(int mindelayseconds) {
        this.mindelayseconds = mindelayseconds;
    }

    public int getMaxdelayseconds() {
        return maxdelayseconds;
    }

    public void setMaxdelayseconds(int maxdelayseconds) {
        this.maxdelayseconds = maxdelayseconds;
    }
    
    public static WorkDelay newInstance() {
        return new WorkDelay();
    }
    
    public static WorkDelay newInstance(int mindelayseconds, int maxdelayseconds) {
        return new WorkDelay(mindelayseconds, maxdelayseconds);
    }
    
    public int getDelay() {
        if (mindelayseconds > 0 && maxdelayseconds > 0) {
            return RandomMaker.between(mindelayseconds, maxdelayseconds);
        } else {
            return Numbers.ZERO;
        }
        
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peertopark.java.commons.objects;

/**
 *
 * @author hector
 */
public abstract class Worker extends Thread {
    
    
    @Override
    public void run() {
        makeWork();
    }

    protected abstract void makeWork();
    
}

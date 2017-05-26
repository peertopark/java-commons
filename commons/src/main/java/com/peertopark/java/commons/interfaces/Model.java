/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peertopark.java.commons.interfaces;

import java.util.Date;

/**
 *
 * @author hector
 */
public interface Model {

    public Integer getId();
    
    public Date getCreationDate();
    
    public boolean isNewModel();
    
}

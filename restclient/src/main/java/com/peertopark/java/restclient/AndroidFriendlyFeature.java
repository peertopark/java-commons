/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peertopark.java.restclient;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import org.glassfish.hk2.api.Descriptor;
import org.glassfish.hk2.api.Filter;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

/**
 *
 * @author hector
 */
public class AndroidFriendlyFeature extends AbstractBinder implements Feature, Filter {
    
    public static AndroidFriendlyFeature build() {
        return new AndroidFriendlyFeature();
    }

    @Override
    public boolean configure(FeatureContext featureContext) {
        if (!featureContext.getConfiguration().isRegistered(AndroidFriendlyFeature.class)) {
            featureContext.register(AndroidFriendlyFeature.class);
        }
        return true;
    }

    @Override
    protected void configure() {
        addUnbindFilter(this);
    }

    @Override
    public boolean matches(Descriptor d) {
        String implClass = d.getImplementation();
        return implClass.startsWith("org.glassfish.jersey.message.internal.DataSource") || implClass.startsWith("org.glassfish.jersey.message.internal.RenderedImage");
    }
    
}

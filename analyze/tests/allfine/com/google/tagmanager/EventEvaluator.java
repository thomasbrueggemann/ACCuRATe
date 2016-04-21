package com.google.tagmanager;

import com.google.tagmanager.ResourceUtil;
import com.google.tagmanager.Runtime;

class EventEvaluator {
    private final ResourceUtil.ExpandedResource mResource;
    private final Runtime mRuntime;

    public EventEvaluator(Runtime var1, ResourceUtil.ExpandedResource var2) {
        if(var1 == null) {
            throw new NullPointerException("runtime cannot be null");
        } else {
            this.mRuntime = var1;
            if(var2 != var1.getResource()) {
                throw new IllegalArgumentException("resource must be the same as the resource in runtime");
            } else {
                this.mResource = var1.getResource();
            }
        }
    }

    void evaluateEvent(String var1) {
        throw new UnsupportedOperationException("this code not yet written");
    }
}

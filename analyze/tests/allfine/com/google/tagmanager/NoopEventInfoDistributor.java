package com.google.tagmanager;

import com.google.tagmanager.EventInfoBuilder;
import com.google.tagmanager.EventInfoDistributor;
import com.google.tagmanager.NoopEventInfoBuilder;

class NoopEventInfoDistributor implements EventInfoDistributor {
    public EventInfoBuilder createDataLayerEventEvaluationEventInfo(String var1) {
        return new NoopEventInfoBuilder();
    }

    public EventInfoBuilder createMacroEvalutionEventInfo(String var1) {
        return new NoopEventInfoBuilder();
    }

    public boolean debugMode() {
        return false;
    }
}

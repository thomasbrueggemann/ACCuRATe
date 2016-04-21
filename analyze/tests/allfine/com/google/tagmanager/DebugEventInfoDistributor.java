package com.google.tagmanager;

import com.google.tagmanager.DebugEventInfoBuilder;
import com.google.tagmanager.DebugInformationHandler;
import com.google.tagmanager.EventInfoBuilder;
import com.google.tagmanager.EventInfoDistributor;

class DebugEventInfoDistributor implements EventInfoDistributor {
    private String containerId;
    private String containerVersion;
    private DebugInformationHandler handler;

    public DebugEventInfoDistributor(DebugInformationHandler var1, String var2, String var3) {
        this.handler = var1;
        this.containerVersion = var2;
        this.containerId = var3;
    }

    public EventInfoBuilder createDataLayerEventEvaluationEventInfo(String var1) {
        return new DebugEventInfoBuilder(1, this.containerVersion, this.containerId, var1, this.handler);
    }

    public EventInfoBuilder createMacroEvalutionEventInfo(String var1) {
        return new DebugEventInfoBuilder(2, this.containerVersion, this.containerId, var1, this.handler);
    }

    public boolean debugMode() {
        return true;
    }
}

package com.google.tagmanager;

import com.google.analytics.containertag.proto.Debug;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.DataLayerEventEvaluationInfoBuilder;
import com.google.tagmanager.DebugDataLayerEventEvaluationInfoBuilder;
import com.google.tagmanager.DebugInformationHandler;
import com.google.tagmanager.DebugMacroEvaluationInfoBuilder;
import com.google.tagmanager.EventInfoBuilder;
import com.google.tagmanager.MacroEvaluationInfoBuilder;

class DebugEventInfoBuilder implements EventInfoBuilder {
    private DebugDataLayerEventEvaluationInfoBuilder dataLayerEventBuilder;
    @VisibleForTesting
    Debug.EventInfo eventInfoBuilder = new Debug.EventInfo();
    private DebugInformationHandler handler;
    private DebugMacroEvaluationInfoBuilder macroBuilder;

    public DebugEventInfoBuilder(int var1, String var2, String var3, String var4, DebugInformationHandler var5) {
        this.eventInfoBuilder.eventType = var1;
        this.eventInfoBuilder.containerVersion = var2;
        this.eventInfoBuilder.containerId = var3;
        this.eventInfoBuilder.key = var4;
        this.handler = var5;
        if(var1 == 1) {
            this.eventInfoBuilder.dataLayerEventResult = new Debug.DataLayerEventEvaluationInfo();
            this.dataLayerEventBuilder = new DebugDataLayerEventEvaluationInfoBuilder(this.eventInfoBuilder.dataLayerEventResult);
        } else {
            this.eventInfoBuilder.macroResult = new Debug.MacroEvaluationInfo();
            this.macroBuilder = new DebugMacroEvaluationInfoBuilder(this.eventInfoBuilder.macroResult);
        }
    }

    public DataLayerEventEvaluationInfoBuilder createDataLayerEventEvaluationInfoBuilder() {
        return this.dataLayerEventBuilder;
    }

    public MacroEvaluationInfoBuilder createMacroEvaluationInfoBuilder() {
        return this.macroBuilder;
    }

    public void processEventInfo() {
        this.handler.receiveEventInfo(this.eventInfoBuilder);
    }
}

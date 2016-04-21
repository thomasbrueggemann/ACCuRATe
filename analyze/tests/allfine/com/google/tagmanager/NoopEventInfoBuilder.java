package com.google.tagmanager;

import com.google.tagmanager.DataLayerEventEvaluationInfoBuilder;
import com.google.tagmanager.EventInfoBuilder;
import com.google.tagmanager.MacroEvaluationInfoBuilder;
import com.google.tagmanager.NoopDataLayerEventEvaluationInfoBuilder;
import com.google.tagmanager.NoopMacroEvaluationInfoBuilder;

class NoopEventInfoBuilder implements EventInfoBuilder {
    public DataLayerEventEvaluationInfoBuilder createDataLayerEventEvaluationInfoBuilder() {
        return new NoopDataLayerEventEvaluationInfoBuilder();
    }

    public MacroEvaluationInfoBuilder createMacroEvaluationInfoBuilder() {
        return new NoopMacroEvaluationInfoBuilder();
    }

    public void processEventInfo() {
    }
}

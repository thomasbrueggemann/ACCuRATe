package com.google.tagmanager;

import com.google.tagmanager.DataLayerEventEvaluationInfoBuilder;
import com.google.tagmanager.MacroEvaluationInfoBuilder;

interface EventInfoBuilder {
    DataLayerEventEvaluationInfoBuilder createDataLayerEventEvaluationInfoBuilder();

    MacroEvaluationInfoBuilder createMacroEvaluationInfoBuilder();

    void processEventInfo();
}

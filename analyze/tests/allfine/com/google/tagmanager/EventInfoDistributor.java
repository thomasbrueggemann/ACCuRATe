package com.google.tagmanager;

import com.google.tagmanager.EventInfoBuilder;

interface EventInfoDistributor {
    EventInfoBuilder createDataLayerEventEvaluationEventInfo(String var1);

    EventInfoBuilder createMacroEvalutionEventInfo(String var1);

    boolean debugMode();
}

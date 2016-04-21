package com.google.tagmanager;

import com.google.tagmanager.MacroEvaluationInfoBuilder;
import com.google.tagmanager.NoopMacroEvaluationInfoBuilder;
import com.google.tagmanager.ValueBuilder;

class NoopValueBuilder implements ValueBuilder {
    public MacroEvaluationInfoBuilder createValueMacroEvaluationInfoExtension() {
        return new NoopMacroEvaluationInfoBuilder();
    }

    public ValueBuilder getListItem(int var1) {
        return new NoopValueBuilder();
    }

    public ValueBuilder getMapKey(int var1) {
        return new NoopValueBuilder();
    }

    public ValueBuilder getMapValue(int var1) {
        return new NoopValueBuilder();
    }

    public ValueBuilder getTemplateToken(int var1) {
        return new NoopValueBuilder();
    }
}

package com.google.tagmanager;

import com.google.tagmanager.MacroEvaluationInfoBuilder;

interface ValueBuilder {
    MacroEvaluationInfoBuilder createValueMacroEvaluationInfoExtension();

    ValueBuilder getListItem(int var1);

    ValueBuilder getMapKey(int var1);

    ValueBuilder getMapValue(int var1);

    ValueBuilder getTemplateToken(int var1);
}

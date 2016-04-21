package com.google.tagmanager;

import com.google.analytics.containertag.proto.Debug;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.DebugMacroEvaluationInfoBuilder;
import com.google.tagmanager.Log;
import com.google.tagmanager.MacroEvaluationInfoBuilder;
import com.google.tagmanager.ValueBuilder;
import com.google.tagmanager.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.tagmanager.protobuf.nano.MessageNano;

class DebugValueBuilder implements ValueBuilder {
    private TypeSystem.Value value;

    public DebugValueBuilder(TypeSystem.Value var1) {
        this.value = var1;
    }

    public static TypeSystem.Value copyImmutableValue(TypeSystem.Value var0) {
        TypeSystem.Value var1 = new TypeSystem.Value();

        try {
            MessageNano.mergeFrom(var1, MessageNano.toByteArray(var0));
            return var1;
        } catch (InvalidProtocolBufferNanoException var3) {
            Log.method_5503("Failed to copy runtime value into debug value");
            return var1;
        }
    }

    private void validateType(int var1, int var2, String var3) {
        if(var1 != var2) {
            throw new DebugValueBuilder.TypeMismatchException(var3, var2);
        }
    }

    public MacroEvaluationInfoBuilder createValueMacroEvaluationInfoExtension() {
        this.validateType(4, this.value.type, "set macro evaluation extension");
        Debug.MacroEvaluationInfo var1 = new Debug.MacroEvaluationInfo();
        this.value.setExtension(Debug.MacroEvaluationInfo.macro, var1);
        return new DebugMacroEvaluationInfoBuilder(var1);
    }

    public ValueBuilder getListItem(int var1) {
        this.validateType(2, this.value.type, "add new list item");
        return new DebugValueBuilder(this.value.listItem[var1]);
    }

    public ValueBuilder getMapKey(int var1) {
        this.validateType(3, this.value.type, "add new map key");
        return new DebugValueBuilder(this.value.mapKey[var1]);
    }

    public ValueBuilder getMapValue(int var1) {
        this.validateType(3, this.value.type, "add new map value");
        return new DebugValueBuilder(this.value.mapValue[var1]);
    }

    public ValueBuilder getTemplateToken(int var1) {
        this.validateType(7, this.value.type, "add template token");
        return new DebugValueBuilder(this.value.templateToken[var1]);
    }

    private static class TypeMismatchException extends IllegalStateException {
        public TypeMismatchException(String var1, int var2) {
            super("Attempted operation: " + var1 + " on object of type: " + var2);
        }
    }
}

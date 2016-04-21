package com.google.analytics.containertag.proto;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.protobuf.nano.CodedInputByteBufferNano;
import com.google.tagmanager.protobuf.nano.CodedOutputByteBufferNano;
import com.google.tagmanager.protobuf.nano.ExtendableMessageNano;
import com.google.tagmanager.protobuf.nano.Extension;
import com.google.tagmanager.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.tagmanager.protobuf.nano.MessageNano;
import com.google.tagmanager.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Debug {
    public static final class DataLayerEventEvaluationInfo extends ExtendableMessageNano {
        public static final Debug.DataLayerEventEvaluationInfo[] EMPTY_ARRAY = new Debug.DataLayerEventEvaluationInfo[0];
        public Debug.ResolvedFunctionCall[] results;
        public Debug.RuleEvaluationStepInfo rulesEvaluation = null;

        public DataLayerEventEvaluationInfo() {
            this.results = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
        }

        public static Debug.DataLayerEventEvaluationInfo parseFrom(CodedInputByteBufferNano var0) throws IOException {
            return (new Debug.DataLayerEventEvaluationInfo()).mergeFrom(var0);
        }

        public static Debug.DataLayerEventEvaluationInfo parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
            return (Debug.DataLayerEventEvaluationInfo)MessageNano.mergeFrom(new Debug.DataLayerEventEvaluationInfo(), var0);
        }

        public final Debug.DataLayerEventEvaluationInfo clear() {
            this.rulesEvaluation = null;
            this.results = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final boolean equals(Object var1) {
            if(var1 != this) {
                if(!(var1 instanceof Debug.DataLayerEventEvaluationInfo)) {
                    return false;
                } else {
                    Debug.DataLayerEventEvaluationInfo var2 = (Debug.DataLayerEventEvaluationInfo)var1;
                    if(this.rulesEvaluation == null) {
                        if(var2.rulesEvaluation != null) {
                            return false;
                        }
                    } else if(!this.rulesEvaluation.equals(var2.rulesEvaluation)) {
                        return false;
                    }

                    if(Arrays.equals(this.results, var2.results)) {
                        if(this.unknownFieldData == null) {
                            if(var2.unknownFieldData == null) {
                                return true;
                            }
                        } else if(this.unknownFieldData.equals(var2.unknownFieldData)) {
                            return true;
                        }
                    }

                    return false;
                }
            } else {
                return true;
            }
        }

        public int getSerializedSize() {
            Debug.RuleEvaluationStepInfo var1 = this.rulesEvaluation;
            int var2 = 0;
            if(var1 != null) {
                var2 = 0 + CodedOutputByteBufferNano.computeMessageSize(1, this.rulesEvaluation);
            }

            if(this.results != null) {
                Debug.ResolvedFunctionCall[] var4 = this.results;
                int var5 = var4.length;

                for(int var6 = 0; var6 < var5; ++var6) {
                    var2 += CodedOutputByteBufferNano.computeMessageSize(2, var4[var6]);
                }
            }

            int var3 = var2 + WireFormatNano.computeWireSize(this.unknownFieldData);
            this.cachedSize = var3;
            return var3;
        }

        public int hashCode() {
            int var1;
            if(this.rulesEvaluation == null) {
                var1 = 0;
            } else {
                var1 = this.rulesEvaluation.hashCode();
            }

            int var2 = var1 + 527;
            if(this.results == null) {
                var2 *= 31;
            } else {
                for(int var3 = 0; var3 < this.results.length; ++var3) {
                    int var4 = var2 * 31;
                    int var5;
                    if(this.results[var3] == null) {
                        var5 = 0;
                    } else {
                        var5 = this.results[var3].hashCode();
                    }

                    var2 = var4 + var5;
                }
            }

            int var6 = var2 * 31;
            List var7 = this.unknownFieldData;
            int var8 = 0;
            if(var7 != null) {
                var8 = this.unknownFieldData.hashCode();
            }

            return var6 + var8;
        }

        public Debug.DataLayerEventEvaluationInfo mergeFrom(CodedInputByteBufferNano var1) throws IOException {
            while(true) {
                int var2 = var1.readTag();
                switch(var2) {
                    case 10:
                        this.rulesEvaluation = new Debug.RuleEvaluationStepInfo();
                        var1.readMessage(this.rulesEvaluation);
                        break;
                    case 18:
                        int var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 18);
                        int var4;
                        if(this.results == null) {
                            var4 = 0;
                        } else {
                            var4 = this.results.length;
                        }

                        Debug.ResolvedFunctionCall[] var5 = new Debug.ResolvedFunctionCall[var4 + var3];
                        if(this.results != null) {
                            System.arraycopy(this.results, 0, var5, 0, var4);
                        }

                        for(this.results = var5; var4 < -1 + this.results.length; ++var4) {
                            this.results[var4] = new Debug.ResolvedFunctionCall();
                            var1.readMessage(this.results[var4]);
                            var1.readTag();
                        }

                        this.results[var4] = new Debug.ResolvedFunctionCall();
                        var1.readMessage(this.results[var4]);
                        break;
                    default:
                        if(this.unknownFieldData == null) {
                            this.unknownFieldData = new ArrayList();
                        }

                        if(WireFormatNano.storeUnknownField(this.unknownFieldData, var1, var2)) {
                            break;
                        }
                    case 0:
                        return this;
                }
            }
        }

        public void writeTo(CodedOutputByteBufferNano var1) throws IOException {
            if(this.rulesEvaluation != null) {
                var1.writeMessage(1, this.rulesEvaluation);
            }

            if(this.results != null) {
                Debug.ResolvedFunctionCall[] var2 = this.results;
                int var3 = var2.length;

                for(int var4 = 0; var4 < var3; ++var4) {
                    var1.writeMessage(2, var2[var4]);
                }
            }

            WireFormatNano.writeUnknownFields(this.unknownFieldData, var1);
        }
    }

    public static final class DebugEvents extends ExtendableMessageNano {
        public static final Debug.DebugEvents[] EMPTY_ARRAY = new Debug.DebugEvents[0];
        public Debug.EventInfo[] event;

        public DebugEvents() {
            this.event = Debug.EventInfo.EMPTY_ARRAY;
        }

        public static Debug.DebugEvents parseFrom(CodedInputByteBufferNano var0) throws IOException {
            return (new Debug.DebugEvents()).mergeFrom(var0);
        }

        public static Debug.DebugEvents parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
            return (Debug.DebugEvents)MessageNano.mergeFrom(new Debug.DebugEvents(), var0);
        }

        public final Debug.DebugEvents clear() {
            this.event = Debug.EventInfo.EMPTY_ARRAY;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final boolean equals(Object var1) {
            if(var1 != this) {
                if(!(var1 instanceof Debug.DebugEvents)) {
                    return false;
                } else {
                    Debug.DebugEvents var2 = (Debug.DebugEvents)var1;
                    if(Arrays.equals(this.event, var2.event)) {
                        if(this.unknownFieldData == null) {
                            if(var2.unknownFieldData == null) {
                                return true;
                            }
                        } else if(this.unknownFieldData.equals(var2.unknownFieldData)) {
                            return true;
                        }
                    }

                    return false;
                }
            } else {
                return true;
            }
        }

        public int getSerializedSize() {
            Debug.EventInfo[] var1 = this.event;
            int var2 = 0;
            if(var1 != null) {
                Debug.EventInfo[] var4 = this.event;
                int var5 = var4.length;

                for(int var6 = 0; var6 < var5; ++var6) {
                    var2 += CodedOutputByteBufferNano.computeMessageSize(1, var4[var6]);
                }
            }

            int var3 = var2 + WireFormatNano.computeWireSize(this.unknownFieldData);
            this.cachedSize = var3;
            return var3;
        }

        public int hashCode() {
            int var1 = 17;
            if(this.event == null) {
                var1 *= 31;
            } else {
                for(int var2 = 0; var2 < this.event.length; ++var2) {
                    int var3 = var1 * 31;
                    int var4;
                    if(this.event[var2] == null) {
                        var4 = 0;
                    } else {
                        var4 = this.event[var2].hashCode();
                    }

                    var1 = var3 + var4;
                }
            }

            int var5 = var1 * 31;
            List var6 = this.unknownFieldData;
            int var7 = 0;
            if(var6 != null) {
                var7 = this.unknownFieldData.hashCode();
            }

            return var5 + var7;
        }

        public Debug.DebugEvents mergeFrom(CodedInputByteBufferNano var1) throws IOException {
            while(true) {
                int var2 = var1.readTag();
                switch(var2) {
                    case 10:
                        int var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 10);
                        int var4;
                        if(this.event == null) {
                            var4 = 0;
                        } else {
                            var4 = this.event.length;
                        }

                        Debug.EventInfo[] var5 = new Debug.EventInfo[var4 + var3];
                        if(this.event != null) {
                            System.arraycopy(this.event, 0, var5, 0, var4);
                        }

                        for(this.event = var5; var4 < -1 + this.event.length; ++var4) {
                            this.event[var4] = new Debug.EventInfo();
                            var1.readMessage(this.event[var4]);
                            var1.readTag();
                        }

                        this.event[var4] = new Debug.EventInfo();
                        var1.readMessage(this.event[var4]);
                        break;
                    default:
                        if(this.unknownFieldData == null) {
                            this.unknownFieldData = new ArrayList();
                        }

                        if(WireFormatNano.storeUnknownField(this.unknownFieldData, var1, var2)) {
                            break;
                        }
                    case 0:
                        return this;
                }
            }
        }

        public void writeTo(CodedOutputByteBufferNano var1) throws IOException {
            if(this.event != null) {
                Debug.EventInfo[] var2 = this.event;
                int var3 = var2.length;

                for(int var4 = 0; var4 < var3; ++var4) {
                    var1.writeMessage(1, var2[var4]);
                }
            }

            WireFormatNano.writeUnknownFields(this.unknownFieldData, var1);
        }
    }

    public static final class EventInfo extends ExtendableMessageNano {
        public static final Debug.EventInfo[] EMPTY_ARRAY = new Debug.EventInfo[0];
        public String containerId = "";
        public String containerVersion = "";
        public Debug.DataLayerEventEvaluationInfo dataLayerEventResult = null;
        public int eventType = 1;
        public String key = "";
        public Debug.MacroEvaluationInfo macroResult = null;

        public static Debug.EventInfo parseFrom(CodedInputByteBufferNano var0) throws IOException {
            return (new Debug.EventInfo()).mergeFrom(var0);
        }

        public static Debug.EventInfo parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
            return (Debug.EventInfo)MessageNano.mergeFrom(new Debug.EventInfo(), var0);
        }

        public final Debug.EventInfo clear() {
            this.eventType = 1;
            this.containerVersion = "";
            this.containerId = "";
            this.key = "";
            this.macroResult = null;
            this.dataLayerEventResult = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final boolean equals(Object var1) {
            if(var1 != this) {
                if(!(var1 instanceof Debug.EventInfo)) {
                    return false;
                } else {
                    Debug.EventInfo var2 = (Debug.EventInfo)var1;
                    if(this.eventType == var2.eventType) {
                        if(this.containerVersion == null) {
                            if(var2.containerVersion != null) {
                                return false;
                            }
                        } else if(!this.containerVersion.equals(var2.containerVersion)) {
                            return false;
                        }

                        if(this.containerId == null) {
                            if(var2.containerId != null) {
                                return false;
                            }
                        } else if(!this.containerId.equals(var2.containerId)) {
                            return false;
                        }

                        if(this.key == null) {
                            if(var2.key != null) {
                                return false;
                            }
                        } else if(!this.key.equals(var2.key)) {
                            return false;
                        }

                        if(this.macroResult == null) {
                            if(var2.macroResult != null) {
                                return false;
                            }
                        } else if(!this.macroResult.equals(var2.macroResult)) {
                            return false;
                        }

                        if(this.dataLayerEventResult == null) {
                            if(var2.dataLayerEventResult != null) {
                                return false;
                            }
                        } else if(!this.dataLayerEventResult.equals(var2.dataLayerEventResult)) {
                            return false;
                        }

                        if(this.unknownFieldData == null) {
                            if(var2.unknownFieldData == null) {
                                return true;
                            }
                        } else if(this.unknownFieldData.equals(var2.unknownFieldData)) {
                            return true;
                        }
                    }

                    return false;
                }
            } else {
                return true;
            }
        }

        public int getSerializedSize() {
            int var1 = this.eventType;
            int var2 = 0;
            if(var1 != 1) {
                var2 = 0 + CodedOutputByteBufferNano.computeInt32Size(1, this.eventType);
            }

            if(!this.containerVersion.equals("")) {
                var2 += CodedOutputByteBufferNano.computeStringSize(2, this.containerVersion);
            }

            if(!this.containerId.equals("")) {
                var2 += CodedOutputByteBufferNano.computeStringSize(3, this.containerId);
            }

            if(!this.key.equals("")) {
                var2 += CodedOutputByteBufferNano.computeStringSize(4, this.key);
            }

            if(this.macroResult != null) {
                var2 += CodedOutputByteBufferNano.computeMessageSize(6, this.macroResult);
            }

            if(this.dataLayerEventResult != null) {
                var2 += CodedOutputByteBufferNano.computeMessageSize(7, this.dataLayerEventResult);
            }

            int var3 = var2 + WireFormatNano.computeWireSize(this.unknownFieldData);
            this.cachedSize = var3;
            return var3;
        }

        public int hashCode() {
            int var1 = 31 * (527 + this.eventType);
            int var2;
            if(this.containerVersion == null) {
                var2 = 0;
            } else {
                var2 = this.containerVersion.hashCode();
            }

            int var3 = 31 * (var1 + var2);
            int var4;
            if(this.containerId == null) {
                var4 = 0;
            } else {
                var4 = this.containerId.hashCode();
            }

            int var5 = 31 * (var3 + var4);
            int var6;
            if(this.key == null) {
                var6 = 0;
            } else {
                var6 = this.key.hashCode();
            }

            int var7 = 31 * (var5 + var6);
            int var8;
            if(this.macroResult == null) {
                var8 = 0;
            } else {
                var8 = this.macroResult.hashCode();
            }

            int var9 = 31 * (var7 + var8);
            int var10;
            if(this.dataLayerEventResult == null) {
                var10 = 0;
            } else {
                var10 = this.dataLayerEventResult.hashCode();
            }

            int var11 = 31 * (var9 + var10);
            List var12 = this.unknownFieldData;
            int var13 = 0;
            if(var12 != null) {
                var13 = this.unknownFieldData.hashCode();
            }

            return var11 + var13;
        }

        public Debug.EventInfo mergeFrom(CodedInputByteBufferNano var1) throws IOException {
            while(true) {
                int var2 = var1.readTag();
                switch(var2) {
                    case 8:
                        int var3 = var1.readInt32();
                        if(var3 != 1 && var3 != 2) {
                            this.eventType = 1;
                            break;
                        }

                        this.eventType = var3;
                        break;
                    case 18:
                        this.containerVersion = var1.readString();
                        break;
                    case 26:
                        this.containerId = var1.readString();
                        break;
                    case 34:
                        this.key = var1.readString();
                        break;
                    case 50:
                        this.macroResult = new Debug.MacroEvaluationInfo();
                        var1.readMessage(this.macroResult);
                        break;
                    case 58:
                        this.dataLayerEventResult = new Debug.DataLayerEventEvaluationInfo();
                        var1.readMessage(this.dataLayerEventResult);
                        break;
                    default:
                        if(this.unknownFieldData == null) {
                            this.unknownFieldData = new ArrayList();
                        }

                        if(WireFormatNano.storeUnknownField(this.unknownFieldData, var1, var2)) {
                            break;
                        }
                    case 0:
                        return this;
                }
            }
        }

        public void writeTo(CodedOutputByteBufferNano var1) throws IOException {
            if(this.eventType != 1) {
                var1.writeInt32(1, this.eventType);
            }

            if(!this.containerVersion.equals("")) {
                var1.writeString(2, this.containerVersion);
            }

            if(!this.containerId.equals("")) {
                var1.writeString(3, this.containerId);
            }

            if(!this.key.equals("")) {
                var1.writeString(4, this.key);
            }

            if(this.macroResult != null) {
                var1.writeMessage(6, this.macroResult);
            }

            if(this.dataLayerEventResult != null) {
                var1.writeMessage(7, this.dataLayerEventResult);
            }

            WireFormatNano.writeUnknownFields(this.unknownFieldData, var1);
        }
    }

    public interface EventType {
        int DATA_LAYER_EVENT = 1;
        int MACRO_REFERENCE = 2;
    }

    public static final class MacroEvaluationInfo extends ExtendableMessageNano {
        public static final Debug.MacroEvaluationInfo[] EMPTY_ARRAY = new Debug.MacroEvaluationInfo[0];
        public static final Extension<Debug.MacroEvaluationInfo> macro = Extension.create(47497405, new Extension.TypeLiteral() {
        });
        public Debug.ResolvedFunctionCall result = null;
        public Debug.RuleEvaluationStepInfo rulesEvaluation = null;

        public static Debug.MacroEvaluationInfo parseFrom(CodedInputByteBufferNano var0) throws IOException {
            return (new Debug.MacroEvaluationInfo()).mergeFrom(var0);
        }

        public static Debug.MacroEvaluationInfo parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
            return (Debug.MacroEvaluationInfo)MessageNano.mergeFrom(new Debug.MacroEvaluationInfo(), var0);
        }

        public final Debug.MacroEvaluationInfo clear() {
            this.rulesEvaluation = null;
            this.result = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final boolean equals(Object var1) {
            if(var1 != this) {
                if(!(var1 instanceof Debug.MacroEvaluationInfo)) {
                    return false;
                } else {
                    Debug.MacroEvaluationInfo var2 = (Debug.MacroEvaluationInfo)var1;
                    if(this.rulesEvaluation == null) {
                        if(var2.rulesEvaluation != null) {
                            return false;
                        }
                    } else if(!this.rulesEvaluation.equals(var2.rulesEvaluation)) {
                        return false;
                    }

                    if(this.result == null) {
                        if(var2.result != null) {
                            return false;
                        }
                    } else if(!this.result.equals(var2.result)) {
                        return false;
                    }

                    if(this.unknownFieldData == null) {
                        if(var2.unknownFieldData == null) {
                            return true;
                        }
                    } else if(this.unknownFieldData.equals(var2.unknownFieldData)) {
                        return true;
                    }

                    return false;
                }
            } else {
                return true;
            }
        }

        public int getSerializedSize() {
            Debug.RuleEvaluationStepInfo var1 = this.rulesEvaluation;
            int var2 = 0;
            if(var1 != null) {
                var2 = 0 + CodedOutputByteBufferNano.computeMessageSize(1, this.rulesEvaluation);
            }

            if(this.result != null) {
                var2 += CodedOutputByteBufferNano.computeMessageSize(3, this.result);
            }

            int var3 = var2 + WireFormatNano.computeWireSize(this.unknownFieldData);
            this.cachedSize = var3;
            return var3;
        }

        public int hashCode() {
            int var1;
            if(this.rulesEvaluation == null) {
                var1 = 0;
            } else {
                var1 = this.rulesEvaluation.hashCode();
            }

            int var2 = 31 * (var1 + 527);
            int var3;
            if(this.result == null) {
                var3 = 0;
            } else {
                var3 = this.result.hashCode();
            }

            int var4 = 31 * (var2 + var3);
            List var5 = this.unknownFieldData;
            int var6 = 0;
            if(var5 != null) {
                var6 = this.unknownFieldData.hashCode();
            }

            return var4 + var6;
        }

        public Debug.MacroEvaluationInfo mergeFrom(CodedInputByteBufferNano var1) throws IOException {
            while(true) {
                int var2 = var1.readTag();
                switch(var2) {
                    case 10:
                        this.rulesEvaluation = new Debug.RuleEvaluationStepInfo();
                        var1.readMessage(this.rulesEvaluation);
                        break;
                    case 26:
                        this.result = new Debug.ResolvedFunctionCall();
                        var1.readMessage(this.result);
                        break;
                    default:
                        if(this.unknownFieldData == null) {
                            this.unknownFieldData = new ArrayList();
                        }

                        if(WireFormatNano.storeUnknownField(this.unknownFieldData, var1, var2)) {
                            break;
                        }
                    case 0:
                        return this;
                }
            }
        }

        public void writeTo(CodedOutputByteBufferNano var1) throws IOException {
            if(this.rulesEvaluation != null) {
                var1.writeMessage(1, this.rulesEvaluation);
            }

            if(this.result != null) {
                var1.writeMessage(3, this.result);
            }

            WireFormatNano.writeUnknownFields(this.unknownFieldData, var1);
        }
    }

    public static final class ResolvedFunctionCall extends ExtendableMessageNano {
        public static final Debug.ResolvedFunctionCall[] EMPTY_ARRAY = new Debug.ResolvedFunctionCall[0];
        public String associatedRuleName;
        public Debug.ResolvedProperty[] properties;
        public TypeSystem.Value result;

        public ResolvedFunctionCall() {
            this.properties = Debug.ResolvedProperty.EMPTY_ARRAY;
            this.result = null;
            this.associatedRuleName = "";
        }

        public static Debug.ResolvedFunctionCall parseFrom(CodedInputByteBufferNano var0) throws IOException {
            return (new Debug.ResolvedFunctionCall()).mergeFrom(var0);
        }

        public static Debug.ResolvedFunctionCall parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
            return (Debug.ResolvedFunctionCall)MessageNano.mergeFrom(new Debug.ResolvedFunctionCall(), var0);
        }

        public final Debug.ResolvedFunctionCall clear() {
            this.properties = Debug.ResolvedProperty.EMPTY_ARRAY;
            this.result = null;
            this.associatedRuleName = "";
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final boolean equals(Object var1) {
            if(var1 != this) {
                if(!(var1 instanceof Debug.ResolvedFunctionCall)) {
                    return false;
                } else {
                    Debug.ResolvedFunctionCall var2 = (Debug.ResolvedFunctionCall)var1;
                    if(Arrays.equals(this.properties, var2.properties)) {
                        if(this.result == null) {
                            if(var2.result != null) {
                                return false;
                            }
                        } else if(!this.result.equals(var2.result)) {
                            return false;
                        }

                        if(this.associatedRuleName == null) {
                            if(var2.associatedRuleName != null) {
                                return false;
                            }
                        } else if(!this.associatedRuleName.equals(var2.associatedRuleName)) {
                            return false;
                        }

                        if(this.unknownFieldData == null) {
                            if(var2.unknownFieldData == null) {
                                return true;
                            }
                        } else if(this.unknownFieldData.equals(var2.unknownFieldData)) {
                            return true;
                        }
                    }

                    return false;
                }
            } else {
                return true;
            }
        }

        public int getSerializedSize() {
            Debug.ResolvedProperty[] var1 = this.properties;
            int var2 = 0;
            if(var1 != null) {
                Debug.ResolvedProperty[] var4 = this.properties;
                int var5 = var4.length;

                for(int var6 = 0; var6 < var5; ++var6) {
                    var2 += CodedOutputByteBufferNano.computeMessageSize(1, var4[var6]);
                }
            }

            if(this.result != null) {
                var2 += CodedOutputByteBufferNano.computeMessageSize(2, this.result);
            }

            if(!this.associatedRuleName.equals("")) {
                var2 += CodedOutputByteBufferNano.computeStringSize(3, this.associatedRuleName);
            }

            int var3 = var2 + WireFormatNano.computeWireSize(this.unknownFieldData);
            this.cachedSize = var3;
            return var3;
        }

        public int hashCode() {
            int var1 = 17;
            if(this.properties == null) {
                var1 *= 31;
            } else {
                for(int var2 = 0; var2 < this.properties.length; ++var2) {
                    int var3 = var1 * 31;
                    int var4;
                    if(this.properties[var2] == null) {
                        var4 = 0;
                    } else {
                        var4 = this.properties[var2].hashCode();
                    }

                    var1 = var3 + var4;
                }
            }

            int var5 = var1 * 31;
            int var6;
            if(this.result == null) {
                var6 = 0;
            } else {
                var6 = this.result.hashCode();
            }

            int var7 = 31 * (var5 + var6);
            int var8;
            if(this.associatedRuleName == null) {
                var8 = 0;
            } else {
                var8 = this.associatedRuleName.hashCode();
            }

            int var9 = 31 * (var7 + var8);
            List var10 = this.unknownFieldData;
            int var11 = 0;
            if(var10 != null) {
                var11 = this.unknownFieldData.hashCode();
            }

            return var9 + var11;
        }

        public Debug.ResolvedFunctionCall mergeFrom(CodedInputByteBufferNano var1) throws IOException {
            while(true) {
                int var2 = var1.readTag();
                switch(var2) {
                    case 10:
                        int var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 10);
                        int var4;
                        if(this.properties == null) {
                            var4 = 0;
                        } else {
                            var4 = this.properties.length;
                        }

                        Debug.ResolvedProperty[] var5 = new Debug.ResolvedProperty[var4 + var3];
                        if(this.properties != null) {
                            System.arraycopy(this.properties, 0, var5, 0, var4);
                        }

                        for(this.properties = var5; var4 < -1 + this.properties.length; ++var4) {
                            this.properties[var4] = new Debug.ResolvedProperty();
                            var1.readMessage(this.properties[var4]);
                            var1.readTag();
                        }

                        this.properties[var4] = new Debug.ResolvedProperty();
                        var1.readMessage(this.properties[var4]);
                        break;
                    case 18:
                        this.result = new TypeSystem.Value();
                        var1.readMessage(this.result);
                        break;
                    case 26:
                        this.associatedRuleName = var1.readString();
                        break;
                    default:
                        if(this.unknownFieldData == null) {
                            this.unknownFieldData = new ArrayList();
                        }

                        if(WireFormatNano.storeUnknownField(this.unknownFieldData, var1, var2)) {
                            break;
                        }
                    case 0:
                        return this;
                }
            }
        }

        public void writeTo(CodedOutputByteBufferNano var1) throws IOException {
            if(this.properties != null) {
                Debug.ResolvedProperty[] var2 = this.properties;
                int var3 = var2.length;

                for(int var4 = 0; var4 < var3; ++var4) {
                    var1.writeMessage(1, var2[var4]);
                }
            }

            if(this.result != null) {
                var1.writeMessage(2, this.result);
            }

            if(!this.associatedRuleName.equals("")) {
                var1.writeString(3, this.associatedRuleName);
            }

            WireFormatNano.writeUnknownFields(this.unknownFieldData, var1);
        }
    }

    public static final class ResolvedProperty extends ExtendableMessageNano {
        public static final Debug.ResolvedProperty[] EMPTY_ARRAY = new Debug.ResolvedProperty[0];
        public String key = "";
        public TypeSystem.Value value = null;

        public static Debug.ResolvedProperty parseFrom(CodedInputByteBufferNano var0) throws IOException {
            return (new Debug.ResolvedProperty()).mergeFrom(var0);
        }

        public static Debug.ResolvedProperty parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
            return (Debug.ResolvedProperty)MessageNano.mergeFrom(new Debug.ResolvedProperty(), var0);
        }

        public final Debug.ResolvedProperty clear() {
            this.key = "";
            this.value = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final boolean equals(Object var1) {
            if(var1 != this) {
                if(!(var1 instanceof Debug.ResolvedProperty)) {
                    return false;
                } else {
                    Debug.ResolvedProperty var2 = (Debug.ResolvedProperty)var1;
                    if(this.key == null) {
                        if(var2.key != null) {
                            return false;
                        }
                    } else if(!this.key.equals(var2.key)) {
                        return false;
                    }

                    if(this.value == null) {
                        if(var2.value != null) {
                            return false;
                        }
                    } else if(!this.value.equals(var2.value)) {
                        return false;
                    }

                    if(this.unknownFieldData == null) {
                        if(var2.unknownFieldData == null) {
                            return true;
                        }
                    } else if(this.unknownFieldData.equals(var2.unknownFieldData)) {
                        return true;
                    }

                    return false;
                }
            } else {
                return true;
            }
        }

        public int getSerializedSize() {
            boolean var1 = this.key.equals("");
            int var2 = 0;
            if(!var1) {
                var2 = 0 + CodedOutputByteBufferNano.computeStringSize(1, this.key);
            }

            if(this.value != null) {
                var2 += CodedOutputByteBufferNano.computeMessageSize(2, this.value);
            }

            int var3 = var2 + WireFormatNano.computeWireSize(this.unknownFieldData);
            this.cachedSize = var3;
            return var3;
        }

        public int hashCode() {
            int var1;
            if(this.key == null) {
                var1 = 0;
            } else {
                var1 = this.key.hashCode();
            }

            int var2 = 31 * (var1 + 527);
            int var3;
            if(this.value == null) {
                var3 = 0;
            } else {
                var3 = this.value.hashCode();
            }

            int var4 = 31 * (var2 + var3);
            List var5 = this.unknownFieldData;
            int var6 = 0;
            if(var5 != null) {
                var6 = this.unknownFieldData.hashCode();
            }

            return var4 + var6;
        }

        public Debug.ResolvedProperty mergeFrom(CodedInputByteBufferNano var1) throws IOException {
            while(true) {
                int var2 = var1.readTag();
                switch(var2) {
                    case 10:
                        this.key = var1.readString();
                        break;
                    case 18:
                        this.value = new TypeSystem.Value();
                        var1.readMessage(this.value);
                        break;
                    default:
                        if(this.unknownFieldData == null) {
                            this.unknownFieldData = new ArrayList();
                        }

                        if(WireFormatNano.storeUnknownField(this.unknownFieldData, var1, var2)) {
                            break;
                        }
                    case 0:
                        return this;
                }
            }
        }

        public void writeTo(CodedOutputByteBufferNano var1) throws IOException {
            if(!this.key.equals("")) {
                var1.writeString(1, this.key);
            }

            if(this.value != null) {
                var1.writeMessage(2, this.value);
            }

            WireFormatNano.writeUnknownFields(this.unknownFieldData, var1);
        }
    }

    public static final class ResolvedRule extends ExtendableMessageNano {
        public static final Debug.ResolvedRule[] EMPTY_ARRAY = new Debug.ResolvedRule[0];
        public Debug.ResolvedFunctionCall[] addMacros;
        public Debug.ResolvedFunctionCall[] addTags;
        public Debug.ResolvedFunctionCall[] negativePredicates;
        public Debug.ResolvedFunctionCall[] positivePredicates;
        public Debug.ResolvedFunctionCall[] removeMacros;
        public Debug.ResolvedFunctionCall[] removeTags;
        public TypeSystem.Value result;

        public ResolvedRule() {
            this.positivePredicates = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
            this.negativePredicates = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
            this.addTags = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
            this.removeTags = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
            this.addMacros = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
            this.removeMacros = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
            this.result = null;
        }

        public static Debug.ResolvedRule parseFrom(CodedInputByteBufferNano var0) throws IOException {
            return (new Debug.ResolvedRule()).mergeFrom(var0);
        }

        public static Debug.ResolvedRule parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
            return (Debug.ResolvedRule)MessageNano.mergeFrom(new Debug.ResolvedRule(), var0);
        }

        public final Debug.ResolvedRule clear() {
            this.positivePredicates = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
            this.negativePredicates = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
            this.addTags = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
            this.removeTags = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
            this.addMacros = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
            this.removeMacros = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
            this.result = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final boolean equals(Object var1) {
            if(var1 != this) {
                if(!(var1 instanceof Debug.ResolvedRule)) {
                    return false;
                } else {
                    Debug.ResolvedRule var2 = (Debug.ResolvedRule)var1;
                    if(Arrays.equals(this.positivePredicates, var2.positivePredicates) && Arrays.equals(this.negativePredicates, var2.negativePredicates) && Arrays.equals(this.addTags, var2.addTags) && Arrays.equals(this.removeTags, var2.removeTags) && Arrays.equals(this.addMacros, var2.addMacros) && Arrays.equals(this.removeMacros, var2.removeMacros)) {
                        if(this.result == null) {
                            if(var2.result != null) {
                                return false;
                            }
                        } else if(!this.result.equals(var2.result)) {
                            return false;
                        }

                        if(this.unknownFieldData == null) {
                            if(var2.unknownFieldData == null) {
                                return true;
                            }
                        } else if(this.unknownFieldData.equals(var2.unknownFieldData)) {
                            return true;
                        }
                    }

                    return false;
                }
            } else {
                return true;
            }
        }

        public int getSerializedSize() {
            Debug.ResolvedFunctionCall[] var1 = this.positivePredicates;
            int var2 = 0;
            if(var1 != null) {
                Debug.ResolvedFunctionCall[] var19 = this.positivePredicates;
                int var20 = var19.length;

                for(int var21 = 0; var21 < var20; ++var21) {
                    var2 += CodedOutputByteBufferNano.computeMessageSize(1, var19[var21]);
                }
            }

            if(this.negativePredicates != null) {
                Debug.ResolvedFunctionCall[] var16 = this.negativePredicates;
                int var17 = var16.length;

                for(int var18 = 0; var18 < var17; ++var18) {
                    var2 += CodedOutputByteBufferNano.computeMessageSize(2, var16[var18]);
                }
            }

            if(this.addTags != null) {
                Debug.ResolvedFunctionCall[] var13 = this.addTags;
                int var14 = var13.length;

                for(int var15 = 0; var15 < var14; ++var15) {
                    var2 += CodedOutputByteBufferNano.computeMessageSize(3, var13[var15]);
                }
            }

            if(this.removeTags != null) {
                Debug.ResolvedFunctionCall[] var10 = this.removeTags;
                int var11 = var10.length;

                for(int var12 = 0; var12 < var11; ++var12) {
                    var2 += CodedOutputByteBufferNano.computeMessageSize(4, var10[var12]);
                }
            }

            if(this.addMacros != null) {
                Debug.ResolvedFunctionCall[] var7 = this.addMacros;
                int var8 = var7.length;

                for(int var9 = 0; var9 < var8; ++var9) {
                    var2 += CodedOutputByteBufferNano.computeMessageSize(5, var7[var9]);
                }
            }

            if(this.removeMacros != null) {
                Debug.ResolvedFunctionCall[] var4 = this.removeMacros;
                int var5 = var4.length;

                for(int var6 = 0; var6 < var5; ++var6) {
                    var2 += CodedOutputByteBufferNano.computeMessageSize(6, var4[var6]);
                }
            }

            if(this.result != null) {
                var2 += CodedOutputByteBufferNano.computeMessageSize(7, this.result);
            }

            int var3 = var2 + WireFormatNano.computeWireSize(this.unknownFieldData);
            this.cachedSize = var3;
            return var3;
        }

        public int hashCode() {
            int var1 = 17;
            if(this.positivePredicates == null) {
                var1 *= 31;
            } else {
                for(int var2 = 0; var2 < this.positivePredicates.length; ++var2) {
                    int var3 = var1 * 31;
                    int var4;
                    if(this.positivePredicates[var2] == null) {
                        var4 = 0;
                    } else {
                        var4 = this.positivePredicates[var2].hashCode();
                    }

                    var1 = var3 + var4;
                }
            }

            if(this.negativePredicates == null) {
                var1 *= 31;
            } else {
                for(int var5 = 0; var5 < this.negativePredicates.length; ++var5) {
                    int var6 = var1 * 31;
                    int var7;
                    if(this.negativePredicates[var5] == null) {
                        var7 = 0;
                    } else {
                        var7 = this.negativePredicates[var5].hashCode();
                    }

                    var1 = var6 + var7;
                }
            }

            if(this.addTags == null) {
                var1 *= 31;
            } else {
                for(int var8 = 0; var8 < this.addTags.length; ++var8) {
                    int var9 = var1 * 31;
                    int var10;
                    if(this.addTags[var8] == null) {
                        var10 = 0;
                    } else {
                        var10 = this.addTags[var8].hashCode();
                    }

                    var1 = var9 + var10;
                }
            }

            if(this.removeTags == null) {
                var1 *= 31;
            } else {
                for(int var11 = 0; var11 < this.removeTags.length; ++var11) {
                    int var12 = var1 * 31;
                    int var13;
                    if(this.removeTags[var11] == null) {
                        var13 = 0;
                    } else {
                        var13 = this.removeTags[var11].hashCode();
                    }

                    var1 = var12 + var13;
                }
            }

            if(this.addMacros == null) {
                var1 *= 31;
            } else {
                for(int var14 = 0; var14 < this.addMacros.length; ++var14) {
                    int var15 = var1 * 31;
                    int var16;
                    if(this.addMacros[var14] == null) {
                        var16 = 0;
                    } else {
                        var16 = this.addMacros[var14].hashCode();
                    }

                    var1 = var15 + var16;
                }
            }

            if(this.removeMacros == null) {
                var1 *= 31;
            } else {
                for(int var17 = 0; var17 < this.removeMacros.length; ++var17) {
                    int var18 = var1 * 31;
                    int var19;
                    if(this.removeMacros[var17] == null) {
                        var19 = 0;
                    } else {
                        var19 = this.removeMacros[var17].hashCode();
                    }

                    var1 = var18 + var19;
                }
            }

            int var20 = var1 * 31;
            int var21;
            if(this.result == null) {
                var21 = 0;
            } else {
                var21 = this.result.hashCode();
            }

            int var22 = 31 * (var20 + var21);
            List var23 = this.unknownFieldData;
            int var24 = 0;
            if(var23 != null) {
                var24 = this.unknownFieldData.hashCode();
            }

            return var22 + var24;
        }

        public Debug.ResolvedRule mergeFrom(CodedInputByteBufferNano var1) throws IOException {
            while(true) {
                int var2 = var1.readTag();
                switch(var2) {
                    case 10:
                        int var23 = WireFormatNano.getRepeatedFieldArrayLength(var1, 10);
                        int var24;
                        if(this.positivePredicates == null) {
                            var24 = 0;
                        } else {
                            var24 = this.positivePredicates.length;
                        }

                        Debug.ResolvedFunctionCall[] var25 = new Debug.ResolvedFunctionCall[var24 + var23];
                        if(this.positivePredicates != null) {
                            System.arraycopy(this.positivePredicates, 0, var25, 0, var24);
                        }

                        for(this.positivePredicates = var25; var24 < -1 + this.positivePredicates.length; ++var24) {
                            this.positivePredicates[var24] = new Debug.ResolvedFunctionCall();
                            var1.readMessage(this.positivePredicates[var24]);
                            var1.readTag();
                        }

                        this.positivePredicates[var24] = new Debug.ResolvedFunctionCall();
                        var1.readMessage(this.positivePredicates[var24]);
                        break;
                    case 18:
                        int var19 = WireFormatNano.getRepeatedFieldArrayLength(var1, 18);
                        int var20;
                        if(this.negativePredicates == null) {
                            var20 = 0;
                        } else {
                            var20 = this.negativePredicates.length;
                        }

                        Debug.ResolvedFunctionCall[] var21 = new Debug.ResolvedFunctionCall[var20 + var19];
                        if(this.negativePredicates != null) {
                            System.arraycopy(this.negativePredicates, 0, var21, 0, var20);
                        }

                        for(this.negativePredicates = var21; var20 < -1 + this.negativePredicates.length; ++var20) {
                            this.negativePredicates[var20] = new Debug.ResolvedFunctionCall();
                            var1.readMessage(this.negativePredicates[var20]);
                            var1.readTag();
                        }

                        this.negativePredicates[var20] = new Debug.ResolvedFunctionCall();
                        var1.readMessage(this.negativePredicates[var20]);
                        break;
                    case 26:
                        int var15 = WireFormatNano.getRepeatedFieldArrayLength(var1, 26);
                        int var16;
                        if(this.addTags == null) {
                            var16 = 0;
                        } else {
                            var16 = this.addTags.length;
                        }

                        Debug.ResolvedFunctionCall[] var17 = new Debug.ResolvedFunctionCall[var16 + var15];
                        if(this.addTags != null) {
                            System.arraycopy(this.addTags, 0, var17, 0, var16);
                        }

                        for(this.addTags = var17; var16 < -1 + this.addTags.length; ++var16) {
                            this.addTags[var16] = new Debug.ResolvedFunctionCall();
                            var1.readMessage(this.addTags[var16]);
                            var1.readTag();
                        }

                        this.addTags[var16] = new Debug.ResolvedFunctionCall();
                        var1.readMessage(this.addTags[var16]);
                        break;
                    case 34:
                        int var11 = WireFormatNano.getRepeatedFieldArrayLength(var1, 34);
                        int var12;
                        if(this.removeTags == null) {
                            var12 = 0;
                        } else {
                            var12 = this.removeTags.length;
                        }

                        Debug.ResolvedFunctionCall[] var13 = new Debug.ResolvedFunctionCall[var12 + var11];
                        if(this.removeTags != null) {
                            System.arraycopy(this.removeTags, 0, var13, 0, var12);
                        }

                        for(this.removeTags = var13; var12 < -1 + this.removeTags.length; ++var12) {
                            this.removeTags[var12] = new Debug.ResolvedFunctionCall();
                            var1.readMessage(this.removeTags[var12]);
                            var1.readTag();
                        }

                        this.removeTags[var12] = new Debug.ResolvedFunctionCall();
                        var1.readMessage(this.removeTags[var12]);
                        break;
                    case 42:
                        int var7 = WireFormatNano.getRepeatedFieldArrayLength(var1, 42);
                        int var8;
                        if(this.addMacros == null) {
                            var8 = 0;
                        } else {
                            var8 = this.addMacros.length;
                        }

                        Debug.ResolvedFunctionCall[] var9 = new Debug.ResolvedFunctionCall[var8 + var7];
                        if(this.addMacros != null) {
                            System.arraycopy(this.addMacros, 0, var9, 0, var8);
                        }

                        for(this.addMacros = var9; var8 < -1 + this.addMacros.length; ++var8) {
                            this.addMacros[var8] = new Debug.ResolvedFunctionCall();
                            var1.readMessage(this.addMacros[var8]);
                            var1.readTag();
                        }

                        this.addMacros[var8] = new Debug.ResolvedFunctionCall();
                        var1.readMessage(this.addMacros[var8]);
                        break;
                    case 50:
                        int var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 50);
                        int var4;
                        if(this.removeMacros == null) {
                            var4 = 0;
                        } else {
                            var4 = this.removeMacros.length;
                        }

                        Debug.ResolvedFunctionCall[] var5 = new Debug.ResolvedFunctionCall[var4 + var3];
                        if(this.removeMacros != null) {
                            System.arraycopy(this.removeMacros, 0, var5, 0, var4);
                        }

                        for(this.removeMacros = var5; var4 < -1 + this.removeMacros.length; ++var4) {
                            this.removeMacros[var4] = new Debug.ResolvedFunctionCall();
                            var1.readMessage(this.removeMacros[var4]);
                            var1.readTag();
                        }

                        this.removeMacros[var4] = new Debug.ResolvedFunctionCall();
                        var1.readMessage(this.removeMacros[var4]);
                        break;
                    case 58:
                        this.result = new TypeSystem.Value();
                        var1.readMessage(this.result);
                        break;
                    default:
                        if(this.unknownFieldData == null) {
                            this.unknownFieldData = new ArrayList();
                        }

                        if(WireFormatNano.storeUnknownField(this.unknownFieldData, var1, var2)) {
                            break;
                        }
                    case 0:
                        return this;
                }
            }
        }

        public void writeTo(CodedOutputByteBufferNano var1) throws IOException {
            if(this.positivePredicates != null) {
                Debug.ResolvedFunctionCall[] var17 = this.positivePredicates;
                int var18 = var17.length;

                for(int var19 = 0; var19 < var18; ++var19) {
                    var1.writeMessage(1, var17[var19]);
                }
            }

            if(this.negativePredicates != null) {
                Debug.ResolvedFunctionCall[] var14 = this.negativePredicates;
                int var15 = var14.length;

                for(int var16 = 0; var16 < var15; ++var16) {
                    var1.writeMessage(2, var14[var16]);
                }
            }

            if(this.addTags != null) {
                Debug.ResolvedFunctionCall[] var11 = this.addTags;
                int var12 = var11.length;

                for(int var13 = 0; var13 < var12; ++var13) {
                    var1.writeMessage(3, var11[var13]);
                }
            }

            if(this.removeTags != null) {
                Debug.ResolvedFunctionCall[] var8 = this.removeTags;
                int var9 = var8.length;

                for(int var10 = 0; var10 < var9; ++var10) {
                    var1.writeMessage(4, var8[var10]);
                }
            }

            if(this.addMacros != null) {
                Debug.ResolvedFunctionCall[] var5 = this.addMacros;
                int var6 = var5.length;

                for(int var7 = 0; var7 < var6; ++var7) {
                    var1.writeMessage(5, var5[var7]);
                }
            }

            if(this.removeMacros != null) {
                Debug.ResolvedFunctionCall[] var2 = this.removeMacros;
                int var3 = var2.length;

                for(int var4 = 0; var4 < var3; ++var4) {
                    var1.writeMessage(6, var2[var4]);
                }
            }

            if(this.result != null) {
                var1.writeMessage(7, this.result);
            }

            WireFormatNano.writeUnknownFields(this.unknownFieldData, var1);
        }
    }

    public static final class RuleEvaluationStepInfo extends ExtendableMessageNano {
        public static final Debug.RuleEvaluationStepInfo[] EMPTY_ARRAY = new Debug.RuleEvaluationStepInfo[0];
        public Debug.ResolvedFunctionCall[] enabledFunctions;
        public Debug.ResolvedRule[] rules;

        public RuleEvaluationStepInfo() {
            this.rules = Debug.ResolvedRule.EMPTY_ARRAY;
            this.enabledFunctions = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
        }

        public static Debug.RuleEvaluationStepInfo parseFrom(CodedInputByteBufferNano var0) throws IOException {
            return (new Debug.RuleEvaluationStepInfo()).mergeFrom(var0);
        }

        public static Debug.RuleEvaluationStepInfo parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
            return (Debug.RuleEvaluationStepInfo)MessageNano.mergeFrom(new Debug.RuleEvaluationStepInfo(), var0);
        }

        public final Debug.RuleEvaluationStepInfo clear() {
            this.rules = Debug.ResolvedRule.EMPTY_ARRAY;
            this.enabledFunctions = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final boolean equals(Object var1) {
            if(var1 != this) {
                if(!(var1 instanceof Debug.RuleEvaluationStepInfo)) {
                    return false;
                } else {
                    Debug.RuleEvaluationStepInfo var2 = (Debug.RuleEvaluationStepInfo)var1;
                    if(Arrays.equals(this.rules, var2.rules) && Arrays.equals(this.enabledFunctions, var2.enabledFunctions)) {
                        if(this.unknownFieldData == null) {
                            if(var2.unknownFieldData == null) {
                                return true;
                            }
                        } else if(this.unknownFieldData.equals(var2.unknownFieldData)) {
                            return true;
                        }
                    }

                    return false;
                }
            } else {
                return true;
            }
        }

        public int getSerializedSize() {
            Debug.ResolvedRule[] var1 = this.rules;
            int var2 = 0;
            if(var1 != null) {
                Debug.ResolvedRule[] var7 = this.rules;
                int var8 = var7.length;

                for(int var9 = 0; var9 < var8; ++var9) {
                    var2 += CodedOutputByteBufferNano.computeMessageSize(1, var7[var9]);
                }
            }

            if(this.enabledFunctions != null) {
                Debug.ResolvedFunctionCall[] var4 = this.enabledFunctions;
                int var5 = var4.length;

                for(int var6 = 0; var6 < var5; ++var6) {
                    var2 += CodedOutputByteBufferNano.computeMessageSize(2, var4[var6]);
                }
            }

            int var3 = var2 + WireFormatNano.computeWireSize(this.unknownFieldData);
            this.cachedSize = var3;
            return var3;
        }

        public int hashCode() {
            int var1 = 17;
            if(this.rules == null) {
                var1 *= 31;
            } else {
                for(int var2 = 0; var2 < this.rules.length; ++var2) {
                    int var3 = var1 * 31;
                    int var4;
                    if(this.rules[var2] == null) {
                        var4 = 0;
                    } else {
                        var4 = this.rules[var2].hashCode();
                    }

                    var1 = var3 + var4;
                }
            }

            if(this.enabledFunctions == null) {
                var1 *= 31;
            } else {
                for(int var5 = 0; var5 < this.enabledFunctions.length; ++var5) {
                    int var6 = var1 * 31;
                    int var7;
                    if(this.enabledFunctions[var5] == null) {
                        var7 = 0;
                    } else {
                        var7 = this.enabledFunctions[var5].hashCode();
                    }

                    var1 = var6 + var7;
                }
            }

            int var8 = var1 * 31;
            List var9 = this.unknownFieldData;
            int var10 = 0;
            if(var9 != null) {
                var10 = this.unknownFieldData.hashCode();
            }

            return var8 + var10;
        }

        public Debug.RuleEvaluationStepInfo mergeFrom(CodedInputByteBufferNano var1) throws IOException {
            while(true) {
                int var2 = var1.readTag();
                switch(var2) {
                    case 10:
                        int var7 = WireFormatNano.getRepeatedFieldArrayLength(var1, 10);
                        int var8;
                        if(this.rules == null) {
                            var8 = 0;
                        } else {
                            var8 = this.rules.length;
                        }

                        Debug.ResolvedRule[] var9 = new Debug.ResolvedRule[var8 + var7];
                        if(this.rules != null) {
                            System.arraycopy(this.rules, 0, var9, 0, var8);
                        }

                        for(this.rules = var9; var8 < -1 + this.rules.length; ++var8) {
                            this.rules[var8] = new Debug.ResolvedRule();
                            var1.readMessage(this.rules[var8]);
                            var1.readTag();
                        }

                        this.rules[var8] = new Debug.ResolvedRule();
                        var1.readMessage(this.rules[var8]);
                        break;
                    case 18:
                        int var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 18);
                        int var4;
                        if(this.enabledFunctions == null) {
                            var4 = 0;
                        } else {
                            var4 = this.enabledFunctions.length;
                        }

                        Debug.ResolvedFunctionCall[] var5 = new Debug.ResolvedFunctionCall[var4 + var3];
                        if(this.enabledFunctions != null) {
                            System.arraycopy(this.enabledFunctions, 0, var5, 0, var4);
                        }

                        for(this.enabledFunctions = var5; var4 < -1 + this.enabledFunctions.length; ++var4) {
                            this.enabledFunctions[var4] = new Debug.ResolvedFunctionCall();
                            var1.readMessage(this.enabledFunctions[var4]);
                            var1.readTag();
                        }

                        this.enabledFunctions[var4] = new Debug.ResolvedFunctionCall();
                        var1.readMessage(this.enabledFunctions[var4]);
                        break;
                    default:
                        if(this.unknownFieldData == null) {
                            this.unknownFieldData = new ArrayList();
                        }

                        if(WireFormatNano.storeUnknownField(this.unknownFieldData, var1, var2)) {
                            break;
                        }
                    case 0:
                        return this;
                }
            }
        }

        public void writeTo(CodedOutputByteBufferNano var1) throws IOException {
            if(this.rules != null) {
                Debug.ResolvedRule[] var5 = this.rules;
                int var6 = var5.length;

                for(int var7 = 0; var7 < var6; ++var7) {
                    var1.writeMessage(1, var5[var7]);
                }
            }

            if(this.enabledFunctions != null) {
                Debug.ResolvedFunctionCall[] var2 = this.enabledFunctions;
                int var3 = var2.length;

                for(int var4 = 0; var4 < var3; ++var4) {
                    var1.writeMessage(2, var2[var4]);
                }
            }

            WireFormatNano.writeUnknownFields(this.unknownFieldData, var1);
        }
    }
}

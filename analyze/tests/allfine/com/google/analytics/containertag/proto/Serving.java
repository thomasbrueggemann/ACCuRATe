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

public interface Serving {
    public static final class CacheOption extends ExtendableMessageNano {
        public static final Serving.CacheOption[] EMPTY_ARRAY = new Serving.CacheOption[0];
        public int expirationSeconds = 0;
        public int gcacheExpirationSeconds = 0;
        public int level = 1;

        public static Serving.CacheOption parseFrom(CodedInputByteBufferNano var0) throws IOException {
            return (new Serving.CacheOption()).mergeFrom(var0);
        }

        public static Serving.CacheOption parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
            return (Serving.CacheOption)MessageNano.mergeFrom(new Serving.CacheOption(), var0);
        }

        public final Serving.CacheOption clear() {
            this.level = 1;
            this.expirationSeconds = 0;
            this.gcacheExpirationSeconds = 0;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final boolean equals(Object var1) {
            if(var1 != this) {
                if(!(var1 instanceof Serving.CacheOption)) {
                    return false;
                } else {
                    Serving.CacheOption var2 = (Serving.CacheOption)var1;
                    if(this.level == var2.level && this.expirationSeconds == var2.expirationSeconds && this.gcacheExpirationSeconds == var2.gcacheExpirationSeconds) {
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
            int var1 = this.level;
            int var2 = 0;
            if(var1 != 1) {
                var2 = 0 + CodedOutputByteBufferNano.computeInt32Size(1, this.level);
            }

            if(this.expirationSeconds != 0) {
                var2 += CodedOutputByteBufferNano.computeInt32Size(2, this.expirationSeconds);
            }

            if(this.gcacheExpirationSeconds != 0) {
                var2 += CodedOutputByteBufferNano.computeInt32Size(3, this.gcacheExpirationSeconds);
            }

            int var3 = var2 + WireFormatNano.computeWireSize(this.unknownFieldData);
            this.cachedSize = var3;
            return var3;
        }

        public int hashCode() {
            int var1 = 31 * (31 * (31 * (527 + this.level) + this.expirationSeconds) + this.gcacheExpirationSeconds);
            int var2;
            if(this.unknownFieldData == null) {
                var2 = 0;
            } else {
                var2 = this.unknownFieldData.hashCode();
            }

            return var1 + var2;
        }

        public Serving.CacheOption mergeFrom(CodedInputByteBufferNano var1) throws IOException {
            while(true) {
                int var2 = var1.readTag();
                switch(var2) {
                    case 8:
                        int var3 = var1.readInt32();
                        if(var3 != 1 && var3 != 2 && var3 != 3) {
                            this.level = 1;
                            break;
                        }

                        this.level = var3;
                        break;
                    case 16:
                        this.expirationSeconds = var1.readInt32();
                        break;
                    case 24:
                        this.gcacheExpirationSeconds = var1.readInt32();
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
            if(this.level != 1) {
                var1.writeInt32(1, this.level);
            }

            if(this.expirationSeconds != 0) {
                var1.writeInt32(2, this.expirationSeconds);
            }

            if(this.gcacheExpirationSeconds != 0) {
                var1.writeInt32(3, this.gcacheExpirationSeconds);
            }

            WireFormatNano.writeUnknownFields(this.unknownFieldData, var1);
        }
    }

    public interface CacheLevel {
        int NO_CACHE = 1;
        int PRIVATE = 2;
        int PUBLIC = 3;
    }

    public static final class Container extends ExtendableMessageNano {
        public static final Serving.Container[] EMPTY_ARRAY = new Serving.Container[0];
        public String containerId = "";
        public Serving.Resource jsResource = null;
        public int state = 1;
        public String version = "";

        public static Serving.Container parseFrom(CodedInputByteBufferNano var0) throws IOException {
            return (new Serving.Container()).mergeFrom(var0);
        }

        public static Serving.Container parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
            return (Serving.Container)MessageNano.mergeFrom(new Serving.Container(), var0);
        }

        public final Serving.Container clear() {
            this.jsResource = null;
            this.containerId = "";
            this.state = 1;
            this.version = "";
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final boolean equals(Object var1) {
            if(var1 != this) {
                if(!(var1 instanceof Serving.Container)) {
                    return false;
                } else {
                    Serving.Container var2 = (Serving.Container)var1;
                    if(this.jsResource == null) {
                        if(var2.jsResource != null) {
                            return false;
                        }
                    } else if(!this.jsResource.equals(var2.jsResource)) {
                        return false;
                    }

                    if(this.containerId == null) {
                        if(var2.containerId != null) {
                            return false;
                        }
                    } else if(!this.containerId.equals(var2.containerId)) {
                        return false;
                    }

                    if(this.state == var2.state) {
                        if(this.version == null) {
                            if(var2.version != null) {
                                return false;
                            }
                        } else if(!this.version.equals(var2.version)) {
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
            Serving.Resource var1 = this.jsResource;
            int var2 = 0;
            if(var1 != null) {
                var2 = 0 + CodedOutputByteBufferNano.computeMessageSize(1, this.jsResource);
            }

            int var3 = var2 + CodedOutputByteBufferNano.computeStringSize(3, this.containerId) + CodedOutputByteBufferNano.computeInt32Size(4, this.state);
            if(!this.version.equals("")) {
                var3 += CodedOutputByteBufferNano.computeStringSize(5, this.version);
            }

            int var4 = var3 + WireFormatNano.computeWireSize(this.unknownFieldData);
            this.cachedSize = var4;
            return var4;
        }

        public int hashCode() {
            int var1;
            if(this.jsResource == null) {
                var1 = 0;
            } else {
                var1 = this.jsResource.hashCode();
            }

            int var2 = 31 * (var1 + 527);
            int var3;
            if(this.containerId == null) {
                var3 = 0;
            } else {
                var3 = this.containerId.hashCode();
            }

            int var4 = 31 * (31 * (var2 + var3) + this.state);
            int var5;
            if(this.version == null) {
                var5 = 0;
            } else {
                var5 = this.version.hashCode();
            }

            int var6 = 31 * (var4 + var5);
            List var7 = this.unknownFieldData;
            int var8 = 0;
            if(var7 != null) {
                var8 = this.unknownFieldData.hashCode();
            }

            return var6 + var8;
        }

        public Serving.Container mergeFrom(CodedInputByteBufferNano var1) throws IOException {
            while(true) {
                int var2 = var1.readTag();
                switch(var2) {
                    case 10:
                        this.jsResource = new Serving.Resource();
                        var1.readMessage(this.jsResource);
                        break;
                    case 26:
                        this.containerId = var1.readString();
                        break;
                    case 32:
                        int var3 = var1.readInt32();
                        if(var3 != 1 && var3 != 2) {
                            this.state = 1;
                            break;
                        }

                        this.state = var3;
                        break;
                    case 42:
                        this.version = var1.readString();
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
            if(this.jsResource != null) {
                var1.writeMessage(1, this.jsResource);
            }

            var1.writeString(3, this.containerId);
            var1.writeInt32(4, this.state);
            if(!this.version.equals("")) {
                var1.writeString(5, this.version);
            }

            WireFormatNano.writeUnknownFields(this.unknownFieldData, var1);
        }
    }

    public static final class FunctionCall extends ExtendableMessageNano {
        public static final Serving.FunctionCall[] EMPTY_ARRAY = new Serving.FunctionCall[0];
        public int function;
        public boolean liveOnly;
        public int name;
        public int[] property;
        public boolean serverSide;

        public FunctionCall() {
            this.property = WireFormatNano.EMPTY_INT_ARRAY;
            this.function = 0;
            this.name = 0;
            this.liveOnly = false;
            this.serverSide = false;
        }

        public static Serving.FunctionCall parseFrom(CodedInputByteBufferNano var0) throws IOException {
            return (new Serving.FunctionCall()).mergeFrom(var0);
        }

        public static Serving.FunctionCall parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
            return (Serving.FunctionCall)MessageNano.mergeFrom(new Serving.FunctionCall(), var0);
        }

        public final Serving.FunctionCall clear() {
            this.property = WireFormatNano.EMPTY_INT_ARRAY;
            this.function = 0;
            this.name = 0;
            this.liveOnly = false;
            this.serverSide = false;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final boolean equals(Object var1) {
            if(var1 != this) {
                if(!(var1 instanceof Serving.FunctionCall)) {
                    return false;
                } else {
                    Serving.FunctionCall var2 = (Serving.FunctionCall)var1;
                    if(Arrays.equals(this.property, var2.property) && this.function == var2.function && this.name == var2.name && this.liveOnly == var2.liveOnly && this.serverSide == var2.serverSide) {
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
            boolean var1 = this.serverSide;
            int var2 = 0;
            if(var1) {
                var2 = 0 + CodedOutputByteBufferNano.computeBoolSize(1, this.serverSide);
            }

            int var3 = var2 + CodedOutputByteBufferNano.computeInt32Size(2, this.function);
            if(this.property != null && this.property.length > 0) {
                int var5 = 0;
                int[] var6 = this.property;
                int var7 = var6.length;

                for(int var8 = 0; var8 < var7; ++var8) {
                    var5 += CodedOutputByteBufferNano.computeInt32SizeNoTag(var6[var8]);
                }

                var3 = var3 + var5 + 1 * this.property.length;
            }

            if(this.name != 0) {
                var3 += CodedOutputByteBufferNano.computeInt32Size(4, this.name);
            }

            if(this.liveOnly) {
                var3 += CodedOutputByteBufferNano.computeBoolSize(6, this.liveOnly);
            }

            int var4 = var3 + WireFormatNano.computeWireSize(this.unknownFieldData);
            this.cachedSize = var4;
            return var4;
        }

        public int hashCode() {
            byte var1 = 1;
            int var2 = 17;
            if(this.property == null) {
                var2 *= 31;
            } else {
                for(int var3 = 0; var3 < this.property.length; ++var3) {
                    var2 = var2 * 31 + this.property[var3];
                }
            }

            int var4 = 31 * (31 * (var2 * 31 + this.function) + this.name);
            byte var5;
            if(this.liveOnly) {
                var5 = var1;
            } else {
                var5 = 2;
            }

            int var6 = 31 * (var4 + var5);
            if(!this.serverSide) {
                var1 = 2;
            }

            int var7 = 31 * (var6 + var1);
            int var8;
            if(this.unknownFieldData == null) {
                var8 = 0;
            } else {
                var8 = this.unknownFieldData.hashCode();
            }

            return var7 + var8;
        }

        public Serving.FunctionCall mergeFrom(CodedInputByteBufferNano var1) throws IOException {
            while(true) {
                int var2 = var1.readTag();
                switch(var2) {
                    case 8:
                        this.serverSide = var1.readBool();
                        break;
                    case 16:
                        this.function = var1.readInt32();
                        break;
                    case 24:
                        int var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 24);
                        int var4 = this.property.length;
                        int[] var5 = new int[var4 + var3];
                        System.arraycopy(this.property, 0, var5, 0, var4);

                        for(this.property = var5; var4 < -1 + this.property.length; ++var4) {
                            this.property[var4] = var1.readInt32();
                            var1.readTag();
                        }

                        this.property[var4] = var1.readInt32();
                        break;
                    case 32:
                        this.name = var1.readInt32();
                        break;
                    case 48:
                        this.liveOnly = var1.readBool();
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
            if(this.serverSide) {
                var1.writeBool(1, this.serverSide);
            }

            var1.writeInt32(2, this.function);
            if(this.property != null) {
                int[] var2 = this.property;
                int var3 = var2.length;

                for(int var4 = 0; var4 < var3; ++var4) {
                    var1.writeInt32(3, var2[var4]);
                }
            }

            if(this.name != 0) {
                var1.writeInt32(4, this.name);
            }

            if(this.liveOnly) {
                var1.writeBool(6, this.liveOnly);
            }

            WireFormatNano.writeUnknownFields(this.unknownFieldData, var1);
        }
    }

    public static final class GaExperimentRandom extends ExtendableMessageNano {
        public static final Serving.GaExperimentRandom[] EMPTY_ARRAY = new Serving.GaExperimentRandom[0];
        public String key = "";
        public long lifetimeInMilliseconds = 0L;
        public long maxRandom = 2147483647L;
        public long minRandom = 0L;
        public boolean retainOriginalValue = false;

        public static Serving.GaExperimentRandom parseFrom(CodedInputByteBufferNano var0) throws IOException {
            return (new Serving.GaExperimentRandom()).mergeFrom(var0);
        }

        public static Serving.GaExperimentRandom parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
            return (Serving.GaExperimentRandom)MessageNano.mergeFrom(new Serving.GaExperimentRandom(), var0);
        }

        public final Serving.GaExperimentRandom clear() {
            this.key = "";
            this.minRandom = 0L;
            this.maxRandom = 2147483647L;
            this.retainOriginalValue = false;
            this.lifetimeInMilliseconds = 0L;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final boolean equals(Object var1) {
            if(var1 != this) {
                if(!(var1 instanceof Serving.GaExperimentRandom)) {
                    return false;
                } else {
                    Serving.GaExperimentRandom var2 = (Serving.GaExperimentRandom)var1;
                    if(this.key == null) {
                        if(var2.key != null) {
                            return false;
                        }
                    } else if(!this.key.equals(var2.key)) {
                        return false;
                    }

                    if(this.minRandom == var2.minRandom && this.maxRandom == var2.maxRandom && this.retainOriginalValue == var2.retainOriginalValue && this.lifetimeInMilliseconds == var2.lifetimeInMilliseconds) {
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
            boolean var1 = this.key.equals("");
            int var2 = 0;
            if(!var1) {
                var2 = 0 + CodedOutputByteBufferNano.computeStringSize(1, this.key);
            }

            if(this.minRandom != 0L) {
                var2 += CodedOutputByteBufferNano.computeInt64Size(2, this.minRandom);
            }

            if(this.maxRandom != 2147483647L) {
                var2 += CodedOutputByteBufferNano.computeInt64Size(3, this.maxRandom);
            }

            if(this.retainOriginalValue) {
                var2 += CodedOutputByteBufferNano.computeBoolSize(4, this.retainOriginalValue);
            }

            if(this.lifetimeInMilliseconds != 0L) {
                var2 += CodedOutputByteBufferNano.computeInt64Size(5, this.lifetimeInMilliseconds);
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

            int var2 = 31 * (31 * (31 * (var1 + 527) + (int)(this.minRandom ^ this.minRandom >>> 32)) + (int)(this.maxRandom ^ this.maxRandom >>> 32));
            byte var3;
            if(this.retainOriginalValue) {
                var3 = 1;
            } else {
                var3 = 2;
            }

            int var4 = 31 * (31 * (var2 + var3) + (int)(this.lifetimeInMilliseconds ^ this.lifetimeInMilliseconds >>> 32));
            List var5 = this.unknownFieldData;
            int var6 = 0;
            if(var5 != null) {
                var6 = this.unknownFieldData.hashCode();
            }

            return var4 + var6;
        }

        public Serving.GaExperimentRandom mergeFrom(CodedInputByteBufferNano var1) throws IOException {
            while(true) {
                int var2 = var1.readTag();
                switch(var2) {
                    case 10:
                        this.key = var1.readString();
                        break;
                    case 16:
                        this.minRandom = var1.readInt64();
                        break;
                    case 24:
                        this.maxRandom = var1.readInt64();
                        break;
                    case 32:
                        this.retainOriginalValue = var1.readBool();
                        break;
                    case 40:
                        this.lifetimeInMilliseconds = var1.readInt64();
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

            if(this.minRandom != 0L) {
                var1.writeInt64(2, this.minRandom);
            }

            if(this.maxRandom != 2147483647L) {
                var1.writeInt64(3, this.maxRandom);
            }

            if(this.retainOriginalValue) {
                var1.writeBool(4, this.retainOriginalValue);
            }

            if(this.lifetimeInMilliseconds != 0L) {
                var1.writeInt64(5, this.lifetimeInMilliseconds);
            }

            WireFormatNano.writeUnknownFields(this.unknownFieldData, var1);
        }
    }

    public static final class GaExperimentSupplemental extends ExtendableMessageNano {
        public static final Serving.GaExperimentSupplemental[] EMPTY_ARRAY = new Serving.GaExperimentSupplemental[0];
        public Serving.GaExperimentRandom[] experimentRandom;
        public TypeSystem.Value[] valueToClear;
        public TypeSystem.Value[] valueToPush;

        public GaExperimentSupplemental() {
            this.valueToPush = TypeSystem.Value.EMPTY_ARRAY;
            this.valueToClear = TypeSystem.Value.EMPTY_ARRAY;
            this.experimentRandom = Serving.GaExperimentRandom.EMPTY_ARRAY;
        }

        public static Serving.GaExperimentSupplemental parseFrom(CodedInputByteBufferNano var0) throws IOException {
            return (new Serving.GaExperimentSupplemental()).mergeFrom(var0);
        }

        public static Serving.GaExperimentSupplemental parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
            return (Serving.GaExperimentSupplemental)MessageNano.mergeFrom(new Serving.GaExperimentSupplemental(), var0);
        }

        public final Serving.GaExperimentSupplemental clear() {
            this.valueToPush = TypeSystem.Value.EMPTY_ARRAY;
            this.valueToClear = TypeSystem.Value.EMPTY_ARRAY;
            this.experimentRandom = Serving.GaExperimentRandom.EMPTY_ARRAY;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final boolean equals(Object var1) {
            if(var1 != this) {
                if(!(var1 instanceof Serving.GaExperimentSupplemental)) {
                    return false;
                } else {
                    Serving.GaExperimentSupplemental var2 = (Serving.GaExperimentSupplemental)var1;
                    if(Arrays.equals(this.valueToPush, var2.valueToPush) && Arrays.equals(this.valueToClear, var2.valueToClear) && Arrays.equals(this.experimentRandom, var2.experimentRandom)) {
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
            TypeSystem.Value[] var1 = this.valueToPush;
            int var2 = 0;
            if(var1 != null) {
                TypeSystem.Value[] var10 = this.valueToPush;
                int var11 = var10.length;

                for(int var12 = 0; var12 < var11; ++var12) {
                    var2 += CodedOutputByteBufferNano.computeMessageSize(1, var10[var12]);
                }
            }

            if(this.valueToClear != null) {
                TypeSystem.Value[] var7 = this.valueToClear;
                int var8 = var7.length;

                for(int var9 = 0; var9 < var8; ++var9) {
                    var2 += CodedOutputByteBufferNano.computeMessageSize(2, var7[var9]);
                }
            }

            if(this.experimentRandom != null) {
                Serving.GaExperimentRandom[] var4 = this.experimentRandom;
                int var5 = var4.length;

                for(int var6 = 0; var6 < var5; ++var6) {
                    var2 += CodedOutputByteBufferNano.computeMessageSize(3, var4[var6]);
                }
            }

            int var3 = var2 + WireFormatNano.computeWireSize(this.unknownFieldData);
            this.cachedSize = var3;
            return var3;
        }

        public int hashCode() {
            int var1 = 17;
            if(this.valueToPush == null) {
                var1 *= 31;
            } else {
                for(int var2 = 0; var2 < this.valueToPush.length; ++var2) {
                    int var3 = var1 * 31;
                    int var4;
                    if(this.valueToPush[var2] == null) {
                        var4 = 0;
                    } else {
                        var4 = this.valueToPush[var2].hashCode();
                    }

                    var1 = var3 + var4;
                }
            }

            if(this.valueToClear == null) {
                var1 *= 31;
            } else {
                for(int var5 = 0; var5 < this.valueToClear.length; ++var5) {
                    int var6 = var1 * 31;
                    int var7;
                    if(this.valueToClear[var5] == null) {
                        var7 = 0;
                    } else {
                        var7 = this.valueToClear[var5].hashCode();
                    }

                    var1 = var6 + var7;
                }
            }

            if(this.experimentRandom == null) {
                var1 *= 31;
            } else {
                for(int var8 = 0; var8 < this.experimentRandom.length; ++var8) {
                    int var9 = var1 * 31;
                    int var10;
                    if(this.experimentRandom[var8] == null) {
                        var10 = 0;
                    } else {
                        var10 = this.experimentRandom[var8].hashCode();
                    }

                    var1 = var9 + var10;
                }
            }

            int var11 = var1 * 31;
            List var12 = this.unknownFieldData;
            int var13 = 0;
            if(var12 != null) {
                var13 = this.unknownFieldData.hashCode();
            }

            return var11 + var13;
        }

        public Serving.GaExperimentSupplemental mergeFrom(CodedInputByteBufferNano var1) throws IOException {
            while(true) {
                int var2 = var1.readTag();
                switch(var2) {
                    case 10:
                        int var11 = WireFormatNano.getRepeatedFieldArrayLength(var1, 10);
                        int var12;
                        if(this.valueToPush == null) {
                            var12 = 0;
                        } else {
                            var12 = this.valueToPush.length;
                        }

                        TypeSystem.Value[] var13 = new TypeSystem.Value[var12 + var11];
                        if(this.valueToPush != null) {
                            System.arraycopy(this.valueToPush, 0, var13, 0, var12);
                        }

                        for(this.valueToPush = var13; var12 < -1 + this.valueToPush.length; ++var12) {
                            this.valueToPush[var12] = new TypeSystem.Value();
                            var1.readMessage(this.valueToPush[var12]);
                            var1.readTag();
                        }

                        this.valueToPush[var12] = new TypeSystem.Value();
                        var1.readMessage(this.valueToPush[var12]);
                        break;
                    case 18:
                        int var7 = WireFormatNano.getRepeatedFieldArrayLength(var1, 18);
                        int var8;
                        if(this.valueToClear == null) {
                            var8 = 0;
                        } else {
                            var8 = this.valueToClear.length;
                        }

                        TypeSystem.Value[] var9 = new TypeSystem.Value[var8 + var7];
                        if(this.valueToClear != null) {
                            System.arraycopy(this.valueToClear, 0, var9, 0, var8);
                        }

                        for(this.valueToClear = var9; var8 < -1 + this.valueToClear.length; ++var8) {
                            this.valueToClear[var8] = new TypeSystem.Value();
                            var1.readMessage(this.valueToClear[var8]);
                            var1.readTag();
                        }

                        this.valueToClear[var8] = new TypeSystem.Value();
                        var1.readMessage(this.valueToClear[var8]);
                        break;
                    case 26:
                        int var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 26);
                        int var4;
                        if(this.experimentRandom == null) {
                            var4 = 0;
                        } else {
                            var4 = this.experimentRandom.length;
                        }

                        Serving.GaExperimentRandom[] var5 = new Serving.GaExperimentRandom[var4 + var3];
                        if(this.experimentRandom != null) {
                            System.arraycopy(this.experimentRandom, 0, var5, 0, var4);
                        }

                        for(this.experimentRandom = var5; var4 < -1 + this.experimentRandom.length; ++var4) {
                            this.experimentRandom[var4] = new Serving.GaExperimentRandom();
                            var1.readMessage(this.experimentRandom[var4]);
                            var1.readTag();
                        }

                        this.experimentRandom[var4] = new Serving.GaExperimentRandom();
                        var1.readMessage(this.experimentRandom[var4]);
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
            if(this.valueToPush != null) {
                TypeSystem.Value[] var8 = this.valueToPush;
                int var9 = var8.length;

                for(int var10 = 0; var10 < var9; ++var10) {
                    var1.writeMessage(1, var8[var10]);
                }
            }

            if(this.valueToClear != null) {
                TypeSystem.Value[] var5 = this.valueToClear;
                int var6 = var5.length;

                for(int var7 = 0; var7 < var6; ++var7) {
                    var1.writeMessage(2, var5[var7]);
                }
            }

            if(this.experimentRandom != null) {
                Serving.GaExperimentRandom[] var2 = this.experimentRandom;
                int var3 = var2.length;

                for(int var4 = 0; var4 < var3; ++var4) {
                    var1.writeMessage(3, var2[var4]);
                }
            }

            WireFormatNano.writeUnknownFields(this.unknownFieldData, var1);
        }
    }

    public static final class Property extends ExtendableMessageNano {
        public static final Serving.Property[] EMPTY_ARRAY = new Serving.Property[0];
        public int key = 0;
        public int value = 0;

        public static Serving.Property parseFrom(CodedInputByteBufferNano var0) throws IOException {
            return (new Serving.Property()).mergeFrom(var0);
        }

        public static Serving.Property parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
            return (Serving.Property)MessageNano.mergeFrom(new Serving.Property(), var0);
        }

        public final Serving.Property clear() {
            this.key = 0;
            this.value = 0;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final boolean equals(Object var1) {
            if(var1 != this) {
                if(!(var1 instanceof Serving.Property)) {
                    return false;
                } else {
                    Serving.Property var2 = (Serving.Property)var1;
                    if(this.key == var2.key && this.value == var2.value) {
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
            int var1 = 0 + CodedOutputByteBufferNano.computeInt32Size(1, this.key) + CodedOutputByteBufferNano.computeInt32Size(2, this.value) + WireFormatNano.computeWireSize(this.unknownFieldData);
            this.cachedSize = var1;
            return var1;
        }

        public int hashCode() {
            int var1 = 31 * (31 * (527 + this.key) + this.value);
            int var2;
            if(this.unknownFieldData == null) {
                var2 = 0;
            } else {
                var2 = this.unknownFieldData.hashCode();
            }

            return var1 + var2;
        }

        public Serving.Property mergeFrom(CodedInputByteBufferNano var1) throws IOException {
            while(true) {
                int var2 = var1.readTag();
                switch(var2) {
                    case 8:
                        this.key = var1.readInt32();
                        break;
                    case 16:
                        this.value = var1.readInt32();
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
            var1.writeInt32(1, this.key);
            var1.writeInt32(2, this.value);
            WireFormatNano.writeUnknownFields(this.unknownFieldData, var1);
        }
    }

    public static final class Resource extends ExtendableMessageNano {
        public static final Serving.Resource[] EMPTY_ARRAY = new Serving.Resource[0];
        private static final String TEMPLATE_VERSION_SET_DEFAULT = "0";
        public String[] key;
        public Serving.CacheOption liveJsCacheOption;
        public Serving.FunctionCall[] macro;
        public String malwareScanAuthCode;
        public boolean oBSOLETEEnableAutoEventTracking;
        public Serving.FunctionCall[] predicate;
        public String previewAuthCode;
        public Serving.Property[] property;
        public float reportingSampleRate;
        public int resourceFormatVersion;
        public Serving.Rule[] rule;
        public String[] supplemental;
        public Serving.FunctionCall[] tag;
        public String templateVersionSet;
        public String[] usageContext;
        public TypeSystem.Value[] value;
        public String version;

        public Resource() {
            this.supplemental = WireFormatNano.EMPTY_STRING_ARRAY;
            this.key = WireFormatNano.EMPTY_STRING_ARRAY;
            this.value = TypeSystem.Value.EMPTY_ARRAY;
            this.property = Serving.Property.EMPTY_ARRAY;
            this.macro = Serving.FunctionCall.EMPTY_ARRAY;
            this.tag = Serving.FunctionCall.EMPTY_ARRAY;
            this.predicate = Serving.FunctionCall.EMPTY_ARRAY;
            this.rule = Serving.Rule.EMPTY_ARRAY;
            this.previewAuthCode = "";
            this.malwareScanAuthCode = "";
            this.templateVersionSet = "0";
            this.version = "";
            this.liveJsCacheOption = null;
            this.reportingSampleRate = 0.0F;
            this.oBSOLETEEnableAutoEventTracking = false;
            this.usageContext = WireFormatNano.EMPTY_STRING_ARRAY;
            this.resourceFormatVersion = 0;
        }

        public static Serving.Resource parseFrom(CodedInputByteBufferNano var0) throws IOException {
            return (new Serving.Resource()).mergeFrom(var0);
        }

        public static Serving.Resource parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
            return (Serving.Resource)MessageNano.mergeFrom(new Serving.Resource(), var0);
        }

        public final Serving.Resource clear() {
            this.supplemental = WireFormatNano.EMPTY_STRING_ARRAY;
            this.key = WireFormatNano.EMPTY_STRING_ARRAY;
            this.value = TypeSystem.Value.EMPTY_ARRAY;
            this.property = Serving.Property.EMPTY_ARRAY;
            this.macro = Serving.FunctionCall.EMPTY_ARRAY;
            this.tag = Serving.FunctionCall.EMPTY_ARRAY;
            this.predicate = Serving.FunctionCall.EMPTY_ARRAY;
            this.rule = Serving.Rule.EMPTY_ARRAY;
            this.previewAuthCode = "";
            this.malwareScanAuthCode = "";
            this.templateVersionSet = "0";
            this.version = "";
            this.liveJsCacheOption = null;
            this.reportingSampleRate = 0.0F;
            this.oBSOLETEEnableAutoEventTracking = false;
            this.usageContext = WireFormatNano.EMPTY_STRING_ARRAY;
            this.resourceFormatVersion = 0;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final boolean equals(Object var1) {
            if(var1 != this) {
                if(!(var1 instanceof Serving.Resource)) {
                    return false;
                } else {
                    Serving.Resource var2 = (Serving.Resource)var1;
                    if(Arrays.equals(this.supplemental, var2.supplemental) && Arrays.equals(this.key, var2.key) && Arrays.equals(this.value, var2.value) && Arrays.equals(this.property, var2.property) && Arrays.equals(this.macro, var2.macro) && Arrays.equals(this.tag, var2.tag) && Arrays.equals(this.predicate, var2.predicate) && Arrays.equals(this.rule, var2.rule)) {
                        if(this.previewAuthCode == null) {
                            if(var2.previewAuthCode != null) {
                                return false;
                            }
                        } else if(!this.previewAuthCode.equals(var2.previewAuthCode)) {
                            return false;
                        }

                        if(this.malwareScanAuthCode == null) {
                            if(var2.malwareScanAuthCode != null) {
                                return false;
                            }
                        } else if(!this.malwareScanAuthCode.equals(var2.malwareScanAuthCode)) {
                            return false;
                        }

                        if(this.templateVersionSet == null) {
                            if(var2.templateVersionSet != null) {
                                return false;
                            }
                        } else if(!this.templateVersionSet.equals(var2.templateVersionSet)) {
                            return false;
                        }

                        if(this.version == null) {
                            if(var2.version != null) {
                                return false;
                            }
                        } else if(!this.version.equals(var2.version)) {
                            return false;
                        }

                        if(this.liveJsCacheOption == null) {
                            if(var2.liveJsCacheOption != null) {
                                return false;
                            }
                        } else if(!this.liveJsCacheOption.equals(var2.liveJsCacheOption)) {
                            return false;
                        }

                        if(this.reportingSampleRate == var2.reportingSampleRate && this.oBSOLETEEnableAutoEventTracking == var2.oBSOLETEEnableAutoEventTracking && Arrays.equals(this.usageContext, var2.usageContext) && this.resourceFormatVersion == var2.resourceFormatVersion) {
                            if(this.unknownFieldData == null) {
                                if(var2.unknownFieldData == null) {
                                    return true;
                                }
                            } else if(this.unknownFieldData.equals(var2.unknownFieldData)) {
                                return true;
                            }
                        }
                    }

                    return false;
                }
            } else {
                return true;
            }
        }

        public int getSerializedSize() {
            String[] var1 = this.key;
            int var2 = 0;
            if(var1 != null) {
                int var30 = this.key.length;
                var2 = 0;
                if(var30 > 0) {
                    int var31 = 0;
                    String[] var32 = this.key;
                    int var33 = var32.length;

                    for(int var34 = 0; var34 < var33; ++var34) {
                        var31 += CodedOutputByteBufferNano.computeStringSizeNoTag(var32[var34]);
                    }

                    var2 = 0 + var31 + 1 * this.key.length;
                }
            }

            if(this.value != null) {
                TypeSystem.Value[] var27 = this.value;
                int var28 = var27.length;

                for(int var29 = 0; var29 < var28; ++var29) {
                    var2 += CodedOutputByteBufferNano.computeMessageSize(2, var27[var29]);
                }
            }

            if(this.property != null) {
                Serving.Property[] var24 = this.property;
                int var25 = var24.length;

                for(int var26 = 0; var26 < var25; ++var26) {
                    var2 += CodedOutputByteBufferNano.computeMessageSize(3, var24[var26]);
                }
            }

            if(this.macro != null) {
                Serving.FunctionCall[] var21 = this.macro;
                int var22 = var21.length;

                for(int var23 = 0; var23 < var22; ++var23) {
                    var2 += CodedOutputByteBufferNano.computeMessageSize(4, var21[var23]);
                }
            }

            if(this.tag != null) {
                Serving.FunctionCall[] var18 = this.tag;
                int var19 = var18.length;

                for(int var20 = 0; var20 < var19; ++var20) {
                    var2 += CodedOutputByteBufferNano.computeMessageSize(5, var18[var20]);
                }
            }

            if(this.predicate != null) {
                Serving.FunctionCall[] var15 = this.predicate;
                int var16 = var15.length;

                for(int var17 = 0; var17 < var16; ++var17) {
                    var2 += CodedOutputByteBufferNano.computeMessageSize(6, var15[var17]);
                }
            }

            if(this.rule != null) {
                Serving.Rule[] var12 = this.rule;
                int var13 = var12.length;

                for(int var14 = 0; var14 < var13; ++var14) {
                    var2 += CodedOutputByteBufferNano.computeMessageSize(7, var12[var14]);
                }
            }

            if(!this.previewAuthCode.equals("")) {
                var2 += CodedOutputByteBufferNano.computeStringSize(9, this.previewAuthCode);
            }

            if(!this.malwareScanAuthCode.equals("")) {
                var2 += CodedOutputByteBufferNano.computeStringSize(10, this.malwareScanAuthCode);
            }

            if(!this.templateVersionSet.equals("0")) {
                var2 += CodedOutputByteBufferNano.computeStringSize(12, this.templateVersionSet);
            }

            if(!this.version.equals("")) {
                var2 += CodedOutputByteBufferNano.computeStringSize(13, this.version);
            }

            if(this.liveJsCacheOption != null) {
                var2 += CodedOutputByteBufferNano.computeMessageSize(14, this.liveJsCacheOption);
            }

            if(this.reportingSampleRate != 0.0F) {
                var2 += CodedOutputByteBufferNano.computeFloatSize(15, this.reportingSampleRate);
            }

            if(this.usageContext != null && this.usageContext.length > 0) {
                int var8 = 0;
                String[] var9 = this.usageContext;
                int var10 = var9.length;

                for(int var11 = 0; var11 < var10; ++var11) {
                    var8 += CodedOutputByteBufferNano.computeStringSizeNoTag(var9[var11]);
                }

                var2 = var2 + var8 + 2 * this.usageContext.length;
            }

            if(this.resourceFormatVersion != 0) {
                var2 += CodedOutputByteBufferNano.computeInt32Size(17, this.resourceFormatVersion);
            }

            if(this.oBSOLETEEnableAutoEventTracking) {
                var2 += CodedOutputByteBufferNano.computeBoolSize(18, this.oBSOLETEEnableAutoEventTracking);
            }

            if(this.supplemental != null && this.supplemental.length > 0) {
                int var4 = 0;
                String[] var5 = this.supplemental;
                int var6 = var5.length;

                for(int var7 = 0; var7 < var6; ++var7) {
                    var4 += CodedOutputByteBufferNano.computeStringSizeNoTag(var5[var7]);
                }

                var2 = var2 + var4 + 2 * this.supplemental.length;
            }

            int var3 = var2 + WireFormatNano.computeWireSize(this.unknownFieldData);
            this.cachedSize = var3;
            return var3;
        }

        public int hashCode() {
            int var1 = 17;
            if(this.supplemental == null) {
                var1 *= 31;
            } else {
                for(int var2 = 0; var2 < this.supplemental.length; ++var2) {
                    int var3 = var1 * 31;
                    int var4;
                    if(this.supplemental[var2] == null) {
                        var4 = 0;
                    } else {
                        var4 = this.supplemental[var2].hashCode();
                    }

                    var1 = var3 + var4;
                }
            }

            if(this.key == null) {
                var1 *= 31;
            } else {
                for(int var5 = 0; var5 < this.key.length; ++var5) {
                    int var6 = var1 * 31;
                    int var7;
                    if(this.key[var5] == null) {
                        var7 = 0;
                    } else {
                        var7 = this.key[var5].hashCode();
                    }

                    var1 = var6 + var7;
                }
            }

            if(this.value == null) {
                var1 *= 31;
            } else {
                for(int var8 = 0; var8 < this.value.length; ++var8) {
                    int var9 = var1 * 31;
                    int var10;
                    if(this.value[var8] == null) {
                        var10 = 0;
                    } else {
                        var10 = this.value[var8].hashCode();
                    }

                    var1 = var9 + var10;
                }
            }

            if(this.property == null) {
                var1 *= 31;
            } else {
                for(int var11 = 0; var11 < this.property.length; ++var11) {
                    int var12 = var1 * 31;
                    int var13;
                    if(this.property[var11] == null) {
                        var13 = 0;
                    } else {
                        var13 = this.property[var11].hashCode();
                    }

                    var1 = var12 + var13;
                }
            }

            if(this.macro == null) {
                var1 *= 31;
            } else {
                for(int var14 = 0; var14 < this.macro.length; ++var14) {
                    int var15 = var1 * 31;
                    int var16;
                    if(this.macro[var14] == null) {
                        var16 = 0;
                    } else {
                        var16 = this.macro[var14].hashCode();
                    }

                    var1 = var15 + var16;
                }
            }

            if(this.tag == null) {
                var1 *= 31;
            } else {
                for(int var17 = 0; var17 < this.tag.length; ++var17) {
                    int var18 = var1 * 31;
                    int var19;
                    if(this.tag[var17] == null) {
                        var19 = 0;
                    } else {
                        var19 = this.tag[var17].hashCode();
                    }

                    var1 = var18 + var19;
                }
            }

            if(this.predicate == null) {
                var1 *= 31;
            } else {
                for(int var20 = 0; var20 < this.predicate.length; ++var20) {
                    int var21 = var1 * 31;
                    int var22;
                    if(this.predicate[var20] == null) {
                        var22 = 0;
                    } else {
                        var22 = this.predicate[var20].hashCode();
                    }

                    var1 = var21 + var22;
                }
            }

            if(this.rule == null) {
                var1 *= 31;
            } else {
                for(int var23 = 0; var23 < this.rule.length; ++var23) {
                    int var24 = var1 * 31;
                    int var25;
                    if(this.rule[var23] == null) {
                        var25 = 0;
                    } else {
                        var25 = this.rule[var23].hashCode();
                    }

                    var1 = var24 + var25;
                }
            }

            int var26 = var1 * 31;
            int var27;
            if(this.previewAuthCode == null) {
                var27 = 0;
            } else {
                var27 = this.previewAuthCode.hashCode();
            }

            int var28 = 31 * (var26 + var27);
            int var29;
            if(this.malwareScanAuthCode == null) {
                var29 = 0;
            } else {
                var29 = this.malwareScanAuthCode.hashCode();
            }

            int var30 = 31 * (var28 + var29);
            int var31;
            if(this.templateVersionSet == null) {
                var31 = 0;
            } else {
                var31 = this.templateVersionSet.hashCode();
            }

            int var32 = 31 * (var30 + var31);
            int var33;
            if(this.version == null) {
                var33 = 0;
            } else {
                var33 = this.version.hashCode();
            }

            int var34 = 31 * (var32 + var33);
            int var35;
            if(this.liveJsCacheOption == null) {
                var35 = 0;
            } else {
                var35 = this.liveJsCacheOption.hashCode();
            }

            int var36 = 31 * (31 * (var34 + var35) + Float.floatToIntBits(this.reportingSampleRate));
            byte var37;
            if(this.oBSOLETEEnableAutoEventTracking) {
                var37 = 1;
            } else {
                var37 = 2;
            }

            int var38 = var36 + var37;
            if(this.usageContext == null) {
                var38 *= 31;
            } else {
                for(int var39 = 0; var39 < this.usageContext.length; ++var39) {
                    int var40 = var38 * 31;
                    int var41;
                    if(this.usageContext[var39] == null) {
                        var41 = 0;
                    } else {
                        var41 = this.usageContext[var39].hashCode();
                    }

                    var38 = var40 + var41;
                }
            }

            int var42 = 31 * (var38 * 31 + this.resourceFormatVersion);
            List var43 = this.unknownFieldData;
            int var44 = 0;
            if(var43 != null) {
                var44 = this.unknownFieldData.hashCode();
            }

            return var42 + var44;
        }

        public Serving.Resource mergeFrom(CodedInputByteBufferNano var1) throws IOException {
            while(true) {
                int var2 = var1.readTag();
                switch(var2) {
                    case 10:
                        int var35 = WireFormatNano.getRepeatedFieldArrayLength(var1, 10);
                        int var36 = this.key.length;
                        String[] var37 = new String[var36 + var35];
                        System.arraycopy(this.key, 0, var37, 0, var36);

                        for(this.key = var37; var36 < -1 + this.key.length; ++var36) {
                            this.key[var36] = var1.readString();
                            var1.readTag();
                        }

                        this.key[var36] = var1.readString();
                        break;
                    case 18:
                        int var31 = WireFormatNano.getRepeatedFieldArrayLength(var1, 18);
                        int var32;
                        if(this.value == null) {
                            var32 = 0;
                        } else {
                            var32 = this.value.length;
                        }

                        TypeSystem.Value[] var33 = new TypeSystem.Value[var32 + var31];
                        if(this.value != null) {
                            System.arraycopy(this.value, 0, var33, 0, var32);
                        }

                        for(this.value = var33; var32 < -1 + this.value.length; ++var32) {
                            this.value[var32] = new TypeSystem.Value();
                            var1.readMessage(this.value[var32]);
                            var1.readTag();
                        }

                        this.value[var32] = new TypeSystem.Value();
                        var1.readMessage(this.value[var32]);
                        break;
                    case 26:
                        int var27 = WireFormatNano.getRepeatedFieldArrayLength(var1, 26);
                        int var28;
                        if(this.property == null) {
                            var28 = 0;
                        } else {
                            var28 = this.property.length;
                        }

                        Serving.Property[] var29 = new Serving.Property[var28 + var27];
                        if(this.property != null) {
                            System.arraycopy(this.property, 0, var29, 0, var28);
                        }

                        for(this.property = var29; var28 < -1 + this.property.length; ++var28) {
                            this.property[var28] = new Serving.Property();
                            var1.readMessage(this.property[var28]);
                            var1.readTag();
                        }

                        this.property[var28] = new Serving.Property();
                        var1.readMessage(this.property[var28]);
                        break;
                    case 34:
                        int var23 = WireFormatNano.getRepeatedFieldArrayLength(var1, 34);
                        int var24;
                        if(this.macro == null) {
                            var24 = 0;
                        } else {
                            var24 = this.macro.length;
                        }

                        Serving.FunctionCall[] var25 = new Serving.FunctionCall[var24 + var23];
                        if(this.macro != null) {
                            System.arraycopy(this.macro, 0, var25, 0, var24);
                        }

                        for(this.macro = var25; var24 < -1 + this.macro.length; ++var24) {
                            this.macro[var24] = new Serving.FunctionCall();
                            var1.readMessage(this.macro[var24]);
                            var1.readTag();
                        }

                        this.macro[var24] = new Serving.FunctionCall();
                        var1.readMessage(this.macro[var24]);
                        break;
                    case 42:
                        int var19 = WireFormatNano.getRepeatedFieldArrayLength(var1, 42);
                        int var20;
                        if(this.tag == null) {
                            var20 = 0;
                        } else {
                            var20 = this.tag.length;
                        }

                        Serving.FunctionCall[] var21 = new Serving.FunctionCall[var20 + var19];
                        if(this.tag != null) {
                            System.arraycopy(this.tag, 0, var21, 0, var20);
                        }

                        for(this.tag = var21; var20 < -1 + this.tag.length; ++var20) {
                            this.tag[var20] = new Serving.FunctionCall();
                            var1.readMessage(this.tag[var20]);
                            var1.readTag();
                        }

                        this.tag[var20] = new Serving.FunctionCall();
                        var1.readMessage(this.tag[var20]);
                        break;
                    case 50:
                        int var15 = WireFormatNano.getRepeatedFieldArrayLength(var1, 50);
                        int var16;
                        if(this.predicate == null) {
                            var16 = 0;
                        } else {
                            var16 = this.predicate.length;
                        }

                        Serving.FunctionCall[] var17 = new Serving.FunctionCall[var16 + var15];
                        if(this.predicate != null) {
                            System.arraycopy(this.predicate, 0, var17, 0, var16);
                        }

                        for(this.predicate = var17; var16 < -1 + this.predicate.length; ++var16) {
                            this.predicate[var16] = new Serving.FunctionCall();
                            var1.readMessage(this.predicate[var16]);
                            var1.readTag();
                        }

                        this.predicate[var16] = new Serving.FunctionCall();
                        var1.readMessage(this.predicate[var16]);
                        break;
                    case 58:
                        int var11 = WireFormatNano.getRepeatedFieldArrayLength(var1, 58);
                        int var12;
                        if(this.rule == null) {
                            var12 = 0;
                        } else {
                            var12 = this.rule.length;
                        }

                        Serving.Rule[] var13 = new Serving.Rule[var12 + var11];
                        if(this.rule != null) {
                            System.arraycopy(this.rule, 0, var13, 0, var12);
                        }

                        for(this.rule = var13; var12 < -1 + this.rule.length; ++var12) {
                            this.rule[var12] = new Serving.Rule();
                            var1.readMessage(this.rule[var12]);
                            var1.readTag();
                        }

                        this.rule[var12] = new Serving.Rule();
                        var1.readMessage(this.rule[var12]);
                        break;
                    case 74:
                        this.previewAuthCode = var1.readString();
                        break;
                    case 82:
                        this.malwareScanAuthCode = var1.readString();
                        break;
                    case 98:
                        this.templateVersionSet = var1.readString();
                        break;
                    case 106:
                        this.version = var1.readString();
                        break;
                    case 114:
                        this.liveJsCacheOption = new Serving.CacheOption();
                        var1.readMessage(this.liveJsCacheOption);
                        break;
                    case 125:
                        this.reportingSampleRate = var1.readFloat();
                        break;
                    case 130:
                        int var7 = WireFormatNano.getRepeatedFieldArrayLength(var1, 130);
                        int var8 = this.usageContext.length;
                        String[] var9 = new String[var8 + var7];
                        System.arraycopy(this.usageContext, 0, var9, 0, var8);

                        for(this.usageContext = var9; var8 < -1 + this.usageContext.length; ++var8) {
                            this.usageContext[var8] = var1.readString();
                            var1.readTag();
                        }

                        this.usageContext[var8] = var1.readString();
                        break;
                    case 136:
                        this.resourceFormatVersion = var1.readInt32();
                        break;
                    case 144:
                        this.oBSOLETEEnableAutoEventTracking = var1.readBool();
                        break;
                    case 154:
                        int var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 154);
                        int var4 = this.supplemental.length;
                        String[] var5 = new String[var4 + var3];
                        System.arraycopy(this.supplemental, 0, var5, 0, var4);

                        for(this.supplemental = var5; var4 < -1 + this.supplemental.length; ++var4) {
                            this.supplemental[var4] = var1.readString();
                            var1.readTag();
                        }

                        this.supplemental[var4] = var1.readString();
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
            if(this.key != null) {
                String[] var26 = this.key;
                int var27 = var26.length;

                for(int var28 = 0; var28 < var27; ++var28) {
                    var1.writeString(1, var26[var28]);
                }
            }

            if(this.value != null) {
                TypeSystem.Value[] var23 = this.value;
                int var24 = var23.length;

                for(int var25 = 0; var25 < var24; ++var25) {
                    var1.writeMessage(2, var23[var25]);
                }
            }

            if(this.property != null) {
                Serving.Property[] var20 = this.property;
                int var21 = var20.length;

                for(int var22 = 0; var22 < var21; ++var22) {
                    var1.writeMessage(3, var20[var22]);
                }
            }

            if(this.macro != null) {
                Serving.FunctionCall[] var17 = this.macro;
                int var18 = var17.length;

                for(int var19 = 0; var19 < var18; ++var19) {
                    var1.writeMessage(4, var17[var19]);
                }
            }

            if(this.tag != null) {
                Serving.FunctionCall[] var14 = this.tag;
                int var15 = var14.length;

                for(int var16 = 0; var16 < var15; ++var16) {
                    var1.writeMessage(5, var14[var16]);
                }
            }

            if(this.predicate != null) {
                Serving.FunctionCall[] var11 = this.predicate;
                int var12 = var11.length;

                for(int var13 = 0; var13 < var12; ++var13) {
                    var1.writeMessage(6, var11[var13]);
                }
            }

            if(this.rule != null) {
                Serving.Rule[] var8 = this.rule;
                int var9 = var8.length;

                for(int var10 = 0; var10 < var9; ++var10) {
                    var1.writeMessage(7, var8[var10]);
                }
            }

            if(!this.previewAuthCode.equals("")) {
                var1.writeString(9, this.previewAuthCode);
            }

            if(!this.malwareScanAuthCode.equals("")) {
                var1.writeString(10, this.malwareScanAuthCode);
            }

            if(!this.templateVersionSet.equals("0")) {
                var1.writeString(12, this.templateVersionSet);
            }

            if(!this.version.equals("")) {
                var1.writeString(13, this.version);
            }

            if(this.liveJsCacheOption != null) {
                var1.writeMessage(14, this.liveJsCacheOption);
            }

            if(this.reportingSampleRate != 0.0F) {
                var1.writeFloat(15, this.reportingSampleRate);
            }

            if(this.usageContext != null) {
                String[] var5 = this.usageContext;
                int var6 = var5.length;

                for(int var7 = 0; var7 < var6; ++var7) {
                    var1.writeString(16, var5[var7]);
                }
            }

            if(this.resourceFormatVersion != 0) {
                var1.writeInt32(17, this.resourceFormatVersion);
            }

            if(this.oBSOLETEEnableAutoEventTracking) {
                var1.writeBool(18, this.oBSOLETEEnableAutoEventTracking);
            }

            if(this.supplemental != null) {
                String[] var2 = this.supplemental;
                int var3 = var2.length;

                for(int var4 = 0; var4 < var3; ++var4) {
                    var1.writeString(19, var2[var4]);
                }
            }

            WireFormatNano.writeUnknownFields(this.unknownFieldData, var1);
        }
    }

    public interface ResourceState {
        int LIVE = 2;
        int PREVIEW = 1;
    }

    public interface ResourceType {
        int CLEAR_CACHE = 6;
        int GET_COOKIE = 5;
        int JS_RESOURCE = 1;
        int NS_RESOURCE = 2;
        int PIXEL_COLLECTION = 3;
        int RAW_PROTO = 7;
        int SET_COOKIE = 4;
    }

    public static final class Rule extends ExtendableMessageNano {
        public static final Serving.Rule[] EMPTY_ARRAY = new Serving.Rule[0];
        public int[] addMacro;
        public int[] addMacroRuleName;
        public int[] addTag;
        public int[] addTagRuleName;
        public int[] negativePredicate;
        public int[] positivePredicate;
        public int[] removeMacro;
        public int[] removeMacroRuleName;
        public int[] removeTag;
        public int[] removeTagRuleName;

        public Rule() {
            this.positivePredicate = WireFormatNano.EMPTY_INT_ARRAY;
            this.negativePredicate = WireFormatNano.EMPTY_INT_ARRAY;
            this.addTag = WireFormatNano.EMPTY_INT_ARRAY;
            this.removeTag = WireFormatNano.EMPTY_INT_ARRAY;
            this.addTagRuleName = WireFormatNano.EMPTY_INT_ARRAY;
            this.removeTagRuleName = WireFormatNano.EMPTY_INT_ARRAY;
            this.addMacro = WireFormatNano.EMPTY_INT_ARRAY;
            this.removeMacro = WireFormatNano.EMPTY_INT_ARRAY;
            this.addMacroRuleName = WireFormatNano.EMPTY_INT_ARRAY;
            this.removeMacroRuleName = WireFormatNano.EMPTY_INT_ARRAY;
        }

        public static Serving.Rule parseFrom(CodedInputByteBufferNano var0) throws IOException {
            return (new Serving.Rule()).mergeFrom(var0);
        }

        public static Serving.Rule parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
            return (Serving.Rule)MessageNano.mergeFrom(new Serving.Rule(), var0);
        }

        public final Serving.Rule clear() {
            this.positivePredicate = WireFormatNano.EMPTY_INT_ARRAY;
            this.negativePredicate = WireFormatNano.EMPTY_INT_ARRAY;
            this.addTag = WireFormatNano.EMPTY_INT_ARRAY;
            this.removeTag = WireFormatNano.EMPTY_INT_ARRAY;
            this.addTagRuleName = WireFormatNano.EMPTY_INT_ARRAY;
            this.removeTagRuleName = WireFormatNano.EMPTY_INT_ARRAY;
            this.addMacro = WireFormatNano.EMPTY_INT_ARRAY;
            this.removeMacro = WireFormatNano.EMPTY_INT_ARRAY;
            this.addMacroRuleName = WireFormatNano.EMPTY_INT_ARRAY;
            this.removeMacroRuleName = WireFormatNano.EMPTY_INT_ARRAY;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final boolean equals(Object var1) {
            if(var1 != this) {
                if(!(var1 instanceof Serving.Rule)) {
                    return false;
                }

                Serving.Rule var2 = (Serving.Rule)var1;
                if(!Arrays.equals(this.positivePredicate, var2.positivePredicate) || !Arrays.equals(this.negativePredicate, var2.negativePredicate) || !Arrays.equals(this.addTag, var2.addTag) || !Arrays.equals(this.removeTag, var2.removeTag) || !Arrays.equals(this.addTagRuleName, var2.addTagRuleName) || !Arrays.equals(this.removeTagRuleName, var2.removeTagRuleName) || !Arrays.equals(this.addMacro, var2.addMacro) || !Arrays.equals(this.removeMacro, var2.removeMacro) || !Arrays.equals(this.addMacroRuleName, var2.addMacroRuleName) || !Arrays.equals(this.removeMacroRuleName, var2.removeMacroRuleName)) {
                    return false;
                }

                if(this.unknownFieldData != null) {
                    if(this.unknownFieldData.equals(var2.unknownFieldData)) {
                        return true;
                    }

                    return false;
                }

                if(var2.unknownFieldData != null) {
                    return false;
                }
            }

            return true;
        }

        public int getSerializedSize() {
            int[] var1 = this.positivePredicate;
            int var2 = 0;
            if(var1 != null) {
                int var40 = this.positivePredicate.length;
                var2 = 0;
                if(var40 > 0) {
                    int var41 = 0;
                    int[] var42 = this.positivePredicate;
                    int var43 = var42.length;

                    for(int var44 = 0; var44 < var43; ++var44) {
                        var41 += CodedOutputByteBufferNano.computeInt32SizeNoTag(var42[var44]);
                    }

                    var2 = 0 + var41 + 1 * this.positivePredicate.length;
                }
            }

            if(this.negativePredicate != null && this.negativePredicate.length > 0) {
                int var36 = 0;
                int[] var37 = this.negativePredicate;
                int var38 = var37.length;

                for(int var39 = 0; var39 < var38; ++var39) {
                    var36 += CodedOutputByteBufferNano.computeInt32SizeNoTag(var37[var39]);
                }

                var2 = var2 + var36 + 1 * this.negativePredicate.length;
            }

            if(this.addTag != null && this.addTag.length > 0) {
                int var32 = 0;
                int[] var33 = this.addTag;
                int var34 = var33.length;

                for(int var35 = 0; var35 < var34; ++var35) {
                    var32 += CodedOutputByteBufferNano.computeInt32SizeNoTag(var33[var35]);
                }

                var2 = var2 + var32 + 1 * this.addTag.length;
            }

            if(this.removeTag != null && this.removeTag.length > 0) {
                int var28 = 0;
                int[] var29 = this.removeTag;
                int var30 = var29.length;

                for(int var31 = 0; var31 < var30; ++var31) {
                    var28 += CodedOutputByteBufferNano.computeInt32SizeNoTag(var29[var31]);
                }

                var2 = var2 + var28 + 1 * this.removeTag.length;
            }

            if(this.addTagRuleName != null && this.addTagRuleName.length > 0) {
                int var24 = 0;
                int[] var25 = this.addTagRuleName;
                int var26 = var25.length;

                for(int var27 = 0; var27 < var26; ++var27) {
                    var24 += CodedOutputByteBufferNano.computeInt32SizeNoTag(var25[var27]);
                }

                var2 = var2 + var24 + 1 * this.addTagRuleName.length;
            }

            if(this.removeTagRuleName != null && this.removeTagRuleName.length > 0) {
                int var20 = 0;
                int[] var21 = this.removeTagRuleName;
                int var22 = var21.length;

                for(int var23 = 0; var23 < var22; ++var23) {
                    var20 += CodedOutputByteBufferNano.computeInt32SizeNoTag(var21[var23]);
                }

                var2 = var2 + var20 + 1 * this.removeTagRuleName.length;
            }

            if(this.addMacro != null && this.addMacro.length > 0) {
                int var16 = 0;
                int[] var17 = this.addMacro;
                int var18 = var17.length;

                for(int var19 = 0; var19 < var18; ++var19) {
                    var16 += CodedOutputByteBufferNano.computeInt32SizeNoTag(var17[var19]);
                }

                var2 = var2 + var16 + 1 * this.addMacro.length;
            }

            if(this.removeMacro != null && this.removeMacro.length > 0) {
                int var12 = 0;
                int[] var13 = this.removeMacro;
                int var14 = var13.length;

                for(int var15 = 0; var15 < var14; ++var15) {
                    var12 += CodedOutputByteBufferNano.computeInt32SizeNoTag(var13[var15]);
                }

                var2 = var2 + var12 + 1 * this.removeMacro.length;
            }

            if(this.addMacroRuleName != null && this.addMacroRuleName.length > 0) {
                int var8 = 0;
                int[] var9 = this.addMacroRuleName;
                int var10 = var9.length;

                for(int var11 = 0; var11 < var10; ++var11) {
                    var8 += CodedOutputByteBufferNano.computeInt32SizeNoTag(var9[var11]);
                }

                var2 = var2 + var8 + 1 * this.addMacroRuleName.length;
            }

            if(this.removeMacroRuleName != null && this.removeMacroRuleName.length > 0) {
                int var4 = 0;
                int[] var5 = this.removeMacroRuleName;
                int var6 = var5.length;

                for(int var7 = 0; var7 < var6; ++var7) {
                    var4 += CodedOutputByteBufferNano.computeInt32SizeNoTag(var5[var7]);
                }

                var2 = var2 + var4 + 1 * this.removeMacroRuleName.length;
            }

            int var3 = var2 + WireFormatNano.computeWireSize(this.unknownFieldData);
            this.cachedSize = var3;
            return var3;
        }

        public int hashCode() {
            int var1 = 17;
            if(this.positivePredicate == null) {
                var1 *= 31;
            } else {
                for(int var2 = 0; var2 < this.positivePredicate.length; ++var2) {
                    var1 = var1 * 31 + this.positivePredicate[var2];
                }
            }

            if(this.negativePredicate == null) {
                var1 *= 31;
            } else {
                for(int var3 = 0; var3 < this.negativePredicate.length; ++var3) {
                    var1 = var1 * 31 + this.negativePredicate[var3];
                }
            }

            if(this.addTag == null) {
                var1 *= 31;
            } else {
                for(int var4 = 0; var4 < this.addTag.length; ++var4) {
                    var1 = var1 * 31 + this.addTag[var4];
                }
            }

            if(this.removeTag == null) {
                var1 *= 31;
            } else {
                for(int var5 = 0; var5 < this.removeTag.length; ++var5) {
                    var1 = var1 * 31 + this.removeTag[var5];
                }
            }

            if(this.addTagRuleName == null) {
                var1 *= 31;
            } else {
                for(int var6 = 0; var6 < this.addTagRuleName.length; ++var6) {
                    var1 = var1 * 31 + this.addTagRuleName[var6];
                }
            }

            if(this.removeTagRuleName == null) {
                var1 *= 31;
            } else {
                for(int var7 = 0; var7 < this.removeTagRuleName.length; ++var7) {
                    var1 = var1 * 31 + this.removeTagRuleName[var7];
                }
            }

            if(this.addMacro == null) {
                var1 *= 31;
            } else {
                for(int var8 = 0; var8 < this.addMacro.length; ++var8) {
                    var1 = var1 * 31 + this.addMacro[var8];
                }
            }

            if(this.removeMacro == null) {
                var1 *= 31;
            } else {
                for(int var9 = 0; var9 < this.removeMacro.length; ++var9) {
                    var1 = var1 * 31 + this.removeMacro[var9];
                }
            }

            if(this.addMacroRuleName == null) {
                var1 *= 31;
            } else {
                for(int var10 = 0; var10 < this.addMacroRuleName.length; ++var10) {
                    var1 = var1 * 31 + this.addMacroRuleName[var10];
                }
            }

            if(this.removeMacroRuleName == null) {
                var1 *= 31;
            } else {
                for(int var11 = 0; var11 < this.removeMacroRuleName.length; ++var11) {
                    var1 = var1 * 31 + this.removeMacroRuleName[var11];
                }
            }

            int var12 = var1 * 31;
            int var13;
            if(this.unknownFieldData == null) {
                var13 = 0;
            } else {
                var13 = this.unknownFieldData.hashCode();
            }

            return var12 + var13;
        }

        public Serving.Rule mergeFrom(CodedInputByteBufferNano var1) throws IOException {
            while(true) {
                int var2 = var1.readTag();
                switch(var2) {
                    case 8:
                        int var39 = WireFormatNano.getRepeatedFieldArrayLength(var1, 8);
                        int var40 = this.positivePredicate.length;
                        int[] var41 = new int[var40 + var39];
                        System.arraycopy(this.positivePredicate, 0, var41, 0, var40);

                        for(this.positivePredicate = var41; var40 < -1 + this.positivePredicate.length; ++var40) {
                            this.positivePredicate[var40] = var1.readInt32();
                            var1.readTag();
                        }

                        this.positivePredicate[var40] = var1.readInt32();
                        break;
                    case 16:
                        int var35 = WireFormatNano.getRepeatedFieldArrayLength(var1, 16);
                        int var36 = this.negativePredicate.length;
                        int[] var37 = new int[var36 + var35];
                        System.arraycopy(this.negativePredicate, 0, var37, 0, var36);

                        for(this.negativePredicate = var37; var36 < -1 + this.negativePredicate.length; ++var36) {
                            this.negativePredicate[var36] = var1.readInt32();
                            var1.readTag();
                        }

                        this.negativePredicate[var36] = var1.readInt32();
                        break;
                    case 24:
                        int var31 = WireFormatNano.getRepeatedFieldArrayLength(var1, 24);
                        int var32 = this.addTag.length;
                        int[] var33 = new int[var32 + var31];
                        System.arraycopy(this.addTag, 0, var33, 0, var32);

                        for(this.addTag = var33; var32 < -1 + this.addTag.length; ++var32) {
                            this.addTag[var32] = var1.readInt32();
                            var1.readTag();
                        }

                        this.addTag[var32] = var1.readInt32();
                        break;
                    case 32:
                        int var27 = WireFormatNano.getRepeatedFieldArrayLength(var1, 32);
                        int var28 = this.removeTag.length;
                        int[] var29 = new int[var28 + var27];
                        System.arraycopy(this.removeTag, 0, var29, 0, var28);

                        for(this.removeTag = var29; var28 < -1 + this.removeTag.length; ++var28) {
                            this.removeTag[var28] = var1.readInt32();
                            var1.readTag();
                        }

                        this.removeTag[var28] = var1.readInt32();
                        break;
                    case 40:
                        int var23 = WireFormatNano.getRepeatedFieldArrayLength(var1, 40);
                        int var24 = this.addTagRuleName.length;
                        int[] var25 = new int[var24 + var23];
                        System.arraycopy(this.addTagRuleName, 0, var25, 0, var24);

                        for(this.addTagRuleName = var25; var24 < -1 + this.addTagRuleName.length; ++var24) {
                            this.addTagRuleName[var24] = var1.readInt32();
                            var1.readTag();
                        }

                        this.addTagRuleName[var24] = var1.readInt32();
                        break;
                    case 48:
                        int var19 = WireFormatNano.getRepeatedFieldArrayLength(var1, 48);
                        int var20 = this.removeTagRuleName.length;
                        int[] var21 = new int[var20 + var19];
                        System.arraycopy(this.removeTagRuleName, 0, var21, 0, var20);

                        for(this.removeTagRuleName = var21; var20 < -1 + this.removeTagRuleName.length; ++var20) {
                            this.removeTagRuleName[var20] = var1.readInt32();
                            var1.readTag();
                        }

                        this.removeTagRuleName[var20] = var1.readInt32();
                        break;
                    case 56:
                        int var15 = WireFormatNano.getRepeatedFieldArrayLength(var1, 56);
                        int var16 = this.addMacro.length;
                        int[] var17 = new int[var16 + var15];
                        System.arraycopy(this.addMacro, 0, var17, 0, var16);

                        for(this.addMacro = var17; var16 < -1 + this.addMacro.length; ++var16) {
                            this.addMacro[var16] = var1.readInt32();
                            var1.readTag();
                        }

                        this.addMacro[var16] = var1.readInt32();
                        break;
                    case 64:
                        int var11 = WireFormatNano.getRepeatedFieldArrayLength(var1, 64);
                        int var12 = this.removeMacro.length;
                        int[] var13 = new int[var12 + var11];
                        System.arraycopy(this.removeMacro, 0, var13, 0, var12);

                        for(this.removeMacro = var13; var12 < -1 + this.removeMacro.length; ++var12) {
                            this.removeMacro[var12] = var1.readInt32();
                            var1.readTag();
                        }

                        this.removeMacro[var12] = var1.readInt32();
                        break;
                    case 72:
                        int var7 = WireFormatNano.getRepeatedFieldArrayLength(var1, 72);
                        int var8 = this.addMacroRuleName.length;
                        int[] var9 = new int[var8 + var7];
                        System.arraycopy(this.addMacroRuleName, 0, var9, 0, var8);

                        for(this.addMacroRuleName = var9; var8 < -1 + this.addMacroRuleName.length; ++var8) {
                            this.addMacroRuleName[var8] = var1.readInt32();
                            var1.readTag();
                        }

                        this.addMacroRuleName[var8] = var1.readInt32();
                        break;
                    case 80:
                        int var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 80);
                        int var4 = this.removeMacroRuleName.length;
                        int[] var5 = new int[var4 + var3];
                        System.arraycopy(this.removeMacroRuleName, 0, var5, 0, var4);

                        for(this.removeMacroRuleName = var5; var4 < -1 + this.removeMacroRuleName.length; ++var4) {
                            this.removeMacroRuleName[var4] = var1.readInt32();
                            var1.readTag();
                        }

                        this.removeMacroRuleName[var4] = var1.readInt32();
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
            if(this.positivePredicate != null) {
                int[] var29 = this.positivePredicate;
                int var30 = var29.length;

                for(int var31 = 0; var31 < var30; ++var31) {
                    var1.writeInt32(1, var29[var31]);
                }
            }

            if(this.negativePredicate != null) {
                int[] var26 = this.negativePredicate;
                int var27 = var26.length;

                for(int var28 = 0; var28 < var27; ++var28) {
                    var1.writeInt32(2, var26[var28]);
                }
            }

            if(this.addTag != null) {
                int[] var23 = this.addTag;
                int var24 = var23.length;

                for(int var25 = 0; var25 < var24; ++var25) {
                    var1.writeInt32(3, var23[var25]);
                }
            }

            if(this.removeTag != null) {
                int[] var20 = this.removeTag;
                int var21 = var20.length;

                for(int var22 = 0; var22 < var21; ++var22) {
                    var1.writeInt32(4, var20[var22]);
                }
            }

            if(this.addTagRuleName != null) {
                int[] var17 = this.addTagRuleName;
                int var18 = var17.length;

                for(int var19 = 0; var19 < var18; ++var19) {
                    var1.writeInt32(5, var17[var19]);
                }
            }

            if(this.removeTagRuleName != null) {
                int[] var14 = this.removeTagRuleName;
                int var15 = var14.length;

                for(int var16 = 0; var16 < var15; ++var16) {
                    var1.writeInt32(6, var14[var16]);
                }
            }

            if(this.addMacro != null) {
                int[] var11 = this.addMacro;
                int var12 = var11.length;

                for(int var13 = 0; var13 < var12; ++var13) {
                    var1.writeInt32(7, var11[var13]);
                }
            }

            if(this.removeMacro != null) {
                int[] var8 = this.removeMacro;
                int var9 = var8.length;

                for(int var10 = 0; var10 < var9; ++var10) {
                    var1.writeInt32(8, var8[var10]);
                }
            }

            if(this.addMacroRuleName != null) {
                int[] var5 = this.addMacroRuleName;
                int var6 = var5.length;

                for(int var7 = 0; var7 < var6; ++var7) {
                    var1.writeInt32(9, var5[var7]);
                }
            }

            if(this.removeMacroRuleName != null) {
                int[] var2 = this.removeMacroRuleName;
                int var3 = var2.length;

                for(int var4 = 0; var4 < var3; ++var4) {
                    var1.writeInt32(10, var2[var4]);
                }
            }

            WireFormatNano.writeUnknownFields(this.unknownFieldData, var1);
        }
    }

    public static final class ServingValue extends ExtendableMessageNano {
        public static final Serving.ServingValue[] EMPTY_ARRAY = new Serving.ServingValue[0];
        public static final Extension<Serving.ServingValue> ext = Extension.create(101, new Extension.TypeLiteral() {
        });
        public int[] listItem;
        public int macroNameReference;
        public int macroReference;
        public int[] mapKey;
        public int[] mapValue;
        public int tagReference;
        public int[] templateToken;

        public ServingValue() {
            this.listItem = WireFormatNano.EMPTY_INT_ARRAY;
            this.mapKey = WireFormatNano.EMPTY_INT_ARRAY;
            this.mapValue = WireFormatNano.EMPTY_INT_ARRAY;
            this.macroReference = 0;
            this.templateToken = WireFormatNano.EMPTY_INT_ARRAY;
            this.macroNameReference = 0;
            this.tagReference = 0;
        }

        public static Serving.ServingValue parseFrom(CodedInputByteBufferNano var0) throws IOException {
            return (new Serving.ServingValue()).mergeFrom(var0);
        }

        public static Serving.ServingValue parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
            return (Serving.ServingValue)MessageNano.mergeFrom(new Serving.ServingValue(), var0);
        }

        public final Serving.ServingValue clear() {
            this.listItem = WireFormatNano.EMPTY_INT_ARRAY;
            this.mapKey = WireFormatNano.EMPTY_INT_ARRAY;
            this.mapValue = WireFormatNano.EMPTY_INT_ARRAY;
            this.macroReference = 0;
            this.templateToken = WireFormatNano.EMPTY_INT_ARRAY;
            this.macroNameReference = 0;
            this.tagReference = 0;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final boolean equals(Object var1) {
            if(var1 != this) {
                if(!(var1 instanceof Serving.ServingValue)) {
                    return false;
                } else {
                    Serving.ServingValue var2 = (Serving.ServingValue)var1;
                    if(Arrays.equals(this.listItem, var2.listItem) && Arrays.equals(this.mapKey, var2.mapKey) && Arrays.equals(this.mapValue, var2.mapValue) && this.macroReference == var2.macroReference && Arrays.equals(this.templateToken, var2.templateToken) && this.macroNameReference == var2.macroNameReference && this.tagReference == var2.tagReference) {
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
            int[] var1 = this.listItem;
            int var2 = 0;
            if(var1 != null) {
                int var16 = this.listItem.length;
                var2 = 0;
                if(var16 > 0) {
                    int var17 = 0;
                    int[] var18 = this.listItem;
                    int var19 = var18.length;

                    for(int var20 = 0; var20 < var19; ++var20) {
                        var17 += CodedOutputByteBufferNano.computeInt32SizeNoTag(var18[var20]);
                    }

                    var2 = 0 + var17 + 1 * this.listItem.length;
                }
            }

            if(this.mapKey != null && this.mapKey.length > 0) {
                int var12 = 0;
                int[] var13 = this.mapKey;
                int var14 = var13.length;

                for(int var15 = 0; var15 < var14; ++var15) {
                    var12 += CodedOutputByteBufferNano.computeInt32SizeNoTag(var13[var15]);
                }

                var2 = var2 + var12 + 1 * this.mapKey.length;
            }

            if(this.mapValue != null && this.mapValue.length > 0) {
                int var8 = 0;
                int[] var9 = this.mapValue;
                int var10 = var9.length;

                for(int var11 = 0; var11 < var10; ++var11) {
                    var8 += CodedOutputByteBufferNano.computeInt32SizeNoTag(var9[var11]);
                }

                var2 = var2 + var8 + 1 * this.mapValue.length;
            }

            if(this.macroReference != 0) {
                var2 += CodedOutputByteBufferNano.computeInt32Size(4, this.macroReference);
            }

            if(this.templateToken != null && this.templateToken.length > 0) {
                int var4 = 0;
                int[] var5 = this.templateToken;
                int var6 = var5.length;

                for(int var7 = 0; var7 < var6; ++var7) {
                    var4 += CodedOutputByteBufferNano.computeInt32SizeNoTag(var5[var7]);
                }

                var2 = var2 + var4 + 1 * this.templateToken.length;
            }

            if(this.macroNameReference != 0) {
                var2 += CodedOutputByteBufferNano.computeInt32Size(6, this.macroNameReference);
            }

            if(this.tagReference != 0) {
                var2 += CodedOutputByteBufferNano.computeInt32Size(7, this.tagReference);
            }

            int var3 = var2 + WireFormatNano.computeWireSize(this.unknownFieldData);
            this.cachedSize = var3;
            return var3;
        }

        public int hashCode() {
            int var1 = 17;
            if(this.listItem == null) {
                var1 *= 31;
            } else {
                for(int var2 = 0; var2 < this.listItem.length; ++var2) {
                    var1 = var1 * 31 + this.listItem[var2];
                }
            }

            if(this.mapKey == null) {
                var1 *= 31;
            } else {
                for(int var3 = 0; var3 < this.mapKey.length; ++var3) {
                    var1 = var1 * 31 + this.mapKey[var3];
                }
            }

            if(this.mapValue == null) {
                var1 *= 31;
            } else {
                for(int var4 = 0; var4 < this.mapValue.length; ++var4) {
                    var1 = var1 * 31 + this.mapValue[var4];
                }
            }

            int var5 = var1 * 31 + this.macroReference;
            if(this.templateToken == null) {
                var5 *= 31;
            } else {
                for(int var6 = 0; var6 < this.templateToken.length; ++var6) {
                    var5 = var5 * 31 + this.templateToken[var6];
                }
            }

            int var7 = 31 * (31 * (var5 * 31 + this.macroNameReference) + this.tagReference);
            int var8;
            if(this.unknownFieldData == null) {
                var8 = 0;
            } else {
                var8 = this.unknownFieldData.hashCode();
            }

            return var7 + var8;
        }

        public Serving.ServingValue mergeFrom(CodedInputByteBufferNano var1) throws IOException {
            while(true) {
                int var2 = var1.readTag();
                switch(var2) {
                    case 8:
                        int var15 = WireFormatNano.getRepeatedFieldArrayLength(var1, 8);
                        int var16 = this.listItem.length;
                        int[] var17 = new int[var16 + var15];
                        System.arraycopy(this.listItem, 0, var17, 0, var16);

                        for(this.listItem = var17; var16 < -1 + this.listItem.length; ++var16) {
                            this.listItem[var16] = var1.readInt32();
                            var1.readTag();
                        }

                        this.listItem[var16] = var1.readInt32();
                        break;
                    case 16:
                        int var11 = WireFormatNano.getRepeatedFieldArrayLength(var1, 16);
                        int var12 = this.mapKey.length;
                        int[] var13 = new int[var12 + var11];
                        System.arraycopy(this.mapKey, 0, var13, 0, var12);

                        for(this.mapKey = var13; var12 < -1 + this.mapKey.length; ++var12) {
                            this.mapKey[var12] = var1.readInt32();
                            var1.readTag();
                        }

                        this.mapKey[var12] = var1.readInt32();
                        break;
                    case 24:
                        int var7 = WireFormatNano.getRepeatedFieldArrayLength(var1, 24);
                        int var8 = this.mapValue.length;
                        int[] var9 = new int[var8 + var7];
                        System.arraycopy(this.mapValue, 0, var9, 0, var8);

                        for(this.mapValue = var9; var8 < -1 + this.mapValue.length; ++var8) {
                            this.mapValue[var8] = var1.readInt32();
                            var1.readTag();
                        }

                        this.mapValue[var8] = var1.readInt32();
                        break;
                    case 32:
                        this.macroReference = var1.readInt32();
                        break;
                    case 40:
                        int var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 40);
                        int var4 = this.templateToken.length;
                        int[] var5 = new int[var4 + var3];
                        System.arraycopy(this.templateToken, 0, var5, 0, var4);

                        for(this.templateToken = var5; var4 < -1 + this.templateToken.length; ++var4) {
                            this.templateToken[var4] = var1.readInt32();
                            var1.readTag();
                        }

                        this.templateToken[var4] = var1.readInt32();
                        break;
                    case 48:
                        this.macroNameReference = var1.readInt32();
                        break;
                    case 56:
                        this.tagReference = var1.readInt32();
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
            if(this.listItem != null) {
                int[] var11 = this.listItem;
                int var12 = var11.length;

                for(int var13 = 0; var13 < var12; ++var13) {
                    var1.writeInt32(1, var11[var13]);
                }
            }

            if(this.mapKey != null) {
                int[] var8 = this.mapKey;
                int var9 = var8.length;

                for(int var10 = 0; var10 < var9; ++var10) {
                    var1.writeInt32(2, var8[var10]);
                }
            }

            if(this.mapValue != null) {
                int[] var5 = this.mapValue;
                int var6 = var5.length;

                for(int var7 = 0; var7 < var6; ++var7) {
                    var1.writeInt32(3, var5[var7]);
                }
            }

            if(this.macroReference != 0) {
                var1.writeInt32(4, this.macroReference);
            }

            if(this.templateToken != null) {
                int[] var2 = this.templateToken;
                int var3 = var2.length;

                for(int var4 = 0; var4 < var3; ++var4) {
                    var1.writeInt32(5, var2[var4]);
                }
            }

            if(this.macroNameReference != 0) {
                var1.writeInt32(6, this.macroNameReference);
            }

            if(this.tagReference != 0) {
                var1.writeInt32(7, this.tagReference);
            }

            WireFormatNano.writeUnknownFields(this.unknownFieldData, var1);
        }
    }

    public static final class Supplemental extends ExtendableMessageNano {
        public static final Serving.Supplemental[] EMPTY_ARRAY = new Serving.Supplemental[0];
        public Serving.GaExperimentSupplemental experimentSupplemental = null;
        public String name = "";
        public TypeSystem.Value value = null;

        public static Serving.Supplemental parseFrom(CodedInputByteBufferNano var0) throws IOException {
            return (new Serving.Supplemental()).mergeFrom(var0);
        }

        public static Serving.Supplemental parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
            return (Serving.Supplemental)MessageNano.mergeFrom(new Serving.Supplemental(), var0);
        }

        public final Serving.Supplemental clear() {
            this.name = "";
            this.value = null;
            this.experimentSupplemental = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final boolean equals(Object var1) {
            if(var1 != this) {
                if(!(var1 instanceof Serving.Supplemental)) {
                    return false;
                } else {
                    Serving.Supplemental var2 = (Serving.Supplemental)var1;
                    if(this.name == null) {
                        if(var2.name != null) {
                            return false;
                        }
                    } else if(!this.name.equals(var2.name)) {
                        return false;
                    }

                    if(this.value == null) {
                        if(var2.value != null) {
                            return false;
                        }
                    } else if(!this.value.equals(var2.value)) {
                        return false;
                    }

                    if(this.experimentSupplemental == null) {
                        if(var2.experimentSupplemental != null) {
                            return false;
                        }
                    } else if(!this.experimentSupplemental.equals(var2.experimentSupplemental)) {
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
            boolean var1 = this.name.equals("");
            int var2 = 0;
            if(!var1) {
                var2 = 0 + CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }

            if(this.value != null) {
                var2 += CodedOutputByteBufferNano.computeMessageSize(2, this.value);
            }

            if(this.experimentSupplemental != null) {
                var2 += CodedOutputByteBufferNano.computeMessageSize(3, this.experimentSupplemental);
            }

            int var3 = var2 + WireFormatNano.computeWireSize(this.unknownFieldData);
            this.cachedSize = var3;
            return var3;
        }

        public int hashCode() {
            int var1;
            if(this.name == null) {
                var1 = 0;
            } else {
                var1 = this.name.hashCode();
            }

            int var2 = 31 * (var1 + 527);
            int var3;
            if(this.value == null) {
                var3 = 0;
            } else {
                var3 = this.value.hashCode();
            }

            int var4 = 31 * (var2 + var3);
            int var5;
            if(this.experimentSupplemental == null) {
                var5 = 0;
            } else {
                var5 = this.experimentSupplemental.hashCode();
            }

            int var6 = 31 * (var4 + var5);
            List var7 = this.unknownFieldData;
            int var8 = 0;
            if(var7 != null) {
                var8 = this.unknownFieldData.hashCode();
            }

            return var6 + var8;
        }

        public Serving.Supplemental mergeFrom(CodedInputByteBufferNano var1) throws IOException {
            while(true) {
                int var2 = var1.readTag();
                switch(var2) {
                    case 10:
                        this.name = var1.readString();
                        break;
                    case 18:
                        this.value = new TypeSystem.Value();
                        var1.readMessage(this.value);
                        break;
                    case 26:
                        this.experimentSupplemental = new Serving.GaExperimentSupplemental();
                        var1.readMessage(this.experimentSupplemental);
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
            if(!this.name.equals("")) {
                var1.writeString(1, this.name);
            }

            if(this.value != null) {
                var1.writeMessage(2, this.value);
            }

            if(this.experimentSupplemental != null) {
                var1.writeMessage(3, this.experimentSupplemental);
            }

            WireFormatNano.writeUnknownFields(this.unknownFieldData, var1);
        }
    }

    public static final class SupplementedResource extends ExtendableMessageNano {
        public static final Serving.SupplementedResource[] EMPTY_ARRAY = new Serving.SupplementedResource[0];
        public String fingerprint;
        public Serving.Resource resource;
        public Serving.Supplemental[] supplemental;

        public SupplementedResource() {
            this.supplemental = Serving.Supplemental.EMPTY_ARRAY;
            this.resource = null;
            this.fingerprint = "";
        }

        public static Serving.SupplementedResource parseFrom(CodedInputByteBufferNano var0) throws IOException {
            return (new Serving.SupplementedResource()).mergeFrom(var0);
        }

        public static Serving.SupplementedResource parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
            return (Serving.SupplementedResource)MessageNano.mergeFrom(new Serving.SupplementedResource(), var0);
        }

        public final Serving.SupplementedResource clear() {
            this.supplemental = Serving.Supplemental.EMPTY_ARRAY;
            this.resource = null;
            this.fingerprint = "";
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final boolean equals(Object var1) {
            if(var1 != this) {
                if(!(var1 instanceof Serving.SupplementedResource)) {
                    return false;
                } else {
                    Serving.SupplementedResource var2 = (Serving.SupplementedResource)var1;
                    if(Arrays.equals(this.supplemental, var2.supplemental)) {
                        if(this.resource == null) {
                            if(var2.resource != null) {
                                return false;
                            }
                        } else if(!this.resource.equals(var2.resource)) {
                            return false;
                        }

                        if(this.fingerprint == null) {
                            if(var2.fingerprint != null) {
                                return false;
                            }
                        } else if(!this.fingerprint.equals(var2.fingerprint)) {
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
            Serving.Supplemental[] var1 = this.supplemental;
            int var2 = 0;
            if(var1 != null) {
                Serving.Supplemental[] var4 = this.supplemental;
                int var5 = var4.length;

                for(int var6 = 0; var6 < var5; ++var6) {
                    var2 += CodedOutputByteBufferNano.computeMessageSize(1, var4[var6]);
                }
            }

            if(this.resource != null) {
                var2 += CodedOutputByteBufferNano.computeMessageSize(2, this.resource);
            }

            if(!this.fingerprint.equals("")) {
                var2 += CodedOutputByteBufferNano.computeStringSize(3, this.fingerprint);
            }

            int var3 = var2 + WireFormatNano.computeWireSize(this.unknownFieldData);
            this.cachedSize = var3;
            return var3;
        }

        public int hashCode() {
            int var1 = 17;
            if(this.supplemental == null) {
                var1 *= 31;
            } else {
                for(int var2 = 0; var2 < this.supplemental.length; ++var2) {
                    int var3 = var1 * 31;
                    int var4;
                    if(this.supplemental[var2] == null) {
                        var4 = 0;
                    } else {
                        var4 = this.supplemental[var2].hashCode();
                    }

                    var1 = var3 + var4;
                }
            }

            int var5 = var1 * 31;
            int var6;
            if(this.resource == null) {
                var6 = 0;
            } else {
                var6 = this.resource.hashCode();
            }

            int var7 = 31 * (var5 + var6);
            int var8;
            if(this.fingerprint == null) {
                var8 = 0;
            } else {
                var8 = this.fingerprint.hashCode();
            }

            int var9 = 31 * (var7 + var8);
            List var10 = this.unknownFieldData;
            int var11 = 0;
            if(var10 != null) {
                var11 = this.unknownFieldData.hashCode();
            }

            return var9 + var11;
        }

        public Serving.SupplementedResource mergeFrom(CodedInputByteBufferNano var1) throws IOException {
            while(true) {
                int var2 = var1.readTag();
                switch(var2) {
                    case 10:
                        int var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 10);
                        int var4;
                        if(this.supplemental == null) {
                            var4 = 0;
                        } else {
                            var4 = this.supplemental.length;
                        }

                        Serving.Supplemental[] var5 = new Serving.Supplemental[var4 + var3];
                        if(this.supplemental != null) {
                            System.arraycopy(this.supplemental, 0, var5, 0, var4);
                        }

                        for(this.supplemental = var5; var4 < -1 + this.supplemental.length; ++var4) {
                            this.supplemental[var4] = new Serving.Supplemental();
                            var1.readMessage(this.supplemental[var4]);
                            var1.readTag();
                        }

                        this.supplemental[var4] = new Serving.Supplemental();
                        var1.readMessage(this.supplemental[var4]);
                        break;
                    case 18:
                        this.resource = new Serving.Resource();
                        var1.readMessage(this.resource);
                        break;
                    case 26:
                        this.fingerprint = var1.readString();
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
            if(this.supplemental != null) {
                Serving.Supplemental[] var2 = this.supplemental;
                int var3 = var2.length;

                for(int var4 = 0; var4 < var3; ++var4) {
                    var1.writeMessage(1, var2[var4]);
                }
            }

            if(this.resource != null) {
                var1.writeMessage(2, this.resource);
            }

            if(!this.fingerprint.equals("")) {
                var1.writeString(3, this.fingerprint);
            }

            WireFormatNano.writeUnknownFields(this.unknownFieldData, var1);
        }
    }
}

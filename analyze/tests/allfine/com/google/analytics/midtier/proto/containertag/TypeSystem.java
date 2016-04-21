package com.google.analytics.midtier.proto.containertag;

import com.google.tagmanager.protobuf.nano.CodedInputByteBufferNano;
import com.google.tagmanager.protobuf.nano.CodedOutputByteBufferNano;
import com.google.tagmanager.protobuf.nano.ExtendableMessageNano;
import com.google.tagmanager.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.tagmanager.protobuf.nano.MessageNano;
import com.google.tagmanager.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface TypeSystem {
    public static final class Value extends ExtendableMessageNano {
        public static final TypeSystem.Value[] EMPTY_ARRAY = new TypeSystem.Value[0];
        public boolean boolean_;
        public boolean containsReferences;
        public int[] escaping;
        public String functionId;
        public long integer;
        public TypeSystem.Value[] listItem;
        public String macroReference;
        public TypeSystem.Value[] mapKey;
        public TypeSystem.Value[] mapValue;
        public String string = "";
        public String tagReference;
        public TypeSystem.Value[] templateToken;
        public int type = 1;

        public Value() {
            this.listItem = EMPTY_ARRAY;
            this.mapKey = EMPTY_ARRAY;
            this.mapValue = EMPTY_ARRAY;
            this.macroReference = "";
            this.functionId = "";
            this.integer = 0L;
            this.boolean_ = false;
            this.templateToken = EMPTY_ARRAY;
            this.tagReference = "";
            this.escaping = WireFormatNano.EMPTY_INT_ARRAY;
            this.containsReferences = false;
        }

        public static TypeSystem.Value parseFrom(CodedInputByteBufferNano var0) throws IOException {
            return (new TypeSystem.Value()).mergeFrom(var0);
        }

        public static TypeSystem.Value parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
            return (TypeSystem.Value)MessageNano.mergeFrom(new TypeSystem.Value(), var0);
        }

        public final TypeSystem.Value clear() {
            this.type = 1;
            this.string = "";
            this.listItem = EMPTY_ARRAY;
            this.mapKey = EMPTY_ARRAY;
            this.mapValue = EMPTY_ARRAY;
            this.macroReference = "";
            this.functionId = "";
            this.integer = 0L;
            this.boolean_ = false;
            this.templateToken = EMPTY_ARRAY;
            this.tagReference = "";
            this.escaping = WireFormatNano.EMPTY_INT_ARRAY;
            this.containsReferences = false;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final boolean equals(Object var1) {
            if(var1 != this) {
                if(!(var1 instanceof TypeSystem.Value)) {
                    return false;
                } else {
                    TypeSystem.Value var2 = (TypeSystem.Value)var1;
                    if(this.type == var2.type) {
                        if(this.string == null) {
                            if(var2.string != null) {
                                return false;
                            }
                        } else if(!this.string.equals(var2.string)) {
                            return false;
                        }

                        if(Arrays.equals(this.listItem, var2.listItem) && Arrays.equals(this.mapKey, var2.mapKey) && Arrays.equals(this.mapValue, var2.mapValue)) {
                            if(this.macroReference == null) {
                                if(var2.macroReference != null) {
                                    return false;
                                }
                            } else if(!this.macroReference.equals(var2.macroReference)) {
                                return false;
                            }

                            if(this.functionId == null) {
                                if(var2.functionId != null) {
                                    return false;
                                }
                            } else if(!this.functionId.equals(var2.functionId)) {
                                return false;
                            }

                            if(this.integer == var2.integer && this.boolean_ == var2.boolean_ && Arrays.equals(this.templateToken, var2.templateToken)) {
                                if(this.tagReference == null) {
                                    if(var2.tagReference != null) {
                                        return false;
                                    }
                                } else if(!this.tagReference.equals(var2.tagReference)) {
                                    return false;
                                }

                                if(Arrays.equals(this.escaping, var2.escaping) && this.containsReferences == var2.containsReferences) {
                                    if(this.unknownFieldData == null) {
                                        if(var2.unknownFieldData == null) {
                                            return true;
                                        }
                                    } else if(this.unknownFieldData.equals(var2.unknownFieldData)) {
                                        return true;
                                    }
                                }
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
            int var1 = 0 + CodedOutputByteBufferNano.computeInt32Size(1, this.type);
            if(!this.string.equals("")) {
                var1 += CodedOutputByteBufferNano.computeStringSize(2, this.string);
            }

            if(this.listItem != null) {
                TypeSystem.Value[] var16 = this.listItem;
                int var17 = var16.length;

                for(int var18 = 0; var18 < var17; ++var18) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(3, var16[var18]);
                }
            }

            if(this.mapKey != null) {
                TypeSystem.Value[] var13 = this.mapKey;
                int var14 = var13.length;

                for(int var15 = 0; var15 < var14; ++var15) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(4, var13[var15]);
                }
            }

            if(this.mapValue != null) {
                TypeSystem.Value[] var10 = this.mapValue;
                int var11 = var10.length;

                for(int var12 = 0; var12 < var11; ++var12) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(5, var10[var12]);
                }
            }

            if(!this.macroReference.equals("")) {
                var1 += CodedOutputByteBufferNano.computeStringSize(6, this.macroReference);
            }

            if(!this.functionId.equals("")) {
                var1 += CodedOutputByteBufferNano.computeStringSize(7, this.functionId);
            }

            if(this.integer != 0L) {
                var1 += CodedOutputByteBufferNano.computeInt64Size(8, this.integer);
            }

            if(this.containsReferences) {
                var1 += CodedOutputByteBufferNano.computeBoolSize(9, this.containsReferences);
            }

            if(this.escaping != null && this.escaping.length > 0) {
                int var6 = 0;
                int[] var7 = this.escaping;
                int var8 = var7.length;

                for(int var9 = 0; var9 < var8; ++var9) {
                    var6 += CodedOutputByteBufferNano.computeInt32SizeNoTag(var7[var9]);
                }

                var1 = var1 + var6 + 1 * this.escaping.length;
            }

            if(this.templateToken != null) {
                TypeSystem.Value[] var3 = this.templateToken;
                int var4 = var3.length;

                for(int var5 = 0; var5 < var4; ++var5) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(11, var3[var5]);
                }
            }

            if(this.boolean_) {
                var1 += CodedOutputByteBufferNano.computeBoolSize(12, this.boolean_);
            }

            if(!this.tagReference.equals("")) {
                var1 += CodedOutputByteBufferNano.computeStringSize(13, this.tagReference);
            }

            int var2 = var1 + WireFormatNano.computeWireSize(this.unknownFieldData);
            this.cachedSize = var2;
            return var2;
        }

        public int hashCode() {
            byte var1 = 1;
            int var2 = 31 * (527 + this.type);
            int var3;
            if(this.string == null) {
                var3 = 0;
            } else {
                var3 = this.string.hashCode();
            }

            int var4 = var2 + var3;
            if(this.listItem == null) {
                var4 *= 31;
            } else {
                for(int var5 = 0; var5 < this.listItem.length; ++var5) {
                    int var6 = var4 * 31;
                    int var7;
                    if(this.listItem[var5] == null) {
                        var7 = 0;
                    } else {
                        var7 = this.listItem[var5].hashCode();
                    }

                    var4 = var6 + var7;
                }
            }

            if(this.mapKey == null) {
                var4 *= 31;
            } else {
                for(int var8 = 0; var8 < this.mapKey.length; ++var8) {
                    int var9 = var4 * 31;
                    int var10;
                    if(this.mapKey[var8] == null) {
                        var10 = 0;
                    } else {
                        var10 = this.mapKey[var8].hashCode();
                    }

                    var4 = var9 + var10;
                }
            }

            if(this.mapValue == null) {
                var4 *= 31;
            } else {
                for(int var11 = 0; var11 < this.mapValue.length; ++var11) {
                    int var12 = var4 * 31;
                    int var13;
                    if(this.mapValue[var11] == null) {
                        var13 = 0;
                    } else {
                        var13 = this.mapValue[var11].hashCode();
                    }

                    var4 = var12 + var13;
                }
            }

            int var14 = var4 * 31;
            int var15;
            if(this.macroReference == null) {
                var15 = 0;
            } else {
                var15 = this.macroReference.hashCode();
            }

            int var16 = 31 * (var14 + var15);
            int var17;
            if(this.functionId == null) {
                var17 = 0;
            } else {
                var17 = this.functionId.hashCode();
            }

            int var18 = 31 * (31 * (var16 + var17) + (int)(this.integer ^ this.integer >>> 32));
            byte var19;
            if(this.boolean_) {
                var19 = var1;
            } else {
                var19 = 2;
            }

            int var20 = var18 + var19;
            if(this.templateToken == null) {
                var20 *= 31;
            } else {
                for(int var21 = 0; var21 < this.templateToken.length; ++var21) {
                    int var22 = var20 * 31;
                    int var23;
                    if(this.templateToken[var21] == null) {
                        var23 = 0;
                    } else {
                        var23 = this.templateToken[var21].hashCode();
                    }

                    var20 = var22 + var23;
                }
            }

            int var24 = var20 * 31;
            int var25;
            if(this.tagReference == null) {
                var25 = 0;
            } else {
                var25 = this.tagReference.hashCode();
            }

            int var26 = var24 + var25;
            if(this.escaping == null) {
                var26 *= 31;
            } else {
                for(int var27 = 0; var27 < this.escaping.length; ++var27) {
                    var26 = var26 * 31 + this.escaping[var27];
                }
            }

            int var28 = var26 * 31;
            if(!this.containsReferences) {
                var1 = 2;
            }

            int var29 = 31 * (var28 + var1);
            List var30 = this.unknownFieldData;
            int var31 = 0;
            if(var30 != null) {
                var31 = this.unknownFieldData.hashCode();
            }

            return var29 + var31;
        }

        public TypeSystem.Value mergeFrom(CodedInputByteBufferNano var1) throws IOException {
            while(true) {
                int var2 = var1.readTag();
                switch(var2) {
                    case 8:
                        int var23 = var1.readInt32();
                        if(var23 != 1 && var23 != 2 && var23 != 3 && var23 != 4 && var23 != 5 && var23 != 6 && var23 != 7 && var23 != 8 && var23 != 9) {
                            this.type = 1;
                            break;
                        }

                        this.type = var23;
                        break;
                    case 18:
                        this.string = var1.readString();
                        break;
                    case 26:
                        int var19 = WireFormatNano.getRepeatedFieldArrayLength(var1, 26);
                        int var20;
                        if(this.listItem == null) {
                            var20 = 0;
                        } else {
                            var20 = this.listItem.length;
                        }

                        TypeSystem.Value[] var21 = new TypeSystem.Value[var20 + var19];
                        if(this.listItem != null) {
                            System.arraycopy(this.listItem, 0, var21, 0, var20);
                        }

                        for(this.listItem = var21; var20 < -1 + this.listItem.length; ++var20) {
                            this.listItem[var20] = new TypeSystem.Value();
                            var1.readMessage(this.listItem[var20]);
                            var1.readTag();
                        }

                        this.listItem[var20] = new TypeSystem.Value();
                        var1.readMessage(this.listItem[var20]);
                        break;
                    case 34:
                        int var15 = WireFormatNano.getRepeatedFieldArrayLength(var1, 34);
                        int var16;
                        if(this.mapKey == null) {
                            var16 = 0;
                        } else {
                            var16 = this.mapKey.length;
                        }

                        TypeSystem.Value[] var17 = new TypeSystem.Value[var16 + var15];
                        if(this.mapKey != null) {
                            System.arraycopy(this.mapKey, 0, var17, 0, var16);
                        }

                        for(this.mapKey = var17; var16 < -1 + this.mapKey.length; ++var16) {
                            this.mapKey[var16] = new TypeSystem.Value();
                            var1.readMessage(this.mapKey[var16]);
                            var1.readTag();
                        }

                        this.mapKey[var16] = new TypeSystem.Value();
                        var1.readMessage(this.mapKey[var16]);
                        break;
                    case 42:
                        int var11 = WireFormatNano.getRepeatedFieldArrayLength(var1, 42);
                        int var12;
                        if(this.mapValue == null) {
                            var12 = 0;
                        } else {
                            var12 = this.mapValue.length;
                        }

                        TypeSystem.Value[] var13 = new TypeSystem.Value[var12 + var11];
                        if(this.mapValue != null) {
                            System.arraycopy(this.mapValue, 0, var13, 0, var12);
                        }

                        for(this.mapValue = var13; var12 < -1 + this.mapValue.length; ++var12) {
                            this.mapValue[var12] = new TypeSystem.Value();
                            var1.readMessage(this.mapValue[var12]);
                            var1.readTag();
                        }

                        this.mapValue[var12] = new TypeSystem.Value();
                        var1.readMessage(this.mapValue[var12]);
                        break;
                    case 50:
                        this.macroReference = var1.readString();
                        break;
                    case 58:
                        this.functionId = var1.readString();
                        break;
                    case 64:
                        this.integer = var1.readInt64();
                        break;
                    case 72:
                        this.containsReferences = var1.readBool();
                        break;
                    case 80:
                        int var7 = WireFormatNano.getRepeatedFieldArrayLength(var1, 80);
                        int var8 = this.escaping.length;
                        int[] var9 = new int[var8 + var7];
                        System.arraycopy(this.escaping, 0, var9, 0, var8);

                        for(this.escaping = var9; var8 < -1 + this.escaping.length; ++var8) {
                            this.escaping[var8] = var1.readInt32();
                            var1.readTag();
                        }

                        this.escaping[var8] = var1.readInt32();
                        break;
                    case 90:
                        int var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 90);
                        int var4;
                        if(this.templateToken == null) {
                            var4 = 0;
                        } else {
                            var4 = this.templateToken.length;
                        }

                        TypeSystem.Value[] var5 = new TypeSystem.Value[var4 + var3];
                        if(this.templateToken != null) {
                            System.arraycopy(this.templateToken, 0, var5, 0, var4);
                        }

                        for(this.templateToken = var5; var4 < -1 + this.templateToken.length; ++var4) {
                            this.templateToken[var4] = new TypeSystem.Value();
                            var1.readMessage(this.templateToken[var4]);
                            var1.readTag();
                        }

                        this.templateToken[var4] = new TypeSystem.Value();
                        var1.readMessage(this.templateToken[var4]);
                        break;
                    case 96:
                        this.boolean_ = var1.readBool();
                        break;
                    case 106:
                        this.tagReference = var1.readString();
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
            var1.writeInt32(1, this.type);
            if(!this.string.equals("")) {
                var1.writeString(2, this.string);
            }

            if(this.listItem != null) {
                TypeSystem.Value[] var14 = this.listItem;
                int var15 = var14.length;

                for(int var16 = 0; var16 < var15; ++var16) {
                    var1.writeMessage(3, var14[var16]);
                }
            }

            if(this.mapKey != null) {
                TypeSystem.Value[] var11 = this.mapKey;
                int var12 = var11.length;

                for(int var13 = 0; var13 < var12; ++var13) {
                    var1.writeMessage(4, var11[var13]);
                }
            }

            if(this.mapValue != null) {
                TypeSystem.Value[] var8 = this.mapValue;
                int var9 = var8.length;

                for(int var10 = 0; var10 < var9; ++var10) {
                    var1.writeMessage(5, var8[var10]);
                }
            }

            if(!this.macroReference.equals("")) {
                var1.writeString(6, this.macroReference);
            }

            if(!this.functionId.equals("")) {
                var1.writeString(7, this.functionId);
            }

            if(this.integer != 0L) {
                var1.writeInt64(8, this.integer);
            }

            if(this.containsReferences) {
                var1.writeBool(9, this.containsReferences);
            }

            if(this.escaping != null && this.escaping.length > 0) {
                int[] var5 = this.escaping;
                int var6 = var5.length;

                for(int var7 = 0; var7 < var6; ++var7) {
                    var1.writeInt32(10, var5[var7]);
                }
            }

            if(this.templateToken != null) {
                TypeSystem.Value[] var2 = this.templateToken;
                int var3 = var2.length;

                for(int var4 = 0; var4 < var3; ++var4) {
                    var1.writeMessage(11, var2[var4]);
                }
            }

            if(this.boolean_) {
                var1.writeBool(12, this.boolean_);
            }

            if(!this.tagReference.equals("")) {
                var1.writeString(13, this.tagReference);
            }

            WireFormatNano.writeUnknownFields(this.unknownFieldData, var1);
        }
    }

    public interface Escaping {
        int CONVERT_JS_VALUE_TO_EXPRESSION = 16;
        int ESCAPE_CSS_STRING = 10;
        int ESCAPE_HTML = 1;
        int ESCAPE_HTML_ATTRIBUTE = 3;
        int ESCAPE_HTML_ATTRIBUTE_NOSPACE = 4;
        int ESCAPE_HTML_RCDATA = 2;
        int ESCAPE_JS_REGEX = 9;
        int ESCAPE_JS_STRING = 7;
        int ESCAPE_JS_VALUE = 8;
        int ESCAPE_URI = 12;
        int FILTER_CSS_VALUE = 11;
        int FILTER_HTML_ATTRIBUTES = 6;
        int FILTER_HTML_ELEMENT_NAME = 5;
        int FILTER_NORMALIZE_URI = 14;
        int NORMALIZE_URI = 13;
        int NO_AUTOESCAPE = 15;
        int TEXT = 17;
    }

    public interface Type {
        int BOOLEAN = 8;
        int FUNCTION_ID = 5;
        int INTEGER = 6;
        int LIST = 2;
        int MACRO_REFERENCE = 4;
        int MAP = 3;
        int STRING = 1;
        int TAG_REFERENCE = 9;
        int TEMPLATE = 7;
    }
}

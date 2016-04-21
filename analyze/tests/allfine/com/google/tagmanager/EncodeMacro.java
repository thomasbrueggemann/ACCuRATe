package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.Base16;
import com.google.tagmanager.Base64Encoder;
import com.google.tagmanager.FunctionCallImplementation;
import com.google.tagmanager.Log;
import com.google.tagmanager.Types;
import java.util.Map;

class EncodeMacro extends FunctionCallImplementation {
    private static final String ARG0;
    private static final String DEFAULT_INPUT_FORMAT = "text";
    private static final String DEFAULT_OUTPUT_FORMAT = "base16";
    // $FF: renamed from: ID java.lang.String
    private static final String field_750;
    private static final String INPUT_FORMAT;
    private static final String NO_PADDING;
    private static final String OUTPUT_FORMAT;

    static {
        field_750 = FunctionType.ENCODE.toString();
        ARG0 = Key.ARG0.toString();
        NO_PADDING = Key.NO_PADDING.toString();
        INPUT_FORMAT = Key.INPUT_FORMAT.toString();
        OUTPUT_FORMAT = Key.OUTPUT_FORMAT.toString();
    }

    public EncodeMacro() {
        String var1 = field_750;
        String[] var2 = new String[] {ARG0};
        super(var1, var2);
    }

    public static String getFunctionId() {
        return field_750;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1) {
        TypeSystem.Value var2 = (TypeSystem.Value)var1.get(ARG0);
        if(var2 != null && var2 != Types.getDefaultValue()) {
            String var3 = Types.valueToString(var2);
            TypeSystem.Value var4 = (TypeSystem.Value)var1.get(INPUT_FORMAT);
            String var5;
            if(var4 == null) {
                var5 = "text";
            } else {
                var5 = Types.valueToString(var4);
            }

            TypeSystem.Value var6 = (TypeSystem.Value)var1.get(OUTPUT_FORMAT);
            String var7;
            if(var6 == null) {
                var7 = "base16";
            } else {
                var7 = Types.valueToString(var6);
            }

            TypeSystem.Value var10000 = (TypeSystem.Value)var1.get(INPUT_FORMAT);
            TypeSystem.Value var9 = (TypeSystem.Value)var1.get(NO_PADDING);
            int var10 = 0;
            if(var9 != null) {
                boolean var16 = Types.valueToBoolean(var9).booleanValue();
                var10 = 0;
                if(var16) {
                    var10 = 0 | 1;
                }
            }

            byte[] var13;
            label66: {
                byte[] var15;
                try {
                    if(!"text".equals(var5)) {
                        if("base16".equals(var5)) {
                            var13 = Base16.decode(var3);
                        } else if("base64".equals(var5)) {
                            var13 = Base64Encoder.decode(var3, var10);
                        } else {
                            if(!"base64url".equals(var5)) {
                                Log.method_5503("Encode: unknown input format: " + var5);
                                TypeSystem.Value var12 = Types.getDefaultValue();
                                return var12;
                            }

                            var13 = Base64Encoder.decode(var3, var10 | 2);
                        }
                        break label66;
                    }

                    var15 = var3.getBytes();
                } catch (IllegalArgumentException var17) {
                    Log.method_5503("Encode: invalid input:");
                    return Types.getDefaultValue();
                }

                var13 = var15;
            }

            String var14;
            if("base16".equals(var7)) {
                var14 = Base16.encode(var13);
            } else if("base64".equals(var7)) {
                var14 = Base64Encoder.encodeToString(var13, var10);
            } else {
                if(!"base64url".equals(var7)) {
                    Log.method_5503("Encode: unknown output format: " + var7);
                    return Types.getDefaultValue();
                }

                var14 = Base64Encoder.encodeToString(var13, var10 | 2);
            }

            return Types.objectToValue(var14);
        } else {
            return Types.getDefaultValue();
        }
    }

    public boolean isCacheable() {
        return true;
    }
}

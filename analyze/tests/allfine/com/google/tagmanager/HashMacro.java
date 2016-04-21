package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.Base16;
import com.google.tagmanager.FunctionCallImplementation;
import com.google.tagmanager.Log;
import com.google.tagmanager.Types;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class HashMacro extends FunctionCallImplementation {
    private static final String ALGORITHM;
    private static final String ARG0;
    private static final String DEFAULT_ALGORITHM = "MD5";
    private static final String DEFAULT_INPUT_FORMAT = "text";
    // $FF: renamed from: ID java.lang.String
    private static final String field_752;
    private static final String INPUT_FORMAT;

    static {
        field_752 = FunctionType.HASH.toString();
        ARG0 = Key.ARG0.toString();
        ALGORITHM = Key.ALGORITHM.toString();
        INPUT_FORMAT = Key.INPUT_FORMAT.toString();
    }

    public HashMacro() {
        String var1 = field_752;
        String[] var2 = new String[] {ARG0};
        super(var1, var2);
    }

    public static String getFunctionId() {
        return field_752;
    }

    private byte[] hash(String var1, byte[] var2) throws NoSuchAlgorithmException {
        MessageDigest var3 = MessageDigest.getInstance(var1);
        var3.update(var2);
        return var3.digest();
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1) {
        TypeSystem.Value var2 = (TypeSystem.Value)var1.get(ARG0);
        if(var2 != null && var2 != Types.getDefaultValue()) {
            String var3 = Types.valueToString(var2);
            TypeSystem.Value var4 = (TypeSystem.Value)var1.get(ALGORITHM);
            String var5;
            if(var4 == null) {
                var5 = "MD5";
            } else {
                var5 = Types.valueToString(var4);
            }

            TypeSystem.Value var6 = (TypeSystem.Value)var1.get(INPUT_FORMAT);
            String var7;
            if(var6 == null) {
                var7 = "text";
            } else {
                var7 = Types.valueToString(var6);
            }

            byte[] var8;
            if("text".equals(var7)) {
                var8 = var3.getBytes();
            } else {
                if(!"base16".equals(var7)) {
                    Log.method_5503("Hash: unknown input format: " + var7);
                    return Types.getDefaultValue();
                }

                var8 = Base16.decode(var3);
            }

            try {
                TypeSystem.Value var10 = Types.objectToValue(Base16.encode(this.hash(var5, var8)));
                return var10;
            } catch (NoSuchAlgorithmException var11) {
                Log.method_5503("Hash: unknown algorithm: " + var5);
                return Types.getDefaultValue();
            }
        } else {
            return Types.getDefaultValue();
        }
    }

    public boolean isCacheable() {
        return true;
    }
}

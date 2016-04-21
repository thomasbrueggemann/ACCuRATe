package com.google.tagmanager.protobuf.nano;

import java.io.UnsupportedEncodingException;

public class InternalNano {
    public static final byte[] bytesDefaultValue(String var0) {
        try {
            byte[] var2 = var0.getBytes("ISO-8859-1");
            return var2;
        } catch (UnsupportedEncodingException var3) {
            throw new IllegalStateException("Java VM does not support a standard character set.", var3);
        }
    }

    public static final byte[] copyFromUtf8(String var0) {
        try {
            byte[] var2 = var0.getBytes("UTF-8");
            return var2;
        } catch (UnsupportedEncodingException var3) {
            throw new RuntimeException("UTF-8 not supported?");
        }
    }

    public static final String stringDefaultValue(String var0) {
        try {
            String var1 = new String(var0.getBytes("ISO-8859-1"), "UTF-8");
            return var1;
        } catch (UnsupportedEncodingException var3) {
            throw new IllegalStateException("Java VM does not support a standard character set.", var3);
        }
    }
}

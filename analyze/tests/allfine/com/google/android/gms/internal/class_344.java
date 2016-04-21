package com.google.android.gms.internal;

import android.os.ParcelFileDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// $FF: renamed from: com.google.android.gms.internal.jy
public final class class_344 {
    // $FF: renamed from: a (java.io.InputStream, java.io.OutputStream, boolean) long
    public static long method_2319(InputStream var0, OutputStream var1, boolean var2) throws IOException {
        return method_2320(var0, var1, var2, 1024);
    }

    // $FF: renamed from: a (java.io.InputStream, java.io.OutputStream, boolean, int) long
    public static long method_2320(InputStream param0, OutputStream param1, boolean param2, int param3) throws IOException {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (android.os.ParcelFileDescriptor) void
    public static void method_2321(ParcelFileDescriptor var0) {
        if(var0 != null) {
            try {
                var0.close();
            } catch (IOException var2) {
                return;
            }
        }

    }

    // $FF: renamed from: a (java.io.InputStream, boolean) byte[]
    public static byte[] method_2322(InputStream var0, boolean var1) throws IOException {
        ByteArrayOutputStream var2 = new ByteArrayOutputStream();
        method_2319(var0, var2, var1);
        return var2.toByteArray();
    }

    // $FF: renamed from: b (java.io.Closeable) void
    public static void method_2323(Closeable var0) {
        if(var0 != null) {
            try {
                var0.close();
            } catch (IOException var2) {
                return;
            }
        }

    }

    // $FF: renamed from: d (java.io.InputStream) byte[]
    public static byte[] method_2324(InputStream var0) throws IOException {
        return method_2322(var0, true);
    }
}

package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.internal.class_531;
import com.google.android.gms.internal.class_66;
import com.google.android.gms.internal.class_67;
import com.google.android.gms.internal.class_910;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

// $FF: renamed from: com.google.android.gms.internal.h
public abstract class class_545 implements class_52 {
    // $FF: renamed from: kw android.view.MotionEvent
    protected MotionEvent field_2897;
    // $FF: renamed from: kx android.util.DisplayMetrics
    protected DisplayMetrics field_2898;
    // $FF: renamed from: ky com.google.android.gms.internal.m
    protected class_66 field_2899;
    // $FF: renamed from: kz com.google.android.gms.internal.n
    private class_67 field_2900;

    protected class_545(Context var1, class_66 var2, class_67 var3) {
        this.field_2899 = var2;
        this.field_2900 = var3;

        try {
            this.field_2898 = var1.getResources().getDisplayMetrics();
        } catch (UnsupportedOperationException var5) {
            this.field_2898 = new DisplayMetrics();
            this.field_2898.density = 1.0F;
        }
    }

    // $FF: renamed from: a (android.content.Context, java.lang.String, boolean) java.lang.String
    private String method_3326(Context param1, String param2, boolean param3) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: t () void
    private void method_3327() {
        this.field_2900.reset();
    }

    // $FF: renamed from: u () byte[]
    private byte[] method_3328() throws IOException {
        return this.field_2900.method_321();
    }

    // $FF: renamed from: a (android.content.Context) java.lang.String
    public String method_227(Context var1) {
        return this.method_3326(var1, (String)null, false);
    }

    // $FF: renamed from: a (android.content.Context, java.lang.String) java.lang.String
    public String method_228(Context var1, String var2) {
        return this.method_3326(var1, var2, true);
    }

    // $FF: renamed from: a (byte[], java.lang.String) java.lang.String
    String method_3329(byte[] var1, String var2) throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
        if(var1.length > 239) {
            this.method_3327();
            this.method_3330(20, 1L);
            var1 = this.method_3328();
        }

        byte[] var3;
        if(var1.length < 239) {
            byte[] var8 = new byte[239 - var1.length];
            (new SecureRandom()).nextBytes(var8);
            var3 = ByteBuffer.allocate(240).put((byte)var1.length).put(var1).put(var8).array();
        } else {
            var3 = ByteBuffer.allocate(240).put((byte)var1.length).put(var1).array();
        }

        MessageDigest var4 = MessageDigest.getInstance("MD5");
        var4.update(var3);
        byte[] var5 = var4.digest();
        byte[] var6 = ByteBuffer.allocate(256).put(var5).put(var3).array();
        byte[] var7 = new byte[256];
        (new class_531()).method_3188(var6, var7);
        if(var2 != null && var2.length() > 0) {
            this.method_3332(var2, var7);
        }

        return this.field_2899.method_319(var7, true);
    }

    // $FF: renamed from: a (int, int, int) void
    public void method_229(int var1, int var2, int var3) {
        if(this.field_2897 != null) {
            this.field_2897.recycle();
        }

        this.field_2897 = MotionEvent.obtain(0L, (long)var3, 1, (float)var1 * this.field_2898.density, (float)var2 * this.field_2898.density, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
    }

    // $FF: renamed from: a (int, long) void
    protected void method_3330(int var1, long var2) throws IOException {
        this.field_2900.method_322(var1, var2);
    }

    // $FF: renamed from: a (int, java.lang.String) void
    protected void method_3331(int var1, String var2) throws IOException {
        this.field_2900.method_323(var1, var2);
    }

    // $FF: renamed from: a (android.view.MotionEvent) void
    public void method_230(MotionEvent var1) {
        if(var1.getAction() == 1) {
            if(this.field_2897 != null) {
                this.field_2897.recycle();
            }

            this.field_2897 = MotionEvent.obtain(var1);
        }

    }

    // $FF: renamed from: a (java.lang.String, byte[]) void
    void method_3332(String var1, byte[] var2) throws UnsupportedEncodingException {
        if(var1.length() > 32) {
            var1 = var1.substring(0, 32);
        }

        (new class_910(var1.getBytes("UTF-8"))).method_4731(var2);
    }

    // $FF: renamed from: b (android.content.Context) void
    protected abstract void method_3333(Context var1);

    // $FF: renamed from: c (android.content.Context) void
    protected abstract void method_3334(Context var1);
}

package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Handler.Callback;
import java.util.HashMap;
import java.util.HashSet;

// $FF: renamed from: com.google.android.gms.common.internal.g
public final class class_1093 implements Callback {
    // $FF: renamed from: LS java.lang.Object
    private static final Object field_5134 = new Object();
    // $FF: renamed from: LT com.google.android.gms.common.internal.g
    private static class_1093 field_5135;
    // $FF: renamed from: LU java.util.HashMap
    private final HashMap<String, class_1093.class_1519> field_5136;
    // $FF: renamed from: mD android.content.Context
    private final Context field_5137;
    private final Handler mHandler;

    private class_1093(Context var1) {
        this.mHandler = new Handler(var1.getMainLooper(), this);
        this.field_5136 = new HashMap();
        this.field_5137 = var1.getApplicationContext();
    }

    // $FF: renamed from: J (android.content.Context) com.google.android.gms.common.internal.g
    public static class_1093 method_5699(Context param0) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.common.internal.g) java.util.HashMap
    // $FF: synthetic method
    static HashMap method_5700(class_1093 var0) {
        return var0.field_5136;
    }

    // $FF: renamed from: a (java.lang.String, com.google.android.gms.common.internal.e$f) boolean
    public boolean method_5701(String param1, com/google/android/gms/common/internal/e<?>.f param2) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b (java.lang.String, com.google.android.gms.common.internal.e$f) void
    public void method_5702(String param1, com/google/android/gms/common/internal/e<?>.f param2) {
        // $FF: Couldn't be decompiled
    }

    public boolean handleMessage(Message param1) {
        // $FF: Couldn't be decompiled
    }

    final class class_1519 {
        // $FF: renamed from: LV java.lang.String
        private final String field_3309;
        // $FF: renamed from: LW com.google.android.gms.common.internal.g$a$a
        private final class_1093.class_1520 field_3310;
        // $FF: renamed from: LX java.util.HashSet
        private final HashSet<com/google/android/gms/common/internal/e<?>.f> field_3311;
        // $FF: renamed from: LY boolean
        private boolean field_3312;
        // $FF: renamed from: LZ android.os.IBinder
        private IBinder field_3313;
        // $FF: renamed from: Ma android.content.ComponentName
        private ComponentName field_3314;
        private int mState;

        public class_1519(String var2) {
            this.field_3309 = var2;
            this.field_3310 = new class_1093.class_1520();
            this.field_3311 = new HashSet();
            this.mState = 0;
        }

        // $FF: renamed from: a (com.google.android.gms.common.internal.g$a, int) int
        // $FF: synthetic method
        static int method_3764(class_1093.class_1519 var0, int var1) {
            var0.mState = var1;
            return var1;
        }

        // $FF: renamed from: a (com.google.android.gms.common.internal.g$a, android.content.ComponentName) android.content.ComponentName
        // $FF: synthetic method
        static ComponentName method_3765(class_1093.class_1519 var0, ComponentName var1) {
            var0.field_3314 = var1;
            return var1;
        }

        // $FF: renamed from: a (com.google.android.gms.common.internal.g$a, android.os.IBinder) android.os.IBinder
        // $FF: synthetic method
        static IBinder method_3766(class_1093.class_1519 var0, IBinder var1) {
            var0.field_3313 = var1;
            return var1;
        }

        // $FF: renamed from: a (com.google.android.gms.common.internal.g$a) java.util.HashSet
        // $FF: synthetic method
        static HashSet method_3767(class_1093.class_1519 var0) {
            return var0.field_3311;
        }

        // $FF: renamed from: J (boolean) void
        public void method_3768(boolean var1) {
            this.field_3312 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.common.internal.e$f) void
        public void method_3769(com/google/android/gms/common/internal/e<?>.f var1) {
            this.field_3311.add(var1);
        }

        // $FF: renamed from: b (com.google.android.gms.common.internal.e$f) void
        public void method_3770(com/google/android/gms/common/internal/e<?>.f var1) {
            this.field_3311.remove(var1);
        }

        // $FF: renamed from: c (com.google.android.gms.common.internal.e$f) boolean
        public boolean method_3771(com/google/android/gms/common/internal/e<?>.f var1) {
            return this.field_3311.contains(var1);
        }

        // $FF: renamed from: gW () com.google.android.gms.common.internal.g$a$a
        public class_1093.class_1520 method_3772() {
            return this.field_3310;
        }

        // $FF: renamed from: gX () java.lang.String
        public String method_3773() {
            return this.field_3309;
        }

        // $FF: renamed from: gY () boolean
        public boolean method_3774() {
            return this.field_3311.isEmpty();
        }

        public IBinder getBinder() {
            return this.field_3313;
        }

        public ComponentName getComponentName() {
            return this.field_3314;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.field_3312;
        }
    }

    public class class_1520 implements ServiceConnection {
        public void onServiceConnected(ComponentName param1, IBinder param2) {
            // $FF: Couldn't be decompiled
        }

        public void onServiceDisconnected(ComponentName param1) {
            // $FF: Couldn't be decompiled
        }
    }
}

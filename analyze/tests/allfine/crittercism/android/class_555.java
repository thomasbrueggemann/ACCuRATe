package crittercism.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.ConditionVariable;
import com.crittercism.app.CrittercismNDK;
import crittercism.android.class_104;
import crittercism.android.class_105;
import crittercism.android.class_106;
import crittercism.android.class_552;
import crittercism.android.class_553;
import crittercism.android.class_669;
import crittercism.android.class_691;
import crittercism.android.class_737;
import crittercism.android.class_749;
import crittercism.android.class_750;
import crittercism.android.class_751;
import crittercism.android.class_752;
import crittercism.android.class_756;
import crittercism.android.class_757;
import crittercism.android.class_763;
import crittercism.android.class_764;
import crittercism.android.class_769;
import crittercism.android.class_790;
import crittercism.android.class_791;
import crittercism.android.class_792;
import crittercism.android.class_795;
import crittercism.android.class_798;
import crittercism.android.class_800;
import crittercism.android.class_803;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

// $FF: renamed from: crittercism.android.dg
public final class class_555 extends class_552 {
    // $FF: renamed from: a android.os.ConditionVariable
    public ConditionVariable field_3006 = new ConditionVariable();
    // $FF: renamed from: b crittercism.android.bm
    public class_800 field_3007 = null;
    // $FF: renamed from: c android.os.ConditionVariable
    private ConditionVariable field_3008 = new ConditionVariable();
    // $FF: renamed from: d crittercism.android.bb
    private class_792 field_3009;
    // $FF: renamed from: e android.content.Context
    private Context field_3010;
    // $FF: renamed from: f crittercism.android.aw
    private class_105 field_3011;
    // $FF: renamed from: g crittercism.android.ax
    private class_104 field_3012;
    // $FF: renamed from: h crittercism.android.au
    private class_106 field_3013;
    // $FF: renamed from: i java.util.List
    private List field_3014 = new ArrayList();
    // $FF: renamed from: j boolean
    private boolean field_3015 = false;
    // $FF: renamed from: k boolean
    private boolean field_3016;
    // $FF: renamed from: l java.lang.Exception
    private Exception field_3017 = null;

    public class_555(class_792 var1, Context var2, class_105 var3, class_104 var4, class_106 var5) {
        this.field_3009 = var1;
        this.field_3010 = var2;
        this.field_3011 = var3;
        this.field_3012 = var4;
        this.field_3013 = var5;
        this.field_3016 = false;
    }

    // $FF: renamed from: a (java.io.File) void
    private void method_3400(File var1) {
        Context var2 = this.field_3010;
        class_691 var3 = new class_691(var2);
        SharedPreferences var4 = var2.getSharedPreferences("com.crittercism.optmz.config", 0);
        if(var4.contains("interval")) {
            var3.field_3367 = var4.getInt("interval", 10);
            if(var4.contains("kill")) {
                var3.field_3366 = var4.getBoolean("kill", false);
                if(var4.contains("persist")) {
                    var3.field_3365 = var4.getBoolean("persist", false);
                    if(var4.contains("enabled")) {
                        var3.field_3364 = var4.getBoolean("enabled", false);
                    } else {
                        var3 = null;
                    }
                } else {
                    var3 = null;
                }
            } else {
                var3 = null;
            }
        } else {
            var3 = null;
        }

        if(var3 != null) {
            class_790.method_4077().method_4089(var3);
        }

        boolean var10000 = this.field_3016;
        this.field_3011.method_427();
        if(!class_790.method_4077().field_3716) {
            class_798 var20 = class_798.method_4147(this.field_3010);
            class_803 var21 = this.field_3011.method_425();
            class_803 var22 = this.field_3011.method_420();
            class_803 var23 = this.field_3011.method_421();
            class_803 var24 = this.field_3011.method_423();
            class_553 var25 = new class_553(this.field_3010, this.field_3013, var21, var22, var23, var24, this.field_3009.method_4104());
            class_790 var26 = class_790.method_4077();
            var26.field_3721 = var25;
            (new class_763(var25, "TXN Thread")).start();
            var26.method_4087(var20);
        }

        var10000 = this.field_3016;
        class_790 var7 = class_790.method_4077();
        if(!var7.field_3716) {
            if(var1 != null && var1.exists()) {
                var1.isFile();
            }

            class_105 var28 = this.field_3011;
            class_803 var12 = this.field_3011.method_420();
            class_803 var13 = this.field_3011.method_421();
            class_803 var14 = this.field_3011.method_422();
            class_803 var15 = this.field_3011.method_423();
            class_803 var16 = this.field_3011.method_418();
            if(var1 != null) {
                class_757.field_3589 = true;
                var7.field_3701.open();
                var16.method_4168(new class_737(var1, var12, var14, var13, var15));
                var1.delete();
                this.field_3011.method_424().method_4165();
            } else {
                var7.field_3701.open();
                class_795.method_4122(this.field_3011);
            }

            var14.method_4165();
            var13.method_4165();
            var15.method_4165();
            var12.method_4166(var14);
        }

        this.field_3006.open();
        this.field_3011.method_420().method_4168(class_669.field_3239);
        if(!class_790.method_4077().field_3716 && this.field_3009.isNdkCrashReportingEnabled()) {
            class_764.method_4020();

            try {
                CrittercismNDK.installNdkLib(this.field_3010, this.field_3009.method_4107());
            } catch (Throwable var27) {
                (new StringBuilder("Exception installing ndk library: ")).append(var27.getClass().getName());
                class_764.method_4020();
            }
        }

        this.method_3404();
    }

    // $FF: renamed from: c () void
    private void method_3401() {
        synchronized(this) {}

        try {
            this.field_3015 = true;
        } finally {
            ;
        }

    }

    // $FF: renamed from: d () boolean
    private boolean method_3402() {
        synchronized(this) {}

        boolean var2;
        try {
            var2 = this.field_3015;
        } finally {
            ;
        }

        return var2;
    }

    // $FF: renamed from: e () java.io.File
    private File method_3403() {
        int var1 = 0;
        File var2 = new File(this.field_3010.getFilesDir().getAbsolutePath() + "/" + this.field_3009.method_4107());
        if(var2.exists() && var2.isDirectory()) {
            File[] var3 = var2.listFiles();
            if(var3 != null) {
                if(var3.length == 1) {
                    File var8 = var3[0];
                    var8.isFile();
                    if(var8.isFile()) {
                        return var8;
                    }
                } else if(var3.length > 1) {
                    for(int var4 = var3.length; var1 < var4; ++var1) {
                        File var5 = var3[var1];
                        var5.isFile();
                        var5.delete();
                    }
                }
            }
        }

        return null;
    }

    // $FF: renamed from: f () void
    private void method_3404() {
        if(!class_790.method_4077().field_3716) {
            boolean var10000 = this.field_3016;
            class_803 var2 = this.field_3011.method_415();
            class_803 var3 = this.field_3011.method_416();
            class_803 var4 = this.field_3011.method_417();
            class_803 var5 = this.field_3011.method_418();
            class_803 var6 = this.field_3011.method_419();
            class_769 var7 = this.field_3011.method_426();
            this.field_3009.method_4102();
            this.field_3007 = new class_800(this.field_3013);
            if(!this.field_3009.delaySendingAppLoad()) {
                var2.method_4168(this.field_3007);
                class_756 var10 = new class_756(this.field_3010);
                var10.method_4004(var2, new class_751.class_1260(), this.field_3009.method_4105(), "/v0/appload/", this.field_3009.method_4102(), this.field_3013, new class_752.class_1262());
                var10.method_4004(var3, new class_750.class_1263(), this.field_3009.method_4102(), "/android_v2/handle_exceptions", (String)null, this.field_3013, new class_749.class_1255());
                var10.method_4004(var5, new class_750.class_1263(), this.field_3009.method_4102(), "/android_v2/handle_ndk_crashes", (String)null, this.field_3013, new class_749.class_1255());
                var10.method_4004(var6, new class_750.class_1263(), this.field_3009.method_4102(), "/android_v2/handle_crashes", (String)null, this.field_3013, new class_749.class_1255());
                var10.method_4004(var4, new class_750.class_1263(), this.field_3009.method_4102(), "/android_v2/handle_exceptions", (String)null, new class_791(this.field_3013, this.field_3009), new class_749.class_1255());
                var10.method_4003();
            }

            if(var7.method_4045()) {
                class_790.method_4077().method_4084();
                return;
            }
        }

    }

    // $FF: renamed from: a () void
    public final void method_3390() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (java.lang.Runnable) boolean
    public final boolean method_3405(Runnable var1) {
        synchronized(this) {}
        boolean var5 = false;

        boolean var3;
        label50: {
            try {
                var5 = true;
                if(!this.method_3402()) {
                    this.field_3014.add(var1);
                    var5 = false;
                    break label50;
                }

                var5 = false;
            } finally {
                if(var5) {
                    ;
                }
            }

            var3 = false;
            return var3;
        }

        var3 = true;
        return var3;
    }

    // $FF: renamed from: b () void
    public final void method_3406() {
        this.field_3008.block();
    }
}

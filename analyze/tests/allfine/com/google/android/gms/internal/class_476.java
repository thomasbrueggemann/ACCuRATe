package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.SystemClock;
import android.os.Build.VERSION;
import com.google.android.gms.internal.class_34;
import com.google.android.gms.internal.class_376;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_389;
import com.google.android.gms.internal.ez;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// $FF: renamed from: com.google.android.gms.internal.dy
@ez
public final class class_476 extends class_34.class_1476 {
    private Context mContext;
    // $FF: renamed from: mv java.lang.String
    private String field_1836;
    // $FF: renamed from: su java.lang.String
    private String field_1837;
    // $FF: renamed from: sv java.util.ArrayList
    private ArrayList<String> field_1838;

    public class_476(String var1, ArrayList<String> var2, Context var3, String var4) {
        this.field_1837 = var1;
        this.field_1838 = var2;
        this.field_1836 = var4;
        this.mContext = var3;
    }

    // $FF: renamed from: cq () void
    private void method_2889() {
        try {
            Class var4 = this.mContext.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter");
            Class[] var5 = new Class[] {Context.class, String.class, String.class, Boolean.TYPE};
            Method var6 = var4.getDeclaredMethod("reportWithProductId", var5);
            Object[] var7 = new Object[] {this.mContext, this.field_1837, "", Boolean.valueOf(true)};
            var6.invoke((Object)null, var7);
        } catch (ClassNotFoundException var8) {
            class_378.method_2461("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (NoSuchMethodException var9) {
            class_378.method_2461("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (Exception var10) {
            class_378.method_2465("Fail to report a conversion.", var10);
        }
    }

    // $FF: renamed from: a (java.lang.String, java.util.HashMap) java.lang.String
    protected String method_2890(String var1, HashMap<String, String> var2) {
        String var3 = this.mContext.getPackageName();

        String var5;
        label22: {
            String var23;
            try {
                var23 = this.mContext.getPackageManager().getPackageInfo(var3, 0).versionName;
            } catch (NameNotFoundException var24) {
                class_378.method_2465("Error to retrieve app version", var24);
                var5 = "";
                break label22;
            }

            var5 = var23;
        }

        long var6 = SystemClock.elapsedRealtime() - class_389.method_2557().method_2593();

        String var21;
        Object[] var22;
        for(Iterator var8 = var2.keySet().iterator(); var8.hasNext(); var1 = var1.replaceAll(var21, String.format("$1%s$2", var22))) {
            String var20 = (String)var8.next();
            var21 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] {var20});
            var22 = new Object[] {var2.get(var20)};
        }

        String var9 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] {"sessionid"});
        Object[] var10 = new Object[] {class_389.field_1421};
        String var11 = var1.replaceAll(var9, String.format("$1%s$2", var10)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] {"appid"}), String.format("$1%s$2", new Object[] {var3}));
        String var12 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] {"osversion"});
        Object[] var13 = new Object[] {String.valueOf(VERSION.SDK_INT)};
        String var14 = var11.replaceAll(var12, String.format("$1%s$2", var13));
        String var15 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] {"sdkversion"});
        Object[] var16 = new Object[] {this.field_1836};
        String var17 = var14.replaceAll(var15, String.format("$1%s$2", var16)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] {"appversion"}), String.format("$1%s$2", new Object[] {var5}));
        String var18 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] {"timestamp"});
        Object[] var19 = new Object[] {String.valueOf(var6)};
        return var17.replaceAll(var18, String.format("$1%s$2", var19)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] {"[^@]+"}), String.format("$1%s$2", new Object[] {""})).replaceAll("@@", "@");
    }

    public String getProductId() {
        return this.field_1837;
    }

    // $FF: renamed from: o (int) int
    protected int method_2891(int var1) {
        return var1 == 0?1:(var1 == 1?2:(var1 == 4?3:0));
    }

    public void recordPlayBillingResolution(int var1) {
        if(var1 == 0) {
            this.method_2889();
        }

        HashMap var2 = new HashMap();
        var2.put("google_play_status", String.valueOf(var1));
        var2.put("sku", this.field_1837);
        var2.put("status", String.valueOf(this.method_2891(var1)));
        Iterator var6 = this.field_1838.iterator();

        while(var6.hasNext()) {
            String var7 = (String)var6.next();
            (new class_376(this.mContext, this.field_1836, this.method_2890(var7, var2))).start();
        }

    }

    public void recordResolution(int var1) {
        if(var1 == 1) {
            this.method_2889();
        }

        HashMap var2 = new HashMap();
        var2.put("status", String.valueOf(var1));
        var2.put("sku", this.field_1837);
        Iterator var5 = this.field_1838.iterator();

        while(var5.hasNext()) {
            String var6 = (String)var5.next();
            (new class_376(this.mContext, this.field_1836, this.method_2890(var6, var2))).start();
        }

    }
}

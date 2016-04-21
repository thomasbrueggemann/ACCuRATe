package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.ez;
import java.lang.reflect.Method;

// $FF: renamed from: com.google.android.gms.internal.dw
@ez
public class class_472 {
    private final Context mContext;
    // $FF: renamed from: sk java.lang.Object
    private Object field_1819;

    public class_472(Context var1) {
        this.mContext = var1;
    }

    // $FF: renamed from: a (java.lang.String, java.lang.String, java.lang.String) android.os.Bundle
    public Bundle method_2872(String var1, String var2, String var3) {
        try {
            Class var5 = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            Class[] var6 = new Class[] {Integer.TYPE, String.class, String.class, String.class, String.class};
            Method var7 = var5.getDeclaredMethod("getBuyIntent", var6);
            Object var8 = var5.cast(this.field_1819);
            Object[] var9 = new Object[] {Integer.valueOf(3), var1, var2, "inapp", var3};
            Bundle var10 = (Bundle)var7.invoke(var8, var9);
            return var10;
        } catch (Exception var11) {
            class_378.method_2465("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", var11);
            return null;
        }
    }

    // $FF: renamed from: c (java.lang.String, java.lang.String) int
    public int method_2873(String var1, String var2) {
        try {
            Class var4 = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            Class[] var5 = new Class[] {Integer.TYPE, String.class, String.class};
            Method var6 = var4.getDeclaredMethod("consumePurchase", var5);
            Object var7 = var4.cast(this.field_1819);
            Object[] var8 = new Object[] {Integer.valueOf(3), var1, var2};
            int var9 = ((Integer)var6.invoke(var7, var8)).intValue();
            return var9;
        } catch (Exception var10) {
            class_378.method_2465("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", var10);
            return 5;
        }
    }

    // $FF: renamed from: d (java.lang.String, java.lang.String) android.os.Bundle
    public Bundle method_2874(String var1, String var2) {
        try {
            Class var4 = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            Class[] var5 = new Class[] {Integer.TYPE, String.class, String.class, String.class};
            Method var6 = var4.getDeclaredMethod("getPurchases", var5);
            Object var7 = var4.cast(this.field_1819);
            Object[] var8 = new Object[] {Integer.valueOf(3), var1, "inapp", var2};
            Bundle var9 = (Bundle)var6.invoke(var7, var8);
            return var9;
        } catch (Exception var10) {
            class_378.method_2465("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", var10);
            return null;
        }
    }

    public void destroy() {
        this.field_1819 = null;
    }

    // $FF: renamed from: r (android.os.IBinder) void
    public void method_2875(IBinder var1) {
        try {
            this.field_1819 = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService$Stub").getDeclaredMethod("asInterface", new Class[] {IBinder.class}).invoke((Object)null, new Object[] {var1});
        } catch (Exception var3) {
            class_378.method_2461("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.");
        }
    }
}

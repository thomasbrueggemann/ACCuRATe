package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.class_1046;
import com.google.android.gms.dynamic.class_206;
import com.google.android.gms.internal.class_33;
import com.google.android.gms.internal.class_34;
import com.google.android.gms.internal.class_429;
import com.google.android.gms.internal.class_474;
import com.google.android.gms.internal.dv;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.dv
@ez
public final class class_473 implements SafeParcelable {
    public static final class_474 CREATOR = new class_474();
    // $FF: renamed from: lM com.google.android.gms.internal.el
    public final class_33 field_1820;
    // $FF: renamed from: lT com.google.android.gms.internal.ee
    public final class_429 field_1821;
    // $FF: renamed from: si com.google.android.gms.internal.eg
    public final class_34 field_1822;
    // $FF: renamed from: sj android.content.Context
    public final Context field_1823;
    public final int versionCode;

    class_473(int var1, IBinder var2, IBinder var3, IBinder var4, IBinder var5) {
        this.versionCode = var1;
        this.field_1820 = (class_33)class_1046.method_5436(class_206.class_1795.method_5435(var2));
        this.field_1821 = (class_429)class_1046.method_5436(class_206.class_1795.method_5435(var3));
        this.field_1822 = (class_34)class_1046.method_5436(class_206.class_1795.method_5435(var4));
        this.field_1823 = (Context)class_1046.method_5436(class_206.class_1795.method_5435(var5));
    }

    public class_473(class_34 var1, class_33 var2, class_429 var3, Context var4) {
        this.versionCode = 1;
        this.field_1822 = var1;
        this.field_1820 = var2;
        this.field_1821 = var3;
        this.field_1823 = var4;
    }

    // $FF: renamed from: a (android.content.Intent, com.google.android.gms.internal.dv) void
    public static void method_2876(Intent var0, class_473 var1) {
        Bundle var2 = new Bundle(1);
        var2.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", var1);
        var0.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", var2);
    }

    // $FF: renamed from: c (android.content.Intent) com.google.android.gms.internal.dv
    public static class_473 method_2877(Intent var0) {
        try {
            Bundle var2 = var0.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            var2.setClassLoader(dv.class.getClassLoader());
            class_473 var3 = (class_473)var2.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            return var3;
        } catch (Exception var4) {
            return null;
        }
    }

    // $FF: renamed from: ck () android.os.IBinder
    IBinder method_2878() {
        return class_1046.method_5437(this.field_1820).asBinder();
    }

    // $FF: renamed from: cl () android.os.IBinder
    IBinder method_2879() {
        return class_1046.method_5437(this.field_1821).asBinder();
    }

    // $FF: renamed from: cm () android.os.IBinder
    IBinder method_2880() {
        return class_1046.method_5437(this.field_1822).asBinder();
    }

    // $FF: renamed from: cn () android.os.IBinder
    IBinder method_2881() {
        return class_1046.method_5437(this.field_1823).asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_474.method_2882(this, var1, var2);
    }
}

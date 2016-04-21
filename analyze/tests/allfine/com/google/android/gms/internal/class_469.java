package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.class_1046;
import com.google.android.gms.dynamic.class_206;
import com.google.android.gms.internal.class_379;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.class_42;
import com.google.android.gms.internal.class_46;
import com.google.android.gms.internal.class_470;
import com.google.android.gms.internal.class_48;
import com.google.android.gms.internal.class_486;
import com.google.android.gms.internal.class_536;
import com.google.android.gms.internal.class_63;
import com.google.android.gms.internal.class_8;
import com.google.android.gms.internal.dm;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.dm
@ez
public final class class_469 implements SafeParcelable {
    public static final class_470 CREATOR = new class_470();
    // $FF: renamed from: lD com.google.android.gms.internal.gt
    public final class_379 field_1802;
    public final int orientation;
    // $FF: renamed from: rK com.google.android.gms.internal.dj
    public final class_486 field_1803;
    // $FF: renamed from: rL com.google.android.gms.internal.t
    public final class_63 field_1804;
    // $FF: renamed from: rM com.google.android.gms.internal.dn
    public final class_46 field_1805;
    // $FF: renamed from: rN com.google.android.gms.internal.gv
    public final class_381 field_1806;
    // $FF: renamed from: rO com.google.android.gms.internal.bw
    public final class_8 field_1807;
    // $FF: renamed from: rP java.lang.String
    public final String field_1808;
    // $FF: renamed from: rQ boolean
    public final boolean field_1809;
    // $FF: renamed from: rR java.lang.String
    public final String field_1810;
    // $FF: renamed from: rS com.google.android.gms.internal.dq
    public final class_48 field_1811;
    // $FF: renamed from: rT int
    public final int field_1812;
    // $FF: renamed from: rU com.google.android.gms.internal.bz
    public final class_42 field_1813;
    // $FF: renamed from: rV java.lang.String
    public final String field_1814;
    // $FF: renamed from: rW com.google.android.gms.internal.x
    public final class_536 field_1815;
    // $FF: renamed from: rq java.lang.String
    public final String field_1816;
    public final int versionCode;

    class_469(int var1, class_486 var2, IBinder var3, IBinder var4, IBinder var5, IBinder var6, String var7, boolean var8, String var9, IBinder var10, int var11, int var12, String var13, class_379 var14, IBinder var15, String var16, class_536 var17) {
        this.versionCode = var1;
        this.field_1803 = var2;
        this.field_1804 = (class_63)class_1046.method_5436(class_206.class_1795.method_5435(var3));
        this.field_1805 = (class_46)class_1046.method_5436(class_206.class_1795.method_5435(var4));
        this.field_1806 = (class_381)class_1046.method_5436(class_206.class_1795.method_5435(var5));
        this.field_1807 = (class_8)class_1046.method_5436(class_206.class_1795.method_5435(var6));
        this.field_1808 = var7;
        this.field_1809 = var8;
        this.field_1810 = var9;
        this.field_1811 = (class_48)class_1046.method_5436(class_206.class_1795.method_5435(var10));
        this.orientation = var11;
        this.field_1812 = var12;
        this.field_1816 = var13;
        this.field_1802 = var14;
        this.field_1813 = (class_42)class_1046.method_5436(class_206.class_1795.method_5435(var15));
        this.field_1814 = var16;
        this.field_1815 = var17;
    }

    public class_469(class_486 var1, class_63 var2, class_46 var3, class_48 var4, class_379 var5) {
        this.versionCode = 4;
        this.field_1803 = var1;
        this.field_1804 = var2;
        this.field_1805 = var3;
        this.field_1806 = null;
        this.field_1807 = null;
        this.field_1808 = null;
        this.field_1809 = false;
        this.field_1810 = null;
        this.field_1811 = var4;
        this.orientation = -1;
        this.field_1812 = 4;
        this.field_1816 = null;
        this.field_1802 = var5;
        this.field_1813 = null;
        this.field_1814 = null;
        this.field_1815 = null;
    }

    public class_469(class_63 var1, class_46 var2, class_8 var3, class_48 var4, class_381 var5, boolean var6, int var7, String var8, class_379 var9, class_42 var10) {
        this.versionCode = 4;
        this.field_1803 = null;
        this.field_1804 = var1;
        this.field_1805 = var2;
        this.field_1806 = var5;
        this.field_1807 = var3;
        this.field_1808 = null;
        this.field_1809 = var6;
        this.field_1810 = null;
        this.field_1811 = var4;
        this.orientation = var7;
        this.field_1812 = 3;
        this.field_1816 = var8;
        this.field_1802 = var9;
        this.field_1813 = var10;
        this.field_1814 = null;
        this.field_1815 = null;
    }

    public class_469(class_63 var1, class_46 var2, class_8 var3, class_48 var4, class_381 var5, boolean var6, int var7, String var8, String var9, class_379 var10, class_42 var11) {
        this.versionCode = 4;
        this.field_1803 = null;
        this.field_1804 = var1;
        this.field_1805 = var2;
        this.field_1806 = var5;
        this.field_1807 = var3;
        this.field_1808 = var9;
        this.field_1809 = var6;
        this.field_1810 = var8;
        this.field_1811 = var4;
        this.orientation = var7;
        this.field_1812 = 3;
        this.field_1816 = null;
        this.field_1802 = var10;
        this.field_1813 = var11;
        this.field_1814 = null;
        this.field_1815 = null;
    }

    public class_469(class_63 var1, class_46 var2, class_48 var3, class_381 var4, int var5, class_379 var6, String var7, class_536 var8) {
        this.versionCode = 4;
        this.field_1803 = null;
        this.field_1804 = var1;
        this.field_1805 = var2;
        this.field_1806 = var4;
        this.field_1807 = null;
        this.field_1808 = null;
        this.field_1809 = false;
        this.field_1810 = null;
        this.field_1811 = var3;
        this.orientation = var5;
        this.field_1812 = 1;
        this.field_1816 = null;
        this.field_1802 = var6;
        this.field_1813 = null;
        this.field_1814 = var7;
        this.field_1815 = var8;
    }

    public class_469(class_63 var1, class_46 var2, class_48 var3, class_381 var4, boolean var5, int var6, class_379 var7) {
        this.versionCode = 4;
        this.field_1803 = null;
        this.field_1804 = var1;
        this.field_1805 = var2;
        this.field_1806 = var4;
        this.field_1807 = null;
        this.field_1808 = null;
        this.field_1809 = var5;
        this.field_1810 = null;
        this.field_1811 = var3;
        this.orientation = var6;
        this.field_1812 = 2;
        this.field_1816 = null;
        this.field_1802 = var7;
        this.field_1813 = null;
        this.field_1814 = null;
        this.field_1815 = null;
    }

    // $FF: renamed from: a (android.content.Intent, com.google.android.gms.internal.dm) void
    public static void method_2860(Intent var0, class_469 var1) {
        Bundle var2 = new Bundle(1);
        var2.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", var1);
        var0.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", var2);
    }

    // $FF: renamed from: b (android.content.Intent) com.google.android.gms.internal.dm
    public static class_469 method_2861(Intent var0) {
        try {
            Bundle var2 = var0.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            var2.setClassLoader(dm.class.getClassLoader());
            class_469 var3 = (class_469)var2.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            return var3;
        } catch (Exception var4) {
            return null;
        }
    }

    // $FF: renamed from: cb () android.os.IBinder
    IBinder method_2862() {
        return class_1046.method_5437(this.field_1804).asBinder();
    }

    // $FF: renamed from: cc () android.os.IBinder
    IBinder method_2863() {
        return class_1046.method_5437(this.field_1805).asBinder();
    }

    // $FF: renamed from: cd () android.os.IBinder
    IBinder method_2864() {
        return class_1046.method_5437(this.field_1806).asBinder();
    }

    // $FF: renamed from: ce () android.os.IBinder
    IBinder method_2865() {
        return class_1046.method_5437(this.field_1807).asBinder();
    }

    // $FF: renamed from: cf () android.os.IBinder
    IBinder method_2866() {
        return class_1046.method_5437(this.field_1813).asBinder();
    }

    // $FF: renamed from: cg () android.os.IBinder
    IBinder method_2867() {
        return class_1046.method_5437(this.field_1811).asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_470.method_2868(this, var1, var2);
    }
}

package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Parcel;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.class_1130;
import com.google.android.gms.internal.class_848;

public final class Device implements SafeParcelable {
    public static final Creator<Device> CREATOR = new class_1130();
    public static final int TYPE_CHEST_STRAP = 4;
    public static final int TYPE_PHONE = 1;
    public static final int TYPE_SCALE = 5;
    public static final int TYPE_TABLET = 2;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WATCH = 3;
    // $FF: renamed from: BR int
    private final int field_1469;
    // $FF: renamed from: FD int
    private final int field_1470;
    // $FF: renamed from: SZ java.lang.String
    private final String field_1471;
    // $FF: renamed from: Sx java.lang.String
    private final String field_1472;
    // $FF: renamed from: Ta java.lang.String
    private final String field_1473;
    // $FF: renamed from: Tb java.lang.String
    private final String field_1474;
    // $FF: renamed from: Tc int
    private final int field_1475;

    Device(int var1, String var2, String var3, String var4, String var5, int var6, int var7) {
        this.field_1469 = var1;
        this.field_1471 = (String)class_1090.method_5685(var2);
        this.field_1473 = (String)class_1090.method_5685(var3);
        this.field_1472 = "";
        this.field_1474 = (String)class_1090.method_5685(var5);
        this.field_1470 = var6;
        this.field_1475 = var7;
    }

    public Device(String var1, String var2, String var3, int var4) {
        this(var1, var2, "", var3, var4, 0);
    }

    public Device(String var1, String var2, String var3, String var4, int var5) {
        this(var1, var2, var4, var5);
    }

    public Device(String var1, String var2, String var3, String var4, int var5, int var6) {
        this(1, var1, var2, "", var4, var5, var6);
    }

    // $FF: renamed from: M (android.content.Context) java.lang.String
    private static String method_2601(Context var0) {
        return Secure.getString(var0.getContentResolver(), "android_id");
    }

    // $FF: renamed from: N (android.content.Context) int
    private static int method_2602(Context var0) {
        int var1 = method_2604(var0);
        byte var2 = 0;
        switch(var1) {
            case 8:
            case 9:
                break;
            case 10:
                boolean var3 = method_2603(var0);
                var2 = 0;
                if(var3) {
                    return 3;
                }
                break;
            default:
                if(!method_2606(var0)) {
                    return 2;
                }

                var2 = 1;
        }

        return var2;
    }

    // $FF: renamed from: O (android.content.Context) boolean
    public static boolean method_2603(Context var0) {
        return (15 & var0.getResources().getConfiguration().uiMode) == 6;
    }

    // $FF: renamed from: P (android.content.Context) int
    private static int method_2604(Context var0) {
        return 5 + method_2605(var0) % 1000 / 100;
    }

    // $FF: renamed from: Q (android.content.Context) int
    private static int method_2605(Context var0) {
        try {
            int var3 = var0.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
            return var3;
        } catch (NameNotFoundException var4) {
            Log.w("Fitness", "Could not find package info for Google Play Services");
            return -1;
        }
    }

    // $FF: renamed from: R (android.content.Context) boolean
    private static boolean method_2606(Context var0) {
        return ((TelephonyManager)var0.getSystemService("phone")).getPhoneType() != 0;
    }

    // $FF: renamed from: a (com.google.android.gms.fitness.data.Device) boolean
    private boolean method_2607(Device var1) {
        return class_1089.equal(this.field_1471, var1.field_1471) && class_1089.equal(this.field_1473, var1.field_1473) && class_1089.equal(this.field_1472, var1.field_1472) && class_1089.equal(this.field_1474, var1.field_1474) && this.field_1470 == var1.field_1470 && this.field_1475 == var1.field_1475;
    }

    public static Device getLocalDevice(Context var0) {
        int var1 = method_2602(var0);
        String var2 = method_2601(var0);
        return new Device(Build.MANUFACTURER, Build.MODEL, VERSION.RELEASE, var2, var1, 2);
    }

    // $FF: renamed from: iS () boolean
    private boolean method_2608() {
        return this.method_2609() == 1;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return this == var1 || var1 instanceof Device && this.method_2607((Device)var1);
    }

    public String getManufacturer() {
        return this.field_1471;
    }

    public String getModel() {
        return this.field_1473;
    }

    String getStreamIdentifier() {
        Object[] var1 = new Object[] {this.field_1471, this.field_1473, this.field_1474};
        return String.format("%s:%s:%s", var1);
    }

    public int getType() {
        return this.field_1470;
    }

    public String getUid() {
        return this.field_1474;
    }

    public String getVersion() {
        return this.field_1472;
    }

    int getVersionCode() {
        return this.field_1469;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.field_1471, this.field_1473, this.field_1472, this.field_1474, Integer.valueOf(this.field_1470)};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: iR () int
    public int method_2609() {
        return this.field_1475;
    }

    // $FF: renamed from: iT () com.google.android.gms.fitness.data.Device
    Device method_2610() {
        return new Device(class_848.method_4469(this.field_1471), class_848.method_4469(this.field_1473), class_848.method_4469(this.field_1472), this.field_1474, this.field_1470);
    }

    // $FF: renamed from: iU () java.lang.String
    public String method_2611() {
        return !class_848.method_4471() && !this.method_2608()?class_848.method_4469(this.field_1474):this.field_1474;
    }

    public String toString() {
        Object[] var1 = new Object[] {this.getStreamIdentifier(), this.field_1472, Integer.valueOf(this.field_1470), Integer.valueOf(this.field_1475)};
        return String.format("Device{%s:%s:%s:%s}", var1);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1130.method_5880(this, var1, var2);
    }
}

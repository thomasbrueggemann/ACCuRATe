package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_827;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

// $FF: renamed from: com.google.android.gms.internal.mc
public class class_828 implements SafeParcelable, Geofence {
    public static final class_827 CREATOR = new class_827();
    // $FF: renamed from: BR int
    private final int field_4108;
    // $FF: renamed from: XC java.lang.String
    private final String field_4109;
    private final int aeh;
    private final short aej;
    private final double aek;
    private final double ael;
    private final float aem;
    private final int aen;
    private final int aeo;
    private final long afm;

    public class_828(int var1, String var2, int var3, short var4, double var5, double var7, float var9, long var10, int var12, int var13) {
        method_4441(var2);
        method_4440(var9);
        method_4439(var5, var7);
        int var14 = method_4442(var3);
        this.field_4108 = var1;
        this.aej = var4;
        this.field_4109 = var2;
        this.aek = var5;
        this.ael = var7;
        this.aem = var9;
        this.afm = var10;
        this.aeh = var14;
        this.aen = var12;
        this.aeo = var13;
    }

    public class_828(String var1, int var2, short var3, double var4, double var6, float var8, long var9, int var11, int var12) {
        this(1, var1, var2, var3, var4, var6, var8, var9, var11, var12);
    }

    // $FF: renamed from: a (double, double) void
    private static void method_4439(double var0, double var2) {
        if(var0 <= 90.0D && var0 >= -90.0D) {
            if(var2 > 180.0D || var2 < -180.0D) {
                throw new IllegalArgumentException("invalid longitude: " + var2);
            }
        } else {
            throw new IllegalArgumentException("invalid latitude: " + var0);
        }
    }

    // $FF: renamed from: b (float) void
    private static void method_4440(float var0) {
        if(var0 <= 0.0F) {
            throw new IllegalArgumentException("invalid radius: " + var0);
        }
    }

    // $FF: renamed from: bY (java.lang.String) void
    private static void method_4441(String var0) {
        if(var0 == null || var0.length() > 100) {
            throw new IllegalArgumentException("requestId is null or too long: " + var0);
        }
    }

    // $FF: renamed from: ek (int) int
    private static int method_4442(int var0) {
        int var1 = var0 & 7;
        if(var1 == 0) {
            throw new IllegalArgumentException("No supported transition specified: " + var0);
        } else {
            return var1;
        }
    }

    // $FF: renamed from: el (int) java.lang.String
    private static String method_4443(int var0) {
        switch(var0) {
            case 1:
                return "CIRCLE";
            default:
                return null;
        }
    }

    // $FF: renamed from: h (byte[]) com.google.android.gms.internal.mc
    public static class_828 method_4444(byte[] var0) {
        Parcel var1 = Parcel.obtain();
        var1.unmarshall(var0, 0, var0.length);
        var1.setDataPosition(0);
        class_828 var2 = CREATOR.method_4437(var1);
        var1.recycle();
        return var2;
    }

    public int describeContents() {
        class_827 var10000 = CREATOR;
        return 0;
    }

    public boolean equals(Object var1) {
        if(this != var1) {
            if(var1 == null) {
                return false;
            }

            if(!(var1 instanceof class_828)) {
                return false;
            }

            class_828 var2 = (class_828)var1;
            if(this.aem != var2.aem) {
                return false;
            }

            if(this.aek != var2.aek) {
                return false;
            }

            if(this.ael != var2.ael) {
                return false;
            }

            if(this.aej != var2.aej) {
                return false;
            }
        }

        return true;
    }

    public long getExpirationTime() {
        return this.afm;
    }

    public double getLatitude() {
        return this.aek;
    }

    public double getLongitude() {
        return this.ael;
    }

    public int getNotificationResponsiveness() {
        return this.aen;
    }

    public String getRequestId() {
        return this.field_4109;
    }

    public int getVersionCode() {
        return this.field_4108;
    }

    public int hashCode() {
        long var1 = Double.doubleToLongBits(this.aek);
        int var3 = 31 + (int)(var1 ^ var1 >>> 32);
        long var4 = Double.doubleToLongBits(this.ael);
        return 31 * (31 * (31 * (var3 * 31 + (int)(var4 ^ var4 >>> 32)) + Float.floatToIntBits(this.aem)) + this.aej) + this.aeh;
    }

    // $FF: renamed from: ma () short
    public short method_4445() {
        return this.aej;
    }

    // $FF: renamed from: mb () float
    public float method_4446() {
        return this.aem;
    }

    // $FF: renamed from: mc () int
    public int method_4447() {
        return this.aeh;
    }

    // $FF: renamed from: md () int
    public int method_4448() {
        return this.aeo;
    }

    public String toString() {
        Locale var1 = Locale.US;
        Object[] var2 = new Object[] {method_4443(this.aej), this.field_4109, Integer.valueOf(this.aeh), Double.valueOf(this.aek), Double.valueOf(this.ael), Float.valueOf(this.aem), Integer.valueOf(this.aen / 1000), Integer.valueOf(this.aeo), Long.valueOf(this.afm)};
        return String.format(var1, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", var2);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_827 var10000 = CREATOR;
        class_827.method_4436(this, var1, var2);
    }
}

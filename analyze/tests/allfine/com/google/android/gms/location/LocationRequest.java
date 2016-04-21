package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.class_665;

public final class LocationRequest implements SafeParcelable {
    public static final class_665 CREATOR = new class_665();
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;
    // $FF: renamed from: BR int
    private final int field_4556;
    // $FF: renamed from: UK boolean
    boolean field_4557;
    long aei;
    long aes;
    long aet;
    int aeu;
    float aev;
    long aew;
    int mPriority;

    public LocationRequest() {
        this.field_4556 = 1;
        this.mPriority = 102;
        this.aes = 3600000L;
        this.aet = 600000L;
        this.field_4557 = false;
        this.aei = Long.MAX_VALUE;
        this.aeu = Integer.MAX_VALUE;
        this.aev = 0.0F;
        this.aew = 0L;
    }

    LocationRequest(int var1, int var2, long var3, long var5, boolean var7, long var8, int var10, float var11, long var12) {
        this.field_4556 = var1;
        this.mPriority = var2;
        this.aes = var3;
        this.aet = var5;
        this.field_4557 = var7;
        this.aei = var8;
        this.aeu = var10;
        this.aev = var11;
        this.aew = var12;
    }

    // $FF: renamed from: a (float) void
    private static void method_5200(float var0) {
        if(var0 < 0.0F) {
            throw new IllegalArgumentException("invalid displacement: " + var0);
        }
    }

    public static LocationRequest create() {
        return new LocationRequest();
    }

    // $FF: renamed from: eb (int) void
    private static void method_5201(int var0) {
        switch(var0) {
            case 100:
            case 102:
            case 104:
            case 105:
                return;
            case 101:
            case 103:
            default:
                throw new IllegalArgumentException("invalid quality: " + var0);
        }
    }

    // $FF: renamed from: ec (int) java.lang.String
    public static String method_5202(int var0) {
        switch(var0) {
            case 100:
                return "PRIORITY_HIGH_ACCURACY";
            case 101:
            case 103:
            default:
                return "???";
            case 102:
                return "PRIORITY_BALANCED_POWER_ACCURACY";
            case 104:
                return "PRIORITY_LOW_POWER";
            case 105:
                return "PRIORITY_NO_POWER";
        }
    }

    // $FF: renamed from: v (long) void
    private static void method_5203(long var0) {
        if(var0 < 0L) {
            throw new IllegalArgumentException("invalid interval: " + var0);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        if(this != var1) {
            if(!(var1 instanceof LocationRequest)) {
                return false;
            }

            LocationRequest var2 = (LocationRequest)var1;
            if(this.mPriority != var2.mPriority || this.aes != var2.aes || this.aet != var2.aet || this.field_4557 != var2.field_4557 || this.aei != var2.aei || this.aeu != var2.aeu || this.aev != var2.aev) {
                return false;
            }
        }

        return true;
    }

    public long getExpirationTime() {
        return this.aei;
    }

    public long getFastestInterval() {
        return this.aet;
    }

    public long getInterval() {
        return this.aes;
    }

    public int getNumUpdates() {
        return this.aeu;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public float getSmallestDisplacement() {
        return this.aev;
    }

    int getVersionCode() {
        return this.field_4556;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {Integer.valueOf(this.mPriority), Long.valueOf(this.aes), Long.valueOf(this.aet), Boolean.valueOf(this.field_4557), Long.valueOf(this.aei), Integer.valueOf(this.aeu), Float.valueOf(this.aev)};
        return class_1089.hashCode(var1);
    }

    public LocationRequest setExpirationDuration(long var1) {
        long var3 = SystemClock.elapsedRealtime();
        if(var1 > Long.MAX_VALUE - var3) {
            this.aei = Long.MAX_VALUE;
        } else {
            this.aei = var3 + var1;
        }

        if(this.aei < 0L) {
            this.aei = 0L;
        }

        return this;
    }

    public LocationRequest setExpirationTime(long var1) {
        this.aei = var1;
        if(this.aei < 0L) {
            this.aei = 0L;
        }

        return this;
    }

    public LocationRequest setFastestInterval(long var1) {
        method_5203(var1);
        this.field_4557 = true;
        this.aet = var1;
        return this;
    }

    public LocationRequest setInterval(long var1) {
        method_5203(var1);
        this.aes = var1;
        if(!this.field_4557) {
            this.aet = (long)((double)this.aes / 6.0D);
        }

        return this;
    }

    public LocationRequest setNumUpdates(int var1) {
        if(var1 <= 0) {
            throw new IllegalArgumentException("invalid numUpdates: " + var1);
        } else {
            this.aeu = var1;
            return this;
        }
    }

    public LocationRequest setPriority(int var1) {
        method_5201(var1);
        this.mPriority = var1;
        return this;
    }

    public LocationRequest setSmallestDisplacement(float var1) {
        method_5200(var1);
        this.aev = var1;
        return this;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("Request[").append(method_5202(this.mPriority));
        if(this.mPriority != 105) {
            var1.append(" requested=");
            var1.append(this.aes + "ms");
        }

        var1.append(" fastest=");
        var1.append(this.aet + "ms");
        if(this.aei != Long.MAX_VALUE) {
            long var7 = this.aei - SystemClock.elapsedRealtime();
            var1.append(" expireIn=");
            var1.append(var7 + "ms");
        }

        if(this.aeu != Integer.MAX_VALUE) {
            var1.append(" num=").append(this.aeu);
        }

        var1.append(']');
        return var1.toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_665.method_3725(this, var1, var2);
    }
}

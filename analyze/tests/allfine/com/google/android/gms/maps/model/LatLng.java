package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.class_816;
import com.google.android.gms.maps.model.class_975;
import com.google.android.gms.maps.model.class_978;

public final class LatLng implements SafeParcelable {
    public static final class_978 CREATOR = new class_978();
    // $FF: renamed from: BR int
    private final int field_2188;
    public final double latitude;
    public final double longitude;

    public LatLng(double var1, double var3) {
        this(1, var1, var3);
    }

    LatLng(int var1, double var2, double var4) {
        this.field_2188 = var1;
        if(-180.0D <= var4 && var4 < 180.0D) {
            this.longitude = var4;
        } else {
            this.longitude = (360.0D + (var4 - 180.0D) % 360.0D) % 360.0D - 180.0D;
        }

        this.latitude = Math.max(-90.0D, Math.min(90.0D, var2));
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        if(this != var1) {
            if(!(var1 instanceof LatLng)) {
                return false;
            }

            LatLng var2 = (LatLng)var1;
            if(Double.doubleToLongBits(this.latitude) != Double.doubleToLongBits(var2.latitude) || Double.doubleToLongBits(this.longitude) != Double.doubleToLongBits(var2.longitude)) {
                return false;
            }
        }

        return true;
    }

    int getVersionCode() {
        return this.field_2188;
    }

    public int hashCode() {
        long var1 = Double.doubleToLongBits(this.latitude);
        int var3 = 31 + (int)(var1 ^ var1 >>> 32);
        long var4 = Double.doubleToLongBits(this.longitude);
        return var3 * 31 + (int)(var4 ^ var4 >>> 32);
    }

    public String toString() {
        return "lat/lng: (" + this.latitude + "," + this.longitude + ")";
    }

    public void writeToParcel(Parcel var1, int var2) {
        if(class_816.method_4241()) {
            class_975.method_5155(this, var1, var2);
        } else {
            class_978.method_5160(this, var1, var2);
        }
    }
}

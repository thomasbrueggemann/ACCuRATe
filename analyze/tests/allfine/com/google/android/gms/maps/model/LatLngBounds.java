package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.class_816;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.class_972;
import com.google.android.gms.maps.model.class_977;

public final class LatLngBounds implements SafeParcelable {
    public static final class_972 CREATOR = new class_972();
    // $FF: renamed from: BR int
    private final int field_3457;
    public final LatLng northeast;
    public final LatLng southwest;

    LatLngBounds(int var1, LatLng var2, LatLng var3) {
        class_1090.method_5681(var2, "null southwest");
        class_1090.method_5681(var3, "null northeast");
        boolean var6;
        if(var3.latitude >= var2.latitude) {
            var6 = true;
        } else {
            var6 = false;
        }

        Object[] var7 = new Object[] {Double.valueOf(var2.latitude), Double.valueOf(var3.latitude)};
        class_1090.method_5684(var6, "southern latitude exceeds northern latitude (%s > %s)", var7);
        this.field_3457 = var1;
        this.southwest = var2;
        this.northeast = var3;
    }

    public LatLngBounds(LatLng var1, LatLng var2) {
        this(1, var1, var2);
    }

    // $FF: renamed from: b (double, double) double
    private static double method_3906(double var0, double var2) {
        return (360.0D + (var0 - var2)) % 360.0D;
    }

    public static LatLngBounds.Builder builder() {
        return new LatLngBounds.Builder();
    }

    // $FF: renamed from: c (double, double) double
    private static double method_3907(double var0, double var2) {
        return (360.0D + (var2 - var0)) % 360.0D;
    }

    // $FF: renamed from: c (double) boolean
    private boolean method_3908(double var1) {
        return this.southwest.latitude <= var1 && var1 <= this.northeast.latitude;
    }

    // $FF: renamed from: d (double, double) double
    // $FF: synthetic method
    static double method_3909(double var0, double var2) {
        return method_3906(var0, var2);
    }

    // $FF: renamed from: d (double) boolean
    private boolean method_3910(double var1) {
        if(this.southwest.longitude <= this.northeast.longitude) {
            return this.southwest.longitude <= var1 && var1 <= this.northeast.longitude;
        } else {
            boolean var3;
            if(this.southwest.longitude > var1) {
                double var5;
                int var4 = (var5 = var1 - this.northeast.longitude) == 0.0D?0:(var5 < 0.0D?-1:1);
                var3 = false;
                if(var4 > 0) {
                    return var3;
                }
            }

            var3 = true;
            return var3;
        }
    }

    // $FF: renamed from: e (double, double) double
    // $FF: synthetic method
    static double method_3911(double var0, double var2) {
        return method_3907(var0, var2);
    }

    public boolean contains(LatLng var1) {
        return this.method_3908(var1.latitude) && this.method_3910(var1.longitude);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        if(this != var1) {
            if(!(var1 instanceof LatLngBounds)) {
                return false;
            }

            LatLngBounds var2 = (LatLngBounds)var1;
            if(!this.southwest.equals(var2.southwest) || !this.northeast.equals(var2.northeast)) {
                return false;
            }
        }

        return true;
    }

    public LatLng getCenter() {
        double var1 = (this.southwest.latitude + this.northeast.latitude) / 2.0D;
        double var3 = this.northeast.longitude;
        double var5 = this.southwest.longitude;
        double var7;
        if(var5 <= var3) {
            var7 = (var3 + var5) / 2.0D;
        } else {
            var7 = (var5 + var3 + 360.0D) / 2.0D;
        }

        return new LatLng(var1, var7);
    }

    int getVersionCode() {
        return this.field_3457;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.southwest, this.northeast};
        return class_1089.hashCode(var1);
    }

    public LatLngBounds including(LatLng var1) {
        double var2 = Math.min(this.southwest.latitude, var1.latitude);
        double var4 = Math.max(this.northeast.latitude, var1.latitude);
        double var6 = this.northeast.longitude;
        double var8 = this.southwest.longitude;
        double var10 = var1.longitude;
        double var12;
        if(!this.method_3910(var10)) {
            if(method_3906(var8, var10) < method_3907(var6, var10)) {
                var12 = var6;
            } else {
                var12 = var10;
                var10 = var8;
            }
        } else {
            var10 = var8;
            var12 = var6;
        }

        return new LatLngBounds(new LatLng(var2, var10), new LatLng(var4, var12));
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("southwest", this.southwest).method_5425("northeast", this.northeast).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        if(class_816.method_4241()) {
            class_977.method_5159(this, var1, var2);
        } else {
            class_972.method_5148(this, var1, var2);
        }
    }

    public static final class Builder {
        private double ajY = Double.POSITIVE_INFINITY;
        private double ajZ = Double.NEGATIVE_INFINITY;
        private double aka = Double.NaN;
        private double akb = Double.NaN;

        // $FF: renamed from: d (double) boolean
        private boolean method_3526(double var1) {
            if(this.aka <= this.akb) {
                return this.aka <= var1 && var1 <= this.akb;
            } else {
                boolean var3;
                if(this.aka > var1) {
                    double var5;
                    int var4 = (var5 = var1 - this.akb) == 0.0D?0:(var5 < 0.0D?-1:1);
                    var3 = false;
                    if(var4 > 0) {
                        return var3;
                    }
                }

                var3 = true;
                return var3;
            }
        }

        public LatLngBounds build() {
            boolean var1;
            if(!Double.isNaN(this.aka)) {
                var1 = true;
            } else {
                var1 = false;
            }

            class_1090.method_5676(var1, "no included points");
            return new LatLngBounds(new LatLng(this.ajY, this.aka), new LatLng(this.ajZ, this.akb));
        }

        public LatLngBounds.Builder include(LatLng var1) {
            this.ajY = Math.min(this.ajY, var1.latitude);
            this.ajZ = Math.max(this.ajZ, var1.latitude);
            double var2 = var1.longitude;
            if(Double.isNaN(this.aka)) {
                this.aka = var2;
                this.akb = var2;
            } else if(!this.method_3526(var2)) {
                if(LatLngBounds.method_3909(this.aka, var2) < LatLngBounds.method_3911(this.akb, var2)) {
                    this.aka = var2;
                    return this;
                }

                this.akb = var2;
                return this;
            }

            return this;
        }
    }
}

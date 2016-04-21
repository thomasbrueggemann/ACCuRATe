package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.VisibleRegion;

// $FF: renamed from: com.google.android.gms.maps.model.y
public class class_964 implements Creator<VisibleRegion> {
    // $FF: renamed from: a (com.google.android.gms.maps.model.VisibleRegion, android.os.Parcel, int) void
    static void method_5114(VisibleRegion var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4309(var1, 2, var0.nearLeft, var2, false);
        class_823.method_4309(var1, 3, var0.nearRight, var2, false);
        class_823.method_4309(var1, 4, var0.farLeft, var2, false);
        class_823.method_4309(var1, 5, var0.farRight, var2, false);
        class_823.method_4309(var1, 6, var0.latLngBounds, var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: cW (android.os.Parcel) com.google.android.gms.maps.model.VisibleRegion
    public VisibleRegion method_5115(Parcel var1) {
        LatLngBounds var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        LatLng var5 = null;
        LatLng var6 = null;
        LatLng var7 = null;
        LatLng var8 = null;

        while(var1.dataPosition() < var3) {
            int var9 = class_824.method_4329(var1);
            switch(class_824.method_4340(var9)) {
                case 1:
                    var4 = class_824.method_4348(var1, var9);
                    break;
                case 2:
                    var8 = (LatLng)class_824.method_4336(var1, var9, LatLng.CREATOR);
                    break;
                case 3:
                    var7 = (LatLng)class_824.method_4336(var1, var9, LatLng.CREATOR);
                    break;
                case 4:
                    var6 = (LatLng)class_824.method_4336(var1, var9, LatLng.CREATOR);
                    break;
                case 5:
                    var5 = (LatLng)class_824.method_4336(var1, var9, LatLng.CREATOR);
                    break;
                case 6:
                    var2 = (LatLngBounds)class_824.method_4336(var1, var9, LatLngBounds.CREATOR);
                    break;
                default:
                    class_824.method_4341(var1, var9);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new VisibleRegion(var4, var8, var7, var6, var5, var2);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5115(var1);
    }

    // $FF: renamed from: eM (int) com.google.android.gms.maps.model.VisibleRegion[]
    public VisibleRegion[] method_5116(int var1) {
        return new VisibleRegion[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5116(var1);
    }
}

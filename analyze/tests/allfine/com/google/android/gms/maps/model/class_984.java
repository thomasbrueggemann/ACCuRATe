package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaLink;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

// $FF: renamed from: com.google.android.gms.maps.model.s
public class class_984 implements Creator<StreetViewPanoramaLocation> {
    // $FF: renamed from: a (com.google.android.gms.maps.model.StreetViewPanoramaLocation, android.os.Parcel, int) void
    static void method_5174(StreetViewPanoramaLocation var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4319(var1, 2, var0.links, var2, false);
        class_823.method_4309(var1, 3, var0.position, var2, false);
        class_823.method_4313(var1, 4, var0.panoId, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: cS (android.os.Parcel) com.google.android.gms.maps.model.StreetViewPanoramaLocation
    public StreetViewPanoramaLocation method_5175(Parcel var1) {
        String var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        LatLng var5 = null;

        StreetViewPanoramaLink[] var6;
        String var8;
        for(var6 = null; var1.dataPosition() < var3; var2 = var8) {
            int var7 = class_824.method_4329(var1);
            LatLng var9;
            StreetViewPanoramaLink[] var10;
            int var11;
            switch(class_824.method_4340(var7)) {
                case 1:
                    int var16 = class_824.method_4348(var1, var7);
                    var9 = var5;
                    var10 = var6;
                    var11 = var16;
                    var8 = var2;
                    break;
                case 2:
                    StreetViewPanoramaLink[] var14 = (StreetViewPanoramaLink[])class_824.method_4342(var1, var7, StreetViewPanoramaLink.CREATOR);
                    var11 = var4;
                    var10 = var14;
                    var8 = var2;
                    var9 = var5;
                    break;
                case 3:
                    LatLng var12 = (LatLng)class_824.method_4336(var1, var7, LatLng.CREATOR);
                    var10 = var6;
                    var11 = var4;
                    var9 = var12;
                    var8 = var2;
                    break;
                case 4:
                    var8 = class_824.method_4356(var1, var7);
                    var9 = var5;
                    var10 = var6;
                    var11 = var4;
                    break;
                default:
                    class_824.method_4341(var1, var7);
                    var8 = var2;
                    var9 = var5;
                    var10 = var6;
                    var11 = var4;
            }

            var4 = var11;
            var6 = var10;
            var5 = var9;
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new StreetViewPanoramaLocation(var4, var6, var5, var2);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5175(var1);
    }

    // $FF: renamed from: eI (int) com.google.android.gms.maps.model.StreetViewPanoramaLocation[]
    public StreetViewPanoramaLocation[] method_5176(int var1) {
        return new StreetViewPanoramaLocation[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5176(var1);
    }
}

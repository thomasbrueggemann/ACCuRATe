package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

// $FF: renamed from: com.google.android.gms.maps.c
public class class_1059 implements Creator<StreetViewPanoramaOptions> {
    // $FF: renamed from: a (com.google.android.gms.maps.StreetViewPanoramaOptions, android.os.Parcel, int) void
    static void method_5539(StreetViewPanoramaOptions var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4309(var1, 2, var0.getStreetViewPanoramaCamera(), var2, false);
        class_823.method_4313(var1, 3, var0.getPanoramaId(), false);
        class_823.method_4309(var1, 4, var0.getPosition(), var2, false);
        class_823.method_4311(var1, 5, var0.getRadius(), false);
        class_823.method_4302(var1, 6, var0.method_5496());
        class_823.method_4302(var1, 7, var0.method_5500());
        class_823.method_4302(var1, 8, var0.method_5497());
        class_823.method_4302(var1, 9, var0.method_5498());
        class_823.method_4302(var1, 10, var0.method_5499());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: cH (android.os.Parcel) com.google.android.gms.maps.StreetViewPanoramaOptions
    public StreetViewPanoramaOptions method_5540(Parcel var1) {
        Integer var2 = null;
        byte var3 = 0;
        int var4 = class_824.method_4331(var1);
        byte var5 = 0;
        byte var6 = 0;
        byte var7 = 0;
        byte var8 = 0;
        LatLng var9 = null;
        String var10 = null;
        StreetViewPanoramaCamera var11 = null;
        int var12 = 0;

        while(var1.dataPosition() < var4) {
            int var13 = class_824.method_4329(var1);
            switch(class_824.method_4340(var13)) {
                case 1:
                    var12 = class_824.method_4348(var1, var13);
                    break;
                case 2:
                    var11 = (StreetViewPanoramaCamera)class_824.method_4336(var1, var13, StreetViewPanoramaCamera.CREATOR);
                    break;
                case 3:
                    var10 = class_824.method_4356(var1, var13);
                    break;
                case 4:
                    var9 = (LatLng)class_824.method_4336(var1, var13, LatLng.CREATOR);
                    break;
                case 5:
                    var2 = class_824.method_4349(var1, var13);
                    break;
                case 6:
                    var8 = class_824.method_4346(var1, var13);
                    break;
                case 7:
                    var7 = class_824.method_4346(var1, var13);
                    break;
                case 8:
                    var6 = class_824.method_4346(var1, var13);
                    break;
                case 9:
                    var5 = class_824.method_4346(var1, var13);
                    break;
                case 10:
                    var3 = class_824.method_4346(var1, var13);
                    break;
                default:
                    class_824.method_4341(var1, var13);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new StreetViewPanoramaOptions(var12, var11, var10, var9, var2, var8, var7, var6, var5, var3);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5540(var1);
    }

    // $FF: renamed from: ex (int) com.google.android.gms.maps.StreetViewPanoramaOptions[]
    public StreetViewPanoramaOptions[] method_5541(int var1) {
        return new StreetViewPanoramaOptions[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5541(var1);
    }
}

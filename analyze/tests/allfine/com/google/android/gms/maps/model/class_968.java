package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

// $FF: renamed from: com.google.android.gms.maps.model.t
public class class_968 implements Creator<StreetViewPanoramaOrientation> {
    // $FF: renamed from: a (com.google.android.gms.maps.model.StreetViewPanoramaOrientation, android.os.Parcel, int) void
    static void method_5122(StreetViewPanoramaOrientation var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4304(var1, 2, var0.tilt);
        class_823.method_4304(var1, 3, var0.bearing);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: cT (android.os.Parcel) com.google.android.gms.maps.model.StreetViewPanoramaOrientation
    public StreetViewPanoramaOrientation method_5123(Parcel var1) {
        float var2 = 0.0F;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        float var5 = 0.0F;

        while(var1.dataPosition() < var3) {
            int var6 = class_824.method_4329(var1);
            switch(class_824.method_4340(var6)) {
                case 1:
                    var4 = class_824.method_4348(var1, var6);
                    break;
                case 2:
                    var5 = class_824.method_4353(var1, var6);
                    break;
                case 3:
                    var2 = class_824.method_4353(var1, var6);
                    break;
                default:
                    class_824.method_4341(var1, var6);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new StreetViewPanoramaOrientation(var4, var5, var2);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5123(var1);
    }

    // $FF: renamed from: eJ (int) com.google.android.gms.maps.model.StreetViewPanoramaOrientation[]
    public StreetViewPanoramaOrientation[] method_5124(int var1) {
        return new StreetViewPanoramaOrientation[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5124(var1);
    }
}

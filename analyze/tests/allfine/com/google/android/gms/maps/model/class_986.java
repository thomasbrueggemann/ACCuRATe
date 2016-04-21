package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

// $FF: renamed from: com.google.android.gms.maps.model.q
public class class_986 implements Creator<StreetViewPanoramaCamera> {
    // $FF: renamed from: a (com.google.android.gms.maps.model.StreetViewPanoramaCamera, android.os.Parcel, int) void
    static void method_5178(StreetViewPanoramaCamera var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4304(var1, 2, var0.zoom);
        class_823.method_4304(var1, 3, var0.tilt);
        class_823.method_4304(var1, 4, var0.bearing);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: cQ (android.os.Parcel) com.google.android.gms.maps.model.StreetViewPanoramaCamera
    public StreetViewPanoramaCamera method_5179(Parcel var1) {
        float var2 = 0.0F;
        int var3 = class_824.method_4331(var1);
        float var4 = 0.0F;
        int var5 = 0;
        float var6 = 0.0F;

        while(var1.dataPosition() < var3) {
            int var7 = class_824.method_4329(var1);
            switch(class_824.method_4340(var7)) {
                case 1:
                    var5 = class_824.method_4348(var1, var7);
                    break;
                case 2:
                    var4 = class_824.method_4353(var1, var7);
                    break;
                case 3:
                    var6 = class_824.method_4353(var1, var7);
                    break;
                case 4:
                    var2 = class_824.method_4353(var1, var7);
                    break;
                default:
                    class_824.method_4341(var1, var7);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new StreetViewPanoramaCamera(var5, var4, var6, var2);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5179(var1);
    }

    // $FF: renamed from: eG (int) com.google.android.gms.maps.model.StreetViewPanoramaCamera[]
    public StreetViewPanoramaCamera[] method_5180(int var1) {
        return new StreetViewPanoramaCamera[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5180(var1);
    }
}

package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.maps.model.StreetViewPanoramaLink;

// $FF: renamed from: com.google.android.gms.maps.model.r
public class class_983 implements Creator<StreetViewPanoramaLink> {
    // $FF: renamed from: a (com.google.android.gms.maps.model.StreetViewPanoramaLink, android.os.Parcel, int) void
    static void method_5171(StreetViewPanoramaLink var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4313(var1, 2, var0.panoId, false);
        class_823.method_4304(var1, 3, var0.bearing);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: cR (android.os.Parcel) com.google.android.gms.maps.model.StreetViewPanoramaLink
    public StreetViewPanoramaLink method_5172(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        String var4 = null;
        float var5 = 0.0F;

        while(var1.dataPosition() < var2) {
            int var6 = class_824.method_4329(var1);
            switch(class_824.method_4340(var6)) {
                case 1:
                    var3 = class_824.method_4348(var1, var6);
                    break;
                case 2:
                    var4 = class_824.method_4356(var1, var6);
                    break;
                case 3:
                    var5 = class_824.method_4353(var1, var6);
                    break;
                default:
                    class_824.method_4341(var1, var6);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new StreetViewPanoramaLink(var3, var4, var5);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5172(var1);
    }

    // $FF: renamed from: eH (int) com.google.android.gms.maps.model.StreetViewPanoramaLink[]
    public StreetViewPanoramaLink[] method_5173(int var1) {
        return new StreetViewPanoramaLink[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5173(var1);
    }
}

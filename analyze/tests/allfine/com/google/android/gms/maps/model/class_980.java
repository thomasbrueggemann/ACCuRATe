package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.maps.model.o
public class class_980 implements Creator<PolylineOptions> {
    // $FF: renamed from: a (com.google.android.gms.maps.model.PolylineOptions, android.os.Parcel, int) void
    static void method_5164(PolylineOptions var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4326(var1, 2, var0.getPoints(), false);
        class_823.method_4304(var1, 3, var0.getWidth());
        class_823.method_4325(var1, 4, var0.getColor());
        class_823.method_4304(var1, 5, var0.getZIndex());
        class_823.method_4316(var1, 6, var0.isVisible());
        class_823.method_4316(var1, 7, var0.isGeodesic());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: cP (android.os.Parcel) com.google.android.gms.maps.model.PolylineOptions
    public PolylineOptions method_5165(Parcel var1) {
        float var2 = 0.0F;
        boolean var3 = false;
        int var4 = class_824.method_4331(var1);
        ArrayList var5 = null;
        boolean var6 = false;
        int var7 = 0;
        float var8 = 0.0F;
        int var9 = 0;

        while(var1.dataPosition() < var4) {
            int var10 = class_824.method_4329(var1);
            switch(class_824.method_4340(var10)) {
                case 1:
                    var9 = class_824.method_4348(var1, var10);
                    break;
                case 2:
                    var5 = class_824.method_4343(var1, var10, LatLng.CREATOR);
                    break;
                case 3:
                    var8 = class_824.method_4353(var1, var10);
                    break;
                case 4:
                    var7 = class_824.method_4348(var1, var10);
                    break;
                case 5:
                    var2 = class_824.method_4353(var1, var10);
                    break;
                case 6:
                    var6 = class_824.method_4344(var1, var10);
                    break;
                case 7:
                    var3 = class_824.method_4344(var1, var10);
                    break;
                default:
                    class_824.method_4341(var1, var10);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new PolylineOptions(var9, var5, var8, var7, var2, var6, var3);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5165(var1);
    }

    // $FF: renamed from: eF (int) com.google.android.gms.maps.model.PolylineOptions[]
    public PolylineOptions[] method_5166(int var1) {
        return new PolylineOptions[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5166(var1);
    }
}

package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.maps.model.m
public class class_982 implements Creator<PolygonOptions> {
    // $FF: renamed from: a (com.google.android.gms.maps.model.PolygonOptions, android.os.Parcel, int) void
    static void method_5168(PolygonOptions var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4326(var1, 2, var0.getPoints(), false);
        class_823.method_4327(var1, 3, var0.method_4976(), false);
        class_823.method_4304(var1, 4, var0.getStrokeWidth());
        class_823.method_4325(var1, 5, var0.getStrokeColor());
        class_823.method_4325(var1, 6, var0.getFillColor());
        class_823.method_4304(var1, 7, var0.getZIndex());
        class_823.method_4316(var1, 8, var0.isVisible());
        class_823.method_4316(var1, 9, var0.isGeodesic());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: cO (android.os.Parcel) com.google.android.gms.maps.model.PolygonOptions
    public PolygonOptions method_5169(Parcel var1) {
        float var2 = 0.0F;
        boolean var3 = false;
        int var4 = class_824.method_4331(var1);
        ArrayList var5 = null;
        ArrayList var6 = new ArrayList();
        boolean var7 = false;
        int var8 = 0;
        int var9 = 0;
        float var10 = 0.0F;
        int var11 = 0;

        while(var1.dataPosition() < var4) {
            int var12 = class_824.method_4329(var1);
            switch(class_824.method_4340(var12)) {
                case 1:
                    var11 = class_824.method_4348(var1, var12);
                    break;
                case 2:
                    var5 = class_824.method_4343(var1, var12, LatLng.CREATOR);
                    break;
                case 3:
                    class_824.method_4339(var1, var12, var6, this.getClass().getClassLoader());
                    break;
                case 4:
                    var10 = class_824.method_4353(var1, var12);
                    break;
                case 5:
                    var9 = class_824.method_4348(var1, var12);
                    break;
                case 6:
                    var8 = class_824.method_4348(var1, var12);
                    break;
                case 7:
                    var2 = class_824.method_4353(var1, var12);
                    break;
                case 8:
                    var7 = class_824.method_4344(var1, var12);
                    break;
                case 9:
                    var3 = class_824.method_4344(var1, var12);
                    break;
                default:
                    class_824.method_4341(var1, var12);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new PolygonOptions(var11, var5, var6, var10, var9, var8, var2, var7, var3);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5169(var1);
    }

    // $FF: renamed from: eE (int) com.google.android.gms.maps.model.PolygonOptions[]
    public PolygonOptions[] method_5170(int var1) {
        return new PolygonOptions[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5170(var1);
    }
}

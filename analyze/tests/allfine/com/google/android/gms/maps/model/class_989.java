package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

// $FF: renamed from: com.google.android.gms.maps.model.a
public class class_989 implements Creator<CameraPosition> {
    // $FF: renamed from: a (com.google.android.gms.maps.model.CameraPosition, android.os.Parcel, int) void
    static void method_5185(CameraPosition var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4309(var1, 2, var0.target, var2, false);
        class_823.method_4304(var1, 3, var0.zoom);
        class_823.method_4304(var1, 4, var0.tilt);
        class_823.method_4304(var1, 5, var0.bearing);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: cI (android.os.Parcel) com.google.android.gms.maps.model.CameraPosition
    public CameraPosition method_5186(Parcel var1) {
        float var2 = 0.0F;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        LatLng var5 = null;
        float var6 = 0.0F;
        float var7 = 0.0F;

        while(var1.dataPosition() < var3) {
            int var8 = class_824.method_4329(var1);
            switch(class_824.method_4340(var8)) {
                case 1:
                    var4 = class_824.method_4348(var1, var8);
                    break;
                case 2:
                    var5 = (LatLng)class_824.method_4336(var1, var8, LatLng.CREATOR);
                    break;
                case 3:
                    var7 = class_824.method_4353(var1, var8);
                    break;
                case 4:
                    var6 = class_824.method_4353(var1, var8);
                    break;
                case 5:
                    var2 = class_824.method_4353(var1, var8);
                    break;
                default:
                    class_824.method_4341(var1, var8);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new CameraPosition(var4, var5, var7, var6, var2);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5186(var1);
    }

    // $FF: renamed from: ey (int) com.google.android.gms.maps.model.CameraPosition[]
    public CameraPosition[] method_5187(int var1) {
        return new CameraPosition[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5187(var1);
    }
}

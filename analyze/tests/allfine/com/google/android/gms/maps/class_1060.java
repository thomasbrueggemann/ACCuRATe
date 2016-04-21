package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.model.CameraPosition;

// $FF: renamed from: com.google.android.gms.maps.a
public class class_1060 implements Creator<GoogleMapOptions> {
    // $FF: renamed from: a (com.google.android.gms.maps.GoogleMapOptions, android.os.Parcel, int) void
    static void method_5542(GoogleMapOptions var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4302(var1, 2, var0.method_1794());
        class_823.method_4302(var1, 3, var0.method_1795());
        class_823.method_4325(var1, 4, var0.getMapType());
        class_823.method_4309(var1, 5, var0.getCamera(), var2, false);
        class_823.method_4302(var1, 6, var0.method_1796());
        class_823.method_4302(var1, 7, var0.method_1797());
        class_823.method_4302(var1, 8, var0.method_1798());
        class_823.method_4302(var1, 9, var0.method_1799());
        class_823.method_4302(var1, 10, var0.method_1800());
        class_823.method_4302(var1, 11, var0.method_1801());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: cG (android.os.Parcel) com.google.android.gms.maps.GoogleMapOptions
    public GoogleMapOptions method_5543(Parcel var1) {
        byte var2 = 0;
        int var3 = class_824.method_4331(var1);
        CameraPosition var4 = null;
        byte var5 = 0;
        byte var6 = 0;
        byte var7 = 0;
        byte var8 = 0;
        byte var9 = 0;
        int var10 = 0;
        byte var11 = 0;
        byte var12 = 0;
        int var13 = 0;

        while(var1.dataPosition() < var3) {
            int var14 = class_824.method_4329(var1);
            switch(class_824.method_4340(var14)) {
                case 1:
                    var13 = class_824.method_4348(var1, var14);
                    break;
                case 2:
                    var12 = class_824.method_4346(var1, var14);
                    break;
                case 3:
                    var11 = class_824.method_4346(var1, var14);
                    break;
                case 4:
                    var10 = class_824.method_4348(var1, var14);
                    break;
                case 5:
                    var4 = (CameraPosition)class_824.method_4336(var1, var14, CameraPosition.CREATOR);
                    break;
                case 6:
                    var9 = class_824.method_4346(var1, var14);
                    break;
                case 7:
                    var8 = class_824.method_4346(var1, var14);
                    break;
                case 8:
                    var7 = class_824.method_4346(var1, var14);
                    break;
                case 9:
                    var6 = class_824.method_4346(var1, var14);
                    break;
                case 10:
                    var5 = class_824.method_4346(var1, var14);
                    break;
                case 11:
                    var2 = class_824.method_4346(var1, var14);
                    break;
                default:
                    class_824.method_4341(var1, var14);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new GoogleMapOptions(var13, var12, var11, var10, var4, var9, var8, var7, var6, var5, var2);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5543(var1);
    }

    // $FF: renamed from: ew (int) com.google.android.gms.maps.GoogleMapOptions[]
    public GoogleMapOptions[] method_5544(int var1) {
        return new GoogleMapOptions[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5544(var1);
    }
}

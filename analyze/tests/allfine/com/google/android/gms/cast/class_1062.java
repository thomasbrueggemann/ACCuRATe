package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.cast.b
public class class_1062 implements Creator<CastDevice> {
    // $FF: renamed from: a (com.google.android.gms.cast.CastDevice, android.os.Parcel, int) void
    static void method_5556(CastDevice var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4313(var1, 2, var0.getDeviceId(), false);
        class_823.method_4313(var1, 3, var0.field_1947, false);
        class_823.method_4313(var1, 4, var0.getFriendlyName(), false);
        class_823.method_4313(var1, 5, var0.getModelName(), false);
        class_823.method_4313(var1, 6, var0.getDeviceVersion(), false);
        class_823.method_4325(var1, 7, var0.getServicePort());
        class_823.method_4326(var1, 8, var0.getIcons(), false);
        class_823.method_4325(var1, 9, var0.getCapabilities());
        class_823.method_4325(var1, 10, var0.getStatus());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: Y (int) com.google.android.gms.cast.CastDevice[]
    public CastDevice[] method_5557(int var1) {
        return new CastDevice[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5558(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5557(var1);
    }

    // $FF: renamed from: u (android.os.Parcel) com.google.android.gms.cast.CastDevice
    public CastDevice method_5558(Parcel var1) {
        int var2 = 0;
        ArrayList var3 = null;
        int var4 = class_824.method_4331(var1);
        int var5 = 0;
        int var6 = 0;
        String var7 = null;
        String var8 = null;
        String var9 = null;
        String var10 = null;
        String var11 = null;
        int var12 = 0;

        while(var1.dataPosition() < var4) {
            int var13 = class_824.method_4329(var1);
            switch(class_824.method_4340(var13)) {
                case 1:
                    var12 = class_824.method_4348(var1, var13);
                    break;
                case 2:
                    var11 = class_824.method_4356(var1, var13);
                    break;
                case 3:
                    var10 = class_824.method_4356(var1, var13);
                    break;
                case 4:
                    var9 = class_824.method_4356(var1, var13);
                    break;
                case 5:
                    var8 = class_824.method_4356(var1, var13);
                    break;
                case 6:
                    var7 = class_824.method_4356(var1, var13);
                    break;
                case 7:
                    var6 = class_824.method_4348(var1, var13);
                    break;
                case 8:
                    var3 = class_824.method_4343(var1, var13, WebImage.CREATOR);
                    break;
                case 9:
                    var5 = class_824.method_4348(var1, var13);
                    break;
                case 10:
                    var2 = class_824.method_4348(var1, var13);
                    break;
                default:
                    class_824.method_4341(var1, var13);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new CastDevice(var12, var11, var10, var9, var8, var7, var6, var3, var5, var2);
        }
    }
}

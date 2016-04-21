package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.fitness.data.c
public class class_1140 implements Creator<BleDevice> {
    // $FF: renamed from: a (com.google.android.gms.fitness.data.BleDevice, android.os.Parcel, int) void
    static void method_5909(BleDevice var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4313(var1, 1, var0.getAddress(), false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4313(var1, 2, var0.getName(), false);
        class_823.method_4324(var1, 3, var0.getSupportedProfiles(), false);
        class_823.method_4326(var1, 4, var0.getDataTypes(), false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bj (android.os.Parcel) com.google.android.gms.fitness.data.BleDevice
    public BleDevice method_5910(Parcel var1) {
        ArrayList var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        ArrayList var5 = null;
        String var6 = null;
        String var7 = null;

        while(var1.dataPosition() < var3) {
            int var8 = class_824.method_4329(var1);
            switch(class_824.method_4340(var8)) {
                case 1:
                    var7 = class_824.method_4356(var1, var8);
                    break;
                case 2:
                    var6 = class_824.method_4356(var1, var8);
                    break;
                case 3:
                    var5 = class_824.method_4332(var1, var8);
                    break;
                case 4:
                    var2 = class_824.method_4343(var1, var8, DataType.CREATOR);
                    break;
                case 1000:
                    var4 = class_824.method_4348(var1, var8);
                    break;
                default:
                    class_824.method_4341(var1, var8);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new BleDevice(var4, var7, var6, var5, var2);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5910(var1);
    }

    // $FF: renamed from: cx (int) com.google.android.gms.fitness.data.BleDevice[]
    public BleDevice[] method_5911(int var1) {
        return new BleDevice[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5911(var1);
    }
}

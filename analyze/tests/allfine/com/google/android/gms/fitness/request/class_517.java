package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.b;
import com.google.android.gms.fitness.request.class_516;

// $FF: renamed from: com.google.android.gms.fitness.request.c
public class class_517 implements Creator<b> {
    // $FF: renamed from: a (com.google.android.gms.fitness.request.b, android.os.Parcel, int) void
    static void method_3138(class_516 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4313(var1, 1, var0.getDeviceAddress(), false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4309(var1, 2, var0.method_3137(), var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bA (android.os.Parcel) com.google.android.gms.fitness.request.b
    public class_516 method_3139(Parcel var1) {
        BleDevice var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        String var5 = null;

        while(var1.dataPosition() < var3) {
            int var6 = class_824.method_4329(var1);
            switch(class_824.method_4340(var6)) {
                case 1:
                    var5 = class_824.method_4356(var1, var6);
                    break;
                case 2:
                    var2 = (BleDevice)class_824.method_4336(var1, var6, BleDevice.CREATOR);
                    break;
                case 1000:
                    var4 = class_824.method_4348(var1, var6);
                    break;
                default:
                    class_824.method_4341(var1, var6);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_516(var4, var5, var2);
        }
    }

    // $FF: renamed from: cR (int) com.google.android.gms.fitness.request.b[]
    public class_516[] method_3140(int var1) {
        return new class_516[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3139(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3140(var1);
    }
}

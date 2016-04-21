package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.wearable.internal.class_1003;
import com.google.android.gms.wearable.internal.class_993;
import com.google.android.gms.wearable.internal.x;

// $FF: renamed from: com.google.android.gms.wearable.internal.y
public class class_1004 implements Creator<x> {
    // $FF: renamed from: a (com.google.android.gms.wearable.internal.x, android.os.Parcel, int) void
    static void method_5237(class_1003 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.versionCode);
        class_823.method_4325(var1, 2, var0.statusCode);
        class_823.method_4309(var1, 3, var0.avA, var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5238(var1);
    }

    // $FF: renamed from: dZ (android.os.Parcel) com.google.android.gms.wearable.internal.x
    public class_1003 method_5238(Parcel var1) {
        int var2 = 0;
        int var3 = class_824.method_4331(var1);
        class_993 var4 = null;
        int var5 = 0;

        while(var1.dataPosition() < var3) {
            int var6 = class_824.method_4329(var1);
            switch(class_824.method_4340(var6)) {
                case 1:
                    var5 = class_824.method_4348(var1, var6);
                    break;
                case 2:
                    var2 = class_824.method_4348(var1, var6);
                    break;
                case 3:
                    var4 = (class_993)class_824.method_4336(var1, var6, class_993.CREATOR);
                    break;
                default:
                    class_824.method_4341(var1, var6);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_1003(var5, var2, var4);
        }
    }

    // $FF: renamed from: gc (int) com.google.android.gms.wearable.internal.x[]
    public class_1003[] method_5239(int var1) {
        return new class_1003[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5239(var1);
    }
}

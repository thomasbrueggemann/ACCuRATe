package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_473;
import com.google.android.gms.internal.dv;

// $FF: renamed from: com.google.android.gms.internal.du
public class class_474 implements Creator<dv> {
    // $FF: renamed from: a (com.google.android.gms.internal.dv, android.os.Parcel, int) void
    static void method_2882(class_473 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.versionCode);
        class_823.method_4307(var1, 2, var0.method_2878(), false);
        class_823.method_4307(var1, 3, var0.method_2879(), false);
        class_823.method_4307(var1, 4, var0.method_2880(), false);
        class_823.method_4307(var1, 5, var0.method_2881(), false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_2883(var1);
    }

    // $FF: renamed from: g (android.os.Parcel) com.google.android.gms.internal.dv
    public class_473 method_2883(Parcel var1) {
        IBinder var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        IBinder var5 = null;
        IBinder var6 = null;
        IBinder var7 = null;

        while(var1.dataPosition() < var3) {
            int var8 = class_824.method_4329(var1);
            switch(class_824.method_4340(var8)) {
                case 1:
                    var4 = class_824.method_4348(var1, var8);
                    break;
                case 2:
                    var7 = class_824.method_4357(var1, var8);
                    break;
                case 3:
                    var6 = class_824.method_4357(var1, var8);
                    break;
                case 4:
                    var5 = class_824.method_4357(var1, var8);
                    break;
                case 5:
                    var2 = class_824.method_4357(var1, var8);
                    break;
                default:
                    class_824.method_4341(var1, var8);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_473(var4, var7, var6, var5, var2);
        }
    }

    // $FF: renamed from: n (int) com.google.android.gms.internal.dv[]
    public class_473[] method_2884(int var1) {
        return new class_473[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_2884(var1);
    }
}

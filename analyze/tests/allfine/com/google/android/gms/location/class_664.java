package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.location.c;
import com.google.android.gms.location.class_667;

// $FF: renamed from: com.google.android.gms.location.d
public class class_664 implements Creator<c> {
    // $FF: renamed from: a (com.google.android.gms.location.c, android.os.Parcel, int) void
    static void method_3722(class_667 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.aex);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4325(var1, 2, var0.aey);
        class_823.method_4305(var1, 3, var0.aez);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3723(var1);
    }

    // $FF: renamed from: ct (android.os.Parcel) com.google.android.gms.location.c
    public class_667 method_3723(Parcel var1) {
        int var2 = 1;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        long var5 = 0L;
        int var7 = var2;

        while(var1.dataPosition() < var3) {
            int var8 = class_824.method_4329(var1);
            switch(class_824.method_4340(var8)) {
                case 1:
                    var7 = class_824.method_4348(var1, var8);
                    break;
                case 2:
                    var2 = class_824.method_4348(var1, var8);
                    break;
                case 3:
                    var5 = class_824.method_4350(var1, var8);
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
            return new class_667(var4, var7, var2, var5);
        }
    }

    // $FF: renamed from: eh (int) com.google.android.gms.location.c[]
    public class_667[] method_3724(int var1) {
        return new class_667[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3724(var1);
    }
}

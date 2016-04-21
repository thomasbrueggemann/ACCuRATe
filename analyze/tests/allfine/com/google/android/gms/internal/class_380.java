package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_379;
import com.google.android.gms.internal.gt;

// $FF: renamed from: com.google.android.gms.internal.gu
public class class_380 implements Creator<gt> {
    // $FF: renamed from: a (com.google.android.gms.internal.gt, android.os.Parcel, int) void
    static void method_2467(class_379 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.versionCode);
        class_823.method_4313(var1, 2, var0.field_1387, false);
        class_823.method_4325(var1, 3, var0.field_1388);
        class_823.method_4325(var1, 4, var0.field_1389);
        class_823.method_4316(var1, 5, var0.field_1390);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_2468(var1);
    }

    // $FF: renamed from: j (android.os.Parcel) com.google.android.gms.internal.gt
    public class_379 method_2468(Parcel var1) {
        boolean var2 = false;
        int var3 = class_824.method_4331(var1);
        String var4 = null;
        int var5 = 0;
        int var6 = 0;
        int var7 = 0;

        while(var1.dataPosition() < var3) {
            int var8 = class_824.method_4329(var1);
            switch(class_824.method_4340(var8)) {
                case 1:
                    var7 = class_824.method_4348(var1, var8);
                    break;
                case 2:
                    var4 = class_824.method_4356(var1, var8);
                    break;
                case 3:
                    var6 = class_824.method_4348(var1, var8);
                    break;
                case 4:
                    var5 = class_824.method_4348(var1, var8);
                    break;
                case 5:
                    var2 = class_824.method_4344(var1, var8);
                    break;
                default:
                    class_824.method_4341(var1, var8);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_379(var7, var4, var6, var5, var2);
        }
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_2469(var1);
    }

    // $FF: renamed from: v (int) com.google.android.gms.internal.gt[]
    public class_379[] method_2469(int var1) {
        return new class_379[var1];
    }
}

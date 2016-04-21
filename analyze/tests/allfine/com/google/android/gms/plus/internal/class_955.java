package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.plus.internal.PlusCommonExtras;

// $FF: renamed from: com.google.android.gms.plus.internal.f
public class class_955 implements Creator<PlusCommonExtras> {
    // $FF: renamed from: a (com.google.android.gms.plus.internal.PlusCommonExtras, android.os.Parcel, int) void
    static void method_5040(PlusCommonExtras var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4313(var1, 1, var0.method_3002(), false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4313(var1, 2, var0.method_3003(), false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: cZ (android.os.Parcel) com.google.android.gms.plus.internal.PlusCommonExtras
    public PlusCommonExtras method_5041(Parcel var1) {
        String var2 = null;
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
                    var2 = class_824.method_4356(var1, var6);
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
            return new PlusCommonExtras(var4, var5, var2);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5041(var1);
    }

    // $FF: renamed from: eR (int) com.google.android.gms.plus.internal.PlusCommonExtras[]
    public PlusCommonExtras[] method_5042(int var1) {
        return new PlusCommonExtras[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5042(var1);
    }
}

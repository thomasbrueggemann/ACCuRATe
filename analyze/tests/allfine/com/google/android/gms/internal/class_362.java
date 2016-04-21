package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_363;
import com.google.android.gms.internal.jb;

// $FF: renamed from: com.google.android.gms.internal.jc
public class class_362 implements Creator<jb> {
    // $FF: renamed from: a (com.google.android.gms.internal.jb, android.os.Parcel, int) void
    static void method_2390(class_363 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_1325);
        class_823.method_4313(var1, 2, var0.field_1326, false);
        class_823.method_4325(var1, 3, var0.field_1327);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: E (android.os.Parcel) com.google.android.gms.internal.jb
    public class_363 method_2391(Parcel var1) {
        int var2 = 0;
        int var3 = class_824.method_4331(var1);
        String var4 = null;
        int var5 = 0;

        while(var1.dataPosition() < var3) {
            int var6 = class_824.method_4329(var1);
            switch(class_824.method_4340(var6)) {
                case 1:
                    var5 = class_824.method_4348(var1, var6);
                    break;
                case 2:
                    var4 = class_824.method_4356(var1, var6);
                    break;
                case 3:
                    var2 = class_824.method_4348(var1, var6);
                    break;
                default:
                    class_824.method_4341(var1, var6);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_363(var5, var4, var2);
        }
    }

    // $FF: renamed from: aE (int) com.google.android.gms.internal.jb[]
    public class_363[] method_2392(int var1) {
        return new class_363[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_2391(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_2392(var1);
    }
}

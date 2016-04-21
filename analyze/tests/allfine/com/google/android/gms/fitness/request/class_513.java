package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.request.class_512;
import com.google.android.gms.fitness.request.e;

// $FF: renamed from: com.google.android.gms.fitness.request.f
public class class_513 implements Creator<e> {
    // $FF: renamed from: a (com.google.android.gms.fitness.request.e, android.os.Parcel, int) void
    static void method_3128(class_512 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4309(var1, 1, var0.method_3127(), var2, false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bC (android.os.Parcel) com.google.android.gms.fitness.request.e
    public class_512 method_3129(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        DataSet var4 = null;

        while(var1.dataPosition() < var2) {
            int var5 = class_824.method_4329(var1);
            switch(class_824.method_4340(var5)) {
                case 1:
                    var4 = (DataSet)class_824.method_4336(var1, var5, DataSet.CREATOR);
                    break;
                case 1000:
                    var3 = class_824.method_4348(var1, var5);
                    break;
                default:
                    class_824.method_4341(var1, var5);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new class_512(var3, var4);
        }
    }

    // $FF: renamed from: cT (int) com.google.android.gms.fitness.request.e[]
    public class_512[] method_3130(int var1) {
        return new class_512[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3129(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3130(var1);
    }
}

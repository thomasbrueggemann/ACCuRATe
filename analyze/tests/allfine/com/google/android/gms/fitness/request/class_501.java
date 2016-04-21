package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.request.ad;
import com.google.android.gms.fitness.request.class_500;

// $FF: renamed from: com.google.android.gms.fitness.request.ae
public class class_501 implements Creator<ad> {
    // $FF: renamed from: a (com.google.android.gms.fitness.request.ad, android.os.Parcel, int) void
    static void method_3052(class_500 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4307(var1, 1, var0.method_3050(), false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bR (android.os.Parcel) com.google.android.gms.fitness.request.ad
    public class_500 method_3053(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        IBinder var4 = null;

        while(var1.dataPosition() < var2) {
            int var5 = class_824.method_4329(var1);
            switch(class_824.method_4340(var5)) {
                case 1:
                    var4 = class_824.method_4357(var1, var5);
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
            return new class_500(var3, var4);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3053(var1);
    }

    // $FF: renamed from: dj (int) com.google.android.gms.fitness.request.ad[]
    public class_500[] method_3054(int var1) {
        return new class_500[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3054(var1);
    }
}

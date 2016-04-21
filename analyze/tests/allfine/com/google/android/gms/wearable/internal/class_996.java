package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.wearable.internal.class_997;
import com.google.android.gms.wearable.internal.p;

// $FF: renamed from: com.google.android.gms.wearable.internal.q
public class class_996 implements Creator<p> {
    // $FF: renamed from: a (com.google.android.gms.wearable.internal.p, android.os.Parcel, int) void
    static void method_5225(class_997 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.versionCode);
        class_823.method_4325(var1, 2, var0.statusCode);
        class_823.method_4325(var1, 3, var0.avw);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5226(var1);
    }

    // $FF: renamed from: dV (android.os.Parcel) com.google.android.gms.wearable.internal.p
    public class_997 method_5226(Parcel var1) {
        int var2 = 0;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        int var5 = 0;

        while(var1.dataPosition() < var3) {
            int var6 = class_824.method_4329(var1);
            switch(class_824.method_4340(var6)) {
                case 1:
                    var5 = class_824.method_4348(var1, var6);
                    break;
                case 2:
                    var4 = class_824.method_4348(var1, var6);
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
            return new class_997(var5, var4, var2);
        }
    }

    // $FF: renamed from: fY (int) com.google.android.gms.wearable.internal.p[]
    public class_997[] method_5227(int var1) {
        return new class_997[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5227(var1);
    }
}

package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.wearable.internal.au;
import com.google.android.gms.wearable.internal.class_1074;
import com.google.android.gms.wearable.internal.class_1078;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.wearable.internal.av
public class class_1077 implements Creator<au> {
    // $FF: renamed from: a (com.google.android.gms.wearable.internal.au, android.os.Parcel, int) void
    static void method_5603(class_1078 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.versionCode);
        class_823.method_4325(var1, 2, var0.statusCode);
        class_823.method_4305(var1, 3, var0.avN);
        class_823.method_4326(var1, 4, var0.avP, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5604(var1);
    }

    // $FF: renamed from: ei (android.os.Parcel) com.google.android.gms.wearable.internal.au
    public class_1078 method_5604(Parcel var1) {
        int var2 = 0;
        int var3 = class_824.method_4331(var1);
        long var4 = 0L;
        ArrayList var6 = null;
        int var7 = 0;

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
                    var4 = class_824.method_4350(var1, var8);
                    break;
                case 4:
                    var6 = class_824.method_4343(var1, var8, class_1074.CREATOR);
                    break;
                default:
                    class_824.method_4341(var1, var8);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_1078(var7, var2, var4, var6);
        }
    }

    // $FF: renamed from: gl (int) com.google.android.gms.wearable.internal.au[]
    public class_1078[] method_5605(int var1) {
        return new class_1078[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5605(var1);
    }
}

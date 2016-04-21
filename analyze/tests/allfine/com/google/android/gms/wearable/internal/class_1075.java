package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.wearable.internal.as;
import com.google.android.gms.wearable.internal.class_1076;

// $FF: renamed from: com.google.android.gms.wearable.internal.at
public class class_1075 implements Creator<as> {
    // $FF: renamed from: a (com.google.android.gms.wearable.internal.as, android.os.Parcel, int) void
    static void method_5600(class_1076 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.versionCode);
        class_823.method_4325(var1, 2, var0.statusCode);
        class_823.method_4325(var1, 3, var0.avO);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5601(var1);
    }

    // $FF: renamed from: eh (android.os.Parcel) com.google.android.gms.wearable.internal.as
    public class_1076 method_5601(Parcel var1) {
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
            return new class_1076(var5, var4, var2);
        }
    }

    // $FF: renamed from: gk (int) com.google.android.gms.wearable.internal.as[]
    public class_1076[] method_5602(int var1) {
        return new class_1076[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5602(var1);
    }
}

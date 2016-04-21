package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.wearable.class_1048;
import com.google.android.gms.wearable.internal.class_1000;
import com.google.android.gms.wearable.internal.t;

// $FF: renamed from: com.google.android.gms.wearable.internal.u
public class class_999 implements Creator<t> {
    // $FF: renamed from: a (com.google.android.gms.wearable.internal.t, android.os.Parcel, int) void
    static void method_5231(class_1000 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.versionCode);
        class_823.method_4325(var1, 2, var0.statusCode);
        class_823.method_4319(var1, 3, var0.avy, var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5232(var1);
    }

    // $FF: renamed from: dX (android.os.Parcel) com.google.android.gms.wearable.internal.t
    public class_1000 method_5232(Parcel var1) {
        int var2 = 0;
        int var3 = class_824.method_4331(var1);
        class_1048[] var4 = null;
        int var5 = 0;

        while(var1.dataPosition() < var3) {
            int var6 = class_824.method_4329(var1);
            switch(class_824.method_4340(var6)) {
                case 1:
                    var5 = class_824.method_4348(var1, var6);
                    break;
                case 2:
                    var2 = class_824.method_4348(var1, var6);
                    break;
                case 3:
                    var4 = (class_1048[])class_824.method_4342(var1, var6, class_1048.CREATOR);
                    break;
                default:
                    class_824.method_4341(var1, var6);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_1000(var5, var2, var4);
        }
    }

    // $FF: renamed from: ga (int) com.google.android.gms.wearable.internal.t[]
    public class_1000[] method_5233(int var1) {
        return new class_1000[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5233(var1);
    }
}

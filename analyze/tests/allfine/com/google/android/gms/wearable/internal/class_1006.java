package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.wearable.internal.class_1005;
import com.google.android.gms.wearable.internal.class_1072;
import com.google.android.gms.wearable.internal.v;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.wearable.internal.w
public class class_1006 implements Creator<v> {
    // $FF: renamed from: a (com.google.android.gms.wearable.internal.v, android.os.Parcel, int) void
    static void method_5240(class_1005 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.versionCode);
        class_823.method_4325(var1, 2, var0.statusCode);
        class_823.method_4326(var1, 3, var0.avz, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5241(var1);
    }

    // $FF: renamed from: dY (android.os.Parcel) com.google.android.gms.wearable.internal.v
    public class_1005 method_5241(Parcel var1) {
        int var2 = 0;
        int var3 = class_824.method_4331(var1);
        ArrayList var4 = null;
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
                    var4 = class_824.method_4343(var1, var6, class_1072.CREATOR);
                    break;
                default:
                    class_824.method_4341(var1, var6);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_1005(var5, var2, var4);
        }
    }

    // $FF: renamed from: gb (int) com.google.android.gms.wearable.internal.v[]
    public class_1005[] method_5242(int var1) {
        return new class_1005[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5242(var1);
    }
}

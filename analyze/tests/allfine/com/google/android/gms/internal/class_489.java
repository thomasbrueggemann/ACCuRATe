package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_486;
import com.google.android.gms.internal.dj;

// $FF: renamed from: com.google.android.gms.internal.di
public class class_489 implements Creator<dj> {
    // $FF: renamed from: a (com.google.android.gms.internal.dj, android.os.Parcel, int) void
    static void method_2993(class_486 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.versionCode);
        class_823.method_4313(var1, 2, var0.field_1956, false);
        class_823.method_4313(var1, 3, var0.field_1957, false);
        class_823.method_4313(var1, 4, var0.mimeType, false);
        class_823.method_4313(var1, 5, var0.packageName, false);
        class_823.method_4313(var1, 6, var0.field_1958, false);
        class_823.method_4313(var1, 7, var0.field_1959, false);
        class_823.method_4313(var1, 8, var0.field_1960, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_2994(var1);
    }

    // $FF: renamed from: e (android.os.Parcel) com.google.android.gms.internal.dj
    public class_486 method_2994(Parcel var1) {
        String var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        String var5 = null;
        String var6 = null;
        String var7 = null;
        String var8 = null;
        String var9 = null;
        String var10 = null;

        while(var1.dataPosition() < var3) {
            int var11 = class_824.method_4329(var1);
            switch(class_824.method_4340(var11)) {
                case 1:
                    var4 = class_824.method_4348(var1, var11);
                    break;
                case 2:
                    var10 = class_824.method_4356(var1, var11);
                    break;
                case 3:
                    var9 = class_824.method_4356(var1, var11);
                    break;
                case 4:
                    var8 = class_824.method_4356(var1, var11);
                    break;
                case 5:
                    var7 = class_824.method_4356(var1, var11);
                    break;
                case 6:
                    var6 = class_824.method_4356(var1, var11);
                    break;
                case 7:
                    var5 = class_824.method_4356(var1, var11);
                    break;
                case 8:
                    var2 = class_824.method_4356(var1, var11);
                    break;
                default:
                    class_824.method_4341(var1, var11);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_486(var4, var10, var9, var8, var7, var6, var5, var2);
        }
    }

    // $FF: renamed from: l (int) com.google.android.gms.internal.dj[]
    public class_486[] method_2995(int var1) {
        return new class_486[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_2995(var1);
    }
}

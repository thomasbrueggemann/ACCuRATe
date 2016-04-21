package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_872;
import com.google.android.gms.internal.ni;

// $FF: renamed from: com.google.android.gms.internal.nk
public class class_874 implements Creator<ni> {
    // $FF: renamed from: a (com.google.android.gms.internal.ni, android.os.Parcel, int) void
    static void method_4538(class_872 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.versionCode);
        class_823.method_4305(var1, 2, var0.akH);
        class_823.method_4313(var1, 3, var0.tag, false);
        class_823.method_4317(var1, 4, var0.akI, false);
        class_823.method_4306(var1, 5, var0.akJ, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: cX (android.os.Parcel) com.google.android.gms.internal.ni
    public class_872 method_4539(Parcel var1) {
        Bundle var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        long var5 = 0L;
        byte[] var7 = null;
        String var8 = null;

        while(var1.dataPosition() < var3) {
            int var9 = class_824.method_4329(var1);
            switch(class_824.method_4340(var9)) {
                case 1:
                    var4 = class_824.method_4348(var1, var9);
                    break;
                case 2:
                    var5 = class_824.method_4350(var1, var9);
                    break;
                case 3:
                    var8 = class_824.method_4356(var1, var9);
                    break;
                case 4:
                    var7 = class_824.method_4359(var1, var9);
                    break;
                case 5:
                    var2 = class_824.method_4358(var1, var9);
                    break;
                default:
                    class_824.method_4341(var1, var9);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_872(var4, var5, var8, var7, var2);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_4539(var1);
    }

    // $FF: renamed from: eO (int) com.google.android.gms.internal.ni[]
    public class_872[] method_4540(int var1) {
        return new class_872[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_4540(var1);
    }
}

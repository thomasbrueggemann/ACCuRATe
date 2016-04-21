package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.wallet.wobs.class_711;
import com.google.android.gms.wallet.wobs.l;

// $FF: renamed from: com.google.android.gms.wallet.wobs.m
public class class_712 implements Creator<l> {
    // $FF: renamed from: a (com.google.android.gms.wallet.wobs.l, android.os.Parcel, int) void
    static void method_3863(class_711 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4305(var1, 2, var0.auK);
        class_823.method_4305(var1, 3, var0.auL);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3864(var1);
    }

    // $FF: renamed from: dM (android.os.Parcel) com.google.android.gms.wallet.wobs.l
    public class_711 method_3864(Parcel var1) {
        long var2 = 0L;
        int var4 = class_824.method_4331(var1);
        int var5 = 0;
        long var6 = var2;

        while(var1.dataPosition() < var4) {
            int var8 = class_824.method_4329(var1);
            switch(class_824.method_4340(var8)) {
                case 1:
                    var5 = class_824.method_4348(var1, var8);
                    break;
                case 2:
                    var6 = class_824.method_4350(var1, var8);
                    break;
                case 3:
                    var2 = class_824.method_4350(var1, var8);
                    break;
                default:
                    class_824.method_4341(var1, var8);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new class_711(var5, var6, var2);
        }
    }

    // $FF: renamed from: fP (int) com.google.android.gms.wallet.wobs.l[]
    public class_711[] method_3865(int var1) {
        return new class_711[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3865(var1);
    }
}

package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.wallet.wobs.class_696;
import com.google.android.gms.wallet.wobs.g;

// $FF: renamed from: com.google.android.gms.wallet.wobs.h
public class class_699 implements Creator<g> {
    // $FF: renamed from: a (com.google.android.gms.wallet.wobs.g, android.os.Parcel, int) void
    static void method_3836(class_696 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4325(var1, 2, var0.auD);
        class_823.method_4313(var1, 3, var0.auE, false);
        class_823.method_4303(var1, 4, var0.auF);
        class_823.method_4313(var1, 5, var0.auG, false);
        class_823.method_4305(var1, 6, var0.auH);
        class_823.method_4325(var1, 7, var0.auI);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3837(var1);
    }

    // $FF: renamed from: dJ (android.os.Parcel) com.google.android.gms.wallet.wobs.g
    public class_696 method_3837(Parcel var1) {
        String var2 = null;
        int var3 = 0;
        int var4 = class_824.method_4331(var1);
        double var5 = 0.0D;
        long var7 = 0L;
        int var9 = -1;
        String var10 = null;
        int var11 = 0;

        while(var1.dataPosition() < var4) {
            int var12 = class_824.method_4329(var1);
            switch(class_824.method_4340(var12)) {
                case 1:
                    var11 = class_824.method_4348(var1, var12);
                    break;
                case 2:
                    var3 = class_824.method_4348(var1, var12);
                    break;
                case 3:
                    var10 = class_824.method_4356(var1, var12);
                    break;
                case 4:
                    var5 = class_824.method_4354(var1, var12);
                    break;
                case 5:
                    var2 = class_824.method_4356(var1, var12);
                    break;
                case 6:
                    var7 = class_824.method_4350(var1, var12);
                    break;
                case 7:
                    var9 = class_824.method_4348(var1, var12);
                    break;
                default:
                    class_824.method_4341(var1, var12);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new class_696(var11, var3, var10, var5, var2, var7, var9);
        }
    }

    // $FF: renamed from: fM (int) com.google.android.gms.wallet.wobs.g[]
    public class_696[] method_3838(int var1) {
        return new class_696[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3838(var1);
    }
}

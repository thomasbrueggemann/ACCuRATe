package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.wallet.wobs.class_696;
import com.google.android.gms.wallet.wobs.class_697;
import com.google.android.gms.wallet.wobs.class_711;
import com.google.android.gms.wallet.wobs.f;

// $FF: renamed from: com.google.android.gms.wallet.wobs.i
public class class_698 implements Creator<f> {
    // $FF: renamed from: a (com.google.android.gms.wallet.wobs.f, android.os.Parcel, int) void
    static void method_3833(class_697 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4313(var1, 2, var0.label, false);
        class_823.method_4309(var1, 3, var0.auC, var2, false);
        class_823.method_4313(var1, 4, var0.type, false);
        class_823.method_4309(var1, 5, var0.atc, var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3834(var1);
    }

    // $FF: renamed from: dK (android.os.Parcel) com.google.android.gms.wallet.wobs.f
    public class_697 method_3834(Parcel var1) {
        class_711 var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        String var5 = null;
        class_696 var6 = null;
        String var7 = null;

        while(var1.dataPosition() < var3) {
            int var8 = class_824.method_4329(var1);
            switch(class_824.method_4340(var8)) {
                case 1:
                    var4 = class_824.method_4348(var1, var8);
                    break;
                case 2:
                    var7 = class_824.method_4356(var1, var8);
                    break;
                case 3:
                    var6 = (class_696)class_824.method_4336(var1, var8, class_696.CREATOR);
                    break;
                case 4:
                    var5 = class_824.method_4356(var1, var8);
                    break;
                case 5:
                    var2 = (class_711)class_824.method_4336(var1, var8, class_711.CREATOR);
                    break;
                default:
                    class_824.method_4341(var1, var8);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_697(var4, var7, var6, var5, var2);
        }
    }

    // $FF: renamed from: fN (int) com.google.android.gms.wallet.wobs.f[]
    public class_697[] method_3835(int var1) {
        return new class_697[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3835(var1);
    }
}

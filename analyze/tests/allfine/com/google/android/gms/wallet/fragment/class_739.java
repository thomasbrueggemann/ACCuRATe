package com.google.android.gms.wallet.fragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle;

// $FF: renamed from: com.google.android.gms.wallet.fragment.c
public class class_739 implements Creator<WalletFragmentStyle> {
    // $FF: renamed from: a (com.google.android.gms.wallet.fragment.WalletFragmentStyle, android.os.Parcel, int) void
    static void method_3982(WalletFragmentStyle var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_5365);
        class_823.method_4306(var1, 2, var0.auo, false);
        class_823.method_4325(var1, 3, var0.aup);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3983(var1);
    }

    // $FF: renamed from: dF (android.os.Parcel) com.google.android.gms.wallet.fragment.WalletFragmentStyle
    public WalletFragmentStyle method_3983(Parcel var1) {
        int var2 = 0;
        int var3 = class_824.method_4331(var1);
        Bundle var4 = null;
        int var5 = 0;

        while(var1.dataPosition() < var3) {
            int var6 = class_824.method_4329(var1);
            switch(class_824.method_4340(var6)) {
                case 1:
                    var5 = class_824.method_4348(var1, var6);
                    break;
                case 2:
                    var4 = class_824.method_4358(var1, var6);
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
            return new WalletFragmentStyle(var5, var4, var2);
        }
    }

    // $FF: renamed from: fH (int) com.google.android.gms.wallet.fragment.WalletFragmentStyle[]
    public WalletFragmentStyle[] method_3984(int var1) {
        return new WalletFragmentStyle[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3984(var1);
    }
}

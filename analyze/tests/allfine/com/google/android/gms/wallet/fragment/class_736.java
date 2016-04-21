package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle;

// $FF: renamed from: com.google.android.gms.wallet.fragment.b
public class class_736 implements Creator<WalletFragmentOptions> {
    // $FF: renamed from: a (com.google.android.gms.wallet.fragment.WalletFragmentOptions, android.os.Parcel, int) void
    static void method_3976(WalletFragmentOptions var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_5235);
        class_823.method_4325(var1, 2, var0.getEnvironment());
        class_823.method_4325(var1, 3, var0.getTheme());
        class_823.method_4309(var1, 4, var0.getFragmentStyle(), var2, false);
        class_823.method_4325(var1, 5, var0.getMode());
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3977(var1);
    }

    // $FF: renamed from: dE (android.os.Parcel) com.google.android.gms.wallet.fragment.WalletFragmentOptions
    public WalletFragmentOptions method_3977(Parcel var1) {
        int var2 = 1;
        int var3 = 0;
        int var4 = class_824.method_4331(var1);
        WalletFragmentStyle var5 = null;
        int var6 = var2;
        int var7 = 0;

        while(var1.dataPosition() < var4) {
            int var8 = class_824.method_4329(var1);
            switch(class_824.method_4340(var8)) {
                case 1:
                    var7 = class_824.method_4348(var1, var8);
                    break;
                case 2:
                    var6 = class_824.method_4348(var1, var8);
                    break;
                case 3:
                    var3 = class_824.method_4348(var1, var8);
                    break;
                case 4:
                    var5 = (WalletFragmentStyle)class_824.method_4336(var1, var8, WalletFragmentStyle.CREATOR);
                    break;
                case 5:
                    var2 = class_824.method_4348(var1, var8);
                    break;
                default:
                    class_824.method_4341(var1, var8);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new WalletFragmentOptions(var7, var6, var3, var5, var2);
        }
    }

    // $FF: renamed from: fG (int) com.google.android.gms.wallet.fragment.WalletFragmentOptions[]
    public WalletFragmentOptions[] method_3978(int var1) {
        return new WalletFragmentOptions[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3978(var1);
    }
}

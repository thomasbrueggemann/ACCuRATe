package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.fragment.WalletFragmentInitParams;

// $FF: renamed from: com.google.android.gms.wallet.fragment.a
public class class_738 implements Creator<WalletFragmentInitParams> {
    // $FF: renamed from: a (com.google.android.gms.wallet.fragment.WalletFragmentInitParams, android.os.Parcel, int) void
    static void method_3979(WalletFragmentInitParams var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_5349);
        class_823.method_4313(var1, 2, var0.getAccountName(), false);
        class_823.method_4309(var1, 3, var0.getMaskedWalletRequest(), var2, false);
        class_823.method_4325(var1, 4, var0.getMaskedWalletRequestCode());
        class_823.method_4309(var1, 5, var0.getMaskedWallet(), var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3980(var1);
    }

    // $FF: renamed from: dD (android.os.Parcel) com.google.android.gms.wallet.fragment.WalletFragmentInitParams
    public WalletFragmentInitParams method_3980(Parcel var1) {
        MaskedWallet var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        int var5 = -1;
        MaskedWalletRequest var6 = null;
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
                    var6 = (MaskedWalletRequest)class_824.method_4336(var1, var8, MaskedWalletRequest.CREATOR);
                    break;
                case 4:
                    var5 = class_824.method_4348(var1, var8);
                    break;
                case 5:
                    var2 = (MaskedWallet)class_824.method_4336(var1, var8, MaskedWallet.CREATOR);
                    break;
                default:
                    class_824.method_4341(var1, var8);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new WalletFragmentInitParams(var4, var7, var6, var5, var2);
        }
    }

    // $FF: renamed from: fF (int) com.google.android.gms.wallet.fragment.WalletFragmentInitParams[]
    public WalletFragmentInitParams[] method_3981(int var1) {
        return new WalletFragmentInitParams[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3981(var1);
    }
}

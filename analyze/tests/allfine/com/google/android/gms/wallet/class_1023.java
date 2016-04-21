package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.wallet.Address;
import com.google.android.gms.wallet.InstrumentInfo;
import com.google.android.gms.wallet.LoyaltyWalletObject;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.OfferWalletObject;

// $FF: renamed from: com.google.android.gms.wallet.k
public class class_1023 implements Creator<MaskedWallet> {
    // $FF: renamed from: a (com.google.android.gms.wallet.MaskedWallet, android.os.Parcel, int) void
    static void method_5341(MaskedWallet var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4313(var1, 2, var0.asB, false);
        class_823.method_4313(var1, 3, var0.asC, false);
        class_823.method_4320(var1, 4, var0.asH, false);
        class_823.method_4313(var1, 5, var0.asE, false);
        class_823.method_4309(var1, 6, var0.asF, var2, false);
        class_823.method_4309(var1, 7, var0.asG, var2, false);
        class_823.method_4319(var1, 8, var0.atm, var2, false);
        class_823.method_4319(var1, 9, var0.atn, var2, false);
        class_823.method_4309(var1, 10, var0.asI, var2, false);
        class_823.method_4309(var1, 11, var0.asJ, var2, false);
        class_823.method_4319(var1, 12, var0.asK, var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5342(var1);
    }

    // $FF: renamed from: dw (android.os.Parcel) com.google.android.gms.wallet.MaskedWallet
    public MaskedWallet method_5342(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        String var4 = null;
        String var5 = null;
        String[] var6 = null;
        String var7 = null;
        Address var8 = null;
        Address var9 = null;
        LoyaltyWalletObject[] var10 = null;
        OfferWalletObject[] var11 = null;
        UserAddress var12 = null;
        UserAddress var13 = null;
        InstrumentInfo[] var14 = null;

        while(var1.dataPosition() < var2) {
            int var15 = class_824.method_4329(var1);
            switch(class_824.method_4340(var15)) {
                case 1:
                    var3 = class_824.method_4348(var1, var15);
                    break;
                case 2:
                    var4 = class_824.method_4356(var1, var15);
                    break;
                case 3:
                    var5 = class_824.method_4356(var1, var15);
                    break;
                case 4:
                    var6 = class_824.method_4328(var1, var15);
                    break;
                case 5:
                    var7 = class_824.method_4356(var1, var15);
                    break;
                case 6:
                    var8 = (Address)class_824.method_4336(var1, var15, Address.CREATOR);
                    break;
                case 7:
                    var9 = (Address)class_824.method_4336(var1, var15, Address.CREATOR);
                    break;
                case 8:
                    var10 = (LoyaltyWalletObject[])class_824.method_4342(var1, var15, LoyaltyWalletObject.CREATOR);
                    break;
                case 9:
                    var11 = (OfferWalletObject[])class_824.method_4342(var1, var15, OfferWalletObject.CREATOR);
                    break;
                case 10:
                    var12 = (UserAddress)class_824.method_4336(var1, var15, UserAddress.CREATOR);
                    break;
                case 11:
                    var13 = (UserAddress)class_824.method_4336(var1, var15, UserAddress.CREATOR);
                    break;
                case 12:
                    var14 = (InstrumentInfo[])class_824.method_4342(var1, var15, InstrumentInfo.CREATOR);
                    break;
                default:
                    class_824.method_4341(var1, var15);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new MaskedWallet(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14);
        }
    }

    // $FF: renamed from: fx (int) com.google.android.gms.wallet.MaskedWallet[]
    public MaskedWallet[] method_5343(int var1) {
        return new MaskedWallet[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5343(var1);
    }
}

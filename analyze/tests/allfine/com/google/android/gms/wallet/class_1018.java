package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.wallet.Address;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.InstrumentInfo;
import com.google.android.gms.wallet.ProxyCard;

// $FF: renamed from: com.google.android.gms.wallet.f
public class class_1018 implements Creator<FullWallet> {
    // $FF: renamed from: a (com.google.android.gms.wallet.FullWallet, android.os.Parcel, int) void
    static void method_5329(FullWallet var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4313(var1, 2, var0.asB, false);
        class_823.method_4313(var1, 3, var0.asC, false);
        class_823.method_4309(var1, 4, var0.asD, var2, false);
        class_823.method_4313(var1, 5, var0.asE, false);
        class_823.method_4309(var1, 6, var0.asF, var2, false);
        class_823.method_4309(var1, 7, var0.asG, var2, false);
        class_823.method_4320(var1, 8, var0.asH, false);
        class_823.method_4309(var1, 9, var0.asI, var2, false);
        class_823.method_4309(var1, 10, var0.asJ, var2, false);
        class_823.method_4319(var1, 11, var0.asK, var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5330(var1);
    }

    // $FF: renamed from: dr (android.os.Parcel) com.google.android.gms.wallet.FullWallet
    public FullWallet method_5330(Parcel var1) {
        InstrumentInfo[] var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        UserAddress var5 = null;
        UserAddress var6 = null;
        String[] var7 = null;
        Address var8 = null;
        Address var9 = null;
        String var10 = null;
        ProxyCard var11 = null;
        String var12 = null;
        String var13 = null;

        while(var1.dataPosition() < var3) {
            int var14 = class_824.method_4329(var1);
            switch(class_824.method_4340(var14)) {
                case 1:
                    var4 = class_824.method_4348(var1, var14);
                    break;
                case 2:
                    var13 = class_824.method_4356(var1, var14);
                    break;
                case 3:
                    var12 = class_824.method_4356(var1, var14);
                    break;
                case 4:
                    var11 = (ProxyCard)class_824.method_4336(var1, var14, ProxyCard.CREATOR);
                    break;
                case 5:
                    var10 = class_824.method_4356(var1, var14);
                    break;
                case 6:
                    var9 = (Address)class_824.method_4336(var1, var14, Address.CREATOR);
                    break;
                case 7:
                    var8 = (Address)class_824.method_4336(var1, var14, Address.CREATOR);
                    break;
                case 8:
                    var7 = class_824.method_4328(var1, var14);
                    break;
                case 9:
                    var6 = (UserAddress)class_824.method_4336(var1, var14, UserAddress.CREATOR);
                    break;
                case 10:
                    var5 = (UserAddress)class_824.method_4336(var1, var14, UserAddress.CREATOR);
                    break;
                case 11:
                    var2 = (InstrumentInfo[])class_824.method_4342(var1, var14, InstrumentInfo.CREATOR);
                    break;
                default:
                    class_824.method_4341(var1, var14);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new FullWallet(var4, var13, var12, var11, var10, var9, var8, var7, var6, var5, var2);
        }
    }

    // $FF: renamed from: fs (int) com.google.android.gms.wallet.FullWallet[]
    public FullWallet[] method_5331(int var1) {
        return new FullWallet[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5331(var1);
    }
}

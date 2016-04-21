package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.wallet.LoyaltyWalletObject;
import com.google.android.gms.wallet.OfferWalletObject;
import com.google.android.gms.wallet.class_1020;
import com.google.android.gms.wallet.d;

// $FF: renamed from: com.google.android.gms.wallet.e
public class class_1021 implements Creator<d> {
    // $FF: renamed from: a (com.google.android.gms.wallet.d, android.os.Parcel, int) void
    static void method_5335(class_1020 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4309(var1, 2, var0.asz, var2, false);
        class_823.method_4309(var1, 3, var0.asA, var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5336(var1);
    }

    // $FF: renamed from: dq (android.os.Parcel) com.google.android.gms.wallet.d
    public class_1020 method_5336(Parcel var1) {
        OfferWalletObject var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;

        LoyaltyWalletObject var5;
        OfferWalletObject var7;
        for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
            int var6 = class_824.method_4329(var1);
            LoyaltyWalletObject var8;
            int var9;
            switch(class_824.method_4340(var6)) {
                case 1:
                    int var11 = class_824.method_4348(var1, var6);
                    var8 = var5;
                    var9 = var11;
                    var7 = var2;
                    break;
                case 2:
                    LoyaltyWalletObject var10 = (LoyaltyWalletObject)class_824.method_4336(var1, var6, LoyaltyWalletObject.CREATOR);
                    var9 = var4;
                    var7 = var2;
                    var8 = var10;
                    break;
                case 3:
                    var7 = (OfferWalletObject)class_824.method_4336(var1, var6, OfferWalletObject.CREATOR);
                    var8 = var5;
                    var9 = var4;
                    break;
                default:
                    class_824.method_4341(var1, var6);
                    var7 = var2;
                    var8 = var5;
                    var9 = var4;
            }

            var4 = var9;
            var5 = var8;
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_1020(var4, var5, var2);
        }
    }

    // $FF: renamed from: fr (int) com.google.android.gms.wallet.d[]
    public class_1020[] method_5337(int var1) {
        return new class_1020[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5337(var1);
    }
}

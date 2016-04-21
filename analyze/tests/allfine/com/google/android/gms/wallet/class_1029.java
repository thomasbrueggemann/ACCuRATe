package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.CountrySpecification;
import com.google.android.gms.wallet.MaskedWalletRequest;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.wallet.l
public class class_1029 implements Creator<MaskedWalletRequest> {
    // $FF: renamed from: a (com.google.android.gms.wallet.MaskedWalletRequest, android.os.Parcel, int) void
    static void method_5361(MaskedWalletRequest var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4313(var1, 2, var0.asC, false);
        class_823.method_4316(var1, 3, var0.atp);
        class_823.method_4316(var1, 4, var0.atq);
        class_823.method_4316(var1, 5, var0.atr);
        class_823.method_4313(var1, 6, var0.ats, false);
        class_823.method_4313(var1, 7, var0.asw, false);
        class_823.method_4313(var1, 8, var0.att, false);
        class_823.method_4309(var1, 9, var0.asL, var2, false);
        class_823.method_4316(var1, 10, var0.atu);
        class_823.method_4316(var1, 11, var0.atv);
        class_823.method_4319(var1, 12, var0.atw, var2, false);
        class_823.method_4316(var1, 13, var0.atx);
        class_823.method_4316(var1, 14, var0.aty);
        class_823.method_4326(var1, 15, var0.atz, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5362(var1);
    }

    // $FF: renamed from: dx (android.os.Parcel) com.google.android.gms.wallet.MaskedWalletRequest
    public MaskedWalletRequest method_5362(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        String var4 = null;
        boolean var5 = false;
        boolean var6 = false;
        boolean var7 = false;
        String var8 = null;
        String var9 = null;
        String var10 = null;
        Cart var11 = null;
        boolean var12 = false;
        boolean var13 = false;
        CountrySpecification[] var14 = null;
        boolean var15 = true;
        boolean var16 = true;
        ArrayList var17 = null;

        while(var1.dataPosition() < var2) {
            int var18 = class_824.method_4329(var1);
            switch(class_824.method_4340(var18)) {
                case 1:
                    var3 = class_824.method_4348(var1, var18);
                    break;
                case 2:
                    var4 = class_824.method_4356(var1, var18);
                    break;
                case 3:
                    var5 = class_824.method_4344(var1, var18);
                    break;
                case 4:
                    var6 = class_824.method_4344(var1, var18);
                    break;
                case 5:
                    var7 = class_824.method_4344(var1, var18);
                    break;
                case 6:
                    var8 = class_824.method_4356(var1, var18);
                    break;
                case 7:
                    var9 = class_824.method_4356(var1, var18);
                    break;
                case 8:
                    var10 = class_824.method_4356(var1, var18);
                    break;
                case 9:
                    var11 = (Cart)class_824.method_4336(var1, var18, Cart.CREATOR);
                    break;
                case 10:
                    var12 = class_824.method_4344(var1, var18);
                    break;
                case 11:
                    var13 = class_824.method_4344(var1, var18);
                    break;
                case 12:
                    var14 = (CountrySpecification[])class_824.method_4342(var1, var18, CountrySpecification.CREATOR);
                    break;
                case 13:
                    var15 = class_824.method_4344(var1, var18);
                    break;
                case 14:
                    var16 = class_824.method_4344(var1, var18);
                    break;
                case 15:
                    var17 = class_824.method_4343(var1, var18, com.google.android.gms.identity.intents.model.CountrySpecification.CREATOR);
                    break;
                default:
                    class_824.method_4341(var1, var18);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new MaskedWalletRequest(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17);
        }
    }

    // $FF: renamed from: fy (int) com.google.android.gms.wallet.MaskedWalletRequest[]
    public MaskedWalletRequest[] method_5363(int var1) {
        return new MaskedWalletRequest[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5363(var1);
    }
}

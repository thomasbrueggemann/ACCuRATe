package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.wallet.OfferWalletObject;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

// $FF: renamed from: com.google.android.gms.wallet.n
public class class_1031 implements Creator<OfferWalletObject> {
    // $FF: renamed from: a (com.google.android.gms.wallet.OfferWalletObject, android.os.Parcel, int) void
    static void method_5367(OfferWalletObject var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4313(var1, 2, var0.field_5299, false);
        class_823.method_4313(var1, 3, var0.atD, false);
        class_823.method_4309(var1, 4, var0.atE, var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5368(var1);
    }

    // $FF: renamed from: dz (android.os.Parcel) com.google.android.gms.wallet.OfferWalletObject
    public OfferWalletObject method_5368(Parcel var1) {
        CommonWalletObject var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        String var5 = null;
        String var6 = null;

        while(var1.dataPosition() < var3) {
            int var7 = class_824.method_4329(var1);
            switch(class_824.method_4340(var7)) {
                case 1:
                    var4 = class_824.method_4348(var1, var7);
                    break;
                case 2:
                    var6 = class_824.method_4356(var1, var7);
                    break;
                case 3:
                    var5 = class_824.method_4356(var1, var7);
                    break;
                case 4:
                    var2 = (CommonWalletObject)class_824.method_4336(var1, var7, CommonWalletObject.CREATOR);
                    break;
                default:
                    class_824.method_4341(var1, var7);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new OfferWalletObject(var4, var6, var5, var2);
        }
    }

    // $FF: renamed from: fA (int) com.google.android.gms.wallet.OfferWalletObject[]
    public OfferWalletObject[] method_5369(int var1) {
        return new OfferWalletObject[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5369(var1);
    }
}

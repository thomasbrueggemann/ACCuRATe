package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.FullWalletRequest;

// $FF: renamed from: com.google.android.gms.wallet.g
public class class_1019 implements Creator<FullWalletRequest> {
    // $FF: renamed from: a (com.google.android.gms.wallet.FullWalletRequest, android.os.Parcel, int) void
    static void method_5332(FullWalletRequest var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4313(var1, 2, var0.asB, false);
        class_823.method_4313(var1, 3, var0.asC, false);
        class_823.method_4309(var1, 4, var0.asL, var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5333(var1);
    }

    // $FF: renamed from: ds (android.os.Parcel) com.google.android.gms.wallet.FullWalletRequest
    public FullWalletRequest method_5333(Parcel var1) {
        Cart var2 = null;
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
                    var2 = (Cart)class_824.method_4336(var1, var7, Cart.CREATOR);
                    break;
                default:
                    class_824.method_4341(var1, var7);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new FullWalletRequest(var4, var6, var5, var2);
        }
    }

    // $FF: renamed from: ft (int) com.google.android.gms.wallet.FullWalletRequest[]
    public FullWalletRequest[] method_5334(int var1) {
        return new FullWalletRequest[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5334(var1);
    }
}

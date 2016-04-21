package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;

// $FF: renamed from: com.google.android.gms.wallet.m
public class class_1030 implements Creator<NotifyTransactionStatusRequest> {
    // $FF: renamed from: a (com.google.android.gms.wallet.NotifyTransactionStatusRequest, android.os.Parcel, int) void
    static void method_5364(NotifyTransactionStatusRequest var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_5046);
        class_823.method_4313(var1, 2, var0.asB, false);
        class_823.method_4325(var1, 3, var0.status);
        class_823.method_4313(var1, 4, var0.atB, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5365(var1);
    }

    // $FF: renamed from: dy (android.os.Parcel) com.google.android.gms.wallet.NotifyTransactionStatusRequest
    public NotifyTransactionStatusRequest method_5365(Parcel var1) {
        String var2 = null;
        int var3 = 0;
        int var4 = class_824.method_4331(var1);
        String var5 = null;
        int var6 = 0;

        while(var1.dataPosition() < var4) {
            int var7 = class_824.method_4329(var1);
            switch(class_824.method_4340(var7)) {
                case 1:
                    var6 = class_824.method_4348(var1, var7);
                    break;
                case 2:
                    var5 = class_824.method_4356(var1, var7);
                    break;
                case 3:
                    var3 = class_824.method_4348(var1, var7);
                    break;
                case 4:
                    var2 = class_824.method_4356(var1, var7);
                    break;
                default:
                    class_824.method_4341(var1, var7);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new NotifyTransactionStatusRequest(var6, var5, var3, var2);
        }
    }

    // $FF: renamed from: fz (int) com.google.android.gms.wallet.NotifyTransactionStatusRequest[]
    public NotifyTransactionStatusRequest[] method_5366(int var1) {
        return new NotifyTransactionStatusRequest[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5366(var1);
    }
}

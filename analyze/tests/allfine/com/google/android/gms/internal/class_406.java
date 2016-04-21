package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_407;

// $FF: renamed from: com.google.android.gms.internal.hn
public class class_406 implements Creator<class_407.class_1640> {
    // $FF: renamed from: a (com.google.android.gms.internal.hm$a, android.os.Parcel, int) void
    static void method_2642(class_407.class_1640 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4309(var1, 1, var0.field_5289, var2, false);
        class_823.method_4325(var1, 1000, var0.field_5288);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: M (int) com.google.android.gms.internal.hm$a[]
    public class_407.class_1640[] method_2643(int var1) {
        return new class_407.class_1640[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_2644(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_2643(var1);
    }

    // $FF: renamed from: p (android.os.Parcel) com.google.android.gms.internal.hm$a
    public class_407.class_1640 method_2644(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        Account var4 = null;

        while(var1.dataPosition() < var2) {
            int var5 = class_824.method_4329(var1);
            switch(class_824.method_4340(var5)) {
                case 1:
                    var4 = (Account)class_824.method_4336(var1, var5, Account.CREATOR);
                    break;
                case 1000:
                    var3 = class_824.method_4348(var1, var5);
                    break;
                default:
                    class_824.method_4341(var1, var5);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new class_407.class_1640(var3, var4);
        }
    }
}

package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_403;
import com.google.android.gms.internal.class_413;
import com.google.android.gms.internal.he;

// $FF: renamed from: com.google.android.gms.internal.hf
public class class_412 implements Creator<he> {
    // $FF: renamed from: a (com.google.android.gms.internal.he, android.os.Parcel, int) void
    static void method_2664(class_413 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4319(var1, 1, var0.field_1532, var2, false);
        class_823.method_4325(var1, 1000, var0.field_1531);
        class_823.method_4313(var1, 2, var0.field_1533, false);
        class_823.method_4316(var1, 3, var0.field_1534);
        class_823.method_4309(var1, 4, var0.account, var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: I (int) com.google.android.gms.internal.he[]
    public class_413[] method_2665(int var1) {
        return new class_413[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_2666(var1);
    }

    // $FF: renamed from: l (android.os.Parcel) com.google.android.gms.internal.he
    public class_413 method_2666(Parcel var1) {
        boolean var2 = false;
        Account var3 = null;
        int var4 = class_824.method_4331(var1);
        String var5 = null;
        class_403[] var6 = null;
        int var7 = 0;

        while(var1.dataPosition() < var4) {
            int var8 = class_824.method_4329(var1);
            switch(class_824.method_4340(var8)) {
                case 1:
                    var6 = (class_403[])class_824.method_4342(var1, var8, class_403.CREATOR);
                    break;
                case 2:
                    var5 = class_824.method_4356(var1, var8);
                    break;
                case 3:
                    var2 = class_824.method_4344(var1, var8);
                    break;
                case 4:
                    var3 = (Account)class_824.method_4336(var1, var8, Account.CREATOR);
                    break;
                case 1000:
                    var7 = class_824.method_4348(var1, var8);
                    break;
                default:
                    class_824.method_4341(var1, var8);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new class_413(var7, var6, var5, var2, var3);
        }
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_2665(var1);
    }
}

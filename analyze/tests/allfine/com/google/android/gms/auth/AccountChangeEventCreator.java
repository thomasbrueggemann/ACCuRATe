package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.AccountChangeEvent;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;

public class AccountChangeEventCreator implements Creator<AccountChangeEvent> {
    public static final int CONTENT_DESCRIPTION;

    // $FF: renamed from: a (com.google.android.gms.auth.AccountChangeEvent, android.os.Parcel, int) void
    static void method_1491(AccountChangeEvent var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_5110);
        class_823.method_4305(var1, 2, var0.field_5111);
        class_823.method_4313(var1, 3, var0.field_5109, false);
        class_823.method_4325(var1, 4, var0.field_5112);
        class_823.method_4325(var1, 5, var0.field_5113);
        class_823.method_4313(var1, 6, var0.field_5114, false);
        class_823.method_4301(var1, var3);
    }

    public AccountChangeEvent createFromParcel(Parcel var1) {
        String var2 = null;
        int var3 = 0;
        int var4 = class_824.method_4331(var1);
        long var5 = 0L;
        int var7 = 0;
        String var8 = null;
        int var9 = 0;

        while(var1.dataPosition() < var4) {
            int var10 = class_824.method_4329(var1);
            switch(class_824.method_4340(var10)) {
                case 1:
                    var9 = class_824.method_4348(var1, var10);
                    break;
                case 2:
                    var5 = class_824.method_4350(var1, var10);
                    break;
                case 3:
                    var8 = class_824.method_4356(var1, var10);
                    break;
                case 4:
                    var7 = class_824.method_4348(var1, var10);
                    break;
                case 5:
                    var3 = class_824.method_4348(var1, var10);
                    break;
                case 6:
                    var2 = class_824.method_4356(var1, var10);
                    break;
                default:
                    class_824.method_4341(var1, var10);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new AccountChangeEvent(var9, var5, var8, var7, var3, var2);
        }
    }

    public AccountChangeEvent[] newArray(int var1) {
        return new AccountChangeEvent[var1];
    }
}

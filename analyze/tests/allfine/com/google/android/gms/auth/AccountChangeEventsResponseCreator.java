package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.AccountChangeEvent;
import com.google.android.gms.auth.AccountChangeEventsResponse;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import java.util.ArrayList;

public class AccountChangeEventsResponseCreator implements Creator<AccountChangeEventsResponse> {
    public static final int CONTENT_DESCRIPTION;

    // $FF: renamed from: a (com.google.android.gms.auth.AccountChangeEventsResponse, android.os.Parcel, int) void
    static void method_2679(AccountChangeEventsResponse var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_4861);
        class_823.method_4326(var1, 2, var0.field_4862, false);
        class_823.method_4301(var1, var3);
    }

    public AccountChangeEventsResponse createFromParcel(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        ArrayList var4 = null;

        while(var1.dataPosition() < var2) {
            int var5 = class_824.method_4329(var1);
            switch(class_824.method_4340(var5)) {
                case 1:
                    var3 = class_824.method_4348(var1, var5);
                    break;
                case 2:
                    var4 = class_824.method_4343(var1, var5, AccountChangeEvent.CREATOR);
                    break;
                default:
                    class_824.method_4341(var1, var5);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new AccountChangeEventsResponse(var3, var4);
        }
    }

    public AccountChangeEventsResponse[] newArray(int var1) {
        return new AccountChangeEventsResponse[var1];
    }
}

package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.class_1137;
import com.google.android.gms.fitness.result.SessionReadResult;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.fitness.result.f
public class class_1015 implements Creator<SessionReadResult> {
    // $FF: renamed from: a (com.google.android.gms.fitness.result.SessionReadResult, android.os.Parcel, int) void
    static void method_5298(SessionReadResult var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4326(var1, 1, var0.getSessions(), false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4326(var1, 2, var0.method_3487(), false);
        class_823.method_4309(var1, 3, var0.getStatus(), var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: ca (android.os.Parcel) com.google.android.gms.fitness.result.SessionReadResult
    public SessionReadResult method_5299(Parcel var1) {
        Status var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        ArrayList var5 = null;
        ArrayList var6 = null;

        while(var1.dataPosition() < var3) {
            int var7 = class_824.method_4329(var1);
            switch(class_824.method_4340(var7)) {
                case 1:
                    var6 = class_824.method_4343(var1, var7, Session.CREATOR);
                    break;
                case 2:
                    var5 = class_824.method_4343(var1, var7, class_1137.CREATOR);
                    break;
                case 3:
                    var2 = (Status)class_824.method_4336(var1, var7, Status.CREATOR);
                    break;
                case 1000:
                    var4 = class_824.method_4348(var1, var7);
                    break;
                default:
                    class_824.method_4341(var1, var7);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new SessionReadResult(var4, var6, var5, var2);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5299(var1);
    }

    // $FF: renamed from: ds (int) com.google.android.gms.fitness.result.SessionReadResult[]
    public SessionReadResult[] method_5300(int var1) {
        return new SessionReadResult[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5300(var1);
    }
}

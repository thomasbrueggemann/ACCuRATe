package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.result.SessionStopResult;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.fitness.result.g
public class class_1017 implements Creator<SessionStopResult> {
    // $FF: renamed from: a (com.google.android.gms.fitness.result.SessionStopResult, android.os.Parcel, int) void
    static void method_5304(SessionStopResult var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4309(var1, 2, var0.getStatus(), var2, false);
        class_823.method_4326(var1, 3, var0.getSessions(), false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: cb (android.os.Parcel) com.google.android.gms.fitness.result.SessionStopResult
    public SessionStopResult method_5305(Parcel var1) {
        ArrayList var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;

        Status var5;
        ArrayList var7;
        for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
            int var6 = class_824.method_4329(var1);
            Status var8;
            int var9;
            switch(class_824.method_4340(var6)) {
                case 2:
                    Status var10 = (Status)class_824.method_4336(var1, var6, Status.CREATOR);
                    var9 = var4;
                    var7 = var2;
                    var8 = var10;
                    break;
                case 3:
                    var7 = class_824.method_4343(var1, var6, Session.CREATOR);
                    var8 = var5;
                    var9 = var4;
                    break;
                case 1000:
                    int var11 = class_824.method_4348(var1, var6);
                    var8 = var5;
                    var9 = var11;
                    var7 = var2;
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
            return new SessionStopResult(var4, var5, var2);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5305(var1);
    }

    // $FF: renamed from: dt (int) com.google.android.gms.fitness.result.SessionStopResult[]
    public SessionStopResult[] method_5306(int var1) {
        return new SessionStopResult[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5306(var1);
    }
}

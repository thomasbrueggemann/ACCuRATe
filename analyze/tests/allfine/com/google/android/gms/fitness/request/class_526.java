package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.fitness.request.s
public class class_526 implements Creator<SessionInsertRequest> {
    // $FF: renamed from: a (com.google.android.gms.fitness.request.SessionInsertRequest, android.os.Parcel, int) void
    static void method_3169(SessionInsertRequest var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4309(var1, 1, var0.getSession(), var2, false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4326(var1, 2, var0.getDataSets(), false);
        class_823.method_4326(var1, 3, var0.getAggregateDataPoints(), false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bK (android.os.Parcel) com.google.android.gms.fitness.request.SessionInsertRequest
    public SessionInsertRequest method_3170(Parcel var1) {
        ArrayList var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        ArrayList var5 = null;

        Session var6;
        ArrayList var8;
        for(var6 = null; var1.dataPosition() < var3; var2 = var8) {
            int var7 = class_824.method_4329(var1);
            ArrayList var9;
            Session var10;
            int var11;
            switch(class_824.method_4340(var7)) {
                case 1:
                    Session var16 = (Session)class_824.method_4336(var1, var7, Session.CREATOR);
                    var11 = var4;
                    var10 = var16;
                    var8 = var2;
                    var9 = var5;
                    break;
                case 2:
                    ArrayList var12 = class_824.method_4343(var1, var7, DataSet.CREATOR);
                    var10 = var6;
                    var11 = var4;
                    var9 = var12;
                    var8 = var2;
                    break;
                case 3:
                    var8 = class_824.method_4343(var1, var7, DataPoint.CREATOR);
                    var9 = var5;
                    var10 = var6;
                    var11 = var4;
                    break;
                case 1000:
                    int var14 = class_824.method_4348(var1, var7);
                    var9 = var5;
                    var10 = var6;
                    var11 = var14;
                    var8 = var2;
                    break;
                default:
                    class_824.method_4341(var1, var7);
                    var8 = var2;
                    var9 = var5;
                    var10 = var6;
                    var11 = var4;
            }

            var4 = var11;
            var6 = var10;
            var5 = var9;
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new SessionInsertRequest(var4, var6, var5, var2);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3170(var1);
    }

    // $FF: renamed from: dc (int) com.google.android.gms.fitness.request.SessionInsertRequest[]
    public SessionInsertRequest[] method_3171(int var1) {
        return new SessionInsertRequest[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3171(var1);
    }
}

package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.SessionReadRequest;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.fitness.request.t
public class class_525 implements Creator<SessionReadRequest> {
    // $FF: renamed from: a (com.google.android.gms.fitness.request.SessionReadRequest, android.os.Parcel, int) void
    static void method_3166(SessionReadRequest var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4313(var1, 1, var0.getSessionName(), false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4313(var1, 2, var0.getSessionId(), false);
        class_823.method_4305(var1, 3, var0.method_5325());
        class_823.method_4305(var1, 4, var0.method_5326());
        class_823.method_4326(var1, 5, var0.getDataTypes(), false);
        class_823.method_4326(var1, 6, var0.getDataSources(), false);
        class_823.method_4316(var1, 7, var0.method_5328());
        class_823.method_4316(var1, 8, var0.method_5327());
        class_823.method_4324(var1, 9, var0.getExcludedPackages(), false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bL (android.os.Parcel) com.google.android.gms.fitness.request.SessionReadRequest
    public SessionReadRequest method_3167(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        String var4 = null;
        String var5 = null;
        long var6 = 0L;
        long var8 = 0L;
        ArrayList var10 = null;
        ArrayList var11 = null;
        boolean var12 = false;
        boolean var13 = false;
        ArrayList var14 = null;

        while(var1.dataPosition() < var2) {
            int var15 = class_824.method_4329(var1);
            switch(class_824.method_4340(var15)) {
                case 1:
                    var4 = class_824.method_4356(var1, var15);
                    break;
                case 2:
                    var5 = class_824.method_4356(var1, var15);
                    break;
                case 3:
                    var6 = class_824.method_4350(var1, var15);
                    break;
                case 4:
                    var8 = class_824.method_4350(var1, var15);
                    break;
                case 5:
                    var10 = class_824.method_4343(var1, var15, DataType.CREATOR);
                    break;
                case 6:
                    var11 = class_824.method_4343(var1, var15, DataSource.CREATOR);
                    break;
                case 7:
                    var12 = class_824.method_4344(var1, var15);
                    break;
                case 8:
                    var13 = class_824.method_4344(var1, var15);
                    break;
                case 9:
                    var14 = class_824.method_4332(var1, var15);
                    break;
                case 1000:
                    var3 = class_824.method_4348(var1, var15);
                    break;
                default:
                    class_824.method_4341(var1, var15);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new SessionReadRequest(var3, var4, var5, var6, var8, var10, var11, var12, var13, var14);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3167(var1);
    }

    // $FF: renamed from: dd (int) com.google.android.gms.fitness.request.SessionReadRequest[]
    public SessionReadRequest[] method_3168(int var1) {
        return new SessionReadRequest[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3168(var1);
    }
}

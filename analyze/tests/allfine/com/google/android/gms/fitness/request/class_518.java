package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.fitness.request.d
public class class_518 implements Creator<DataDeleteRequest> {
    // $FF: renamed from: a (com.google.android.gms.fitness.request.DataDeleteRequest, android.os.Parcel, int) void
    static void method_3141(DataDeleteRequest var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4305(var1, 1, var0.method_5451());
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4305(var1, 2, var0.method_5452());
        class_823.method_4326(var1, 3, var0.getDataSources(), false);
        class_823.method_4326(var1, 4, var0.getDataTypes(), false);
        class_823.method_4326(var1, 5, var0.getSessions(), false);
        class_823.method_4316(var1, 6, var0.method_5453());
        class_823.method_4316(var1, 7, var0.method_5454());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bB (android.os.Parcel) com.google.android.gms.fitness.request.DataDeleteRequest
    public DataDeleteRequest method_3142(Parcel var1) {
        long var2 = 0L;
        ArrayList var4 = null;
        boolean var5 = false;
        int var6 = class_824.method_4331(var1);
        boolean var7 = false;
        ArrayList var8 = null;
        ArrayList var9 = null;
        long var10 = var2;
        int var12 = 0;

        while(var1.dataPosition() < var6) {
            int var13 = class_824.method_4329(var1);
            switch(class_824.method_4340(var13)) {
                case 1:
                    var10 = class_824.method_4350(var1, var13);
                    break;
                case 2:
                    var2 = class_824.method_4350(var1, var13);
                    break;
                case 3:
                    var9 = class_824.method_4343(var1, var13, DataSource.CREATOR);
                    break;
                case 4:
                    var8 = class_824.method_4343(var1, var13, DataType.CREATOR);
                    break;
                case 5:
                    var4 = class_824.method_4343(var1, var13, Session.CREATOR);
                    break;
                case 6:
                    var7 = class_824.method_4344(var1, var13);
                    break;
                case 7:
                    var5 = class_824.method_4344(var1, var13);
                    break;
                case 1000:
                    var12 = class_824.method_4348(var1, var13);
                    break;
                default:
                    class_824.method_4341(var1, var13);
            }
        }

        if(var1.dataPosition() != var6) {
            throw new class_824.class_1307("Overread allowed size end=" + var6, var1);
        } else {
            return new DataDeleteRequest(var12, var10, var2, var9, var8, var4, var7, var5);
        }
    }

    // $FF: renamed from: cS (int) com.google.android.gms.fitness.request.DataDeleteRequest[]
    public DataDeleteRequest[] method_3143(int var1) {
        return new DataDeleteRequest[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3142(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3143(var1);
    }
}

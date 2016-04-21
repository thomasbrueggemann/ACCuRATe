package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataReadRequest;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.fitness.request.g
public class class_514 implements Creator<DataReadRequest> {
    // $FF: renamed from: a (com.google.android.gms.fitness.request.DataReadRequest, android.os.Parcel, int) void
    static void method_3131(DataReadRequest var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4326(var1, 1, var0.getDataTypes(), false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4326(var1, 2, var0.getDataSources(), false);
        class_823.method_4305(var1, 3, var0.method_5268());
        class_823.method_4305(var1, 4, var0.method_5269());
        class_823.method_4326(var1, 5, var0.getAggregatedDataTypes(), false);
        class_823.method_4326(var1, 6, var0.getAggregatedDataSources(), false);
        class_823.method_4325(var1, 7, var0.getBucketType());
        class_823.method_4305(var1, 8, var0.method_5273());
        class_823.method_4309(var1, 9, var0.getActivityDataSource(), var2, false);
        class_823.method_4325(var1, 10, var0.getLimit());
        class_823.method_4316(var1, 11, var0.method_5270());
        class_823.method_4316(var1, 12, var0.method_5272());
        class_823.method_4316(var1, 13, var0.method_5271());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bD (android.os.Parcel) com.google.android.gms.fitness.request.DataReadRequest
    public DataReadRequest method_3132(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        ArrayList var4 = null;
        ArrayList var5 = null;
        long var6 = 0L;
        long var8 = 0L;
        ArrayList var10 = null;
        ArrayList var11 = null;
        int var12 = 0;
        long var13 = 0L;
        DataSource var15 = null;
        int var16 = 0;
        boolean var17 = false;
        boolean var18 = false;
        boolean var19 = false;

        while(var1.dataPosition() < var2) {
            int var20 = class_824.method_4329(var1);
            switch(class_824.method_4340(var20)) {
                case 1:
                    var4 = class_824.method_4343(var1, var20, DataType.CREATOR);
                    break;
                case 2:
                    var5 = class_824.method_4343(var1, var20, DataSource.CREATOR);
                    break;
                case 3:
                    var6 = class_824.method_4350(var1, var20);
                    break;
                case 4:
                    var8 = class_824.method_4350(var1, var20);
                    break;
                case 5:
                    var10 = class_824.method_4343(var1, var20, DataType.CREATOR);
                    break;
                case 6:
                    var11 = class_824.method_4343(var1, var20, DataSource.CREATOR);
                    break;
                case 7:
                    var12 = class_824.method_4348(var1, var20);
                    break;
                case 8:
                    var13 = class_824.method_4350(var1, var20);
                    break;
                case 9:
                    var15 = (DataSource)class_824.method_4336(var1, var20, DataSource.CREATOR);
                    break;
                case 10:
                    var16 = class_824.method_4348(var1, var20);
                    break;
                case 11:
                    var17 = class_824.method_4344(var1, var20);
                    break;
                case 12:
                    var18 = class_824.method_4344(var1, var20);
                    break;
                case 13:
                    var19 = class_824.method_4344(var1, var20);
                    break;
                case 1000:
                    var3 = class_824.method_4348(var1, var20);
                    break;
                default:
                    class_824.method_4341(var1, var20);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new DataReadRequest(var3, var4, var5, var6, var8, var10, var11, var12, var13, var15, var16, var17, var18, var19);
        }
    }

    // $FF: renamed from: cU (int) com.google.android.gms.fitness.request.DataReadRequest[]
    public DataReadRequest[] method_3133(int var1) {
        return new DataReadRequest[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3132(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3133(var1);
    }
}

package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.fitness.request.h
public class class_515 implements Creator<DataSourcesRequest> {
    // $FF: renamed from: a (com.google.android.gms.fitness.request.DataSourcesRequest, android.os.Parcel, int) void
    static void method_3134(DataSourcesRequest var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4326(var1, 1, var0.getDataTypes(), false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4314(var1, 2, var0.method_4975(), false);
        class_823.method_4316(var1, 3, var0.method_4974());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bE (android.os.Parcel) com.google.android.gms.fitness.request.DataSourcesRequest
    public DataSourcesRequest method_3135(Parcel var1) {
        ArrayList var2 = null;
        boolean var3 = false;
        int var4 = class_824.method_4331(var1);
        ArrayList var5 = null;
        int var6 = 0;

        while(var1.dataPosition() < var4) {
            int var7 = class_824.method_4329(var1);
            switch(class_824.method_4340(var7)) {
                case 1:
                    var5 = class_824.method_4343(var1, var7, DataType.CREATOR);
                    break;
                case 2:
                    var2 = class_824.method_4330(var1, var7);
                    break;
                case 3:
                    var3 = class_824.method_4344(var1, var7);
                    break;
                case 1000:
                    var6 = class_824.method_4348(var1, var7);
                    break;
                default:
                    class_824.method_4341(var1, var7);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new DataSourcesRequest(var6, var5, var2, var3);
        }
    }

    // $FF: renamed from: cV (int) com.google.android.gms.fitness.request.DataSourcesRequest[]
    public DataSourcesRequest[] method_3136(int var1) {
        return new DataSourcesRequest[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3135(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3136(var1);
    }
}

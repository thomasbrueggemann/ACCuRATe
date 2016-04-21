package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.result.DataSourcesResult;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.fitness.result.c
public class class_1014 implements Creator<DataSourcesResult> {
    // $FF: renamed from: a (com.google.android.gms.fitness.result.DataSourcesResult, android.os.Parcel, int) void
    static void method_5295(DataSourcesResult var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4326(var1, 1, var0.getDataSources(), false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4309(var1, 2, var0.getStatus(), var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bX (android.os.Parcel) com.google.android.gms.fitness.result.DataSourcesResult
    public DataSourcesResult method_5296(Parcel var1) {
        Status var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        ArrayList var5 = null;

        while(var1.dataPosition() < var3) {
            int var6 = class_824.method_4329(var1);
            switch(class_824.method_4340(var6)) {
                case 1:
                    var5 = class_824.method_4343(var1, var6, DataSource.CREATOR);
                    break;
                case 2:
                    var2 = (Status)class_824.method_4336(var1, var6, Status.CREATOR);
                    break;
                case 1000:
                    var4 = class_824.method_4348(var1, var6);
                    break;
                default:
                    class_824.method_4341(var1, var6);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new DataSourcesResult(var4, var5, var2);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5296(var1);
    }

    // $FF: renamed from: dp (int) com.google.android.gms.fitness.result.DataSourcesResult[]
    public DataSourcesResult[] method_5297(int var1) {
        return new DataSourcesResult[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5297(var1);
    }
}

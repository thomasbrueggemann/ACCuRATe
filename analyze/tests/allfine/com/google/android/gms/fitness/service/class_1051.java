package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;

// $FF: renamed from: com.google.android.gms.fitness.service.a
public class class_1051 implements Creator<FitnessSensorServiceRequest> {
    // $FF: renamed from: a (com.google.android.gms.fitness.service.FitnessSensorServiceRequest, android.os.Parcel, int) void
    static void method_5511(FitnessSensorServiceRequest var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4309(var1, 1, var0.getDataSource(), var2, false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4307(var1, 2, var0.method_5246(), false);
        class_823.method_4305(var1, 3, var0.method_5244());
        class_823.method_4305(var1, 4, var0.method_5245());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: cc (android.os.Parcel) com.google.android.gms.fitness.service.FitnessSensorServiceRequest
    public FitnessSensorServiceRequest method_5512(Parcel var1) {
        long var2 = 0L;
        IBinder var4 = null;
        int var5 = class_824.method_4331(var1);
        int var6 = 0;
        long var7 = var2;
        DataSource var9 = null;

        while(var1.dataPosition() < var5) {
            int var10 = class_824.method_4329(var1);
            switch(class_824.method_4340(var10)) {
                case 1:
                    var9 = (DataSource)class_824.method_4336(var1, var10, DataSource.CREATOR);
                    break;
                case 2:
                    var4 = class_824.method_4357(var1, var10);
                    break;
                case 3:
                    var7 = class_824.method_4350(var1, var10);
                    break;
                case 4:
                    var2 = class_824.method_4350(var1, var10);
                    break;
                case 1000:
                    var6 = class_824.method_4348(var1, var10);
                    break;
                default:
                    class_824.method_4341(var1, var10);
            }
        }

        if(var1.dataPosition() != var5) {
            throw new class_824.class_1307("Overread allowed size end=" + var5, var1);
        } else {
            return new FitnessSensorServiceRequest(var6, var9, var4, var7, var2);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5512(var1);
    }

    // $FF: renamed from: du (int) com.google.android.gms.fitness.service.FitnessSensorServiceRequest[]
    public FitnessSensorServiceRequest[] method_5513(int var1) {
        return new FitnessSensorServiceRequest[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5513(var1);
    }
}

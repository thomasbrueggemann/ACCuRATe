package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.aj;
import com.google.android.gms.fitness.request.class_493;

// $FF: renamed from: com.google.android.gms.fitness.request.ak
public class class_494 implements Creator<aj> {
    // $FF: renamed from: a (com.google.android.gms.fitness.request.aj, android.os.Parcel, int) void
    static void method_3038(class_493 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4309(var1, 1, var0.getDataType(), var2, false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4309(var1, 2, var0.getDataSource(), var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bU (android.os.Parcel) com.google.android.gms.fitness.request.aj
    public class_493 method_3039(Parcel var1) {
        DataSource var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;

        DataType var5;
        DataSource var7;
        for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
            int var6 = class_824.method_4329(var1);
            DataType var8;
            int var9;
            switch(class_824.method_4340(var6)) {
                case 1:
                    DataType var12 = (DataType)class_824.method_4336(var1, var6, DataType.CREATOR);
                    var9 = var4;
                    var7 = var2;
                    var8 = var12;
                    break;
                case 2:
                    var7 = (DataSource)class_824.method_4336(var1, var6, DataSource.CREATOR);
                    var8 = var5;
                    var9 = var4;
                    break;
                case 1000:
                    int var10 = class_824.method_4348(var1, var6);
                    var8 = var5;
                    var9 = var10;
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
            return new class_493(var4, var5, var2);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3039(var1);
    }

    // $FF: renamed from: dm (int) com.google.android.gms.fitness.request.aj[]
    public class_493[] method_3040(int var1) {
        return new class_493[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3040(var1);
    }
}

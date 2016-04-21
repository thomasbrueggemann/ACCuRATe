package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.result.DataReadResult;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.fitness.result.b
public class class_1011 implements Creator<DataReadResult> {
    // $FF: renamed from: a (com.google.android.gms.fitness.result.DataReadResult, android.os.Parcel, int) void
    static void method_5286(DataReadResult var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4327(var1, 1, var0.method_4231(), false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4309(var1, 2, var0.getStatus(), var2, false);
        class_823.method_4327(var1, 3, var0.method_4230(), false);
        class_823.method_4325(var1, 5, var0.method_4229());
        class_823.method_4326(var1, 6, var0.method_4228(), false);
        class_823.method_4326(var1, 7, var0.method_4232(), false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bW (android.os.Parcel) com.google.android.gms.fitness.result.DataReadResult
    public DataReadResult method_5287(Parcel var1) {
        int var2 = 0;
        ArrayList var3 = null;
        int var4 = class_824.method_4331(var1);
        ArrayList var5 = new ArrayList();
        ArrayList var6 = new ArrayList();
        ArrayList var7 = null;
        Status var8 = null;
        int var9 = 0;

        while(var1.dataPosition() < var4) {
            int var10 = class_824.method_4329(var1);
            switch(class_824.method_4340(var10)) {
                case 1:
                    class_824.method_4339(var1, var10, var5, this.getClass().getClassLoader());
                    break;
                case 2:
                    var8 = (Status)class_824.method_4336(var1, var10, Status.CREATOR);
                    break;
                case 3:
                    class_824.method_4339(var1, var10, var6, this.getClass().getClassLoader());
                    break;
                case 5:
                    var2 = class_824.method_4348(var1, var10);
                    break;
                case 6:
                    var7 = class_824.method_4343(var1, var10, DataSource.CREATOR);
                    break;
                case 7:
                    var3 = class_824.method_4343(var1, var10, DataType.CREATOR);
                    break;
                case 1000:
                    var9 = class_824.method_4348(var1, var10);
                    break;
                default:
                    class_824.method_4341(var1, var10);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new DataReadResult(var9, var5, var8, var6, var2, var7, var3);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5287(var1);
    }

    // $FF: renamed from: do (int) com.google.android.gms.fitness.result.DataReadResult[]
    public DataReadResult[] method_5288(int var1) {
        return new DataReadResult[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5288(var1);
    }
}

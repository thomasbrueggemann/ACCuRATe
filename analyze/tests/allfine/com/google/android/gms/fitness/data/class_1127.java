package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Value;

// $FF: renamed from: com.google.android.gms.fitness.data.e
public class class_1127 implements Creator<DataPoint> {
    // $FF: renamed from: a (com.google.android.gms.fitness.data.DataPoint, android.os.Parcel, int) void
    static void method_5871(DataPoint var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4309(var1, 1, var0.getDataSource(), var2, false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4305(var1, 3, var0.getTimestampNanos());
        class_823.method_4305(var1, 4, var0.method_4480());
        class_823.method_4319(var1, 5, var0.method_4477(), var2, false);
        class_823.method_4309(var1, 6, var0.getOriginalDataSource(), var2, false);
        class_823.method_4305(var1, 7, var0.method_4478());
        class_823.method_4305(var1, 8, var0.method_4479());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bl (android.os.Parcel) com.google.android.gms.fitness.data.DataPoint
    public DataPoint method_5872(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        DataSource var4 = null;
        long var5 = 0L;
        long var7 = 0L;
        Value[] var9 = null;
        DataSource var10 = null;
        long var11 = 0L;
        long var13 = 0L;

        while(var1.dataPosition() < var2) {
            int var15 = class_824.method_4329(var1);
            switch(class_824.method_4340(var15)) {
                case 1:
                    var4 = (DataSource)class_824.method_4336(var1, var15, DataSource.CREATOR);
                    break;
                case 3:
                    var5 = class_824.method_4350(var1, var15);
                    break;
                case 4:
                    var7 = class_824.method_4350(var1, var15);
                    break;
                case 5:
                    var9 = (Value[])class_824.method_4342(var1, var15, Value.CREATOR);
                    break;
                case 6:
                    var10 = (DataSource)class_824.method_4336(var1, var15, DataSource.CREATOR);
                    break;
                case 7:
                    var11 = class_824.method_4350(var1, var15);
                    break;
                case 8:
                    var13 = class_824.method_4350(var1, var15);
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
            return new DataPoint(var3, var4, var5, var7, var9, var10, var11, var13);
        }
    }

    // $FF: renamed from: cB (int) com.google.android.gms.fitness.data.DataPoint[]
    public DataPoint[] method_5873(int var1) {
        return new DataPoint[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5872(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5873(var1);
    }
}

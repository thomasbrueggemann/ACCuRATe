package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;

// $FF: renamed from: com.google.android.gms.fitness.data.s
public class class_1135 implements Creator<Subscription> {
    // $FF: renamed from: a (com.google.android.gms.fitness.data.Subscription, android.os.Parcel, int) void
    static void method_5895(Subscription var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4309(var1, 1, var0.getDataSource(), var2, false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4309(var1, 2, var0.getDataType(), var2, false);
        class_823.method_4305(var1, 3, var0.method_4911());
        class_823.method_4325(var1, 4, var0.getAccuracyMode());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bw (android.os.Parcel) com.google.android.gms.fitness.data.Subscription
    public Subscription method_5896(Parcel var1) {
        DataType var2 = null;
        int var3 = 0;
        int var4 = class_824.method_4331(var1);
        long var5 = 0L;
        DataSource var7 = null;
        int var8 = 0;

        while(var1.dataPosition() < var4) {
            int var9 = class_824.method_4329(var1);
            switch(class_824.method_4340(var9)) {
                case 1:
                    var7 = (DataSource)class_824.method_4336(var1, var9, DataSource.CREATOR);
                    break;
                case 2:
                    var2 = (DataType)class_824.method_4336(var1, var9, DataType.CREATOR);
                    break;
                case 3:
                    var5 = class_824.method_4350(var1, var9);
                    break;
                case 4:
                    var3 = class_824.method_4348(var1, var9);
                    break;
                case 1000:
                    var8 = class_824.method_4348(var1, var9);
                    break;
                default:
                    class_824.method_4341(var1, var9);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new Subscription(var8, var7, var2, var5, var3);
        }
    }

    // $FF: renamed from: cN (int) com.google.android.gms.fitness.data.Subscription[]
    public Subscription[] method_5897(int var1) {
        return new Subscription[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5896(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5897(var1);
    }
}

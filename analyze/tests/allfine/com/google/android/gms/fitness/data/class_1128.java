package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Session;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.fitness.data.d
public class class_1128 implements Creator<Bucket> {
    // $FF: renamed from: a (com.google.android.gms.fitness.data.Bucket, android.os.Parcel, int) void
    static void method_5874(Bucket var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4305(var1, 1, var0.method_5196());
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4305(var1, 2, var0.method_5197());
        class_823.method_4309(var1, 3, var0.getSession(), var2, false);
        class_823.method_4325(var1, 4, var0.method_5194());
        class_823.method_4326(var1, 5, var0.getDataSets(), false);
        class_823.method_4325(var1, 6, var0.getBucketType());
        class_823.method_4316(var1, 7, var0.method_5195());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bk (android.os.Parcel) com.google.android.gms.fitness.data.Bucket
    public Bucket method_5875(Parcel var1) {
        long var2 = 0L;
        ArrayList var4 = null;
        boolean var5 = false;
        int var6 = class_824.method_4331(var1);
        int var7 = 0;
        int var8 = 0;
        Session var9 = null;
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
                    var9 = (Session)class_824.method_4336(var1, var13, Session.CREATOR);
                    break;
                case 4:
                    var8 = class_824.method_4348(var1, var13);
                    break;
                case 5:
                    var4 = class_824.method_4343(var1, var13, DataSet.CREATOR);
                    break;
                case 6:
                    var7 = class_824.method_4348(var1, var13);
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
            return new Bucket(var12, var10, var2, var9, var8, var4, var7, var5);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5875(var1);
    }

    // $FF: renamed from: cz (int) com.google.android.gms.fitness.data.Bucket[]
    public Bucket[] method_5876(int var1) {
        return new Bucket[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5876(var1);
    }
}

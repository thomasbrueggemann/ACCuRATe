package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.RawDataPoint;
import com.google.android.gms.fitness.data.RawDataSet;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.fitness.data.o
public class class_1132 implements Creator<RawDataSet> {
    // $FF: renamed from: a (com.google.android.gms.fitness.data.RawDataSet, android.os.Parcel, int) void
    static void method_5886(RawDataSet var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_3288);
        class_823.method_4325(var1, 1000, var0.field_3286);
        class_823.method_4325(var1, 2, var0.field_3289);
        class_823.method_4326(var1, 3, var0.field_3290, false);
        class_823.method_4316(var1, 4, var0.field_3287);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bt (android.os.Parcel) com.google.android.gms.fitness.data.RawDataSet
    public RawDataSet method_5887(Parcel var1) {
        boolean var2 = false;
        int var3 = class_824.method_4331(var1);
        ArrayList var4 = null;
        int var5 = 0;
        int var6 = 0;
        int var7 = 0;

        while(var1.dataPosition() < var3) {
            int var8 = class_824.method_4329(var1);
            switch(class_824.method_4340(var8)) {
                case 1:
                    var6 = class_824.method_4348(var1, var8);
                    break;
                case 2:
                    var5 = class_824.method_4348(var1, var8);
                    break;
                case 3:
                    var4 = class_824.method_4343(var1, var8, RawDataPoint.CREATOR);
                    break;
                case 4:
                    var2 = class_824.method_4344(var1, var8);
                    break;
                case 1000:
                    var7 = class_824.method_4348(var1, var8);
                    break;
                default:
                    class_824.method_4341(var1, var8);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new RawDataSet(var7, var6, var5, var4, var2);
        }
    }

    // $FF: renamed from: cJ (int) com.google.android.gms.fitness.data.RawDataSet[]
    public RawDataSet[] method_5888(int var1) {
        return new RawDataSet[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5887(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5888(var1);
    }
}

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.class_841;
import com.google.android.gms.internal.lg;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.lh
public class class_836 implements Creator<lg> {
    // $FF: renamed from: a (com.google.android.gms.internal.lg, android.os.Parcel, int) void
    static void method_4457(class_841 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4326(var1, 1, var0.getDataTypes(), false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: by (android.os.Parcel) com.google.android.gms.internal.lg
    public class_841 method_4458(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        ArrayList var4 = null;

        while(var1.dataPosition() < var2) {
            int var5 = class_824.method_4329(var1);
            switch(class_824.method_4340(var5)) {
                case 1:
                    var4 = class_824.method_4343(var1, var5, DataType.CREATOR);
                    break;
                case 1000:
                    var3 = class_824.method_4348(var1, var5);
                    break;
                default:
                    class_824.method_4341(var1, var5);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new class_841(var3, var4);
        }
    }

    // $FF: renamed from: cP (int) com.google.android.gms.internal.lg[]
    public class_841[] method_4459(int var1) {
        return new class_841[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_4458(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_4459(var1);
    }
}

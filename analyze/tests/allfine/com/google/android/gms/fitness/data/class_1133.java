package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.RawDataPoint;
import com.google.android.gms.fitness.data.Value;

// $FF: renamed from: com.google.android.gms.fitness.data.n
public class class_1133 implements Creator<RawDataPoint> {
    // $FF: renamed from: a (com.google.android.gms.fitness.data.RawDataPoint, android.os.Parcel, int) void
    static void method_5889(RawDataPoint var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4305(var1, 1, var0.field_5056);
        class_823.method_4325(var1, 1000, var0.field_5055);
        class_823.method_4305(var1, 2, var0.field_5057);
        class_823.method_4319(var1, 3, var0.field_5058, var2, false);
        class_823.method_4325(var1, 4, var0.field_5061);
        class_823.method_4325(var1, 5, var0.field_5062);
        class_823.method_4305(var1, 6, var0.field_5059);
        class_823.method_4305(var1, 7, var0.field_5060);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bs (android.os.Parcel) com.google.android.gms.fitness.data.RawDataPoint
    public RawDataPoint method_5890(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        long var4 = 0L;
        long var6 = 0L;
        Value[] var8 = null;
        int var9 = 0;
        int var10 = 0;
        long var11 = 0L;
        long var13 = 0L;

        while(var1.dataPosition() < var2) {
            int var15 = class_824.method_4329(var1);
            switch(class_824.method_4340(var15)) {
                case 1:
                    var4 = class_824.method_4350(var1, var15);
                    break;
                case 2:
                    var6 = class_824.method_4350(var1, var15);
                    break;
                case 3:
                    var8 = (Value[])class_824.method_4342(var1, var15, Value.CREATOR);
                    break;
                case 4:
                    var9 = class_824.method_4348(var1, var15);
                    break;
                case 5:
                    var10 = class_824.method_4348(var1, var15);
                    break;
                case 6:
                    var11 = class_824.method_4350(var1, var15);
                    break;
                case 7:
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
            return new RawDataPoint(var3, var4, var6, var8, var9, var10, var11, var13);
        }
    }

    // $FF: renamed from: cI (int) com.google.android.gms.fitness.data.RawDataPoint[]
    public RawDataPoint[] method_5891(int var1) {
        return new RawDataPoint[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5890(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5891(var1);
    }
}

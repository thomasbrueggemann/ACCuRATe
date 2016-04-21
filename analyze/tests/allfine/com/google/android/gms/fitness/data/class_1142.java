package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.Value;

// $FF: renamed from: com.google.android.gms.fitness.data.u
public class class_1142 implements Creator<Value> {
    // $FF: renamed from: a (com.google.android.gms.fitness.data.Value, android.os.Parcel, int) void
    static void method_5941(Value var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getFormat());
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4316(var1, 2, var0.isSet());
        class_823.method_4304(var1, 3, var0.method_3266());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bx (android.os.Parcel) com.google.android.gms.fitness.data.Value
    public Value method_5942(Parcel var1) {
        boolean var2 = false;
        int var3 = class_824.method_4331(var1);
        float var4 = 0.0F;
        int var5 = 0;
        int var6 = 0;

        while(var1.dataPosition() < var3) {
            int var7 = class_824.method_4329(var1);
            switch(class_824.method_4340(var7)) {
                case 1:
                    var5 = class_824.method_4348(var1, var7);
                    break;
                case 2:
                    var2 = class_824.method_4344(var1, var7);
                    break;
                case 3:
                    var4 = class_824.method_4353(var1, var7);
                    break;
                case 1000:
                    var6 = class_824.method_4348(var1, var7);
                    break;
                default:
                    class_824.method_4341(var1, var7);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new Value(var6, var5, var2, var4);
        }
    }

    // $FF: renamed from: cO (int) com.google.android.gms.fitness.data.Value[]
    public Value[] method_5943(int var1) {
        return new Value[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5942(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5943(var1);
    }
}

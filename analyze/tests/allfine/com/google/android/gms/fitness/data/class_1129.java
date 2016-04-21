package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.Field;

// $FF: renamed from: com.google.android.gms.fitness.data.j
public class class_1129 implements Creator<Field> {
    // $FF: renamed from: a (com.google.android.gms.fitness.data.Field, android.os.Parcel, int) void
    static void method_5877(Field var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4313(var1, 1, var0.getName(), false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4325(var1, 2, var0.getFormat());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bq (android.os.Parcel) com.google.android.gms.fitness.data.Field
    public Field method_5878(Parcel var1) {
        int var2 = 0;
        int var3 = class_824.method_4331(var1);
        String var4 = null;
        int var5 = 0;

        while(var1.dataPosition() < var3) {
            int var6 = class_824.method_4329(var1);
            switch(class_824.method_4340(var6)) {
                case 1:
                    var4 = class_824.method_4356(var1, var6);
                    break;
                case 2:
                    var2 = class_824.method_4348(var1, var6);
                    break;
                case 1000:
                    var5 = class_824.method_4348(var1, var6);
                    break;
                default:
                    class_824.method_4341(var1, var6);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new Field(var5, var4, var2);
        }
    }

    // $FF: renamed from: cG (int) com.google.android.gms.fitness.data.Field[]
    public Field[] method_5879(int var1) {
        return new Field[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5878(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5879(var1);
    }
}

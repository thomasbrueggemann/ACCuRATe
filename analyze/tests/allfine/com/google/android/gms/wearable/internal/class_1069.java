package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.wearable.internal.aq;
import com.google.android.gms.wearable.internal.class_1070;

// $FF: renamed from: com.google.android.gms.wearable.internal.ar
public class class_1069 implements Creator<aq> {
    // $FF: renamed from: a (com.google.android.gms.wearable.internal.aq, android.os.Parcel, int) void
    static void method_5588(class_1070 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_5095);
        class_823.method_4307(var1, 2, var0.method_5591(), false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5589(var1);
    }

    // $FF: renamed from: eg (android.os.Parcel) com.google.android.gms.wearable.internal.aq
    public class_1070 method_5589(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        IBinder var4 = null;

        while(var1.dataPosition() < var2) {
            int var5 = class_824.method_4329(var1);
            switch(class_824.method_4340(var5)) {
                case 1:
                    var3 = class_824.method_4348(var1, var5);
                    break;
                case 2:
                    var4 = class_824.method_4357(var1, var5);
                    break;
                default:
                    class_824.method_4341(var1, var5);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new class_1070(var3, var4);
        }
    }

    // $FF: renamed from: gj (int) com.google.android.gms.wearable.internal.aq[]
    public class_1070[] method_5590(int var1) {
        return new class_1070[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5590(var1);
    }
}

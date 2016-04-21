package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.wearable.internal.am;
import com.google.android.gms.wearable.internal.class_1074;

// $FF: renamed from: com.google.android.gms.wearable.internal.an
public class class_1073 implements Creator<am> {
    // $FF: renamed from: a (com.google.android.gms.wearable.internal.am, android.os.Parcel, int) void
    static void method_5595(class_1074 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.versionCode);
        class_823.method_4313(var1, 2, var0.packageName, false);
        class_823.method_4313(var1, 3, var0.label, false);
        class_823.method_4305(var1, 4, var0.avN);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5596(var1);
    }

    // $FF: renamed from: ee (android.os.Parcel) com.google.android.gms.wearable.internal.am
    public class_1074 method_5596(Parcel var1) {
        String var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        long var5 = 0L;
        String var7 = null;

        while(var1.dataPosition() < var3) {
            int var8 = class_824.method_4329(var1);
            switch(class_824.method_4340(var8)) {
                case 1:
                    var4 = class_824.method_4348(var1, var8);
                    break;
                case 2:
                    var7 = class_824.method_4356(var1, var8);
                    break;
                case 3:
                    var2 = class_824.method_4356(var1, var8);
                    break;
                case 4:
                    var5 = class_824.method_4350(var1, var8);
                    break;
                default:
                    class_824.method_4341(var1, var8);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_1074(var4, var7, var2, var5);
        }
    }

    // $FF: renamed from: gh (int) com.google.android.gms.wearable.internal.am[]
    public class_1074[] method_5597(int var1) {
        return new class_1074[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5597(var1);
    }
}

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_920;
import com.google.android.gms.internal.op;

// $FF: renamed from: com.google.android.gms.internal.oq
public class class_919 implements Creator<op> {
    // $FF: renamed from: a (com.google.android.gms.internal.op, android.os.Parcel, int) void
    static void method_4753(class_920 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4320(var1, 2, var0.atO, false);
        class_823.method_4321(var1, 3, var0.atP, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_4754(var1);
    }

    // $FF: renamed from: dC (android.os.Parcel) com.google.android.gms.internal.op
    public class_920 method_4754(Parcel var1) {
        String[] var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        byte[][] var5 = (byte[][])null;

        while(var1.dataPosition() < var3) {
            int var6 = class_824.method_4329(var1);
            switch(class_824.method_4340(var6)) {
                case 1:
                    var4 = class_824.method_4348(var1, var6);
                    break;
                case 2:
                    var2 = class_824.method_4328(var1, var6);
                    break;
                case 3:
                    var5 = class_824.method_4360(var1, var6);
                    break;
                default:
                    class_824.method_4341(var1, var6);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_920(var4, var2, var5);
        }
    }

    // $FF: renamed from: fD (int) com.google.android.gms.internal.op[]
    public class_920[] method_4755(int var1) {
        return new class_920[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_4755(var1);
    }
}

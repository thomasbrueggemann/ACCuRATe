package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.wearable.internal.b;
import com.google.android.gms.wearable.internal.class_1008;

// $FF: renamed from: com.google.android.gms.wearable.internal.c
public class class_1009 implements Creator<b> {
    // $FF: renamed from: a (com.google.android.gms.wearable.internal.b, android.os.Parcel, int) void
    static void method_5248(class_1008 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_4596);
        class_823.method_4307(var1, 2, var0.method_5247(), false);
        class_823.method_4319(var1, 3, var0.avl, var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5249(var1);
    }

    // $FF: renamed from: dS (android.os.Parcel) com.google.android.gms.wearable.internal.b
    public class_1008 method_5249(Parcel var1) {
        IntentFilter[] var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        IBinder var5 = null;

        while(var1.dataPosition() < var3) {
            int var6 = class_824.method_4329(var1);
            switch(class_824.method_4340(var6)) {
                case 1:
                    var4 = class_824.method_4348(var1, var6);
                    break;
                case 2:
                    var5 = class_824.method_4357(var1, var6);
                    break;
                case 3:
                    var2 = (IntentFilter[])class_824.method_4342(var1, var6, IntentFilter.CREATOR);
                    break;
                default:
                    class_824.method_4341(var1, var6);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_1008(var4, var5, var2);
        }
    }

    // $FF: renamed from: fV (int) com.google.android.gms.wearable.internal.b[]
    public class_1008[] method_5250(int var1) {
        return new class_1008[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5250(var1);
    }
}

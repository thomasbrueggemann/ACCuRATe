package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_536;
import com.google.android.gms.internal.x;

// $FF: renamed from: com.google.android.gms.internal.y
public class class_535 implements Creator<x> {
    // $FF: renamed from: a (com.google.android.gms.internal.x, android.os.Parcel, int) void
    static void method_3271(class_536 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.versionCode);
        class_823.method_4316(var1, 2, var0.field_2873);
        class_823.method_4316(var1, 3, var0.field_2874);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: a (android.os.Parcel) com.google.android.gms.internal.x
    public class_536 method_3272(Parcel var1) {
        boolean var2 = false;
        int var3 = class_824.method_4331(var1);
        boolean var4 = false;
        int var5 = 0;

        while(var1.dataPosition() < var3) {
            int var6 = class_824.method_4329(var1);
            switch(class_824.method_4340(var6)) {
                case 1:
                    var5 = class_824.method_4348(var1, var6);
                    break;
                case 2:
                    var4 = class_824.method_4344(var1, var6);
                    break;
                case 3:
                    var2 = class_824.method_4344(var1, var6);
                    break;
                default:
                    class_824.method_4341(var1, var6);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_536(var5, var4, var2);
        }
    }

    // $FF: renamed from: b (int) com.google.android.gms.internal.x[]
    public class_536[] method_3273(int var1) {
        return new class_536[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3272(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3273(var1);
    }
}

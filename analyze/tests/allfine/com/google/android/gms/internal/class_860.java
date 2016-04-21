package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_272;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.of
public class class_860 implements Creator<class_272.class_1291> {
    // $FF: renamed from: a (com.google.android.gms.internal.nz$c, android.os.Parcel, int) void
    static void method_4513(class_272.class_1291 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        Set var4 = var0.amc;
        if(var4.contains(Integer.valueOf(1))) {
            class_823.method_4325(var1, 1, var0.field_803);
        }

        if(var4.contains(Integer.valueOf(2))) {
            class_823.method_4313(var1, 2, var0.field_804, true);
        }

        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_4514(var1);
    }

    // $FF: renamed from: di (android.os.Parcel) com.google.android.gms.internal.nz$c
    public class_272.class_1291 method_4514(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        HashSet var3 = new HashSet();
        int var4 = 0;
        String var5 = null;

        while(var1.dataPosition() < var2) {
            int var6 = class_824.method_4329(var1);
            switch(class_824.method_4340(var6)) {
                case 1:
                    var4 = class_824.method_4348(var1, var6);
                    var3.add(Integer.valueOf(1));
                    break;
                case 2:
                    var5 = class_824.method_4356(var1, var6);
                    var3.add(Integer.valueOf(2));
                    break;
                default:
                    class_824.method_4341(var1, var6);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new class_272.class_1291(var3, var4, var5);
        }
    }

    // $FF: renamed from: fa (int) com.google.android.gms.internal.nz$c[]
    public class_272.class_1291[] method_4515(int var1) {
        return new class_272.class_1291[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_4515(var1);
    }
}

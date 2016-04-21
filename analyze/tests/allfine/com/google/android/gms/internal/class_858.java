package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_272;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.od
public class class_858 implements Creator<class_272.class_1166> {
    // $FF: renamed from: a (com.google.android.gms.internal.nz$b$a, android.os.Parcel, int) void
    static void method_4507(class_272.class_1166 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        Set var4 = var0.amc;
        if(var4.contains(Integer.valueOf(1))) {
            class_823.method_4325(var1, 1, var0.field_826);
        }

        if(var4.contains(Integer.valueOf(2))) {
            class_823.method_4325(var1, 2, var0.any);
        }

        if(var4.contains(Integer.valueOf(3))) {
            class_823.method_4325(var1, 3, var0.anz);
        }

        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_4508(var1);
    }

    // $FF: renamed from: dg (android.os.Parcel) com.google.android.gms.internal.nz$b$a
    public class_272.class_1166 method_4508(Parcel var1) {
        int var2 = 0;
        int var3 = class_824.method_4331(var1);
        HashSet var4 = new HashSet();
        int var5 = 0;
        int var6 = 0;

        while(var1.dataPosition() < var3) {
            int var7 = class_824.method_4329(var1);
            switch(class_824.method_4340(var7)) {
                case 1:
                    var6 = class_824.method_4348(var1, var7);
                    var4.add(Integer.valueOf(1));
                    break;
                case 2:
                    var5 = class_824.method_4348(var1, var7);
                    var4.add(Integer.valueOf(2));
                    break;
                case 3:
                    var2 = class_824.method_4348(var1, var7);
                    var4.add(Integer.valueOf(3));
                    break;
                default:
                    class_824.method_4341(var1, var7);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_272.class_1166(var4, var6, var5, var2);
        }
    }

    // $FF: renamed from: eY (int) com.google.android.gms.internal.nz$b$a[]
    public class_272.class_1166[] method_4509(int var1) {
        return new class_272.class_1166[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_4509(var1);
    }
}

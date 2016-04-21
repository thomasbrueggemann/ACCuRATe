package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_272;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.oe
public class class_861 implements Creator<class_272.class_1169> {
    // $FF: renamed from: a (com.google.android.gms.internal.nz$b$b, android.os.Parcel, int) void
    static void method_4516(class_272.class_1169 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        Set var4 = var0.amc;
        if(var4.contains(Integer.valueOf(1))) {
            class_823.method_4325(var1, 1, var0.field_822);
        }

        if(var4.contains(Integer.valueOf(2))) {
            class_823.method_4325(var1, 2, var0.field_824);
        }

        if(var4.contains(Integer.valueOf(3))) {
            class_823.method_4313(var1, 3, var0.field_825, true);
        }

        if(var4.contains(Integer.valueOf(4))) {
            class_823.method_4325(var1, 4, var0.field_823);
        }

        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_4517(var1);
    }

    // $FF: renamed from: dh (android.os.Parcel) com.google.android.gms.internal.nz$b$b
    public class_272.class_1169 method_4517(Parcel var1) {
        int var2 = 0;
        int var3 = class_824.method_4331(var1);
        HashSet var4 = new HashSet();
        String var5 = null;
        int var6 = 0;
        int var7 = 0;

        while(var1.dataPosition() < var3) {
            int var8 = class_824.method_4329(var1);
            switch(class_824.method_4340(var8)) {
                case 1:
                    var7 = class_824.method_4348(var1, var8);
                    var4.add(Integer.valueOf(1));
                    break;
                case 2:
                    var6 = class_824.method_4348(var1, var8);
                    var4.add(Integer.valueOf(2));
                    break;
                case 3:
                    var5 = class_824.method_4356(var1, var8);
                    var4.add(Integer.valueOf(3));
                    break;
                case 4:
                    var2 = class_824.method_4348(var1, var8);
                    var4.add(Integer.valueOf(4));
                    break;
                default:
                    class_824.method_4341(var1, var8);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_272.class_1169(var4, var7, var6, var5, var2);
        }
    }

    // $FF: renamed from: eZ (int) com.google.android.gms.internal.nz$b$b[]
    public class_272.class_1169[] method_4518(int var1) {
        return new class_272.class_1169[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_4518(var1);
    }
}

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_272;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.oj
public class class_915 implements Creator<class_272.class_1296> {
    // $FF: renamed from: a (com.google.android.gms.internal.nz$h, android.os.Parcel, int) void
    static void method_4740(class_272.class_1296 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        Set var4 = var0.amc;
        if(var4.contains(Integer.valueOf(1))) {
            class_823.method_4325(var1, 1, var0.field_805);
        }

        if(var4.contains(Integer.valueOf(3))) {
            class_823.method_4325(var1, 3, var0.method_1720());
        }

        if(var4.contains(Integer.valueOf(4))) {
            class_823.method_4313(var1, 4, var0.mValue, true);
        }

        if(var4.contains(Integer.valueOf(5))) {
            class_823.method_4313(var1, 5, var0.anH, true);
        }

        if(var4.contains(Integer.valueOf(6))) {
            class_823.method_4325(var1, 6, var0.field_806);
        }

        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_4741(var1);
    }

    // $FF: renamed from: dm (android.os.Parcel) com.google.android.gms.internal.nz$h
    public class_272.class_1296 method_4741(Parcel var1) {
        String var2 = null;
        int var3 = 0;
        int var4 = class_824.method_4331(var1);
        HashSet var5 = new HashSet();
        int var6 = 0;
        String var7 = null;
        int var8 = 0;

        while(var1.dataPosition() < var4) {
            int var9 = class_824.method_4329(var1);
            switch(class_824.method_4340(var9)) {
                case 1:
                    var8 = class_824.method_4348(var1, var9);
                    var5.add(Integer.valueOf(1));
                    break;
                case 2:
                default:
                    class_824.method_4341(var1, var9);
                    break;
                case 3:
                    var3 = class_824.method_4348(var1, var9);
                    var5.add(Integer.valueOf(3));
                    break;
                case 4:
                    var2 = class_824.method_4356(var1, var9);
                    var5.add(Integer.valueOf(4));
                    break;
                case 5:
                    var7 = class_824.method_4356(var1, var9);
                    var5.add(Integer.valueOf(5));
                    break;
                case 6:
                    var6 = class_824.method_4348(var1, var9);
                    var5.add(Integer.valueOf(6));
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new class_272.class_1296(var5, var8, var7, var6, var2, var3);
        }
    }

    // $FF: renamed from: fe (int) com.google.android.gms.internal.nz$h[]
    public class_272.class_1296[] method_4742(int var1) {
        return new class_272.class_1296[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_4742(var1);
    }
}

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_272;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.og
public class class_918 implements Creator<class_272.class_1292> {
    // $FF: renamed from: a (com.google.android.gms.internal.nz$d, android.os.Parcel, int) void
    static void method_4750(class_272.class_1292 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        Set var4 = var0.amc;
        if(var4.contains(Integer.valueOf(1))) {
            class_823.method_4325(var1, 1, var0.field_795);
        }

        if(var4.contains(Integer.valueOf(2))) {
            class_823.method_4313(var1, 2, var0.amA, true);
        }

        if(var4.contains(Integer.valueOf(3))) {
            class_823.method_4313(var1, 3, var0.anA, true);
        }

        if(var4.contains(Integer.valueOf(4))) {
            class_823.method_4313(var1, 4, var0.amD, true);
        }

        if(var4.contains(Integer.valueOf(5))) {
            class_823.method_4313(var1, 5, var0.anB, true);
        }

        if(var4.contains(Integer.valueOf(6))) {
            class_823.method_4313(var1, 6, var0.anC, true);
        }

        if(var4.contains(Integer.valueOf(7))) {
            class_823.method_4313(var1, 7, var0.anD, true);
        }

        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_4751(var1);
    }

    // $FF: renamed from: dj (android.os.Parcel) com.google.android.gms.internal.nz$d
    public class_272.class_1292 method_4751(Parcel var1) {
        String var2 = null;
        int var3 = class_824.method_4331(var1);
        HashSet var4 = new HashSet();
        int var5 = 0;
        String var6 = null;
        String var7 = null;
        String var8 = null;
        String var9 = null;
        String var10 = null;

        while(var1.dataPosition() < var3) {
            int var11 = class_824.method_4329(var1);
            switch(class_824.method_4340(var11)) {
                case 1:
                    var5 = class_824.method_4348(var1, var11);
                    var4.add(Integer.valueOf(1));
                    break;
                case 2:
                    var10 = class_824.method_4356(var1, var11);
                    var4.add(Integer.valueOf(2));
                    break;
                case 3:
                    var9 = class_824.method_4356(var1, var11);
                    var4.add(Integer.valueOf(3));
                    break;
                case 4:
                    var8 = class_824.method_4356(var1, var11);
                    var4.add(Integer.valueOf(4));
                    break;
                case 5:
                    var7 = class_824.method_4356(var1, var11);
                    var4.add(Integer.valueOf(5));
                    break;
                case 6:
                    var6 = class_824.method_4356(var1, var11);
                    var4.add(Integer.valueOf(6));
                    break;
                case 7:
                    var2 = class_824.method_4356(var1, var11);
                    var4.add(Integer.valueOf(7));
                    break;
                default:
                    class_824.method_4341(var1, var11);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_272.class_1292(var4, var5, var10, var9, var8, var7, var6, var2);
        }
    }

    // $FF: renamed from: fb (int) com.google.android.gms.internal.nz$d[]
    public class_272.class_1292[] method_4752(int var1) {
        return new class_272.class_1292[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_4752(var1);
    }
}

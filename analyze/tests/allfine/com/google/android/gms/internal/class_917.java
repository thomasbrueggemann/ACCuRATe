package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_272;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.oh
public class class_917 implements Creator<class_272.class_1294> {
    // $FF: renamed from: a (com.google.android.gms.internal.nz$f, android.os.Parcel, int) void
    static void method_4747(class_272.class_1294 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        Set var4 = var0.amc;
        if(var4.contains(Integer.valueOf(1))) {
            class_823.method_4325(var1, 1, var0.field_796);
        }

        if(var4.contains(Integer.valueOf(2))) {
            class_823.method_4313(var1, 2, var0.anE, true);
        }

        if(var4.contains(Integer.valueOf(3))) {
            class_823.method_4313(var1, 3, var0.field_799, true);
        }

        if(var4.contains(Integer.valueOf(4))) {
            class_823.method_4313(var1, 4, var0.amz, true);
        }

        if(var4.contains(Integer.valueOf(5))) {
            class_823.method_4313(var1, 5, var0.anF, true);
        }

        if(var4.contains(Integer.valueOf(6))) {
            class_823.method_4313(var1, 6, var0.mName, true);
        }

        if(var4.contains(Integer.valueOf(7))) {
            class_823.method_4316(var1, 7, var0.anG);
        }

        if(var4.contains(Integer.valueOf(8))) {
            class_823.method_4313(var1, 8, var0.amP, true);
        }

        if(var4.contains(Integer.valueOf(9))) {
            class_823.method_4313(var1, 9, var0.field_798, true);
        }

        if(var4.contains(Integer.valueOf(10))) {
            class_823.method_4325(var1, 10, var0.field_797);
        }

        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_4748(var1);
    }

    // $FF: renamed from: dk (android.os.Parcel) com.google.android.gms.internal.nz$f
    public class_272.class_1294 method_4748(Parcel var1) {
        int var2 = 0;
        String var3 = null;
        int var4 = class_824.method_4331(var1);
        HashSet var5 = new HashSet();
        String var6 = null;
        boolean var7 = false;
        String var8 = null;
        String var9 = null;
        String var10 = null;
        String var11 = null;
        String var12 = null;
        int var13 = 0;

        while(var1.dataPosition() < var4) {
            int var14 = class_824.method_4329(var1);
            switch(class_824.method_4340(var14)) {
                case 1:
                    var13 = class_824.method_4348(var1, var14);
                    var5.add(Integer.valueOf(1));
                    break;
                case 2:
                    var12 = class_824.method_4356(var1, var14);
                    var5.add(Integer.valueOf(2));
                    break;
                case 3:
                    var11 = class_824.method_4356(var1, var14);
                    var5.add(Integer.valueOf(3));
                    break;
                case 4:
                    var10 = class_824.method_4356(var1, var14);
                    var5.add(Integer.valueOf(4));
                    break;
                case 5:
                    var9 = class_824.method_4356(var1, var14);
                    var5.add(Integer.valueOf(5));
                    break;
                case 6:
                    var8 = class_824.method_4356(var1, var14);
                    var5.add(Integer.valueOf(6));
                    break;
                case 7:
                    var7 = class_824.method_4344(var1, var14);
                    var5.add(Integer.valueOf(7));
                    break;
                case 8:
                    var6 = class_824.method_4356(var1, var14);
                    var5.add(Integer.valueOf(8));
                    break;
                case 9:
                    var3 = class_824.method_4356(var1, var14);
                    var5.add(Integer.valueOf(9));
                    break;
                case 10:
                    var2 = class_824.method_4348(var1, var14);
                    var5.add(Integer.valueOf(10));
                    break;
                default:
                    class_824.method_4341(var1, var14);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new class_272.class_1294(var5, var13, var12, var11, var10, var9, var8, var7, var6, var3, var2);
        }
    }

    // $FF: renamed from: fc (int) com.google.android.gms.internal.nz$f[]
    public class_272.class_1294[] method_4749(int var1) {
        return new class_272.class_1294[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_4749(var1);
    }
}

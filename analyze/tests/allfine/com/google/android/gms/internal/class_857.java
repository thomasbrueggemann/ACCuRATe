package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_272;
import com.google.android.gms.internal.nz;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.oa
public class class_857 implements Creator<nz> {
    // $FF: renamed from: a (com.google.android.gms.internal.nz, android.os.Parcel, int) void
    static void method_4504(class_272 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        Set var4 = var0.amc;
        if(var4.contains(Integer.valueOf(1))) {
            class_823.method_4325(var1, 1, var0.field_814);
        }

        if(var4.contains(Integer.valueOf(2))) {
            class_823.method_4313(var1, 2, var0.ana, true);
        }

        if(var4.contains(Integer.valueOf(3))) {
            class_823.method_4309(var1, 3, var0.anb, var2, true);
        }

        if(var4.contains(Integer.valueOf(4))) {
            class_823.method_4313(var1, 4, var0.anc, true);
        }

        if(var4.contains(Integer.valueOf(5))) {
            class_823.method_4313(var1, 5, var0.and, true);
        }

        if(var4.contains(Integer.valueOf(6))) {
            class_823.method_4325(var1, 6, var0.ane);
        }

        if(var4.contains(Integer.valueOf(7))) {
            class_823.method_4309(var1, 7, var0.anf, var2, true);
        }

        if(var4.contains(Integer.valueOf(8))) {
            class_823.method_4313(var1, 8, var0.ang, true);
        }

        if(var4.contains(Integer.valueOf(9))) {
            class_823.method_4313(var1, 9, var0.field_816, true);
        }

        if(var4.contains(Integer.valueOf(12))) {
            class_823.method_4325(var1, 12, var0.field_817);
        }

        if(var4.contains(Integer.valueOf(14))) {
            class_823.method_4313(var1, 14, var0.field_813, true);
        }

        if(var4.contains(Integer.valueOf(15))) {
            class_823.method_4309(var1, 15, var0.anh, var2, true);
        }

        if(var4.contains(Integer.valueOf(16))) {
            class_823.method_4316(var1, 16, var0.ani);
        }

        if(var4.contains(Integer.valueOf(19))) {
            class_823.method_4309(var1, 19, var0.anj, var2, true);
        }

        if(var4.contains(Integer.valueOf(18))) {
            class_823.method_4313(var1, 18, var0.field_815, true);
        }

        if(var4.contains(Integer.valueOf(21))) {
            class_823.method_4325(var1, 21, var0.anl);
        }

        if(var4.contains(Integer.valueOf(20))) {
            class_823.method_4313(var1, 20, var0.ank, true);
        }

        if(var4.contains(Integer.valueOf(23))) {
            class_823.method_4326(var1, 23, var0.ann, true);
        }

        if(var4.contains(Integer.valueOf(22))) {
            class_823.method_4326(var1, 22, var0.anm, true);
        }

        if(var4.contains(Integer.valueOf(25))) {
            class_823.method_4325(var1, 25, var0.anp);
        }

        if(var4.contains(Integer.valueOf(24))) {
            class_823.method_4325(var1, 24, var0.ano);
        }

        if(var4.contains(Integer.valueOf(27))) {
            class_823.method_4313(var1, 27, var0.field_818, true);
        }

        if(var4.contains(Integer.valueOf(26))) {
            class_823.method_4313(var1, 26, var0.anq, true);
        }

        if(var4.contains(Integer.valueOf(29))) {
            class_823.method_4316(var1, 29, var0.ans);
        }

        if(var4.contains(Integer.valueOf(28))) {
            class_823.method_4326(var1, 28, var0.anr, true);
        }

        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_4505(var1);
    }

    // $FF: renamed from: dd (android.os.Parcel) com.google.android.gms.internal.nz
    public class_272 method_4505(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        HashSet var3 = new HashSet();
        int var4 = 0;
        String var5 = null;
        class_272.class_1290 var6 = null;
        String var7 = null;
        String var8 = null;
        int var9 = 0;
        class_272.class_1165 var10 = null;
        String var11 = null;
        String var12 = null;
        int var13 = 0;
        String var14 = null;
        class_272.class_1291 var15 = null;
        boolean var16 = false;
        String var17 = null;
        class_272.class_1292 var18 = null;
        String var19 = null;
        int var20 = 0;
        ArrayList var21 = null;
        ArrayList var22 = null;
        int var23 = 0;
        int var24 = 0;
        String var25 = null;
        String var26 = null;
        ArrayList var27 = null;
        boolean var28 = false;

        while(var1.dataPosition() < var2) {
            int var29 = class_824.method_4329(var1);
            switch(class_824.method_4340(var29)) {
                case 1:
                    var4 = class_824.method_4348(var1, var29);
                    var3.add(Integer.valueOf(1));
                    break;
                case 2:
                    var5 = class_824.method_4356(var1, var29);
                    var3.add(Integer.valueOf(2));
                    break;
                case 3:
                    class_272.class_1290 var55 = (class_272.class_1290)class_824.method_4336(var1, var29, class_272.class_1290.CREATOR);
                    var3.add(Integer.valueOf(3));
                    var6 = var55;
                    break;
                case 4:
                    var7 = class_824.method_4356(var1, var29);
                    var3.add(Integer.valueOf(4));
                    break;
                case 5:
                    var8 = class_824.method_4356(var1, var29);
                    var3.add(Integer.valueOf(5));
                    break;
                case 6:
                    var9 = class_824.method_4348(var1, var29);
                    var3.add(Integer.valueOf(6));
                    break;
                case 7:
                    class_272.class_1165 var50 = (class_272.class_1165)class_824.method_4336(var1, var29, class_272.class_1165.CREATOR);
                    var3.add(Integer.valueOf(7));
                    var10 = var50;
                    break;
                case 8:
                    var11 = class_824.method_4356(var1, var29);
                    var3.add(Integer.valueOf(8));
                    break;
                case 9:
                    var12 = class_824.method_4356(var1, var29);
                    var3.add(Integer.valueOf(9));
                    break;
                case 10:
                case 11:
                case 13:
                case 17:
                default:
                    class_824.method_4341(var1, var29);
                    break;
                case 12:
                    var13 = class_824.method_4348(var1, var29);
                    var3.add(Integer.valueOf(12));
                    break;
                case 14:
                    var14 = class_824.method_4356(var1, var29);
                    var3.add(Integer.valueOf(14));
                    break;
                case 15:
                    class_272.class_1291 var44 = (class_272.class_1291)class_824.method_4336(var1, var29, class_272.class_1291.CREATOR);
                    var3.add(Integer.valueOf(15));
                    var15 = var44;
                    break;
                case 16:
                    var16 = class_824.method_4344(var1, var29);
                    var3.add(Integer.valueOf(16));
                    break;
                case 18:
                    var17 = class_824.method_4356(var1, var29);
                    var3.add(Integer.valueOf(18));
                    break;
                case 19:
                    class_272.class_1292 var41 = (class_272.class_1292)class_824.method_4336(var1, var29, class_272.class_1292.CREATOR);
                    var3.add(Integer.valueOf(19));
                    var18 = var41;
                    break;
                case 20:
                    var19 = class_824.method_4356(var1, var29);
                    var3.add(Integer.valueOf(20));
                    break;
                case 21:
                    var20 = class_824.method_4348(var1, var29);
                    var3.add(Integer.valueOf(21));
                    break;
                case 22:
                    var21 = class_824.method_4343(var1, var29, class_272.class_1294.CREATOR);
                    var3.add(Integer.valueOf(22));
                    break;
                case 23:
                    var22 = class_824.method_4343(var1, var29, class_272.class_1295.CREATOR);
                    var3.add(Integer.valueOf(23));
                    break;
                case 24:
                    var23 = class_824.method_4348(var1, var29);
                    var3.add(Integer.valueOf(24));
                    break;
                case 25:
                    var24 = class_824.method_4348(var1, var29);
                    var3.add(Integer.valueOf(25));
                    break;
                case 26:
                    var25 = class_824.method_4356(var1, var29);
                    var3.add(Integer.valueOf(26));
                    break;
                case 27:
                    var26 = class_824.method_4356(var1, var29);
                    var3.add(Integer.valueOf(27));
                    break;
                case 28:
                    var27 = class_824.method_4343(var1, var29, class_272.class_1296.CREATOR);
                    var3.add(Integer.valueOf(28));
                    break;
                case 29:
                    var28 = class_824.method_4344(var1, var29);
                    var3.add(Integer.valueOf(29));
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new class_272(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28);
        }
    }

    // $FF: renamed from: eV (int) com.google.android.gms.internal.nz[]
    public class_272[] method_4506(int var1) {
        return new class_272[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_4506(var1);
    }
}

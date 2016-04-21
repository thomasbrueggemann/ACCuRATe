package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_447;
import com.google.android.gms.internal.fk;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.fl
public class class_445 implements Creator<fk> {
    // $FF: renamed from: a (com.google.android.gms.internal.fk, android.os.Parcel, int) void
    static void method_2798(class_447 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.versionCode);
        class_823.method_4313(var1, 2, var0.field_1695, false);
        class_823.method_4313(var1, 3, var0.field_1697, false);
        class_823.method_4324(var1, 4, var0.field_1692, false);
        class_823.method_4325(var1, 5, var0.errorCode);
        class_823.method_4324(var1, 6, var0.field_1693, false);
        class_823.method_4305(var1, 7, var0.field_1698);
        class_823.method_4316(var1, 8, var0.field_1699);
        class_823.method_4305(var1, 9, var0.field_1700);
        class_823.method_4324(var1, 10, var0.field_1701, false);
        class_823.method_4305(var1, 11, var0.field_1694);
        class_823.method_4325(var1, 12, var0.orientation);
        class_823.method_4313(var1, 13, var0.field_1702, false);
        class_823.method_4305(var1, 14, var0.field_1703);
        class_823.method_4313(var1, 15, var0.field_1704, false);
        class_823.method_4313(var1, 19, var0.field_1706, false);
        class_823.method_4316(var1, 18, var0.field_1705);
        class_823.method_4313(var1, 21, var0.field_1707, false);
        class_823.method_4316(var1, 23, var0.field_1709);
        class_823.method_4316(var1, 22, var0.field_1708);
        class_823.method_4316(var1, 25, var0.field_1710);
        class_823.method_4316(var1, 24, var0.field_1696);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_2799(var1);
    }

    // $FF: renamed from: i (android.os.Parcel) com.google.android.gms.internal.fk
    public class_447 method_2799(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        String var4 = null;
        String var5 = null;
        ArrayList var6 = null;
        int var7 = 0;
        ArrayList var8 = null;
        long var9 = 0L;
        boolean var11 = false;
        long var12 = 0L;
        ArrayList var14 = null;
        long var15 = 0L;
        int var17 = 0;
        String var18 = null;
        long var19 = 0L;
        String var21 = null;
        boolean var22 = false;
        String var23 = null;
        String var24 = null;
        boolean var25 = false;
        boolean var26 = false;
        boolean var27 = false;
        boolean var28 = false;

        while(var1.dataPosition() < var2) {
            int var29 = class_824.method_4329(var1);
            switch(class_824.method_4340(var29)) {
                case 1:
                    var3 = class_824.method_4348(var1, var29);
                    break;
                case 2:
                    var4 = class_824.method_4356(var1, var29);
                    break;
                case 3:
                    var5 = class_824.method_4356(var1, var29);
                    break;
                case 4:
                    var6 = class_824.method_4332(var1, var29);
                    break;
                case 5:
                    var7 = class_824.method_4348(var1, var29);
                    break;
                case 6:
                    var8 = class_824.method_4332(var1, var29);
                    break;
                case 7:
                    var9 = class_824.method_4350(var1, var29);
                    break;
                case 8:
                    var11 = class_824.method_4344(var1, var29);
                    break;
                case 9:
                    var12 = class_824.method_4350(var1, var29);
                    break;
                case 10:
                    var14 = class_824.method_4332(var1, var29);
                    break;
                case 11:
                    var15 = class_824.method_4350(var1, var29);
                    break;
                case 12:
                    var17 = class_824.method_4348(var1, var29);
                    break;
                case 13:
                    var18 = class_824.method_4356(var1, var29);
                    break;
                case 14:
                    var19 = class_824.method_4350(var1, var29);
                    break;
                case 15:
                    var21 = class_824.method_4356(var1, var29);
                    break;
                case 16:
                case 17:
                case 20:
                default:
                    class_824.method_4341(var1, var29);
                    break;
                case 18:
                    var22 = class_824.method_4344(var1, var29);
                    break;
                case 19:
                    var23 = class_824.method_4356(var1, var29);
                    break;
                case 21:
                    var24 = class_824.method_4356(var1, var29);
                    break;
                case 22:
                    var25 = class_824.method_4344(var1, var29);
                    break;
                case 23:
                    var26 = class_824.method_4344(var1, var29);
                    break;
                case 24:
                    var27 = class_824.method_4344(var1, var29);
                    break;
                case 25:
                    var28 = class_824.method_4344(var1, var29);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new class_447(var3, var4, var5, var6, var7, var8, var9, var11, var12, var14, var15, var17, var18, var19, var21, var22, var23, var24, var25, var26, var27, var28);
        }
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_2800(var1);
    }

    // $FF: renamed from: q (int) com.google.android.gms.internal.fk[]
    public class_447[] method_2800(int var1) {
        return new class_447[var1];
    }
}

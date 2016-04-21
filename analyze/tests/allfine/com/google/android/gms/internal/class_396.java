package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_399;
import com.google.android.gms.internal.class_401;
import com.google.android.gms.internal.hq;

// $FF: renamed from: com.google.android.gms.internal.hr
public class class_396 implements Creator<hq> {
    // $FF: renamed from: a (com.google.android.gms.internal.hq, android.os.Parcel, int) void
    static void method_2612(class_399 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4313(var1, 1, var0.name, false);
        class_823.method_4325(var1, 1000, var0.field_1487);
        class_823.method_4313(var1, 2, var0.field_1488, false);
        class_823.method_4316(var1, 3, var0.field_1489);
        class_823.method_4325(var1, 4, var0.weight);
        class_823.method_4316(var1, 5, var0.field_1490);
        class_823.method_4313(var1, 6, var0.field_1491, false);
        class_823.method_4319(var1, 7, var0.field_1492, var2, false);
        class_823.method_4318(var1, 8, var0.field_1493, false);
        class_823.method_4313(var1, 11, var0.field_1494, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: Q (int) com.google.android.gms.internal.hq[]
    public class_399[] method_2613(int var1) {
        return new class_399[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_2614(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_2613(var1);
    }

    // $FF: renamed from: r (android.os.Parcel) com.google.android.gms.internal.hq
    public class_399 method_2614(Parcel var1) {
        boolean var2 = false;
        String var3 = null;
        int var4 = class_824.method_4331(var1);
        int var5 = 1;
        int[] var6 = null;
        class_401[] var7 = null;
        String var8 = null;
        boolean var9 = false;
        String var10 = null;
        String var11 = null;
        int var12 = 0;

        while(var1.dataPosition() < var4) {
            int var13 = class_824.method_4329(var1);
            switch(class_824.method_4340(var13)) {
                case 1:
                    var11 = class_824.method_4356(var1, var13);
                    break;
                case 2:
                    var10 = class_824.method_4356(var1, var13);
                    break;
                case 3:
                    var9 = class_824.method_4344(var1, var13);
                    break;
                case 4:
                    var5 = class_824.method_4348(var1, var13);
                    break;
                case 5:
                    var2 = class_824.method_4344(var1, var13);
                    break;
                case 6:
                    var8 = class_824.method_4356(var1, var13);
                    break;
                case 7:
                    var7 = (class_401[])class_824.method_4342(var1, var13, class_401.CREATOR);
                    break;
                case 8:
                    var6 = class_824.method_4362(var1, var13);
                    break;
                case 11:
                    var3 = class_824.method_4356(var1, var13);
                    break;
                case 1000:
                    var12 = class_824.method_4348(var1, var13);
                    break;
                default:
                    class_824.method_4341(var1, var13);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new class_399(var12, var11, var10, var9, var5, var2, var8, var7, var6, var3);
        }
    }
}

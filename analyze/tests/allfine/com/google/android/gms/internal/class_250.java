package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.bj;
import com.google.android.gms.internal.class_249;

// $FF: renamed from: com.google.android.gms.internal.bk
public class class_250 implements Creator<bj> {
    // $FF: renamed from: a (com.google.android.gms.internal.bj, android.os.Parcel, int) void
    static void method_1604(class_249 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.versionCode);
        class_823.method_4325(var1, 2, var0.field_684);
        class_823.method_4325(var1, 3, var0.backgroundColor);
        class_823.method_4325(var1, 4, var0.field_685);
        class_823.method_4325(var1, 5, var0.field_686);
        class_823.method_4325(var1, 6, var0.field_687);
        class_823.method_4325(var1, 7, var0.field_688);
        class_823.method_4325(var1, 8, var0.field_689);
        class_823.method_4325(var1, 9, var0.field_690);
        class_823.method_4313(var1, 10, var0.field_691, false);
        class_823.method_4325(var1, 11, var0.field_692);
        class_823.method_4313(var1, 12, var0.field_693, false);
        class_823.method_4325(var1, 13, var0.field_694);
        class_823.method_4325(var1, 14, var0.field_695);
        class_823.method_4313(var1, 15, var0.field_696, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_1605(var1);
    }

    // $FF: renamed from: d (android.os.Parcel) com.google.android.gms.internal.bj
    public class_249 method_1605(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        int var4 = 0;
        int var5 = 0;
        int var6 = 0;
        int var7 = 0;
        int var8 = 0;
        int var9 = 0;
        int var10 = 0;
        int var11 = 0;
        String var12 = null;
        int var13 = 0;
        String var14 = null;
        int var15 = 0;
        int var16 = 0;
        String var17 = null;

        while(var1.dataPosition() < var2) {
            int var18 = class_824.method_4329(var1);
            switch(class_824.method_4340(var18)) {
                case 1:
                    var3 = class_824.method_4348(var1, var18);
                    break;
                case 2:
                    var4 = class_824.method_4348(var1, var18);
                    break;
                case 3:
                    var5 = class_824.method_4348(var1, var18);
                    break;
                case 4:
                    var6 = class_824.method_4348(var1, var18);
                    break;
                case 5:
                    var7 = class_824.method_4348(var1, var18);
                    break;
                case 6:
                    var8 = class_824.method_4348(var1, var18);
                    break;
                case 7:
                    var9 = class_824.method_4348(var1, var18);
                    break;
                case 8:
                    var10 = class_824.method_4348(var1, var18);
                    break;
                case 9:
                    var11 = class_824.method_4348(var1, var18);
                    break;
                case 10:
                    var12 = class_824.method_4356(var1, var18);
                    break;
                case 11:
                    var13 = class_824.method_4348(var1, var18);
                    break;
                case 12:
                    var14 = class_824.method_4356(var1, var18);
                    break;
                case 13:
                    var15 = class_824.method_4348(var1, var18);
                    break;
                case 14:
                    var16 = class_824.method_4348(var1, var18);
                    break;
                case 15:
                    var17 = class_824.method_4356(var1, var18);
                    break;
                default:
                    class_824.method_4341(var1, var18);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new class_249(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17);
        }
    }

    // $FF: renamed from: h (int) com.google.android.gms.internal.bj[]
    public class_249[] method_1606(int var1) {
        return new class_249[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_1606(var1);
    }
}

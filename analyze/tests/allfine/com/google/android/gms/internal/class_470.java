package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_379;
import com.google.android.gms.internal.class_469;
import com.google.android.gms.internal.class_486;
import com.google.android.gms.internal.class_536;
import com.google.android.gms.internal.dm;

// $FF: renamed from: com.google.android.gms.internal.dl
public class class_470 implements Creator<dm> {
    // $FF: renamed from: a (com.google.android.gms.internal.dm, android.os.Parcel, int) void
    static void method_2868(class_469 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.versionCode);
        class_823.method_4309(var1, 2, var0.field_1803, var2, false);
        class_823.method_4307(var1, 3, var0.method_2862(), false);
        class_823.method_4307(var1, 4, var0.method_2863(), false);
        class_823.method_4307(var1, 5, var0.method_2864(), false);
        class_823.method_4307(var1, 6, var0.method_2865(), false);
        class_823.method_4313(var1, 7, var0.field_1808, false);
        class_823.method_4316(var1, 8, var0.field_1809);
        class_823.method_4313(var1, 9, var0.field_1810, false);
        class_823.method_4307(var1, 10, var0.method_2867(), false);
        class_823.method_4325(var1, 11, var0.orientation);
        class_823.method_4325(var1, 12, var0.field_1812);
        class_823.method_4313(var1, 13, var0.field_1816, false);
        class_823.method_4309(var1, 14, var0.field_1802, var2, false);
        class_823.method_4307(var1, 15, var0.method_2866(), false);
        class_823.method_4309(var1, 17, var0.field_1815, var2, false);
        class_823.method_4313(var1, 16, var0.field_1814, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_2869(var1);
    }

    // $FF: renamed from: f (android.os.Parcel) com.google.android.gms.internal.dm
    public class_469 method_2869(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        class_486 var4 = null;
        IBinder var5 = null;
        IBinder var6 = null;
        IBinder var7 = null;
        IBinder var8 = null;
        String var9 = null;
        boolean var10 = false;
        String var11 = null;
        IBinder var12 = null;
        int var13 = 0;
        int var14 = 0;
        String var15 = null;
        class_379 var16 = null;
        IBinder var17 = null;
        String var18 = null;
        class_536 var19 = null;

        while(var1.dataPosition() < var2) {
            int var20 = class_824.method_4329(var1);
            switch(class_824.method_4340(var20)) {
                case 1:
                    var3 = class_824.method_4348(var1, var20);
                    break;
                case 2:
                    var4 = (class_486)class_824.method_4336(var1, var20, class_486.CREATOR);
                    break;
                case 3:
                    var5 = class_824.method_4357(var1, var20);
                    break;
                case 4:
                    var6 = class_824.method_4357(var1, var20);
                    break;
                case 5:
                    var7 = class_824.method_4357(var1, var20);
                    break;
                case 6:
                    var8 = class_824.method_4357(var1, var20);
                    break;
                case 7:
                    var9 = class_824.method_4356(var1, var20);
                    break;
                case 8:
                    var10 = class_824.method_4344(var1, var20);
                    break;
                case 9:
                    var11 = class_824.method_4356(var1, var20);
                    break;
                case 10:
                    var12 = class_824.method_4357(var1, var20);
                    break;
                case 11:
                    var13 = class_824.method_4348(var1, var20);
                    break;
                case 12:
                    var14 = class_824.method_4348(var1, var20);
                    break;
                case 13:
                    var15 = class_824.method_4356(var1, var20);
                    break;
                case 14:
                    var16 = (class_379)class_824.method_4336(var1, var20, class_379.CREATOR);
                    break;
                case 15:
                    var17 = class_824.method_4357(var1, var20);
                    break;
                case 16:
                    var18 = class_824.method_4356(var1, var20);
                    break;
                case 17:
                    var19 = (class_536)class_824.method_4336(var1, var20, class_536.CREATOR);
                    break;
                default:
                    class_824.method_4341(var1, var20);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new class_469(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19);
        }
    }

    // $FF: renamed from: m (int) com.google.android.gms.internal.dm[]
    public class_469[] method_2870(int var1) {
        return new class_469[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_2870(var1);
    }
}

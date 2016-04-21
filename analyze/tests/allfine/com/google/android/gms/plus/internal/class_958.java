package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.class_959;
import com.google.android.gms.plus.internal.h;

// $FF: renamed from: com.google.android.gms.plus.internal.j
public class class_958 implements Creator<h> {
    // $FF: renamed from: a (com.google.android.gms.plus.internal.h, android.os.Parcel, int) void
    static void method_5059(class_959 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4313(var1, 1, var0.getAccountName(), false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4320(var1, 2, var0.method_5062(), false);
        class_823.method_4320(var1, 3, var0.method_5063(), false);
        class_823.method_4320(var1, 4, var0.method_5064(), false);
        class_823.method_4313(var1, 5, var0.method_5065(), false);
        class_823.method_4313(var1, 6, var0.method_5066(), false);
        class_823.method_4313(var1, 7, var0.method_5067(), false);
        class_823.method_4313(var1, 8, var0.method_5068(), false);
        class_823.method_4309(var1, 9, var0.method_5069(), var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5060(var1);
    }

    // $FF: renamed from: da (android.os.Parcel) com.google.android.gms.plus.internal.h
    public class_959 method_5060(Parcel var1) {
        PlusCommonExtras var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        String var5 = null;
        String var6 = null;
        String var7 = null;
        String var8 = null;
        String[] var9 = null;
        String[] var10 = null;
        String[] var11 = null;
        String var12 = null;

        while(var1.dataPosition() < var3) {
            int var13 = class_824.method_4329(var1);
            switch(class_824.method_4340(var13)) {
                case 1:
                    var12 = class_824.method_4356(var1, var13);
                    break;
                case 2:
                    var11 = class_824.method_4328(var1, var13);
                    break;
                case 3:
                    var10 = class_824.method_4328(var1, var13);
                    break;
                case 4:
                    var9 = class_824.method_4328(var1, var13);
                    break;
                case 5:
                    var8 = class_824.method_4356(var1, var13);
                    break;
                case 6:
                    var7 = class_824.method_4356(var1, var13);
                    break;
                case 7:
                    var6 = class_824.method_4356(var1, var13);
                    break;
                case 8:
                    var5 = class_824.method_4356(var1, var13);
                    break;
                case 9:
                    var2 = (PlusCommonExtras)class_824.method_4336(var1, var13, PlusCommonExtras.CREATOR);
                    break;
                case 1000:
                    var4 = class_824.method_4348(var1, var13);
                    break;
                default:
                    class_824.method_4341(var1, var13);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_959(var4, var12, var11, var10, var9, var8, var7, var6, var5, var2);
        }
    }

    // $FF: renamed from: eS (int) com.google.android.gms.plus.internal.h[]
    public class_959[] method_5061(int var1) {
        return new class_959[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5061(var1);
    }
}

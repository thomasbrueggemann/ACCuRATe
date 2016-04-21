package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_223;
import com.google.android.gms.internal.class_242;
import com.google.android.gms.internal.class_379;
import com.google.android.gms.internal.class_448;
import com.google.android.gms.internal.fi;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.fj
public class class_446 implements Creator<fi> {
    // $FF: renamed from: a (com.google.android.gms.internal.fi, android.os.Parcel, int) void
    static void method_2801(class_448 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.versionCode);
        class_823.method_4306(var1, 2, var0.field_1721, false);
        class_823.method_4309(var1, 3, var0.field_1722, var2, false);
        class_823.method_4309(var1, 4, var0.field_1713, var2, false);
        class_823.method_4313(var1, 5, var0.field_1711, false);
        class_823.method_4309(var1, 6, var0.applicationInfo, var2, false);
        class_823.method_4309(var1, 7, var0.field_1723, var2, false);
        class_823.method_4313(var1, 8, var0.field_1724, false);
        class_823.method_4313(var1, 9, var0.field_1715, false);
        class_823.method_4313(var1, 10, var0.field_1716, false);
        class_823.method_4309(var1, 11, var0.field_1712, var2, false);
        class_823.method_4306(var1, 12, var0.field_1717, false);
        class_823.method_4325(var1, 13, var0.field_1718);
        class_823.method_4324(var1, 14, var0.field_1714, false);
        class_823.method_4306(var1, 15, var0.field_1719, false);
        class_823.method_4316(var1, 16, var0.field_1720);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_2802(var1);
    }

    // $FF: renamed from: h (android.os.Parcel) com.google.android.gms.internal.fi
    public class_448 method_2802(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        Bundle var4 = null;
        class_223 var5 = null;
        class_242 var6 = null;
        String var7 = null;
        ApplicationInfo var8 = null;
        PackageInfo var9 = null;
        String var10 = null;
        String var11 = null;
        String var12 = null;
        class_379 var13 = null;
        Bundle var14 = null;
        int var15 = 0;
        ArrayList var16 = null;
        Bundle var17 = null;
        boolean var18 = false;

        while(var1.dataPosition() < var2) {
            int var19 = class_824.method_4329(var1);
            switch(class_824.method_4340(var19)) {
                case 1:
                    var3 = class_824.method_4348(var1, var19);
                    break;
                case 2:
                    var4 = class_824.method_4358(var1, var19);
                    break;
                case 3:
                    var5 = (class_223)class_824.method_4336(var1, var19, class_223.CREATOR);
                    break;
                case 4:
                    var6 = (class_242)class_824.method_4336(var1, var19, class_242.CREATOR);
                    break;
                case 5:
                    var7 = class_824.method_4356(var1, var19);
                    break;
                case 6:
                    var8 = (ApplicationInfo)class_824.method_4336(var1, var19, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    var9 = (PackageInfo)class_824.method_4336(var1, var19, PackageInfo.CREATOR);
                    break;
                case 8:
                    var10 = class_824.method_4356(var1, var19);
                    break;
                case 9:
                    var11 = class_824.method_4356(var1, var19);
                    break;
                case 10:
                    var12 = class_824.method_4356(var1, var19);
                    break;
                case 11:
                    var13 = (class_379)class_824.method_4336(var1, var19, class_379.CREATOR);
                    break;
                case 12:
                    var14 = class_824.method_4358(var1, var19);
                    break;
                case 13:
                    var15 = class_824.method_4348(var1, var19);
                    break;
                case 14:
                    var16 = class_824.method_4332(var1, var19);
                    break;
                case 15:
                    var17 = class_824.method_4358(var1, var19);
                    break;
                case 16:
                    var18 = class_824.method_4344(var1, var19);
                    break;
                default:
                    class_824.method_4341(var1, var19);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new class_448(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18);
        }
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_2803(var1);
    }

    // $FF: renamed from: p (int) com.google.android.gms.internal.fi[]
    public class_448[] method_2803(int var1) {
        return new class_448[var1];
    }
}

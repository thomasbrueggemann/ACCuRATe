package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.class_223;
import com.google.android.gms.internal.class_249;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.aw
public class class_214 implements Creator<av> {
    // $FF: renamed from: a (com.google.android.gms.internal.av, android.os.Parcel, int) void
    static void method_1500(class_223 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.versionCode);
        class_823.method_4305(var1, 2, var0.field_550);
        class_823.method_4306(var1, 3, var0.extras, false);
        class_823.method_4325(var1, 4, var0.field_551);
        class_823.method_4324(var1, 5, var0.field_552, false);
        class_823.method_4316(var1, 6, var0.field_553);
        class_823.method_4325(var1, 7, var0.field_554);
        class_823.method_4316(var1, 8, var0.field_555);
        class_823.method_4313(var1, 9, var0.field_556, false);
        class_823.method_4309(var1, 10, var0.field_557, var2, false);
        class_823.method_4309(var1, 11, var0.field_558, var2, false);
        class_823.method_4313(var1, 12, var0.field_559, false);
        class_823.method_4306(var1, 13, var0.field_560, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: b (android.os.Parcel) com.google.android.gms.internal.av
    public class_223 method_1501(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        long var4 = 0L;
        Bundle var6 = null;
        int var7 = 0;
        ArrayList var8 = null;
        boolean var9 = false;
        int var10 = 0;
        boolean var11 = false;
        String var12 = null;
        class_249 var13 = null;
        Location var14 = null;
        String var15 = null;
        Bundle var16 = null;

        while(var1.dataPosition() < var2) {
            int var17 = class_824.method_4329(var1);
            switch(class_824.method_4340(var17)) {
                case 1:
                    var3 = class_824.method_4348(var1, var17);
                    break;
                case 2:
                    var4 = class_824.method_4350(var1, var17);
                    break;
                case 3:
                    var6 = class_824.method_4358(var1, var17);
                    break;
                case 4:
                    var7 = class_824.method_4348(var1, var17);
                    break;
                case 5:
                    var8 = class_824.method_4332(var1, var17);
                    break;
                case 6:
                    var9 = class_824.method_4344(var1, var17);
                    break;
                case 7:
                    var10 = class_824.method_4348(var1, var17);
                    break;
                case 8:
                    var11 = class_824.method_4344(var1, var17);
                    break;
                case 9:
                    var12 = class_824.method_4356(var1, var17);
                    break;
                case 10:
                    var13 = (class_249)class_824.method_4336(var1, var17, class_249.CREATOR);
                    break;
                case 11:
                    var14 = (Location)class_824.method_4336(var1, var17, Location.CREATOR);
                    break;
                case 12:
                    var15 = class_824.method_4356(var1, var17);
                    break;
                case 13:
                    var16 = class_824.method_4358(var1, var17);
                    break;
                default:
                    class_824.method_4341(var1, var17);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new class_223(var3, var4, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_1501(var1);
    }

    // $FF: renamed from: e (int) com.google.android.gms.internal.av[]
    public class_223[] method_1502(int var1) {
        return new class_223[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_1502(var1);
    }
}

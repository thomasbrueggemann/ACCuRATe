package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_397;
import com.google.android.gms.internal.class_411;
import com.google.android.gms.internal.class_413;
import com.google.android.gms.internal.hs;

// $FF: renamed from: com.google.android.gms.internal.ht
public class class_400 implements Creator<hs> {
    // $FF: renamed from: a (com.google.android.gms.internal.hs, android.os.Parcel, int) void
    static void method_2626(class_397 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4309(var1, 1, var0.field_1480, var2, false);
        class_823.method_4325(var1, 1000, var0.field_1479);
        class_823.method_4305(var1, 2, var0.field_1481);
        class_823.method_4325(var1, 3, var0.field_1482);
        class_823.method_4313(var1, 4, var0.field_1484, false);
        class_823.method_4309(var1, 5, var0.field_1483, var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: R (int) com.google.android.gms.internal.hs[]
    public class_397[] method_2627(int var1) {
        return new class_397[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_2628(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_2627(var1);
    }

    // $FF: renamed from: s (android.os.Parcel) com.google.android.gms.internal.hs
    public class_397 method_2628(Parcel var1) {
        int var2 = 0;
        class_413 var3 = null;
        int var4 = class_824.method_4331(var1);
        long var5 = 0L;
        String var7 = null;
        class_411 var8 = null;
        int var9 = 0;

        while(var1.dataPosition() < var4) {
            int var10 = class_824.method_4329(var1);
            switch(class_824.method_4340(var10)) {
                case 1:
                    var8 = (class_411)class_824.method_4336(var1, var10, class_411.CREATOR);
                    break;
                case 2:
                    var5 = class_824.method_4350(var1, var10);
                    break;
                case 3:
                    var2 = class_824.method_4348(var1, var10);
                    break;
                case 4:
                    var7 = class_824.method_4356(var1, var10);
                    break;
                case 5:
                    var3 = (class_413)class_824.method_4336(var1, var10, class_413.CREATOR);
                    break;
                case 1000:
                    var9 = class_824.method_4348(var1, var10);
                    break;
                default:
                    class_824.method_4341(var1, var10);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new class_397(var9, var8, var5, var2, var7, var3);
        }
    }
}

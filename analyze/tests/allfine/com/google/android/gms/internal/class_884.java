package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_887;
import com.google.android.gms.internal.class_898;
import com.google.android.gms.internal.mn;

// $FF: renamed from: com.google.android.gms.internal.mo
public class class_884 implements Creator<mn> {
    // $FF: renamed from: a (com.google.android.gms.internal.mn, android.os.Parcel, int) void
    static void method_4561(class_887 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1000, var0.field_4206);
        class_823.method_4309(var1, 2, var0.method_4568(), var2, false);
        class_823.method_4305(var1, 3, var0.getInterval());
        class_823.method_4325(var1, 4, var0.getPriority());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: cB (android.os.Parcel) com.google.android.gms.internal.mn
    public class_887 method_4562(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        class_898 var4 = null;
        long var5 = class_887.afA;
        int var7 = 102;

        while(var1.dataPosition() < var2) {
            int var8 = class_824.method_4329(var1);
            switch(class_824.method_4340(var8)) {
                case 2:
                    var4 = (class_898)class_824.method_4336(var1, var8, class_898.CREATOR);
                    break;
                case 3:
                    var5 = class_824.method_4350(var1, var8);
                    break;
                case 4:
                    var7 = class_824.method_4348(var1, var8);
                    break;
                case 1000:
                    var3 = class_824.method_4348(var1, var8);
                    break;
                default:
                    class_824.method_4341(var1, var8);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new class_887(var3, var4, var5, var7);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_4562(var1);
    }

    // $FF: renamed from: er (int) com.google.android.gms.internal.mn[]
    public class_887[] method_4563(int var1) {
        return new class_887[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_4563(var1);
    }
}

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_399;
import com.google.android.gms.internal.class_403;
import com.google.android.gms.internal.hi;

// $FF: renamed from: com.google.android.gms.internal.hj
public class class_402 implements Creator<hi> {
    // $FF: renamed from: a (com.google.android.gms.internal.hi, android.os.Parcel, int) void
    static void method_2632(class_403 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4313(var1, 1, var0.field_1501, false);
        class_823.method_4325(var1, 1000, var0.field_1500);
        class_823.method_4309(var1, 3, var0.field_1502, var2, false);
        class_823.method_4325(var1, 4, var0.field_1503);
        class_823.method_4317(var1, 5, var0.field_1504, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: K (int) com.google.android.gms.internal.hi[]
    public class_403[] method_2633(int var1) {
        return new class_403[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_2634(var1);
    }

    // $FF: renamed from: n (android.os.Parcel) com.google.android.gms.internal.hi
    public class_403 method_2634(Parcel var1) {
        byte[] var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        int var5 = -1;
        class_399 var6 = null;
        String var7 = null;

        while(var1.dataPosition() < var3) {
            int var8 = class_824.method_4329(var1);
            switch(class_824.method_4340(var8)) {
                case 1:
                    var7 = class_824.method_4356(var1, var8);
                    break;
                case 3:
                    var6 = (class_399)class_824.method_4336(var1, var8, class_399.CREATOR);
                    break;
                case 4:
                    var5 = class_824.method_4348(var1, var8);
                    break;
                case 5:
                    var2 = class_824.method_4359(var1, var8);
                    break;
                case 1000:
                    var4 = class_824.method_4348(var1, var8);
                    break;
                default:
                    class_824.method_4341(var1, var8);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_403(var4, var7, var6, var5, var2);
        }
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_2633(var1);
    }
}

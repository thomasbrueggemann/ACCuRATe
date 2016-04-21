package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_893;
import com.google.android.gms.internal.class_898;
import com.google.android.gms.internal.mh;

// $FF: renamed from: com.google.android.gms.internal.mi
public class class_897 implements Creator<mh> {
    // $FF: renamed from: a (com.google.android.gms.internal.mh, android.os.Parcel, int) void
    static void method_4591(class_893 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.method_4582());
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4325(var1, 2, var0.method_4583());
        class_823.method_4309(var1, 3, var0.method_4584(), var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_4592(var1);
    }

    // $FF: renamed from: cy (android.os.Parcel) com.google.android.gms.internal.mh
    public class_893 method_4592(Parcel var1) {
        int var2 = 0;
        int var3 = class_824.method_4331(var1);
        int var4 = -1;
        class_898 var5 = null;
        int var6 = 0;

        while(var1.dataPosition() < var3) {
            int var7 = class_824.method_4329(var1);
            switch(class_824.method_4340(var7)) {
                case 1:
                    var2 = class_824.method_4348(var1, var7);
                    break;
                case 2:
                    var4 = class_824.method_4348(var1, var7);
                    break;
                case 3:
                    var5 = (class_898)class_824.method_4336(var1, var7, class_898.CREATOR);
                    break;
                case 1000:
                    var6 = class_824.method_4348(var1, var7);
                    break;
                default:
                    class_824.method_4341(var1, var7);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_893(var6, var2, var4, var5);
        }
    }

    // $FF: renamed from: eo (int) com.google.android.gms.internal.mh[]
    public class_893[] method_4593(int var1) {
        return new class_893[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_4593(var1);
    }
}

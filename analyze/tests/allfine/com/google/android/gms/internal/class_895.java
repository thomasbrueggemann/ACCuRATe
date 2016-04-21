package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_885;
import com.google.android.gms.internal.class_889;
import com.google.android.gms.internal.class_898;
import com.google.android.gms.internal.mj;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.mk
public class class_895 implements Creator<mj> {
    // $FF: renamed from: a (com.google.android.gms.internal.mj, android.os.Parcel, int) void
    static void method_4587(class_898 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4326(var1, 1, var0.afr, false);
        class_823.method_4325(var1, 1000, var0.field_4214);
        class_823.method_4313(var1, 2, var0.method_4595(), false);
        class_823.method_4316(var1, 3, var0.method_4596());
        class_823.method_4326(var1, 4, var0.afu, false);
        class_823.method_4324(var1, 6, var0.afv, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_4588(var1);
    }

    // $FF: renamed from: cz (android.os.Parcel) com.google.android.gms.internal.mj
    public class_898 method_4588(Parcel var1) {
        boolean var2 = false;
        ArrayList var3 = null;
        int var4 = class_824.method_4331(var1);
        ArrayList var5 = null;
        String var6 = null;
        ArrayList var7 = null;
        int var8 = 0;

        while(var1.dataPosition() < var4) {
            int var9 = class_824.method_4329(var1);
            switch(class_824.method_4340(var9)) {
                case 1:
                    var7 = class_824.method_4343(var1, var9, class_885.CREATOR);
                    break;
                case 2:
                    var6 = class_824.method_4356(var1, var9);
                    break;
                case 3:
                    var2 = class_824.method_4344(var1, var9);
                    break;
                case 4:
                    var5 = class_824.method_4343(var1, var9, class_889.CREATOR);
                    break;
                case 6:
                    var3 = class_824.method_4332(var1, var9);
                    break;
                case 1000:
                    var8 = class_824.method_4348(var1, var9);
                    break;
                default:
                    class_824.method_4341(var1, var9);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new class_898(var8, var7, var6, var2, var5, var3);
        }
    }

    // $FF: renamed from: ep (int) com.google.android.gms.internal.mj[]
    public class_898[] method_4589(int var1) {
        return new class_898[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_4589(var1);
    }
}

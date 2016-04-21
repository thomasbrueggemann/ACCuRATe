package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_348;
import com.google.android.gms.wallet.wobs.class_701;
import com.google.android.gms.wallet.wobs.class_703;
import com.google.android.gms.wallet.wobs.d;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.wallet.wobs.e
public class class_702 implements Creator<d> {
    // $FF: renamed from: a (com.google.android.gms.wallet.wobs.d, android.os.Parcel, int) void
    static void method_3842(class_703 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4313(var1, 2, var0.auz, false);
        class_823.method_4313(var1, 3, var0.auA, false);
        class_823.method_4326(var1, 4, var0.auB, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3843(var1);
    }

    // $FF: renamed from: dI (android.os.Parcel) com.google.android.gms.wallet.wobs.d
    public class_703 method_3843(Parcel var1) {
        String var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        ArrayList var5 = class_348.method_2342();
        String var6 = null;

        while(var1.dataPosition() < var3) {
            int var7 = class_824.method_4329(var1);
            switch(class_824.method_4340(var7)) {
                case 1:
                    var4 = class_824.method_4348(var1, var7);
                    break;
                case 2:
                    var6 = class_824.method_4356(var1, var7);
                    break;
                case 3:
                    var2 = class_824.method_4356(var1, var7);
                    break;
                case 4:
                    var5 = class_824.method_4343(var1, var7, class_701.CREATOR);
                    break;
                default:
                    class_824.method_4341(var1, var7);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_703(var4, var6, var2, var5);
        }
    }

    // $FF: renamed from: fL (int) com.google.android.gms.wallet.wobs.d[]
    public class_703[] method_3844(int var1) {
        return new class_703[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3844(var1);
    }
}

package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.wallet.wobs.class_705;
import com.google.android.gms.wallet.wobs.class_707;
import com.google.android.gms.wallet.wobs.class_711;
import com.google.android.gms.wallet.wobs.p;

// $FF: renamed from: com.google.android.gms.wallet.wobs.q
public class class_708 implements Creator<p> {
    // $FF: renamed from: a (com.google.android.gms.wallet.wobs.p, android.os.Parcel, int) void
    static void method_3857(class_707 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4313(var1, 2, var0.auJ, false);
        class_823.method_4313(var1, 3, var0.field_3413, false);
        class_823.method_4309(var1, 4, var0.auN, var2, false);
        class_823.method_4309(var1, 5, var0.auO, var2, false);
        class_823.method_4309(var1, 6, var0.auP, var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3858(var1);
    }

    // $FF: renamed from: dO (android.os.Parcel) com.google.android.gms.wallet.wobs.p
    public class_707 method_3858(Parcel var1) {
        class_705 var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        class_705 var5 = null;
        class_711 var6 = null;
        String var7 = null;
        String var8 = null;

        while(var1.dataPosition() < var3) {
            int var9 = class_824.method_4329(var1);
            switch(class_824.method_4340(var9)) {
                case 1:
                    var4 = class_824.method_4348(var1, var9);
                    break;
                case 2:
                    var8 = class_824.method_4356(var1, var9);
                    break;
                case 3:
                    var7 = class_824.method_4356(var1, var9);
                    break;
                case 4:
                    var6 = (class_711)class_824.method_4336(var1, var9, class_711.CREATOR);
                    break;
                case 5:
                    var5 = (class_705)class_824.method_4336(var1, var9, class_705.CREATOR);
                    break;
                case 6:
                    var2 = (class_705)class_824.method_4336(var1, var9, class_705.CREATOR);
                    break;
                default:
                    class_824.method_4341(var1, var9);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_707(var4, var8, var7, var6, var5, var2);
        }
    }

    // $FF: renamed from: fR (int) com.google.android.gms.wallet.wobs.p[]
    public class_707[] method_3859(int var1) {
        return new class_707[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3859(var1);
    }
}

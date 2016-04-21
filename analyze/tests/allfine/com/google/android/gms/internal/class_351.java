package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_269;
import com.google.android.gms.internal.class_354;
import com.google.android.gms.internal.jp;

// $FF: renamed from: com.google.android.gms.internal.jq
public class class_351 implements Creator<jp> {
    // $FF: renamed from: a (com.google.android.gms.internal.jp, android.os.Parcel, int) void
    static void method_2346(class_269 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4308(var1, 2, var0.method_1712(), false);
        class_823.method_4309(var1, 3, var0.method_1713(), var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: M (android.os.Parcel) com.google.android.gms.internal.jp
    public class_269 method_2347(Parcel var1) {
        class_354 var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        Parcel var5 = null;

        while(var1.dataPosition() < var3) {
            int var6 = class_824.method_4329(var1);
            switch(class_824.method_4340(var6)) {
                case 1:
                    var4 = class_824.method_4348(var1, var6);
                    break;
                case 2:
                    var5 = class_824.method_4333(var1, var6);
                    break;
                case 3:
                    var2 = (class_354)class_824.method_4336(var1, var6, class_354.CREATOR);
                    break;
                default:
                    class_824.method_4341(var1, var6);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_269(var4, var5, var2);
        }
    }

    // $FF: renamed from: aM (int) com.google.android.gms.internal.jp[]
    public class_269[] method_2348(int var1) {
        return new class_269[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_2347(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_2348(var1);
    }
}

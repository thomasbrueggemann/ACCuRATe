package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_835;
import com.google.android.gms.internal.ls;

// $FF: renamed from: com.google.android.gms.internal.lt
public class class_831 implements Creator<ls> {
    // $FF: renamed from: a (com.google.android.gms.internal.ls, android.os.Parcel, int) void
    static void method_4453(class_835 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.uid);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4313(var1, 2, var0.packageName, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_4454(var1);
    }

    // $FF: renamed from: cu (android.os.Parcel) com.google.android.gms.internal.ls
    public class_835 method_4454(Parcel var1) {
        int var2 = 0;
        int var3 = class_824.method_4331(var1);
        String var4 = null;
        int var5 = 0;

        while(var1.dataPosition() < var3) {
            int var6 = class_824.method_4329(var1);
            switch(class_824.method_4340(var6)) {
                case 1:
                    var2 = class_824.method_4348(var1, var6);
                    break;
                case 2:
                    var4 = class_824.method_4356(var1, var6);
                    break;
                case 1000:
                    var5 = class_824.method_4348(var1, var6);
                    break;
                default:
                    class_824.method_4341(var1, var6);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_835(var5, var2, var4);
        }
    }

    // $FF: renamed from: ei (int) com.google.android.gms.internal.ls[]
    public class_835[] method_4455(int var1) {
        return new class_835[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_4455(var1);
    }
}

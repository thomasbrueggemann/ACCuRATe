package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.internal.class_837;
import com.google.android.gms.internal.li;

// $FF: renamed from: com.google.android.gms.internal.lj
public class class_838 implements Creator<li> {
    // $FF: renamed from: a (com.google.android.gms.internal.li, android.os.Parcel, int) void
    static void method_4460(class_837 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4309(var1, 1, var0.getDataSource(), var2, false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bz (android.os.Parcel) com.google.android.gms.internal.li
    public class_837 method_4461(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        DataSource var4 = null;

        while(var1.dataPosition() < var2) {
            int var5 = class_824.method_4329(var1);
            switch(class_824.method_4340(var5)) {
                case 1:
                    var4 = (DataSource)class_824.method_4336(var1, var5, DataSource.CREATOR);
                    break;
                case 1000:
                    var3 = class_824.method_4348(var1, var5);
                    break;
                default:
                    class_824.method_4341(var1, var5);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new class_837(var3, var4);
        }
    }

    // $FF: renamed from: cQ (int) com.google.android.gms.internal.li[]
    public class_837[] method_4462(int var1) {
        return new class_837[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_4461(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_4462(var1);
    }
}

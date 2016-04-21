package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.class_522;
import com.google.android.gms.fitness.request.w;

// $FF: renamed from: com.google.android.gms.fitness.request.x
public class class_521 implements Creator<w> {
    // $FF: renamed from: a (com.google.android.gms.fitness.request.w, android.os.Parcel, int) void
    static void method_3157(class_522 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4309(var1, 1, var0.getSession(), var2, false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bN (android.os.Parcel) com.google.android.gms.fitness.request.w
    public class_522 method_3158(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        Session var4 = null;

        while(var1.dataPosition() < var2) {
            int var5 = class_824.method_4329(var1);
            switch(class_824.method_4340(var5)) {
                case 1:
                    var4 = (Session)class_824.method_4336(var1, var5, Session.CREATOR);
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
            return new class_522(var3, var4);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3158(var1);
    }

    // $FF: renamed from: df (int) com.google.android.gms.fitness.request.w[]
    public class_522[] method_3159(int var1) {
        return new class_522[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3159(var1);
    }
}

package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.af;
import com.google.android.gms.fitness.request.class_498;

// $FF: renamed from: com.google.android.gms.fitness.request.ag
public class class_499 implements Creator<af> {
    // $FF: renamed from: a (com.google.android.gms.fitness.request.af, android.os.Parcel, int) void
    static void method_3047(class_498 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4309(var1, 1, var0.method_3045(), var2, false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4316(var1, 2, var0.method_3046());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bS (android.os.Parcel) com.google.android.gms.fitness.request.af
    public class_498 method_3048(Parcel var1) {
        boolean var2 = false;
        int var3 = class_824.method_4331(var1);
        Subscription var4 = null;

        int var5;
        boolean var7;
        for(var5 = 0; var1.dataPosition() < var3; var2 = var7) {
            int var6 = class_824.method_4329(var1);
            Subscription var8;
            int var9;
            switch(class_824.method_4340(var6)) {
                case 1:
                    Subscription var12 = (Subscription)class_824.method_4336(var1, var6, Subscription.CREATOR);
                    var9 = var5;
                    var7 = var2;
                    var8 = var12;
                    break;
                case 2:
                    var7 = class_824.method_4344(var1, var6);
                    var8 = var4;
                    var9 = var5;
                    break;
                case 1000:
                    int var10 = class_824.method_4348(var1, var6);
                    var8 = var4;
                    var9 = var10;
                    var7 = var2;
                    break;
                default:
                    class_824.method_4341(var1, var6);
                    var7 = var2;
                    var8 = var4;
                    var9 = var5;
            }

            var5 = var9;
            var4 = var8;
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_498(var5, var4, var2);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3048(var1);
    }

    // $FF: renamed from: dk (int) com.google.android.gms.fitness.request.af[]
    public class_498[] method_3049(int var1) {
        return new class_498[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3049(var1);
    }
}

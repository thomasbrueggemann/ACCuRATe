package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.request.class_528;
import com.google.android.gms.fitness.request.q;

// $FF: renamed from: com.google.android.gms.fitness.request.r
public class class_527 implements Creator<q> {
    // $FF: renamed from: a (com.google.android.gms.fitness.request.q, android.os.Parcel, int) void
    static void method_3172(class_528 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4307(var1, 1, var0.method_3176(), false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4309(var1, 2, var0.method_3175(), var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bJ (android.os.Parcel) com.google.android.gms.fitness.request.q
    public class_528 method_3173(Parcel var1) {
        PendingIntent var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        IBinder var5 = null;

        while(var1.dataPosition() < var3) {
            int var6 = class_824.method_4329(var1);
            switch(class_824.method_4340(var6)) {
                case 1:
                    var5 = class_824.method_4357(var1, var6);
                    break;
                case 2:
                    var2 = (PendingIntent)class_824.method_4336(var1, var6, PendingIntent.CREATOR);
                    break;
                case 1000:
                    var4 = class_824.method_4348(var1, var6);
                    break;
                default:
                    class_824.method_4341(var1, var6);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_528(var4, var5, var2);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3173(var1);
    }

    // $FF: renamed from: db (int) com.google.android.gms.fitness.request.q[]
    public class_528[] method_3174(int var1) {
        return new class_528[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3174(var1);
    }
}

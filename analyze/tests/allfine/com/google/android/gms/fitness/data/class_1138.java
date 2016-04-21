package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.class_1141;

// $FF: renamed from: com.google.android.gms.fitness.data.p
public class class_1138 implements Creator<Session> {
    // $FF: renamed from: a (com.google.android.gms.fitness.data.Session, android.os.Parcel, int) void
    static void method_5903(Session var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4305(var1, 1, var0.method_5847());
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4305(var1, 2, var0.method_5848());
        class_823.method_4313(var1, 3, var0.getName(), false);
        class_823.method_4313(var1, 4, var0.getIdentifier(), false);
        class_823.method_4313(var1, 5, var0.getDescription(), false);
        class_823.method_4325(var1, 7, var0.method_5846());
        class_823.method_4309(var1, 8, var0.method_5849(), var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bu (android.os.Parcel) com.google.android.gms.fitness.data.Session
    public Session method_5904(Parcel var1) {
        long var2 = 0L;
        int var4 = 0;
        class_1141 var5 = null;
        int var6 = class_824.method_4331(var1);
        String var7 = null;
        String var8 = null;
        String var9 = null;
        long var10 = var2;
        int var12 = 0;

        while(var1.dataPosition() < var6) {
            int var13 = class_824.method_4329(var1);
            switch(class_824.method_4340(var13)) {
                case 1:
                    var10 = class_824.method_4350(var1, var13);
                    break;
                case 2:
                    var2 = class_824.method_4350(var1, var13);
                    break;
                case 3:
                    var9 = class_824.method_4356(var1, var13);
                    break;
                case 4:
                    var8 = class_824.method_4356(var1, var13);
                    break;
                case 5:
                    var7 = class_824.method_4356(var1, var13);
                    break;
                case 7:
                    var4 = class_824.method_4348(var1, var13);
                    break;
                case 8:
                    var5 = (class_1141)class_824.method_4336(var1, var13, class_1141.CREATOR);
                    break;
                case 1000:
                    var12 = class_824.method_4348(var1, var13);
                    break;
                default:
                    class_824.method_4341(var1, var13);
            }
        }

        if(var1.dataPosition() != var6) {
            throw new class_824.class_1307("Overread allowed size end=" + var6, var1);
        } else {
            return new Session(var12, var10, var2, var9, var8, var7, var4, var5);
        }
    }

    // $FF: renamed from: cL (int) com.google.android.gms.fitness.data.Session[]
    public Session[] method_5905(int var1) {
        return new Session[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5904(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5905(var1);
    }
}

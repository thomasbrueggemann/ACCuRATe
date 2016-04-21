package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.class_1137;
import com.google.android.gms.fitness.data.q;

// $FF: renamed from: com.google.android.gms.fitness.data.r
public class class_1136 implements Creator<q> {
    // $FF: renamed from: a (com.google.android.gms.fitness.data.q, android.os.Parcel, int) void
    static void method_5898(class_1137 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4309(var1, 1, var0.getSession(), var2, false);
        class_823.method_4325(var1, 1000, var0.field_5244);
        class_823.method_4309(var1, 2, var0.method_5902(), var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bv (android.os.Parcel) com.google.android.gms.fitness.data.q
    public class_1137 method_5899(Parcel var1) {
        DataSet var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;

        Session var5;
        DataSet var7;
        for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
            int var6 = class_824.method_4329(var1);
            Session var8;
            int var9;
            switch(class_824.method_4340(var6)) {
                case 1:
                    Session var12 = (Session)class_824.method_4336(var1, var6, Session.CREATOR);
                    var9 = var4;
                    var7 = var2;
                    var8 = var12;
                    break;
                case 2:
                    var7 = (DataSet)class_824.method_4336(var1, var6, DataSet.CREATOR);
                    var8 = var5;
                    var9 = var4;
                    break;
                case 1000:
                    int var10 = class_824.method_4348(var1, var6);
                    var8 = var5;
                    var9 = var10;
                    var7 = var2;
                    break;
                default:
                    class_824.method_4341(var1, var6);
                    var7 = var2;
                    var8 = var5;
                    var9 = var4;
            }

            var4 = var9;
            var5 = var8;
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_1137(var4, var5, var2);
        }
    }

    // $FF: renamed from: cM (int) com.google.android.gms.fitness.data.q[]
    public class_1137[] method_5900(int var1) {
        return new class_1137[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5899(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5900(var1);
    }
}

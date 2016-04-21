package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.wearable.internal.class_993;
import com.google.android.gms.wearable.internal.m;

// $FF: renamed from: com.google.android.gms.wearable.internal.n
public class class_998 implements Creator<m> {
    // $FF: renamed from: a (com.google.android.gms.wearable.internal.m, android.os.Parcel, int) void
    static void method_5228(class_993 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_4580);
        class_823.method_4309(var1, 2, var0.getUri(), var2, false);
        class_823.method_4306(var1, 4, var0.method_5212(), false);
        class_823.method_4317(var1, 5, var0.getData(), false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5229(var1);
    }

    // $FF: renamed from: dU (android.os.Parcel) com.google.android.gms.wearable.internal.m
    public class_993 method_5229(Parcel var1) {
        byte[] var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        Bundle var5 = null;

        Uri var6;
        byte[] var8;
        for(var6 = null; var1.dataPosition() < var3; var2 = var8) {
            int var7 = class_824.method_4329(var1);
            Bundle var9;
            Uri var10;
            int var11;
            switch(class_824.method_4340(var7)) {
                case 1:
                    int var16 = class_824.method_4348(var1, var7);
                    var9 = var5;
                    var10 = var6;
                    var11 = var16;
                    var8 = var2;
                    break;
                case 2:
                    Uri var14 = (Uri)class_824.method_4336(var1, var7, Uri.CREATOR);
                    var11 = var4;
                    var10 = var14;
                    var8 = var2;
                    var9 = var5;
                    break;
                case 3:
                default:
                    class_824.method_4341(var1, var7);
                    var8 = var2;
                    var9 = var5;
                    var10 = var6;
                    var11 = var4;
                    break;
                case 4:
                    Bundle var12 = class_824.method_4358(var1, var7);
                    var10 = var6;
                    var11 = var4;
                    var9 = var12;
                    var8 = var2;
                    break;
                case 5:
                    var8 = class_824.method_4359(var1, var7);
                    var9 = var5;
                    var10 = var6;
                    var11 = var4;
            }

            var4 = var11;
            var6 = var10;
            var5 = var9;
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_993(var4, var6, var5, var2);
        }
    }

    // $FF: renamed from: fX (int) com.google.android.gms.wearable.internal.m[]
    public class_993[] method_5230(int var1) {
        return new class_993[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5230(var1);
    }
}

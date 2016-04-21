package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.OpenContentsRequest;

// $FF: renamed from: com.google.android.gms.drive.internal.au
public class class_1104 implements Creator<OpenContentsRequest> {
    // $FF: renamed from: a (com.google.android.gms.drive.internal.OpenContentsRequest, android.os.Parcel, int) void
    static void method_5736(OpenContentsRequest var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_5323);
        class_823.method_4309(var1, 2, var0.field_5325, var2, false);
        class_823.method_4325(var1, 3, var0.field_5324);
        class_823.method_4325(var1, 4, var0.field_5326);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: aw (android.os.Parcel) com.google.android.gms.drive.internal.OpenContentsRequest
    public OpenContentsRequest method_5737(Parcel var1) {
        int var2 = 0;
        int var3 = class_824.method_4331(var1);
        DriveId var4 = null;
        int var5 = 0;

        int var6;
        int var8;
        for(var6 = 0; var1.dataPosition() < var3; var2 = var8) {
            int var7 = class_824.method_4329(var1);
            int var9;
            DriveId var10;
            int var11;
            switch(class_824.method_4340(var7)) {
                case 1:
                    int var16 = class_824.method_4348(var1, var7);
                    var9 = var5;
                    var10 = var4;
                    var11 = var16;
                    var8 = var2;
                    break;
                case 2:
                    DriveId var14 = (DriveId)class_824.method_4336(var1, var7, DriveId.CREATOR);
                    var11 = var6;
                    var10 = var14;
                    var8 = var2;
                    var9 = var5;
                    break;
                case 3:
                    int var12 = class_824.method_4348(var1, var7);
                    var10 = var4;
                    var11 = var6;
                    var9 = var12;
                    var8 = var2;
                    break;
                case 4:
                    var8 = class_824.method_4348(var1, var7);
                    var9 = var5;
                    var10 = var4;
                    var11 = var6;
                    break;
                default:
                    class_824.method_4341(var1, var7);
                    var8 = var2;
                    var9 = var5;
                    var10 = var4;
                    var11 = var6;
            }

            var6 = var11;
            var4 = var10;
            var5 = var9;
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new OpenContentsRequest(var6, var4, var5, var2);
        }
    }

    // $FF: renamed from: bI (int) com.google.android.gms.drive.internal.OpenContentsRequest[]
    public OpenContentsRequest[] method_5738(int var1) {
        return new OpenContentsRequest[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5737(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5738(var1);
    }
}

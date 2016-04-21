package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.SetResourceParentsRequest;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.drive.internal.ba
public class class_1121 implements Creator<SetResourceParentsRequest> {
    // $FF: renamed from: a (com.google.android.gms.drive.internal.SetResourceParentsRequest, android.os.Parcel, int) void
    static void method_5792(SetResourceParentsRequest var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_4030);
        class_823.method_4309(var1, 2, var0.field_4032, var2, false);
        class_823.method_4326(var1, 3, var0.field_4031, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: aB (android.os.Parcel) com.google.android.gms.drive.internal.SetResourceParentsRequest
    public SetResourceParentsRequest method_5793(Parcel var1) {
        ArrayList var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;

        DriveId var5;
        ArrayList var7;
        for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
            int var6 = class_824.method_4329(var1);
            DriveId var8;
            int var9;
            switch(class_824.method_4340(var6)) {
                case 1:
                    int var11 = class_824.method_4348(var1, var6);
                    var8 = var5;
                    var9 = var11;
                    var7 = var2;
                    break;
                case 2:
                    DriveId var10 = (DriveId)class_824.method_4336(var1, var6, DriveId.CREATOR);
                    var9 = var4;
                    var7 = var2;
                    var8 = var10;
                    break;
                case 3:
                    var7 = class_824.method_4343(var1, var6, DriveId.CREATOR);
                    var8 = var5;
                    var9 = var4;
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
            return new SetResourceParentsRequest(var4, var5, var2);
        }
    }

    // $FF: renamed from: bN (int) com.google.android.gms.drive.internal.SetResourceParentsRequest[]
    public SetResourceParentsRequest[] method_5794(int var1) {
        return new SetResourceParentsRequest[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5793(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5794(var1);
    }
}

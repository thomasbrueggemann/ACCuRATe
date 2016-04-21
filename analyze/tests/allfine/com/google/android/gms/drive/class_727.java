package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.DriveId;

// $FF: renamed from: com.google.android.gms.drive.c
public class class_727 implements Creator<DriveId> {
    // $FF: renamed from: a (com.google.android.gms.drive.DriveId, android.os.Parcel, int) void
    static void method_3954(DriveId var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_2223);
        class_823.method_4313(var1, 2, var0.field_2224, false);
        class_823.method_4305(var1, 3, var0.field_2225);
        class_823.method_4305(var1, 4, var0.field_2226);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: O (android.os.Parcel) com.google.android.gms.drive.DriveId
    public DriveId method_3955(Parcel var1) {
        long var2 = 0L;
        int var4 = class_824.method_4331(var1);
        int var5 = 0;
        String var6 = null;
        long var7 = var2;

        while(var1.dataPosition() < var4) {
            int var9 = class_824.method_4329(var1);
            switch(class_824.method_4340(var9)) {
                case 1:
                    var5 = class_824.method_4348(var1, var9);
                    break;
                case 2:
                    var6 = class_824.method_4356(var1, var9);
                    break;
                case 3:
                    var7 = class_824.method_4350(var1, var9);
                    break;
                case 4:
                    var2 = class_824.method_4350(var1, var9);
                    break;
                default:
                    class_824.method_4341(var1, var9);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new DriveId(var5, var6, var7, var2);
        }
    }

    // $FF: renamed from: aT (int) com.google.android.gms.drive.DriveId[]
    public DriveId[] method_3956(int var1) {
        return new DriveId[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3955(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3956(var1);
    }
}

package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.DrivePreferences;

// $FF: renamed from: com.google.android.gms.drive.d
public class class_728 implements Creator<DrivePreferences> {
    // $FF: renamed from: a (com.google.android.gms.drive.DrivePreferences, android.os.Parcel, int) void
    static void method_3957(DrivePreferences var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_4686);
        class_823.method_4316(var1, 2, var0.field_4687);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: P (android.os.Parcel) com.google.android.gms.drive.DrivePreferences
    public DrivePreferences method_3958(Parcel var1) {
        boolean var2 = false;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;

        while(var1.dataPosition() < var3) {
            int var5 = class_824.method_4329(var1);
            switch(class_824.method_4340(var5)) {
                case 1:
                    var4 = class_824.method_4348(var1, var5);
                    break;
                case 2:
                    var2 = class_824.method_4344(var1, var5);
                    break;
                default:
                    class_824.method_4341(var1, var5);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new DrivePreferences(var4, var2);
        }
    }

    // $FF: renamed from: aU (int) com.google.android.gms.drive.DrivePreferences[]
    public DrivePreferences[] method_3959(int var1) {
        return new DrivePreferences[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3958(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3959(var1);
    }
}

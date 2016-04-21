package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.StorageStats;

// $FF: renamed from: com.google.android.gms.drive.g
public class class_733 implements Creator<StorageStats> {
    // $FF: renamed from: a (com.google.android.gms.drive.StorageStats, android.os.Parcel, int) void
    static void method_3969(StorageStats var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_3393);
        class_823.method_4305(var1, 2, var0.field_3394);
        class_823.method_4305(var1, 3, var0.field_3395);
        class_823.method_4305(var1, 4, var0.field_3396);
        class_823.method_4305(var1, 5, var0.field_3397);
        class_823.method_4325(var1, 6, var0.field_3398);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: R (android.os.Parcel) com.google.android.gms.drive.StorageStats
    public StorageStats method_3970(Parcel var1) {
        int var2 = 0;
        long var3 = 0L;
        int var5 = class_824.method_4331(var1);
        long var6 = var3;
        long var8 = var3;
        long var10 = var3;
        int var12 = 0;

        while(var1.dataPosition() < var5) {
            int var13 = class_824.method_4329(var1);
            switch(class_824.method_4340(var13)) {
                case 1:
                    var12 = class_824.method_4348(var1, var13);
                    break;
                case 2:
                    var10 = class_824.method_4350(var1, var13);
                    break;
                case 3:
                    var8 = class_824.method_4350(var1, var13);
                    break;
                case 4:
                    var6 = class_824.method_4350(var1, var13);
                    break;
                case 5:
                    var3 = class_824.method_4350(var1, var13);
                    break;
                case 6:
                    var2 = class_824.method_4348(var1, var13);
                    break;
                default:
                    class_824.method_4341(var1, var13);
            }
        }

        if(var1.dataPosition() != var5) {
            throw new class_824.class_1307("Overread allowed size end=" + var5, var1);
        } else {
            return new StorageStats(var12, var10, var8, var6, var3, var2);
        }
    }

    // $FF: renamed from: aY (int) com.google.android.gms.drive.StorageStats[]
    public StorageStats[] method_3971(int var1) {
        return new StorageStats[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3970(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3971(var1);
    }
}

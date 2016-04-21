package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;

public class StatusCreator implements Creator<Status> {
    public static final int CONTENT_DESCRIPTION;

    // $FF: renamed from: a (com.google.android.gms.common.api.Status, android.os.Parcel, int) void
    static void method_4370(Status var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getStatusCode());
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4313(var1, 2, var0.getStatusMessage(), false);
        class_823.method_4309(var1, 3, var0.getPendingIntent(), var2, false);
        class_823.method_4301(var1, var3);
    }

    public Status createFromParcel(Parcel var1) {
        PendingIntent var2 = null;
        int var3 = 0;
        int var4 = class_824.method_4331(var1);
        String var5 = null;
        int var6 = 0;

        while(var1.dataPosition() < var4) {
            int var7 = class_824.method_4329(var1);
            switch(class_824.method_4340(var7)) {
                case 1:
                    var3 = class_824.method_4348(var1, var7);
                    break;
                case 2:
                    var5 = class_824.method_4356(var1, var7);
                    break;
                case 3:
                    var2 = (PendingIntent)class_824.method_4336(var1, var7, PendingIntent.CREATOR);
                    break;
                case 1000:
                    var6 = class_824.method_4348(var1, var7);
                    break;
                default:
                    class_824.method_4341(var1, var7);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new Status(var6, var3, var5, var2);
        }
    }

    public Status[] newArray(int var1) {
        return new Status[var1];
    }
}

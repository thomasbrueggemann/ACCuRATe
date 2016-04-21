package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.TrashResourceRequest;

// $FF: renamed from: com.google.android.gms.drive.internal.bc
public class class_1120 implements Creator<TrashResourceRequest> {
    // $FF: renamed from: a (com.google.android.gms.drive.internal.TrashResourceRequest, android.os.Parcel, int) void
    static void method_5786(TrashResourceRequest var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_5223);
        class_823.method_4309(var1, 2, var0.field_5224, var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: aC (android.os.Parcel) com.google.android.gms.drive.internal.TrashResourceRequest
    public TrashResourceRequest method_5787(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        DriveId var4 = null;

        while(var1.dataPosition() < var2) {
            int var5 = class_824.method_4329(var1);
            switch(class_824.method_4340(var5)) {
                case 1:
                    var3 = class_824.method_4348(var1, var5);
                    break;
                case 2:
                    var4 = (DriveId)class_824.method_4336(var1, var5, DriveId.CREATOR);
                    break;
                default:
                    class_824.method_4341(var1, var5);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new TrashResourceRequest(var3, var4);
        }
    }

    // $FF: renamed from: bO (int) com.google.android.gms.drive.internal.TrashResourceRequest[]
    public TrashResourceRequest[] method_5788(int var1) {
        return new TrashResourceRequest[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5787(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5788(var1);
    }
}

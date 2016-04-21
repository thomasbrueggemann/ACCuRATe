package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.CreateFileIntentSenderRequest;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

// $FF: renamed from: com.google.android.gms.drive.internal.i
public class class_284 implements Creator<CreateFileIntentSenderRequest> {
    // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateFileIntentSenderRequest, android.os.Parcel, int) void
    static void method_1774(CreateFileIntentSenderRequest var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_4518);
        class_823.method_4309(var1, 2, var0.field_4521, var2, false);
        class_823.method_4325(var1, 3, var0.field_4523);
        class_823.method_4313(var1, 4, var0.field_4519, false);
        class_823.method_4309(var1, 5, var0.field_4520, var2, false);
        class_823.method_4311(var1, 6, var0.field_4522, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: ab (android.os.Parcel) com.google.android.gms.drive.internal.CreateFileIntentSenderRequest
    public CreateFileIntentSenderRequest method_1775(Parcel var1) {
        int var2 = 0;
        Integer var3 = null;
        int var4 = class_824.method_4331(var1);
        DriveId var5 = null;
        String var6 = null;
        MetadataBundle var7 = null;
        int var8 = 0;

        while(var1.dataPosition() < var4) {
            int var9 = class_824.method_4329(var1);
            switch(class_824.method_4340(var9)) {
                case 1:
                    var8 = class_824.method_4348(var1, var9);
                    break;
                case 2:
                    var7 = (MetadataBundle)class_824.method_4336(var1, var9, MetadataBundle.CREATOR);
                    break;
                case 3:
                    var2 = class_824.method_4348(var1, var9);
                    break;
                case 4:
                    var6 = class_824.method_4356(var1, var9);
                    break;
                case 5:
                    var5 = (DriveId)class_824.method_4336(var1, var9, DriveId.CREATOR);
                    break;
                case 6:
                    var3 = class_824.method_4349(var1, var9);
                    break;
                default:
                    class_824.method_4341(var1, var9);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new CreateFileIntentSenderRequest(var8, var7, var2, var6, var5, var3);
        }
    }

    // $FF: renamed from: bl (int) com.google.android.gms.drive.internal.CreateFileIntentSenderRequest[]
    public CreateFileIntentSenderRequest[] method_1776(int var1) {
        return new CreateFileIntentSenderRequest[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_1775(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_1776(var1);
    }
}

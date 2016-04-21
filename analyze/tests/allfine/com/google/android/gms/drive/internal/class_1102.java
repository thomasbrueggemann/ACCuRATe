package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;

// $FF: renamed from: com.google.android.gms.drive.internal.aw
public class class_1102 implements Creator<OpenFileIntentSenderRequest> {
    // $FF: renamed from: a (com.google.android.gms.drive.internal.OpenFileIntentSenderRequest, android.os.Parcel, int) void
    static void method_5730(OpenFileIntentSenderRequest var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_4849);
        class_823.method_4313(var1, 2, var0.field_4850, false);
        class_823.method_4320(var1, 3, var0.field_4851, false);
        class_823.method_4309(var1, 4, var0.field_4852, var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: ax (android.os.Parcel) com.google.android.gms.drive.internal.OpenFileIntentSenderRequest
    public OpenFileIntentSenderRequest method_5731(Parcel var1) {
        DriveId var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        String[] var5 = null;
        String var6 = null;

        while(var1.dataPosition() < var3) {
            int var7 = class_824.method_4329(var1);
            switch(class_824.method_4340(var7)) {
                case 1:
                    var4 = class_824.method_4348(var1, var7);
                    break;
                case 2:
                    var6 = class_824.method_4356(var1, var7);
                    break;
                case 3:
                    var5 = class_824.method_4328(var1, var7);
                    break;
                case 4:
                    var2 = (DriveId)class_824.method_4336(var1, var7, DriveId.CREATOR);
                    break;
                default:
                    class_824.method_4341(var1, var7);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new OpenFileIntentSenderRequest(var4, var6, var5, var2);
        }
    }

    // $FF: renamed from: bJ (int) com.google.android.gms.drive.internal.OpenFileIntentSenderRequest[]
    public OpenFileIntentSenderRequest[] method_5732(int var1) {
        return new OpenFileIntentSenderRequest[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5731(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5732(var1);
    }
}

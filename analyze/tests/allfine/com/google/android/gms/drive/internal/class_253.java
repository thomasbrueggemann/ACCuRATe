package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.AuthorizeAccessRequest;

// $FF: renamed from: com.google.android.gms.drive.internal.b
public class class_253 implements Creator<AuthorizeAccessRequest> {
    // $FF: renamed from: a (com.google.android.gms.drive.internal.AuthorizeAccessRequest, android.os.Parcel, int) void
    static void method_1636(AuthorizeAccessRequest var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_4853);
        class_823.method_4305(var1, 2, var0.field_4855);
        class_823.method_4309(var1, 3, var0.field_4854, var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: W (android.os.Parcel) com.google.android.gms.drive.internal.AuthorizeAccessRequest
    public AuthorizeAccessRequest method_1637(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        long var4 = 0L;
        DriveId var6 = null;

        while(var1.dataPosition() < var2) {
            int var7 = class_824.method_4329(var1);
            switch(class_824.method_4340(var7)) {
                case 1:
                    var3 = class_824.method_4348(var1, var7);
                    break;
                case 2:
                    var4 = class_824.method_4350(var1, var7);
                    break;
                case 3:
                    var6 = (DriveId)class_824.method_4336(var1, var7, DriveId.CREATOR);
                    break;
                default:
                    class_824.method_4341(var1, var7);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new AuthorizeAccessRequest(var3, var4, var6);
        }
    }

    // $FF: renamed from: bf (int) com.google.android.gms.drive.internal.AuthorizeAccessRequest[]
    public AuthorizeAccessRequest[] method_1638(int var1) {
        return new AuthorizeAccessRequest[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_1637(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_1638(var1);
    }
}

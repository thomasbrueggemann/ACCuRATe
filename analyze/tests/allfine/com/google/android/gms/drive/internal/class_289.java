package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.internal.DisconnectRequest;

// $FF: renamed from: com.google.android.gms.drive.internal.n
public class class_289 implements Creator<DisconnectRequest> {
    // $FF: renamed from: a (com.google.android.gms.drive.internal.DisconnectRequest, android.os.Parcel, int) void
    static void method_1790(DisconnectRequest var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_5230);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: af (android.os.Parcel) com.google.android.gms.drive.internal.DisconnectRequest
    public DisconnectRequest method_1791(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;

        while(var1.dataPosition() < var2) {
            int var4 = class_824.method_4329(var1);
            switch(class_824.method_4340(var4)) {
                case 1:
                    var3 = class_824.method_4348(var1, var4);
                    break;
                default:
                    class_824.method_4341(var1, var4);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new DisconnectRequest(var3);
        }
    }

    // $FF: renamed from: bp (int) com.google.android.gms.drive.internal.DisconnectRequest[]
    public DisconnectRequest[] method_1792(int var1) {
        return new DisconnectRequest[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_1791(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_1792(var1);
    }
}

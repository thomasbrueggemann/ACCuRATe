package com.google.android.gms.auth.api;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.GoogleAuthApiResponse;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;

public class GoogleAuthApiResponseCreator implements Creator<GoogleAuthApiResponse> {
    public static final int CONTENT_DESCRIPTION;

    // $FF: renamed from: a (com.google.android.gms.auth.api.GoogleAuthApiResponse, android.os.Parcel, int) void
    static void method_3322(GoogleAuthApiResponse var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.responseCode);
        class_823.method_4325(var1, 1000, var0.versionCode);
        class_823.method_4306(var1, 2, var0.field_3407, false);
        class_823.method_4317(var1, 3, var0.field_3406, false);
        class_823.method_4301(var1, var3);
    }

    public GoogleAuthApiResponse createFromParcel(Parcel var1) {
        byte[] var2 = null;
        int var3 = 0;
        int var4 = class_824.method_4331(var1);
        Bundle var5 = null;
        int var6 = 0;

        while(var1.dataPosition() < var4) {
            int var7 = class_824.method_4329(var1);
            switch(class_824.method_4340(var7)) {
                case 1:
                    var3 = class_824.method_4348(var1, var7);
                    break;
                case 2:
                    var5 = class_824.method_4358(var1, var7);
                    break;
                case 3:
                    var2 = class_824.method_4359(var1, var7);
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
            return new GoogleAuthApiResponse(var6, var3, var5, var2);
        }
    }

    public GoogleAuthApiResponse[] newArray(int var1) {
        return new GoogleAuthApiResponse[var1];
    }
}

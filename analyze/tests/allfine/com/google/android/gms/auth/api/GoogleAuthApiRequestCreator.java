package com.google.android.gms.auth.api;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.GoogleAuthApiRequest;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import java.util.ArrayList;

public class GoogleAuthApiRequestCreator implements Creator<GoogleAuthApiRequest> {
    public static final int CONTENT_DESCRIPTION;

    // $FF: renamed from: a (com.google.android.gms.auth.api.GoogleAuthApiRequest, android.os.Parcel, int) void
    static void method_3181(GoogleAuthApiRequest var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4313(var1, 1, var0.name, false);
        class_823.method_4325(var1, 1000, var0.versionCode);
        class_823.method_4313(var1, 2, var0.version, false);
        class_823.method_4313(var1, 3, var0.field_3610, false);
        class_823.method_4313(var1, 4, var0.field_3617, false);
        class_823.method_4306(var1, 5, var0.field_3611, false);
        class_823.method_4313(var1, 6, var0.field_3612, false);
        class_823.method_4324(var1, 7, var0.field_3613, false);
        class_823.method_4313(var1, 8, var0.field_3614, false);
        class_823.method_4325(var1, 9, var0.field_3615);
        class_823.method_4306(var1, 10, var0.field_3616, false);
        class_823.method_4317(var1, 11, var0.field_3608, false);
        class_823.method_4305(var1, 12, var0.field_3609);
        class_823.method_4301(var1, var3);
    }

    public GoogleAuthApiRequest createFromParcel(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        String var4 = null;
        String var5 = null;
        String var6 = null;
        String var7 = null;
        Bundle var8 = null;
        String var9 = null;
        ArrayList var10 = null;
        String var11 = null;
        int var12 = 0;
        Bundle var13 = null;
        byte[] var14 = null;
        long var15 = 0L;

        while(var1.dataPosition() < var2) {
            int var17 = class_824.method_4329(var1);
            switch(class_824.method_4340(var17)) {
                case 1:
                    var4 = class_824.method_4356(var1, var17);
                    break;
                case 2:
                    var5 = class_824.method_4356(var1, var17);
                    break;
                case 3:
                    var6 = class_824.method_4356(var1, var17);
                    break;
                case 4:
                    var7 = class_824.method_4356(var1, var17);
                    break;
                case 5:
                    var8 = class_824.method_4358(var1, var17);
                    break;
                case 6:
                    var9 = class_824.method_4356(var1, var17);
                    break;
                case 7:
                    var10 = class_824.method_4332(var1, var17);
                    break;
                case 8:
                    var11 = class_824.method_4356(var1, var17);
                    break;
                case 9:
                    var12 = class_824.method_4348(var1, var17);
                    break;
                case 10:
                    var13 = class_824.method_4358(var1, var17);
                    break;
                case 11:
                    var14 = class_824.method_4359(var1, var17);
                    break;
                case 12:
                    var15 = class_824.method_4350(var1, var17);
                    break;
                case 1000:
                    var3 = class_824.method_4348(var1, var17);
                    break;
                default:
                    class_824.method_4341(var1, var17);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new GoogleAuthApiRequest(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15);
        }
    }

    public GoogleAuthApiRequest[] newArray(int var1) {
        return new GoogleAuthApiRequest[var1];
    }
}

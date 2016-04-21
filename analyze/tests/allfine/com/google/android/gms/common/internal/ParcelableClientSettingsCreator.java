package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import java.util.ArrayList;

public class ParcelableClientSettingsCreator implements Creator<ClientSettings.ParcelableClientSettings> {
    public static final int CONTENT_DESCRIPTION;

    // $FF: renamed from: a (com.google.android.gms.common.internal.ClientSettings$ParcelableClientSettings, android.os.Parcel, int) void
    static void method_2845(ClientSettings.ParcelableClientSettings var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4313(var1, 1, var0.getAccountName(), false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4324(var1, 2, var0.getScopes(), false);
        class_823.method_4325(var1, 3, var0.getGravityForPopups());
        class_823.method_4313(var1, 4, var0.getRealClientPackageName(), false);
        class_823.method_4301(var1, var3);
    }

    public ClientSettings.ParcelableClientSettings createFromParcel(Parcel var1) {
        int var2 = 0;
        String var3 = null;
        int var4 = class_824.method_4331(var1);
        ArrayList var5 = null;
        String var6 = null;
        int var7 = 0;

        while(var1.dataPosition() < var4) {
            int var8 = class_824.method_4329(var1);
            switch(class_824.method_4340(var8)) {
                case 1:
                    var6 = class_824.method_4356(var1, var8);
                    break;
                case 2:
                    var5 = class_824.method_4332(var1, var8);
                    break;
                case 3:
                    var2 = class_824.method_4348(var1, var8);
                    break;
                case 4:
                    var3 = class_824.method_4356(var1, var8);
                    break;
                case 1000:
                    var7 = class_824.method_4348(var1, var8);
                    break;
                default:
                    class_824.method_4341(var1, var8);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new ClientSettings.ParcelableClientSettings(var7, var6, var5, var2, var3);
        }
    }

    public ClientSettings.ParcelableClientSettings[] newArray(int var1) {
        return new ClientSettings.ParcelableClientSettings[var1];
    }
}

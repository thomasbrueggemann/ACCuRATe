package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.cast.a
public class class_1063 implements Creator<ApplicationMetadata> {
    // $FF: renamed from: a (com.google.android.gms.cast.ApplicationMetadata, android.os.Parcel, int) void
    static void method_5559(ApplicationMetadata var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4313(var1, 2, var0.getApplicationId(), false);
        class_823.method_4313(var1, 3, var0.getName(), false);
        class_823.method_4326(var1, 4, var0.getImages(), false);
        class_823.method_4324(var1, 5, var0.field_4436, false);
        class_823.method_4313(var1, 6, var0.getSenderAppIdentifier(), false);
        class_823.method_4309(var1, 7, var0.method_4988(), var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: U (int) com.google.android.gms.cast.ApplicationMetadata[]
    public ApplicationMetadata[] method_5560(int var1) {
        return new ApplicationMetadata[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5561(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5560(var1);
    }

    // $FF: renamed from: t (android.os.Parcel) com.google.android.gms.cast.ApplicationMetadata
    public ApplicationMetadata method_5561(Parcel var1) {
        Uri var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        String var5 = null;
        ArrayList var6 = null;
        ArrayList var7 = null;
        String var8 = null;
        String var9 = null;

        while(var1.dataPosition() < var3) {
            int var10 = class_824.method_4329(var1);
            switch(class_824.method_4340(var10)) {
                case 1:
                    var4 = class_824.method_4348(var1, var10);
                    break;
                case 2:
                    var9 = class_824.method_4356(var1, var10);
                    break;
                case 3:
                    var8 = class_824.method_4356(var1, var10);
                    break;
                case 4:
                    var7 = class_824.method_4343(var1, var10, WebImage.CREATOR);
                    break;
                case 5:
                    var6 = class_824.method_4332(var1, var10);
                    break;
                case 6:
                    var5 = class_824.method_4356(var1, var10);
                    break;
                case 7:
                    var2 = (Uri)class_824.method_4336(var1, var10, Uri.CREATOR);
                    break;
                default:
                    class_824.method_4341(var1, var10);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new ApplicationMetadata(var4, var9, var8, var7, var6, var5, var2);
        }
    }
}

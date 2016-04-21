package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.wearable.Asset;

// $FF: renamed from: com.google.android.gms.wearable.a
public class class_1047 implements Creator<Asset> {
    // $FF: renamed from: a (com.google.android.gms.wearable.Asset, android.os.Parcel, int) void
    static void method_5482(Asset var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_5068);
        class_823.method_4317(var1, 2, var0.getData(), false);
        class_823.method_4313(var1, 3, var0.getDigest(), false);
        class_823.method_4309(var1, 4, var0.auR, var2, false);
        class_823.method_4309(var1, 5, var0.uri, var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5483(var1);
    }

    // $FF: renamed from: dP (android.os.Parcel) com.google.android.gms.wearable.Asset
    public Asset method_5483(Parcel var1) {
        Uri var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        ParcelFileDescriptor var5 = null;
        String var6 = null;
        byte[] var7 = null;

        while(var1.dataPosition() < var3) {
            int var8 = class_824.method_4329(var1);
            switch(class_824.method_4340(var8)) {
                case 1:
                    var4 = class_824.method_4348(var1, var8);
                    break;
                case 2:
                    var7 = class_824.method_4359(var1, var8);
                    break;
                case 3:
                    var6 = class_824.method_4356(var1, var8);
                    break;
                case 4:
                    var5 = (ParcelFileDescriptor)class_824.method_4336(var1, var8, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    var2 = (Uri)class_824.method_4336(var1, var8, Uri.CREATOR);
                    break;
                default:
                    class_824.method_4341(var1, var8);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new Asset(var4, var7, var6, var5, var2);
        }
    }

    // $FF: renamed from: fS (int) com.google.android.gms.wearable.Asset[]
    public Asset[] method_5484(int var1) {
        return new Asset[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5484(var1);
    }
}

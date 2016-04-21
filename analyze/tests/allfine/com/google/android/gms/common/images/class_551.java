package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;

// $FF: renamed from: com.google.android.gms.common.images.b
public class class_551 implements Creator<WebImage> {
    // $FF: renamed from: a (com.google.android.gms.common.images.WebImage, android.os.Parcel, int) void
    static void method_3387(WebImage var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4309(var1, 2, var0.getUrl(), var2, false);
        class_823.method_4325(var1, 3, var0.getWidth());
        class_823.method_4325(var1, 4, var0.getHeight());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: A (android.os.Parcel) com.google.android.gms.common.images.WebImage
    public WebImage method_3388(Parcel var1) {
        int var2 = 0;
        int var3 = class_824.method_4331(var1);
        Uri var4 = null;
        int var5 = 0;

        int var6;
        int var8;
        for(var6 = 0; var1.dataPosition() < var3; var2 = var8) {
            int var7 = class_824.method_4329(var1);
            int var9;
            Uri var10;
            int var11;
            switch(class_824.method_4340(var7)) {
                case 1:
                    int var16 = class_824.method_4348(var1, var7);
                    var9 = var5;
                    var10 = var4;
                    var11 = var16;
                    var8 = var2;
                    break;
                case 2:
                    Uri var14 = (Uri)class_824.method_4336(var1, var7, Uri.CREATOR);
                    var11 = var6;
                    var10 = var14;
                    var8 = var2;
                    var9 = var5;
                    break;
                case 3:
                    int var12 = class_824.method_4348(var1, var7);
                    var10 = var4;
                    var11 = var6;
                    var9 = var12;
                    var8 = var2;
                    break;
                case 4:
                    var8 = class_824.method_4348(var1, var7);
                    var9 = var5;
                    var10 = var4;
                    var11 = var6;
                    break;
                default:
                    class_824.method_4341(var1, var7);
                    var8 = var2;
                    var9 = var5;
                    var10 = var4;
                    var11 = var6;
            }

            var6 = var11;
            var4 = var10;
            var5 = var9;
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new WebImage(var6, var4, var5, var2);
        }
    }

    // $FF: renamed from: ax (int) com.google.android.gms.common.images.WebImage[]
    public WebImage[] method_3389(int var1) {
        return new WebImage[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3388(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3389(var1);
    }
}

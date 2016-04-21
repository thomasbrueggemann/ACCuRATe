package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

// $FF: renamed from: com.google.android.gms.maps.model.e
public class class_974 implements Creator<GroundOverlayOptions> {
    // $FF: renamed from: a (com.google.android.gms.maps.model.GroundOverlayOptions, android.os.Parcel, int) void
    static void method_5152(GroundOverlayOptions var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4307(var1, 2, var0.method_4202(), false);
        class_823.method_4309(var1, 3, var0.getLocation(), var2, false);
        class_823.method_4304(var1, 4, var0.getWidth());
        class_823.method_4304(var1, 5, var0.getHeight());
        class_823.method_4309(var1, 6, var0.getBounds(), var2, false);
        class_823.method_4304(var1, 7, var0.getBearing());
        class_823.method_4304(var1, 8, var0.getZIndex());
        class_823.method_4316(var1, 9, var0.isVisible());
        class_823.method_4304(var1, 10, var0.getTransparency());
        class_823.method_4304(var1, 11, var0.getAnchorU());
        class_823.method_4304(var1, 12, var0.getAnchorV());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: cK (android.os.Parcel) com.google.android.gms.maps.model.GroundOverlayOptions
    public GroundOverlayOptions method_5153(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        IBinder var4 = null;
        LatLng var5 = null;
        float var6 = 0.0F;
        float var7 = 0.0F;
        LatLngBounds var8 = null;
        float var9 = 0.0F;
        float var10 = 0.0F;
        boolean var11 = false;
        float var12 = 0.0F;
        float var13 = 0.0F;
        float var14 = 0.0F;

        while(var1.dataPosition() < var2) {
            int var15 = class_824.method_4329(var1);
            switch(class_824.method_4340(var15)) {
                case 1:
                    var3 = class_824.method_4348(var1, var15);
                    break;
                case 2:
                    var4 = class_824.method_4357(var1, var15);
                    break;
                case 3:
                    var5 = (LatLng)class_824.method_4336(var1, var15, LatLng.CREATOR);
                    break;
                case 4:
                    var6 = class_824.method_4353(var1, var15);
                    break;
                case 5:
                    var7 = class_824.method_4353(var1, var15);
                    break;
                case 6:
                    var8 = (LatLngBounds)class_824.method_4336(var1, var15, LatLngBounds.CREATOR);
                    break;
                case 7:
                    var9 = class_824.method_4353(var1, var15);
                    break;
                case 8:
                    var10 = class_824.method_4353(var1, var15);
                    break;
                case 9:
                    var11 = class_824.method_4344(var1, var15);
                    break;
                case 10:
                    var12 = class_824.method_4353(var1, var15);
                    break;
                case 11:
                    var13 = class_824.method_4353(var1, var15);
                    break;
                case 12:
                    var14 = class_824.method_4353(var1, var15);
                    break;
                default:
                    class_824.method_4341(var1, var15);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new GroundOverlayOptions(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5153(var1);
    }

    // $FF: renamed from: eA (int) com.google.android.gms.maps.model.GroundOverlayOptions[]
    public GroundOverlayOptions[] method_5154(int var1) {
        return new GroundOverlayOptions[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5154(var1);
    }
}

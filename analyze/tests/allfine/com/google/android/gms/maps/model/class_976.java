package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

// $FF: renamed from: com.google.android.gms.maps.model.k
public class class_976 implements Creator<MarkerOptions> {
    // $FF: renamed from: a (com.google.android.gms.maps.model.MarkerOptions, android.os.Parcel, int) void
    static void method_5156(MarkerOptions var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4309(var1, 2, var0.getPosition(), var2, false);
        class_823.method_4313(var1, 3, var0.getTitle(), false);
        class_823.method_4313(var1, 4, var0.getSnippet(), false);
        class_823.method_4307(var1, 5, var0.method_3184(), false);
        class_823.method_4304(var1, 6, var0.getAnchorU());
        class_823.method_4304(var1, 7, var0.getAnchorV());
        class_823.method_4316(var1, 8, var0.isDraggable());
        class_823.method_4316(var1, 9, var0.isVisible());
        class_823.method_4316(var1, 10, var0.isFlat());
        class_823.method_4304(var1, 11, var0.getRotation());
        class_823.method_4304(var1, 12, var0.getInfoWindowAnchorU());
        class_823.method_4304(var1, 13, var0.getInfoWindowAnchorV());
        class_823.method_4304(var1, 14, var0.getAlpha());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: cN (android.os.Parcel) com.google.android.gms.maps.model.MarkerOptions
    public MarkerOptions method_5157(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        LatLng var4 = null;
        String var5 = null;
        String var6 = null;
        IBinder var7 = null;
        float var8 = 0.0F;
        float var9 = 0.0F;
        boolean var10 = false;
        boolean var11 = false;
        boolean var12 = false;
        float var13 = 0.0F;
        float var14 = 0.5F;
        float var15 = 0.0F;
        float var16 = 1.0F;

        while(var1.dataPosition() < var2) {
            int var17 = class_824.method_4329(var1);
            switch(class_824.method_4340(var17)) {
                case 1:
                    var3 = class_824.method_4348(var1, var17);
                    break;
                case 2:
                    var4 = (LatLng)class_824.method_4336(var1, var17, LatLng.CREATOR);
                    break;
                case 3:
                    var5 = class_824.method_4356(var1, var17);
                    break;
                case 4:
                    var6 = class_824.method_4356(var1, var17);
                    break;
                case 5:
                    var7 = class_824.method_4357(var1, var17);
                    break;
                case 6:
                    var8 = class_824.method_4353(var1, var17);
                    break;
                case 7:
                    var9 = class_824.method_4353(var1, var17);
                    break;
                case 8:
                    var10 = class_824.method_4344(var1, var17);
                    break;
                case 9:
                    var11 = class_824.method_4344(var1, var17);
                    break;
                case 10:
                    var12 = class_824.method_4344(var1, var17);
                    break;
                case 11:
                    var13 = class_824.method_4353(var1, var17);
                    break;
                case 12:
                    var14 = class_824.method_4353(var1, var17);
                    break;
                case 13:
                    var15 = class_824.method_4353(var1, var17);
                    break;
                case 14:
                    var16 = class_824.method_4353(var1, var17);
                    break;
                default:
                    class_824.method_4341(var1, var17);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new MarkerOptions(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5157(var1);
    }

    // $FF: renamed from: eD (int) com.google.android.gms.maps.model.MarkerOptions[]
    public MarkerOptions[] method_5158(int var1) {
        return new MarkerOptions[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5158(var1);
    }
}

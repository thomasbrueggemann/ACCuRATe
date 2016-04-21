package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.maps.model.TileOverlayOptions;

// $FF: renamed from: com.google.android.gms.maps.model.w
public class class_969 implements Creator<TileOverlayOptions> {
    // $FF: renamed from: a (com.google.android.gms.maps.model.TileOverlayOptions, android.os.Parcel, int) void
    static void method_5125(TileOverlayOptions var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4307(var1, 2, var0.method_4401(), false);
        class_823.method_4316(var1, 3, var0.isVisible());
        class_823.method_4304(var1, 4, var0.getZIndex());
        class_823.method_4316(var1, 5, var0.getFadeIn());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: cV (android.os.Parcel) com.google.android.gms.maps.model.TileOverlayOptions
    public TileOverlayOptions method_5126(Parcel var1) {
        boolean var2 = false;
        int var3 = class_824.method_4331(var1);
        IBinder var4 = null;
        float var5 = 0.0F;
        boolean var6 = true;
        int var7 = 0;

        while(var1.dataPosition() < var3) {
            int var8 = class_824.method_4329(var1);
            switch(class_824.method_4340(var8)) {
                case 1:
                    var7 = class_824.method_4348(var1, var8);
                    break;
                case 2:
                    var4 = class_824.method_4357(var1, var8);
                    break;
                case 3:
                    var2 = class_824.method_4344(var1, var8);
                    break;
                case 4:
                    var5 = class_824.method_4353(var1, var8);
                    break;
                case 5:
                    var6 = class_824.method_4344(var1, var8);
                    break;
                default:
                    class_824.method_4341(var1, var8);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new TileOverlayOptions(var7, var4, var2, var5, var6);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5126(var1);
    }

    // $FF: renamed from: eL (int) com.google.android.gms.maps.model.TileOverlayOptions[]
    public TileOverlayOptions[] method_5127(int var1) {
        return new TileOverlayOptions[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5127(var1);
    }
}

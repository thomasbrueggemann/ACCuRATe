package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_885;
import com.google.android.gms.internal.class_891;
import com.google.android.gms.internal.mr;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.ms
public class class_888 implements Creator<mr> {
    // $FF: renamed from: a (com.google.android.gms.internal.mr, android.os.Parcel, int) void
    static void method_4569(class_891 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4313(var1, 1, var0.getName(), false);
        class_823.method_4325(var1, 1000, var0.field_4209);
        class_823.method_4309(var1, 2, var0.method_4576(), var2, false);
        class_823.method_4313(var1, 3, var0.getAddress(), false);
        class_823.method_4326(var1, 4, var0.method_4577(), false);
        class_823.method_4313(var1, 5, var0.getPhoneNumber(), false);
        class_823.method_4313(var1, 6, var0.method_4578(), false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: cD (android.os.Parcel) com.google.android.gms.internal.mr
    public class_891 method_4570(Parcel var1) {
        String var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        String var5 = null;
        ArrayList var6 = null;
        String var7 = null;
        LatLng var8 = null;
        String var9 = null;

        while(var1.dataPosition() < var3) {
            int var10 = class_824.method_4329(var1);
            switch(class_824.method_4340(var10)) {
                case 1:
                    var9 = class_824.method_4356(var1, var10);
                    break;
                case 2:
                    var8 = (LatLng)class_824.method_4336(var1, var10, LatLng.CREATOR);
                    break;
                case 3:
                    var7 = class_824.method_4356(var1, var10);
                    break;
                case 4:
                    var6 = class_824.method_4343(var1, var10, class_885.CREATOR);
                    break;
                case 5:
                    var5 = class_824.method_4356(var1, var10);
                    break;
                case 6:
                    var2 = class_824.method_4356(var1, var10);
                    break;
                case 1000:
                    var4 = class_824.method_4348(var1, var10);
                    break;
                default:
                    class_824.method_4341(var1, var10);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_891(var4, var9, var8, var7, var6, var5, var2);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_4570(var1);
    }

    // $FF: renamed from: et (int) com.google.android.gms.internal.mr[]
    public class_891[] method_4571(int var1) {
        return new class_891[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_4571(var1);
    }
}

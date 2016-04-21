package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.Device;

// $FF: renamed from: com.google.android.gms.fitness.data.i
public class class_1130 implements Creator<Device> {
    // $FF: renamed from: a (com.google.android.gms.fitness.data.Device, android.os.Parcel, int) void
    static void method_5880(Device var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4313(var1, 1, var0.getManufacturer(), false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4313(var1, 2, var0.getModel(), false);
        class_823.method_4313(var1, 3, var0.getVersion(), false);
        class_823.method_4313(var1, 4, var0.method_2611(), false);
        class_823.method_4325(var1, 5, var0.getType());
        class_823.method_4325(var1, 6, var0.method_2609());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bp (android.os.Parcel) com.google.android.gms.fitness.data.Device
    public Device method_5881(Parcel var1) {
        int var2 = 0;
        String var3 = null;
        int var4 = class_824.method_4331(var1);
        int var5 = 0;
        String var6 = null;
        String var7 = null;
        String var8 = null;
        int var9 = 0;

        while(var1.dataPosition() < var4) {
            int var10 = class_824.method_4329(var1);
            switch(class_824.method_4340(var10)) {
                case 1:
                    var8 = class_824.method_4356(var1, var10);
                    break;
                case 2:
                    var7 = class_824.method_4356(var1, var10);
                    break;
                case 3:
                    var6 = class_824.method_4356(var1, var10);
                    break;
                case 4:
                    var3 = class_824.method_4356(var1, var10);
                    break;
                case 5:
                    var5 = class_824.method_4348(var1, var10);
                    break;
                case 6:
                    var2 = class_824.method_4348(var1, var10);
                    break;
                case 1000:
                    var9 = class_824.method_4348(var1, var10);
                    break;
                default:
                    class_824.method_4341(var1, var10);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new Device(var9, var8, var7, var6, var3, var5, var2);
        }
    }

    // $FF: renamed from: cF (int) com.google.android.gms.fitness.data.Device[]
    public Device[] method_5882(int var1) {
        return new Device[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5881(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5882(var1);
    }
}

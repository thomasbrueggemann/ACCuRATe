package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_333;
import com.google.android.gms.internal.il;

// $FF: renamed from: com.google.android.gms.internal.im
public class class_331 implements Creator<il> {
    // $FF: renamed from: a (com.google.android.gms.internal.il, android.os.Parcel, int) void
    static void method_2276(class_333 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4303(var1, 2, var0.method_2296());
        class_823.method_4316(var1, 3, var0.method_2297());
        class_823.method_4325(var1, 4, var0.method_2298());
        class_823.method_4309(var1, 5, var0.getApplicationMetadata(), var2, false);
        class_823.method_4325(var1, 6, var0.method_2299());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: ah (int) com.google.android.gms.internal.il[]
    public class_333[] method_2277(int var1) {
        return new class_333[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_2278(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_2277(var1);
    }

    // $FF: renamed from: x (android.os.Parcel) com.google.android.gms.internal.il
    public class_333 method_2278(Parcel var1) {
        int var2 = 0;
        int var3 = class_824.method_4331(var1);
        double var4 = 0.0D;
        ApplicationMetadata var6 = null;
        int var7 = 0;
        boolean var8 = false;
        int var9 = 0;

        while(var1.dataPosition() < var3) {
            int var10 = class_824.method_4329(var1);
            switch(class_824.method_4340(var10)) {
                case 1:
                    var9 = class_824.method_4348(var1, var10);
                    break;
                case 2:
                    var4 = class_824.method_4354(var1, var10);
                    break;
                case 3:
                    var8 = class_824.method_4344(var1, var10);
                    break;
                case 4:
                    var7 = class_824.method_4348(var1, var10);
                    break;
                case 5:
                    var6 = (ApplicationMetadata)class_824.method_4336(var1, var10, ApplicationMetadata.CREATOR);
                    break;
                case 6:
                    var2 = class_824.method_4348(var1, var10);
                    break;
                default:
                    class_824.method_4341(var1, var10);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_333(var9, var4, var8, var7, var6, var2);
        }
    }
}

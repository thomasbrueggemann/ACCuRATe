package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.wearable.c;
import com.google.android.gms.wearable.class_1048;

// $FF: renamed from: com.google.android.gms.wearable.d
public class class_1049 implements Creator<c> {
    // $FF: renamed from: a (com.google.android.gms.wearable.c, android.os.Parcel, int) void
    static void method_5486(class_1048 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_4886);
        class_823.method_4313(var1, 2, var0.getName(), false);
        class_823.method_4313(var1, 3, var0.getAddress(), false);
        class_823.method_4325(var1, 4, var0.getType());
        class_823.method_4325(var1, 5, var0.getRole());
        class_823.method_4316(var1, 6, var0.isEnabled());
        class_823.method_4316(var1, 7, var0.isConnected());
        class_823.method_4313(var1, 8, var0.method_5485(), false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5487(var1);
    }

    // $FF: renamed from: dQ (android.os.Parcel) com.google.android.gms.wearable.c
    public class_1048 method_5487(Parcel var1) {
        String var2 = null;
        boolean var3 = false;
        int var4 = class_824.method_4331(var1);
        boolean var5 = false;
        int var6 = 0;
        int var7 = 0;
        String var8 = null;
        String var9 = null;
        int var10 = 0;

        while(var1.dataPosition() < var4) {
            int var11 = class_824.method_4329(var1);
            switch(class_824.method_4340(var11)) {
                case 1:
                    var10 = class_824.method_4348(var1, var11);
                    break;
                case 2:
                    var9 = class_824.method_4356(var1, var11);
                    break;
                case 3:
                    var8 = class_824.method_4356(var1, var11);
                    break;
                case 4:
                    var7 = class_824.method_4348(var1, var11);
                    break;
                case 5:
                    var6 = class_824.method_4348(var1, var11);
                    break;
                case 6:
                    var5 = class_824.method_4344(var1, var11);
                    break;
                case 7:
                    var3 = class_824.method_4344(var1, var11);
                    break;
                case 8:
                    var2 = class_824.method_4356(var1, var11);
                    break;
                default:
                    class_824.method_4341(var1, var11);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new class_1048(var10, var9, var8, var7, var6, var5, var3, var2);
        }
    }

    // $FF: renamed from: fT (int) com.google.android.gms.wearable.c[]
    public class_1048[] method_5488(int var1) {
        return new class_1048[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5488(var1);
    }
}

package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.wearable.internal.ah;
import com.google.android.gms.wearable.internal.class_1082;

// $FF: renamed from: com.google.android.gms.wearable.internal.ai
public class class_1083 implements Creator<ah> {
    // $FF: renamed from: a (com.google.android.gms.wearable.internal.ah, android.os.Parcel, int) void
    static void method_5611(class_1082 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_5106);
        class_823.method_4325(var1, 2, var0.getRequestId());
        class_823.method_4313(var1, 3, var0.getPath(), false);
        class_823.method_4317(var1, 4, var0.getData(), false);
        class_823.method_4313(var1, 5, var0.getSourceNodeId(), false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5612(var1);
    }

    // $FF: renamed from: ec (android.os.Parcel) com.google.android.gms.wearable.internal.ah
    public class_1082 method_5612(Parcel var1) {
        int var2 = 0;
        String var3 = null;
        int var4 = class_824.method_4331(var1);
        byte[] var5 = null;
        String var6 = null;
        int var7 = 0;

        while(var1.dataPosition() < var4) {
            int var8 = class_824.method_4329(var1);
            switch(class_824.method_4340(var8)) {
                case 1:
                    var7 = class_824.method_4348(var1, var8);
                    break;
                case 2:
                    var2 = class_824.method_4348(var1, var8);
                    break;
                case 3:
                    var6 = class_824.method_4356(var1, var8);
                    break;
                case 4:
                    var5 = class_824.method_4359(var1, var8);
                    break;
                case 5:
                    var3 = class_824.method_4356(var1, var8);
                    break;
                default:
                    class_824.method_4341(var1, var8);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new class_1082(var7, var2, var6, var5, var3);
        }
    }

    // $FF: renamed from: gf (int) com.google.android.gms.wearable.internal.ah[]
    public class_1082[] method_5613(int var1) {
        return new class_1082[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5613(var1);
    }
}

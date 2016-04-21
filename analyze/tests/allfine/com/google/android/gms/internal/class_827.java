package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_828;
import com.google.android.gms.internal.mc;

// $FF: renamed from: com.google.android.gms.internal.md
public class class_827 implements Creator<mc> {
    // $FF: renamed from: a (com.google.android.gms.internal.mc, android.os.Parcel, int) void
    static void method_4436(class_828 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4313(var1, 1, var0.getRequestId(), false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4305(var1, 2, var0.getExpirationTime());
        class_823.method_4315(var1, 3, var0.method_4445());
        class_823.method_4303(var1, 4, var0.getLatitude());
        class_823.method_4303(var1, 5, var0.getLongitude());
        class_823.method_4304(var1, 6, var0.method_4446());
        class_823.method_4325(var1, 7, var0.method_4447());
        class_823.method_4325(var1, 8, var0.getNotificationResponsiveness());
        class_823.method_4325(var1, 9, var0.method_4448());
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_4437(var1);
    }

    // $FF: renamed from: cw (android.os.Parcel) com.google.android.gms.internal.mc
    public class_828 method_4437(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        String var4 = null;
        int var5 = 0;
        short var6 = 0;
        double var7 = 0.0D;
        double var9 = 0.0D;
        float var11 = 0.0F;
        long var12 = 0L;
        int var14 = 0;
        int var15 = -1;

        while(var1.dataPosition() < var2) {
            int var16 = class_824.method_4329(var1);
            switch(class_824.method_4340(var16)) {
                case 1:
                    var4 = class_824.method_4356(var1, var16);
                    break;
                case 2:
                    var12 = class_824.method_4350(var1, var16);
                    break;
                case 3:
                    var6 = class_824.method_4347(var1, var16);
                    break;
                case 4:
                    var7 = class_824.method_4354(var1, var16);
                    break;
                case 5:
                    var9 = class_824.method_4354(var1, var16);
                    break;
                case 6:
                    var11 = class_824.method_4353(var1, var16);
                    break;
                case 7:
                    var5 = class_824.method_4348(var1, var16);
                    break;
                case 8:
                    var14 = class_824.method_4348(var1, var16);
                    break;
                case 9:
                    var15 = class_824.method_4348(var1, var16);
                    break;
                case 1000:
                    var3 = class_824.method_4348(var1, var16);
                    break;
                default:
                    class_824.method_4341(var1, var16);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new class_828(var3, var4, var5, var6, var7, var9, var11, var12, var14, var15);
        }
    }

    // $FF: renamed from: em (int) com.google.android.gms.internal.mc[]
    public class_828[] method_4438(int var1) {
        return new class_828[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_4438(var1);
    }
}

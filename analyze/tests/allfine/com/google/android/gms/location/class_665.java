package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.location.LocationRequest;

// $FF: renamed from: com.google.android.gms.location.b
public class class_665 implements Creator<LocationRequest> {
    // $FF: renamed from: a (com.google.android.gms.location.LocationRequest, android.os.Parcel, int) void
    static void method_3725(LocationRequest var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.mPriority);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4305(var1, 2, var0.aes);
        class_823.method_4305(var1, 3, var0.aet);
        class_823.method_4316(var1, 4, var0.field_4557);
        class_823.method_4305(var1, 5, var0.aei);
        class_823.method_4325(var1, 6, var0.aeu);
        class_823.method_4304(var1, 7, var0.aev);
        class_823.method_4305(var1, 8, var0.aew);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3726(var1);
    }

    // $FF: renamed from: cs (android.os.Parcel) com.google.android.gms.location.LocationRequest
    public LocationRequest method_3726(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        int var4 = 102;
        long var5 = 3600000L;
        long var7 = 600000L;
        boolean var9 = false;
        long var10 = Long.MAX_VALUE;
        int var12 = Integer.MAX_VALUE;
        float var13 = 0.0F;
        long var14 = 0L;

        while(var1.dataPosition() < var2) {
            int var16 = class_824.method_4329(var1);
            switch(class_824.method_4340(var16)) {
                case 1:
                    var4 = class_824.method_4348(var1, var16);
                    break;
                case 2:
                    var5 = class_824.method_4350(var1, var16);
                    break;
                case 3:
                    var7 = class_824.method_4350(var1, var16);
                    break;
                case 4:
                    var9 = class_824.method_4344(var1, var16);
                    break;
                case 5:
                    var10 = class_824.method_4350(var1, var16);
                    break;
                case 6:
                    var12 = class_824.method_4348(var1, var16);
                    break;
                case 7:
                    var13 = class_824.method_4353(var1, var16);
                    break;
                case 8:
                    var14 = class_824.method_4350(var1, var16);
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
            return new LocationRequest(var3, var4, var5, var7, var9, var10, var12, var13, var14);
        }
    }

    // $FF: renamed from: ed (int) com.google.android.gms.location.LocationRequest[]
    public LocationRequest[] method_3727(int var1) {
        return new LocationRequest[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3727(var1);
    }
}

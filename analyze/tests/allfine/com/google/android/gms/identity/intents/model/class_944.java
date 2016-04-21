package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.identity.intents.model.UserAddress;

// $FF: renamed from: com.google.android.gms.identity.intents.model.b
public class class_944 implements Creator<UserAddress> {
    // $FF: renamed from: a (com.google.android.gms.identity.intents.model.UserAddress, android.os.Parcel, int) void
    static void method_4929(UserAddress var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4313(var1, 2, var0.name, false);
        class_823.method_4313(var1, 3, var0.adN, false);
        class_823.method_4313(var1, 4, var0.adO, false);
        class_823.method_4313(var1, 5, var0.adP, false);
        class_823.method_4313(var1, 6, var0.adQ, false);
        class_823.method_4313(var1, 7, var0.adR, false);
        class_823.method_4313(var1, 8, var0.adS, false);
        class_823.method_4313(var1, 9, var0.adT, false);
        class_823.method_4313(var1, 10, var0.field_4513, false);
        class_823.method_4313(var1, 11, var0.adU, false);
        class_823.method_4313(var1, 12, var0.adV, false);
        class_823.method_4313(var1, 13, var0.adW, false);
        class_823.method_4316(var1, 14, var0.adX);
        class_823.method_4313(var1, 15, var0.adY, false);
        class_823.method_4313(var1, 16, var0.adZ, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: cr (android.os.Parcel) com.google.android.gms.identity.intents.model.UserAddress
    public UserAddress method_4930(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        String var4 = null;
        String var5 = null;
        String var6 = null;
        String var7 = null;
        String var8 = null;
        String var9 = null;
        String var10 = null;
        String var11 = null;
        String var12 = null;
        String var13 = null;
        String var14 = null;
        String var15 = null;
        boolean var16 = false;
        String var17 = null;
        String var18 = null;

        while(var1.dataPosition() < var2) {
            int var19 = class_824.method_4329(var1);
            switch(class_824.method_4340(var19)) {
                case 1:
                    var3 = class_824.method_4348(var1, var19);
                    break;
                case 2:
                    var4 = class_824.method_4356(var1, var19);
                    break;
                case 3:
                    var5 = class_824.method_4356(var1, var19);
                    break;
                case 4:
                    var6 = class_824.method_4356(var1, var19);
                    break;
                case 5:
                    var7 = class_824.method_4356(var1, var19);
                    break;
                case 6:
                    var8 = class_824.method_4356(var1, var19);
                    break;
                case 7:
                    var9 = class_824.method_4356(var1, var19);
                    break;
                case 8:
                    var10 = class_824.method_4356(var1, var19);
                    break;
                case 9:
                    var11 = class_824.method_4356(var1, var19);
                    break;
                case 10:
                    var12 = class_824.method_4356(var1, var19);
                    break;
                case 11:
                    var13 = class_824.method_4356(var1, var19);
                    break;
                case 12:
                    var14 = class_824.method_4356(var1, var19);
                    break;
                case 13:
                    var15 = class_824.method_4356(var1, var19);
                    break;
                case 14:
                    var16 = class_824.method_4344(var1, var19);
                    break;
                case 15:
                    var17 = class_824.method_4356(var1, var19);
                    break;
                case 16:
                    var18 = class_824.method_4356(var1, var19);
                    break;
                default:
                    class_824.method_4341(var1, var19);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new UserAddress(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_4930(var1);
    }

    // $FF: renamed from: dZ (int) com.google.android.gms.identity.intents.model.UserAddress[]
    public UserAddress[] method_4931(int var1) {
        return new UserAddress[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_4931(var1);
    }
}

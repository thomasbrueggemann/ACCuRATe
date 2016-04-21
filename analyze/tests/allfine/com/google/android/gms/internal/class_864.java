package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_876;
import com.google.android.gms.internal.nm;

// $FF: renamed from: com.google.android.gms.internal.nn
public class class_864 implements Creator<nm> {
    // $FF: renamed from: a (com.google.android.gms.internal.nm, android.os.Parcel, int) void
    static void method_4525(class_876 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.versionCode);
        class_823.method_4313(var1, 2, var0.packageName, false);
        class_823.method_4325(var1, 3, var0.akR);
        class_823.method_4325(var1, 4, var0.akS);
        class_823.method_4313(var1, 5, var0.akT, false);
        class_823.method_4313(var1, 6, var0.akU, false);
        class_823.method_4316(var1, 7, var0.akV);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: cY (android.os.Parcel) com.google.android.gms.internal.nm
    public class_876 method_4526(Parcel var1) {
        String var2 = null;
        int var3 = 0;
        int var4 = class_824.method_4331(var1);
        boolean var5 = true;
        String var6 = null;
        int var7 = 0;
        String var8 = null;
        int var9 = 0;

        while(var1.dataPosition() < var4) {
            int var10 = class_824.method_4329(var1);
            switch(class_824.method_4340(var10)) {
                case 1:
                    var9 = class_824.method_4348(var1, var10);
                    break;
                case 2:
                    var8 = class_824.method_4356(var1, var10);
                    break;
                case 3:
                    var7 = class_824.method_4348(var1, var10);
                    break;
                case 4:
                    var3 = class_824.method_4348(var1, var10);
                    break;
                case 5:
                    var6 = class_824.method_4356(var1, var10);
                    break;
                case 6:
                    var2 = class_824.method_4356(var1, var10);
                    break;
                case 7:
                    var5 = class_824.method_4344(var1, var10);
                    break;
                default:
                    class_824.method_4341(var1, var10);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new class_876(var9, var8, var7, var3, var6, var2, var5);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_4526(var1);
    }

    // $FF: renamed from: eP (int) com.google.android.gms.internal.nm[]
    public class_876[] method_4527(int var1) {
        return new class_876[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_4527(var1);
    }
}

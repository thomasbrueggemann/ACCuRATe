package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.class_242;

// $FF: renamed from: com.google.android.gms.internal.az
public class class_241 implements Creator<ay> {
    // $FF: renamed from: a (com.google.android.gms.internal.ay, android.os.Parcel, int) void
    static void method_1591(class_242 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.versionCode);
        class_823.method_4313(var1, 2, var0.field_636, false);
        class_823.method_4325(var1, 3, var0.height);
        class_823.method_4325(var1, 4, var0.heightPixels);
        class_823.method_4316(var1, 5, var0.field_637);
        class_823.method_4325(var1, 6, var0.width);
        class_823.method_4325(var1, 7, var0.widthPixels);
        class_823.method_4319(var1, 8, var0.field_638, var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: c (android.os.Parcel) com.google.android.gms.internal.ay
    public class_242 method_1592(Parcel var1) {
        class_242[] var2 = null;
        int var3 = 0;
        int var4 = class_824.method_4331(var1);
        int var5 = 0;
        boolean var6 = false;
        int var7 = 0;
        int var8 = 0;
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
                    var8 = class_824.method_4348(var1, var11);
                    break;
                case 4:
                    var7 = class_824.method_4348(var1, var11);
                    break;
                case 5:
                    var6 = class_824.method_4344(var1, var11);
                    break;
                case 6:
                    var5 = class_824.method_4348(var1, var11);
                    break;
                case 7:
                    var3 = class_824.method_4348(var1, var11);
                    break;
                case 8:
                    var2 = (class_242[])class_824.method_4342(var1, var11, class_242.CREATOR);
                    break;
                default:
                    class_824.method_4341(var1, var11);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new class_242(var10, var9, var8, var7, var6, var5, var3, var2);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_1592(var1);
    }

    // $FF: renamed from: f (int) com.google.android.gms.internal.ay[]
    public class_242[] method_1593(int var1) {
        return new class_242[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_1593(var1);
    }
}

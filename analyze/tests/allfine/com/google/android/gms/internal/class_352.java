package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_354;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.jo
public class class_352 implements Creator<class_354.class_1756> {
    // $FF: renamed from: a (com.google.android.gms.internal.jm$a, android.os.Parcel, int) void
    static void method_2349(class_354.class_1756 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.versionCode);
        class_823.method_4313(var1, 2, var0.className, false);
        class_823.method_4326(var1, 3, var0.field_5072, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: L (android.os.Parcel) com.google.android.gms.internal.jm$a
    public class_354.class_1756 method_2350(Parcel var1) {
        ArrayList var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        String var5 = null;

        while(var1.dataPosition() < var3) {
            int var6 = class_824.method_4329(var1);
            switch(class_824.method_4340(var6)) {
                case 1:
                    var4 = class_824.method_4348(var1, var6);
                    break;
                case 2:
                    var5 = class_824.method_4356(var1, var6);
                    break;
                case 3:
                    var2 = class_824.method_4343(var1, var6, class_354.class_1757.CREATOR);
                    break;
                default:
                    class_824.method_4341(var1, var6);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_354.class_1756(var4, var5, var2);
        }
    }

    // $FF: renamed from: aL (int) com.google.android.gms.internal.jm$a[]
    public class_354.class_1756[] method_2351(int var1) {
        return new class_354.class_1756[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_2350(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_2351(var1);
    }
}

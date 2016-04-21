package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_272;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.oc
public class class_859 implements Creator<class_272.class_1165> {
    // $FF: renamed from: a (com.google.android.gms.internal.nz$b, android.os.Parcel, int) void
    static void method_4510(class_272.class_1165 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        Set var4 = var0.amc;
        if(var4.contains(Integer.valueOf(1))) {
            class_823.method_4325(var1, 1, var0.field_802);
        }

        if(var4.contains(Integer.valueOf(2))) {
            class_823.method_4309(var1, 2, var0.anv, var2, true);
        }

        if(var4.contains(Integer.valueOf(3))) {
            class_823.method_4309(var1, 3, var0.anw, var2, true);
        }

        if(var4.contains(Integer.valueOf(4))) {
            class_823.method_4325(var1, 4, var0.anx);
        }

        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_4511(var1);
    }

    // $FF: renamed from: df (android.os.Parcel) com.google.android.gms.internal.nz$b
    public class_272.class_1165 method_4511(Parcel var1) {
        class_272.class_1169 var2 = null;
        int var3 = 0;
        int var4 = class_824.method_4331(var1);
        HashSet var5 = new HashSet();
        class_272.class_1166 var6 = null;
        int var7 = 0;

        while(var1.dataPosition() < var4) {
            int var8 = class_824.method_4329(var1);
            switch(class_824.method_4340(var8)) {
                case 1:
                    var7 = class_824.method_4348(var1, var8);
                    var5.add(Integer.valueOf(1));
                    break;
                case 2:
                    class_272.class_1166 var12 = (class_272.class_1166)class_824.method_4336(var1, var8, class_272.class_1166.CREATOR);
                    var5.add(Integer.valueOf(2));
                    var6 = var12;
                    break;
                case 3:
                    class_272.class_1169 var10 = (class_272.class_1169)class_824.method_4336(var1, var8, class_272.class_1169.CREATOR);
                    var5.add(Integer.valueOf(3));
                    var2 = var10;
                    break;
                case 4:
                    var3 = class_824.method_4348(var1, var8);
                    var5.add(Integer.valueOf(4));
                    break;
                default:
                    class_824.method_4341(var1, var8);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new class_272.class_1165(var5, var7, var6, var2, var3);
        }
    }

    // $FF: renamed from: eX (int) com.google.android.gms.internal.nz$b[]
    public class_272.class_1165[] method_4512(int var1) {
        return new class_272.class_1165[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_4512(var1);
    }
}

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_271;
import com.google.android.gms.internal.class_273;
import com.google.android.gms.internal.nw;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.nx
public class class_863 implements Creator<nw> {
    // $FF: renamed from: a (com.google.android.gms.internal.nw, android.os.Parcel, int) void
    static void method_4522(class_273 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        Set var4 = var0.amc;
        if(var4.contains(Integer.valueOf(1))) {
            class_823.method_4325(var1, 1, var0.field_820);
        }

        if(var4.contains(Integer.valueOf(2))) {
            class_823.method_4313(var1, 2, var0.field_819, true);
        }

        if(var4.contains(Integer.valueOf(4))) {
            class_823.method_4309(var1, 4, var0.amX, var2, true);
        }

        if(var4.contains(Integer.valueOf(5))) {
            class_823.method_4313(var1, 5, var0.amP, true);
        }

        if(var4.contains(Integer.valueOf(6))) {
            class_823.method_4309(var1, 6, var0.amY, var2, true);
        }

        if(var4.contains(Integer.valueOf(7))) {
            class_823.method_4313(var1, 7, var0.field_821, true);
        }

        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_4523(var1);
    }

    // $FF: renamed from: dc (android.os.Parcel) com.google.android.gms.internal.nw
    public class_273 method_4523(Parcel var1) {
        String var2 = null;
        int var3 = class_824.method_4331(var1);
        HashSet var4 = new HashSet();
        int var5 = 0;
        class_271 var6 = null;
        String var7 = null;
        class_271 var8 = null;
        String var9 = null;

        while(var1.dataPosition() < var3) {
            int var10 = class_824.method_4329(var1);
            switch(class_824.method_4340(var10)) {
                case 1:
                    var5 = class_824.method_4348(var1, var10);
                    var4.add(Integer.valueOf(1));
                    break;
                case 2:
                    var9 = class_824.method_4356(var1, var10);
                    var4.add(Integer.valueOf(2));
                    break;
                case 3:
                default:
                    class_824.method_4341(var1, var10);
                    break;
                case 4:
                    class_271 var15 = (class_271)class_824.method_4336(var1, var10, class_271.CREATOR);
                    var4.add(Integer.valueOf(4));
                    var8 = var15;
                    break;
                case 5:
                    var7 = class_824.method_4356(var1, var10);
                    var4.add(Integer.valueOf(5));
                    break;
                case 6:
                    class_271 var12 = (class_271)class_824.method_4336(var1, var10, class_271.CREATOR);
                    var4.add(Integer.valueOf(6));
                    var6 = var12;
                    break;
                case 7:
                    var2 = class_824.method_4356(var1, var10);
                    var4.add(Integer.valueOf(7));
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new class_273(var4, var5, var9, var8, var7, var6, var2);
        }
    }

    // $FF: renamed from: eU (int) com.google.android.gms.internal.nw[]
    public class_273[] method_4524(int var1) {
        return new class_273[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_4524(var1);
    }
}

package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.wallet.LineItem;

// $FF: renamed from: com.google.android.gms.wallet.i
public class class_1025 implements Creator<LineItem> {
    // $FF: renamed from: a (com.google.android.gms.wallet.LineItem, android.os.Parcel, int) void
    static void method_5348(LineItem var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4313(var1, 2, var0.description, false);
        class_823.method_4313(var1, 3, var0.asP, false);
        class_823.method_4313(var1, 4, var0.asQ, false);
        class_823.method_4313(var1, 5, var0.asv, false);
        class_823.method_4325(var1, 6, var0.asR);
        class_823.method_4313(var1, 7, var0.asw, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5349(var1);
    }

    // $FF: renamed from: du (android.os.Parcel) com.google.android.gms.wallet.LineItem
    public LineItem method_5349(Parcel var1) {
        int var2 = 0;
        String var3 = null;
        int var4 = class_824.method_4331(var1);
        String var5 = null;
        String var6 = null;
        String var7 = null;
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
                    var7 = class_824.method_4356(var1, var10);
                    break;
                case 4:
                    var6 = class_824.method_4356(var1, var10);
                    break;
                case 5:
                    var5 = class_824.method_4356(var1, var10);
                    break;
                case 6:
                    var2 = class_824.method_4348(var1, var10);
                    break;
                case 7:
                    var3 = class_824.method_4356(var1, var10);
                    break;
                default:
                    class_824.method_4341(var1, var10);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new LineItem(var9, var8, var7, var6, var5, var2, var3);
        }
    }

    // $FF: renamed from: fv (int) com.google.android.gms.wallet.LineItem[]
    public LineItem[] method_5350(int var1) {
        return new LineItem[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5350(var1);
    }
}

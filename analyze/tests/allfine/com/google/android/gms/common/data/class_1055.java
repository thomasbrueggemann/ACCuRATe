package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;

// $FF: renamed from: com.google.android.gms.common.data.f
public class class_1055 implements Creator<DataHolder> {
    // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, android.os.Parcel, int) void
    static void method_5519(DataHolder var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4320(var1, 1, var0.method_5996(), false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4319(var1, 2, var0.method_5997(), var2, false);
        class_823.method_4325(var1, 3, var0.getStatusCode());
        class_823.method_4306(var1, 4, var0.method_5998(), false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: at (int) com.google.android.gms.common.data.DataHolder[]
    public DataHolder[] method_5520(int var1) {
        return new DataHolder[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5521(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5520(var1);
    }

    // $FF: renamed from: z (android.os.Parcel) com.google.android.gms.common.data.DataHolder
    public DataHolder method_5521(Parcel var1) {
        int var2 = 0;
        Bundle var3 = null;
        int var4 = class_824.method_4331(var1);
        CursorWindow[] var5 = null;
        String[] var6 = null;
        int var7 = 0;

        while(var1.dataPosition() < var4) {
            int var9 = class_824.method_4329(var1);
            switch(class_824.method_4340(var9)) {
                case 1:
                    var6 = class_824.method_4328(var1, var9);
                    break;
                case 2:
                    var5 = (CursorWindow[])class_824.method_4342(var1, var9, CursorWindow.CREATOR);
                    break;
                case 3:
                    var2 = class_824.method_4348(var1, var9);
                    break;
                case 4:
                    var3 = class_824.method_4358(var1, var9);
                    break;
                case 1000:
                    var7 = class_824.method_4348(var1, var9);
                    break;
                default:
                    class_824.method_4341(var1, var9);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            DataHolder var8 = new DataHolder(var7, var6, var5, var2, var3);
            var8.method_5995();
            return var8;
        }
    }
}

package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.CustomProperty;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.drive.metadata.internal.a
public class class_961 implements Creator<AppVisibleCustomProperties> {
    // $FF: renamed from: a (com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties, android.os.Parcel, int) void
    static void method_5089(AppVisibleCustomProperties var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_2950);
        class_823.method_4326(var1, 2, var0.field_2951, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: aF (android.os.Parcel) com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties
    public AppVisibleCustomProperties method_5090(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        ArrayList var4 = null;

        while(var1.dataPosition() < var2) {
            int var5 = class_824.method_4329(var1);
            switch(class_824.method_4340(var5)) {
                case 1:
                    var3 = class_824.method_4348(var1, var5);
                    break;
                case 2:
                    var4 = class_824.method_4343(var1, var5, CustomProperty.CREATOR);
                    break;
                default:
                    class_824.method_4341(var1, var5);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new AppVisibleCustomProperties(var3, var4);
        }
    }

    // $FF: renamed from: bR (int) com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties[]
    public AppVisibleCustomProperties[] method_5091(int var1) {
        return new AppVisibleCustomProperties[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5090(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5091(var1);
    }
}

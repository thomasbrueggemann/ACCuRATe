package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.internal.InFilter;

// $FF: renamed from: com.google.android.gms.drive.query.internal.h
public class class_1044 implements Creator<InFilter> {
    // $FF: renamed from: a (com.google.android.gms.drive.query.internal.InFilter, android.os.Parcel, int) void
    static void method_5412(InFilter var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1000, var0.field_2022);
        class_823.method_4309(var1, 1, var0.field_2023, var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: aP (android.os.Parcel) com.google.android.gms.drive.query.internal.InFilter
    public InFilter method_5413(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        MetadataBundle var4 = null;

        while(var1.dataPosition() < var2) {
            int var5 = class_824.method_4329(var1);
            switch(class_824.method_4340(var5)) {
                case 1:
                    var4 = (MetadataBundle)class_824.method_4336(var1, var5, MetadataBundle.CREATOR);
                    break;
                case 1000:
                    var3 = class_824.method_4348(var1, var5);
                    break;
                default:
                    class_824.method_4341(var1, var5);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new InFilter(var3, var4);
        }
    }

    // $FF: renamed from: cb (int) com.google.android.gms.drive.query.internal.InFilter[]
    public InFilter[] method_5414(int var1) {
        return new InFilter[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5413(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5414(var1);
    }
}

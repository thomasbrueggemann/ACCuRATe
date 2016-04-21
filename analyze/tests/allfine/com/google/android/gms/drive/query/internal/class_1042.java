package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.query.internal.MatchAllFilter;

// $FF: renamed from: com.google.android.gms.drive.query.internal.j
public class class_1042 implements Creator<MatchAllFilter> {
    // $FF: renamed from: a (com.google.android.gms.drive.query.internal.MatchAllFilter, android.os.Parcel, int) void
    static void method_5406(MatchAllFilter var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1000, var0.field_2039);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: aR (android.os.Parcel) com.google.android.gms.drive.query.internal.MatchAllFilter
    public MatchAllFilter method_5407(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;

        while(var1.dataPosition() < var2) {
            int var4 = class_824.method_4329(var1);
            switch(class_824.method_4340(var4)) {
                case 1000:
                    var3 = class_824.method_4348(var1, var4);
                    break;
                default:
                    class_824.method_4341(var1, var4);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new MatchAllFilter(var3);
        }
    }

    // $FF: renamed from: cd (int) com.google.android.gms.drive.query.internal.MatchAllFilter[]
    public MatchAllFilter[] method_5408(int var1) {
        return new MatchAllFilter[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5407(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5408(var1);
    }
}

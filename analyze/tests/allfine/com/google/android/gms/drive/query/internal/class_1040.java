package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.FieldOnlyFilter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.HasFilter;
import com.google.android.gms.drive.query.internal.InFilter;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.NotFilter;

// $FF: renamed from: com.google.android.gms.drive.query.internal.d
public class class_1040 implements Creator<FilterHolder> {
    // $FF: renamed from: a (com.google.android.gms.drive.query.internal.FilterHolder, android.os.Parcel, int) void
    static void method_5400(FilterHolder var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4309(var1, 1, var0.field_869, var2, false);
        class_823.method_4325(var1, 1000, var0.field_868);
        class_823.method_4309(var1, 2, var0.field_870, var2, false);
        class_823.method_4309(var1, 3, var0.field_871, var2, false);
        class_823.method_4309(var1, 4, var0.field_872, var2, false);
        class_823.method_4309(var1, 5, var0.field_873, var2, false);
        class_823.method_4309(var1, 6, var0.field_874, var2, false);
        class_823.method_4309(var1, 7, var0.field_875, var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: aN (android.os.Parcel) com.google.android.gms.drive.query.internal.FilterHolder
    public FilterHolder method_5401(Parcel var1) {
        HasFilter var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        MatchAllFilter var5 = null;
        InFilter var6 = null;
        NotFilter var7 = null;
        LogicalFilter var8 = null;
        FieldOnlyFilter var9 = null;
        ComparisonFilter var10 = null;

        while(var1.dataPosition() < var3) {
            int var11 = class_824.method_4329(var1);
            switch(class_824.method_4340(var11)) {
                case 1:
                    var10 = (ComparisonFilter)class_824.method_4336(var1, var11, ComparisonFilter.CREATOR);
                    break;
                case 2:
                    var9 = (FieldOnlyFilter)class_824.method_4336(var1, var11, FieldOnlyFilter.CREATOR);
                    break;
                case 3:
                    var8 = (LogicalFilter)class_824.method_4336(var1, var11, LogicalFilter.CREATOR);
                    break;
                case 4:
                    var7 = (NotFilter)class_824.method_4336(var1, var11, NotFilter.CREATOR);
                    break;
                case 5:
                    var6 = (InFilter)class_824.method_4336(var1, var11, InFilter.CREATOR);
                    break;
                case 6:
                    var5 = (MatchAllFilter)class_824.method_4336(var1, var11, MatchAllFilter.CREATOR);
                    break;
                case 7:
                    var2 = (HasFilter)class_824.method_4336(var1, var11, HasFilter.CREATOR);
                    break;
                case 1000:
                    var4 = class_824.method_4348(var1, var11);
                    break;
                default:
                    class_824.method_4341(var1, var11);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new FilterHolder(var4, var10, var9, var8, var7, var6, var5, var2);
        }
    }

    // $FF: renamed from: bZ (int) com.google.android.gms.drive.query.internal.FilterHolder[]
    public FilterHolder[] method_5402(int var1) {
        return new FilterHolder[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5401(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5402(var1);
    }
}

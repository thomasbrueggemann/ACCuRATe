package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.SortOrder;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.drive.query.a
public class class_945 implements Creator<Query> {
    // $FF: renamed from: a (com.google.android.gms.drive.query.Query, android.os.Parcel, int) void
    static void method_4933(Query var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1000, var0.field_4095);
        class_823.method_4309(var1, 1, var0.field_4096, var2, false);
        class_823.method_4313(var1, 3, var0.field_4097, false);
        class_823.method_4309(var1, 4, var0.field_4098, var2, false);
        class_823.method_4324(var1, 5, var0.field_4099, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: aI (android.os.Parcel) com.google.android.gms.drive.query.Query
    public Query method_4934(Parcel var1) {
        ArrayList var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        SortOrder var5 = null;
        String var6 = null;
        LogicalFilter var7 = null;

        while(var1.dataPosition() < var3) {
            int var8 = class_824.method_4329(var1);
            switch(class_824.method_4340(var8)) {
                case 1:
                    var7 = (LogicalFilter)class_824.method_4336(var1, var8, LogicalFilter.CREATOR);
                    break;
                case 3:
                    var6 = class_824.method_4356(var1, var8);
                    break;
                case 4:
                    var5 = (SortOrder)class_824.method_4336(var1, var8, SortOrder.CREATOR);
                    break;
                case 5:
                    var2 = class_824.method_4332(var1, var8);
                    break;
                case 1000:
                    var4 = class_824.method_4348(var1, var8);
                    break;
                default:
                    class_824.method_4341(var1, var8);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new Query(var4, var7, var6, var5, var2);
        }
    }

    // $FF: renamed from: bU (int) com.google.android.gms.drive.query.Query[]
    public Query[] method_4935(int var1) {
        return new Query[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_4934(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_4935(var1);
    }
}

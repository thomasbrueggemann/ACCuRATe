package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.query.SortOrder;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.drive.query.b
public class class_946 implements Creator<SortOrder> {
    // $FF: renamed from: a (com.google.android.gms.drive.query.SortOrder, android.os.Parcel, int) void
    static void method_4942(SortOrder var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1000, var0.field_1044);
        class_823.method_4326(var1, 1, var0.field_1045, false);
        class_823.method_4316(var1, 2, var0.field_1046);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: aJ (android.os.Parcel) com.google.android.gms.drive.query.SortOrder
    public SortOrder method_4943(Parcel var1) {
        boolean var2 = false;
        int var3 = class_824.method_4331(var1);
        ArrayList var4 = null;
        int var5 = 0;

        while(var1.dataPosition() < var3) {
            int var6 = class_824.method_4329(var1);
            switch(class_824.method_4340(var6)) {
                case 1:
                    var4 = class_824.method_4343(var1, var6, FieldWithSortOrder.CREATOR);
                    break;
                case 2:
                    var2 = class_824.method_4344(var1, var6);
                    break;
                case 1000:
                    var5 = class_824.method_4348(var1, var6);
                    break;
                default:
                    class_824.method_4341(var1, var6);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new SortOrder(var5, var4, var2);
        }
    }

    // $FF: renamed from: bV (int) com.google.android.gms.drive.query.SortOrder[]
    public SortOrder[] method_4944(int var1) {
        return new SortOrder[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_4943(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_4944(var1);
    }
}

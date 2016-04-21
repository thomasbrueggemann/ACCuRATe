package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;

// $FF: renamed from: com.google.android.gms.drive.query.internal.c
public class class_1035 implements Creator<FieldWithSortOrder> {
    // $FF: renamed from: a (com.google.android.gms.drive.query.internal.FieldWithSortOrder, android.os.Parcel, int) void
    static void method_5387(FieldWithSortOrder var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1000, var0.field_3184);
        class_823.method_4313(var1, 1, var0.field_3185, false);
        class_823.method_4316(var1, 2, var0.field_3186);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: aM (android.os.Parcel) com.google.android.gms.drive.query.internal.FieldWithSortOrder
    public FieldWithSortOrder method_5388(Parcel var1) {
        boolean var2 = false;
        int var3 = class_824.method_4331(var1);
        String var4 = null;
        int var5 = 0;

        while(var1.dataPosition() < var3) {
            int var6 = class_824.method_4329(var1);
            switch(class_824.method_4340(var6)) {
                case 1:
                    var4 = class_824.method_4356(var1, var6);
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
            return new FieldWithSortOrder(var5, var4, var2);
        }
    }

    // $FF: renamed from: bY (int) com.google.android.gms.drive.query.internal.FieldWithSortOrder[]
    public FieldWithSortOrder[] method_5389(int var1) {
        return new FieldWithSortOrder[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5388(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5389(var1);
    }
}

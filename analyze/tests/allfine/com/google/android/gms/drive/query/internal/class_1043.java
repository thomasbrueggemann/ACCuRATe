package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.drive.query.internal.i
public class class_1043 implements Creator<LogicalFilter> {
    // $FF: renamed from: a (com.google.android.gms.drive.query.internal.LogicalFilter, android.os.Parcel, int) void
    static void method_5409(LogicalFilter var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1000, var0.field_2025);
        class_823.method_4309(var1, 1, var0.field_2027, var2, false);
        class_823.method_4326(var1, 2, var0.field_2028, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: aQ (android.os.Parcel) com.google.android.gms.drive.query.internal.LogicalFilter
    public LogicalFilter method_5410(Parcel var1) {
        ArrayList var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;

        Operator var5;
        ArrayList var7;
        for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
            int var6 = class_824.method_4329(var1);
            Operator var8;
            int var9;
            switch(class_824.method_4340(var6)) {
                case 1:
                    Operator var10 = (Operator)class_824.method_4336(var1, var6, Operator.CREATOR);
                    var9 = var4;
                    var7 = var2;
                    var8 = var10;
                    break;
                case 2:
                    var7 = class_824.method_4343(var1, var6, FilterHolder.CREATOR);
                    var8 = var5;
                    var9 = var4;
                    break;
                case 1000:
                    int var11 = class_824.method_4348(var1, var6);
                    var8 = var5;
                    var9 = var11;
                    var7 = var2;
                    break;
                default:
                    class_824.method_4341(var1, var6);
                    var7 = var2;
                    var8 = var5;
                    var9 = var4;
            }

            var4 = var9;
            var5 = var8;
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new LogicalFilter(var4, var5, var2);
        }
    }

    // $FF: renamed from: cc (int) com.google.android.gms.drive.query.internal.LogicalFilter[]
    public LogicalFilter[] method_5411(int var1) {
        return new LogicalFilter[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5410(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5411(var1);
    }
}

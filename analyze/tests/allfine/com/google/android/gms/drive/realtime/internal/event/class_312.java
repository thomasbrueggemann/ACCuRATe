package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.realtime.internal.event.ValuesAddedDetails;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.event.h
public class class_312 implements Creator<ValuesAddedDetails> {
    // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.event.ValuesAddedDetails, android.os.Parcel, int) void
    static void method_2187(ValuesAddedDetails var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_4135);
        class_823.method_4325(var1, 2, var0.mIndex);
        class_823.method_4325(var1, 3, var0.field_4138);
        class_823.method_4325(var1, 4, var0.field_4139);
        class_823.method_4313(var1, 5, var0.field_4136, false);
        class_823.method_4325(var1, 6, var0.field_4137);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bf (android.os.Parcel) com.google.android.gms.drive.realtime.internal.event.ValuesAddedDetails
    public ValuesAddedDetails method_2188(Parcel var1) {
        int var2 = 0;
        int var3 = class_824.method_4331(var1);
        String var4 = null;
        int var5 = 0;
        int var6 = 0;
        int var7 = 0;
        int var8 = 0;

        while(var1.dataPosition() < var3) {
            int var9 = class_824.method_4329(var1);
            switch(class_824.method_4340(var9)) {
                case 1:
                    var8 = class_824.method_4348(var1, var9);
                    break;
                case 2:
                    var7 = class_824.method_4348(var1, var9);
                    break;
                case 3:
                    var6 = class_824.method_4348(var1, var9);
                    break;
                case 4:
                    var5 = class_824.method_4348(var1, var9);
                    break;
                case 5:
                    var4 = class_824.method_4356(var1, var9);
                    break;
                case 6:
                    var2 = class_824.method_4348(var1, var9);
                    break;
                default:
                    class_824.method_4341(var1, var9);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new ValuesAddedDetails(var8, var7, var6, var5, var4, var2);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_2188(var1);
    }

    // $FF: renamed from: cs (int) com.google.android.gms.drive.realtime.internal.event.ValuesAddedDetails[]
    public ValuesAddedDetails[] method_2189(int var1) {
        return new ValuesAddedDetails[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_2189(var1);
    }
}

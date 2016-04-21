package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.realtime.internal.event.ReferenceShiftedDetails;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.event.d
public class class_316 implements Creator<ReferenceShiftedDetails> {
    // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.event.ReferenceShiftedDetails, android.os.Parcel, int) void
    static void method_2199(ReferenceShiftedDetails var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_4697);
        class_823.method_4313(var1, 2, var0.field_4698, false);
        class_823.method_4313(var1, 3, var0.field_4699, false);
        class_823.method_4325(var1, 4, var0.field_4700);
        class_823.method_4325(var1, 5, var0.field_4701);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bb (android.os.Parcel) com.google.android.gms.drive.realtime.internal.event.ReferenceShiftedDetails
    public ReferenceShiftedDetails method_2200(Parcel var1) {
        String var2 = null;
        int var3 = 0;
        int var4 = class_824.method_4331(var1);
        int var5 = 0;
        String var6 = null;
        int var7 = 0;

        while(var1.dataPosition() < var4) {
            int var8 = class_824.method_4329(var1);
            switch(class_824.method_4340(var8)) {
                case 1:
                    var7 = class_824.method_4348(var1, var8);
                    break;
                case 2:
                    var6 = class_824.method_4356(var1, var8);
                    break;
                case 3:
                    var2 = class_824.method_4356(var1, var8);
                    break;
                case 4:
                    var5 = class_824.method_4348(var1, var8);
                    break;
                case 5:
                    var3 = class_824.method_4348(var1, var8);
                    break;
                default:
                    class_824.method_4341(var1, var8);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new ReferenceShiftedDetails(var7, var6, var2, var5, var3);
        }
    }

    // $FF: renamed from: co (int) com.google.android.gms.drive.realtime.internal.event.ReferenceShiftedDetails[]
    public ReferenceShiftedDetails[] method_2201(int var1) {
        return new ReferenceShiftedDetails[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_2200(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_2201(var1);
    }
}

package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.realtime.internal.event.ValueChangedDetails;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.event.g
public class class_315 implements Creator<ValueChangedDetails> {
    // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.event.ValueChangedDetails, android.os.Parcel, int) void
    static void method_2196(ValueChangedDetails var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_1546);
        class_823.method_4325(var1, 2, var0.field_1547);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: be (android.os.Parcel) com.google.android.gms.drive.realtime.internal.event.ValueChangedDetails
    public ValueChangedDetails method_2197(Parcel var1) {
        int var2 = 0;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;

        while(var1.dataPosition() < var3) {
            int var5 = class_824.method_4329(var1);
            switch(class_824.method_4340(var5)) {
                case 1:
                    var4 = class_824.method_4348(var1, var5);
                    break;
                case 2:
                    var2 = class_824.method_4348(var1, var5);
                    break;
                default:
                    class_824.method_4341(var1, var5);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new ValueChangedDetails(var4, var2);
        }
    }

    // $FF: renamed from: cr (int) com.google.android.gms.drive.realtime.internal.event.ValueChangedDetails[]
    public ValueChangedDetails[] method_2198(int var1) {
        return new ValueChangedDetails[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_2197(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_2198(var1);
    }
}

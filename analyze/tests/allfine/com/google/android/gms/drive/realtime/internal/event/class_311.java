package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.realtime.internal.event.ValuesSetDetails;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.event.j
public class class_311 implements Creator<ValuesSetDetails> {
    // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.event.ValuesSetDetails, android.os.Parcel, int) void
    static void method_2183(ValuesSetDetails var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_2110);
        class_823.method_4325(var1, 2, var0.mIndex);
        class_823.method_4325(var1, 3, var0.field_2111);
        class_823.method_4325(var1, 4, var0.field_2112);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bh (android.os.Parcel) com.google.android.gms.drive.realtime.internal.event.ValuesSetDetails
    public ValuesSetDetails method_2184(Parcel var1) {
        int var2 = 0;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        int var5 = 0;
        int var6 = 0;

        while(var1.dataPosition() < var3) {
            int var7 = class_824.method_4329(var1);
            switch(class_824.method_4340(var7)) {
                case 1:
                    var6 = class_824.method_4348(var1, var7);
                    break;
                case 2:
                    var5 = class_824.method_4348(var1, var7);
                    break;
                case 3:
                    var4 = class_824.method_4348(var1, var7);
                    break;
                case 4:
                    var2 = class_824.method_4348(var1, var7);
                    break;
                default:
                    class_824.method_4341(var1, var7);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new ValuesSetDetails(var6, var5, var4, var2);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_2184(var1);
    }

    // $FF: renamed from: cu (int) com.google.android.gms.drive.realtime.internal.event.ValuesSetDetails[]
    public ValuesSetDetails[] method_2185(int var1) {
        return new ValuesSetDetails[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_2185(var1);
    }
}

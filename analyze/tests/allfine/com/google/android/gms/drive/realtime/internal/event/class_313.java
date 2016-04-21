package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.realtime.internal.event.ValuesRemovedDetails;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.event.i
public class class_313 implements Creator<ValuesRemovedDetails> {
    // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.event.ValuesRemovedDetails, android.os.Parcel, int) void
    static void method_2190(ValuesRemovedDetails var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_2105);
        class_823.method_4325(var1, 2, var0.mIndex);
        class_823.method_4325(var1, 3, var0.field_2108);
        class_823.method_4325(var1, 4, var0.field_2109);
        class_823.method_4313(var1, 5, var0.field_2106, false);
        class_823.method_4325(var1, 6, var0.field_2107);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bg (android.os.Parcel) com.google.android.gms.drive.realtime.internal.event.ValuesRemovedDetails
    public ValuesRemovedDetails method_2191(Parcel var1) {
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
            return new ValuesRemovedDetails(var8, var7, var6, var5, var4, var2);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_2191(var1);
    }

    // $FF: renamed from: ct (int) com.google.android.gms.drive.realtime.internal.event.ValuesRemovedDetails[]
    public ValuesRemovedDetails[] method_2192(int var1) {
        return new ValuesRemovedDetails[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_2192(var1);
    }
}

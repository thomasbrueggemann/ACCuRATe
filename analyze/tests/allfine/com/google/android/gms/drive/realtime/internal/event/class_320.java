package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.realtime.internal.event.ObjectChangedDetails;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.event.a
public class class_320 implements Creator<ObjectChangedDetails> {
    // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.event.ObjectChangedDetails, android.os.Parcel, int) void
    static void method_2211(ObjectChangedDetails var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_1476);
        class_823.method_4325(var1, 2, var0.field_1477);
        class_823.method_4325(var1, 3, var0.field_1478);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: aY (android.os.Parcel) com.google.android.gms.drive.realtime.internal.event.ObjectChangedDetails
    public ObjectChangedDetails method_2212(Parcel var1) {
        int var2 = 0;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        int var5 = 0;

        while(var1.dataPosition() < var3) {
            int var6 = class_824.method_4329(var1);
            switch(class_824.method_4340(var6)) {
                case 1:
                    var5 = class_824.method_4348(var1, var6);
                    break;
                case 2:
                    var4 = class_824.method_4348(var1, var6);
                    break;
                case 3:
                    var2 = class_824.method_4348(var1, var6);
                    break;
                default:
                    class_824.method_4341(var1, var6);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new ObjectChangedDetails(var5, var4, var2);
        }
    }

    // $FF: renamed from: cl (int) com.google.android.gms.drive.realtime.internal.event.ObjectChangedDetails[]
    public ObjectChangedDetails[] method_2213(int var1) {
        return new ObjectChangedDetails[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_2212(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_2213(var1);
    }
}

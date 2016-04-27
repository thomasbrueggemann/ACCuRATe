package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.realtime.internal.event.TextInsertedDetails;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.event.f
public class class_314 implements Creator<TextInsertedDetails> {
    // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.event.TextInsertedDetails, android.os.Parcel, int) void
    static void method_2193(TextInsertedDetails var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_4538);
        class_823.method_4325(var1, 2, var0.mIndex);
        class_823.method_4325(var1, 3, var0.field_4539);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bd (android.os.Parcel) com.google.android.gms.drive.realtime.internal.event.TextInsertedDetails
    public TextInsertedDetails method_2194(Parcel var1) {
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
            return new TextInsertedDetails(var5, var4, var2);
        }
    }

    // $FF: renamed from: cq (int) com.google.android.gms.drive.realtime.internal.event.TextInsertedDetails[]
    public TextInsertedDetails[] method_2195(int var1) {
        return new TextInsertedDetails[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_2194(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_2195(var1);
    }
}
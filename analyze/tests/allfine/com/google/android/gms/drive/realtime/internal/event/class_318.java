package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.realtime.internal.event.ObjectChangedDetails;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;
import com.google.android.gms.drive.realtime.internal.event.ReferenceShiftedDetails;
import com.google.android.gms.drive.realtime.internal.event.TextDeletedDetails;
import com.google.android.gms.drive.realtime.internal.event.TextInsertedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValueChangedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesAddedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesRemovedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesSetDetails;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.event.b
public class class_318 implements Creator<ParcelableEvent> {
    // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.event.ParcelableEvent, android.os.Parcel, int) void
    static void method_2205(ParcelableEvent var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_3940);
        class_823.method_4313(var1, 2, var0.field_3954, false);
        class_823.method_4313(var1, 3, var0.field_3945, false);
        class_823.method_4324(var1, 4, var0.field_3947, false);
        class_823.method_4316(var1, 5, var0.field_3948);
        class_823.method_4313(var1, 6, var0.field_3946, false);
        class_823.method_4313(var1, 7, var0.field_3949, false);
        class_823.method_4309(var1, 8, var0.field_3950, var2, false);
        class_823.method_4309(var1, 9, var0.field_3951, var2, false);
        class_823.method_4309(var1, 10, var0.field_3952, var2, false);
        class_823.method_4309(var1, 11, var0.field_3953, var2, false);
        class_823.method_4309(var1, 12, var0.field_3941, var2, false);
        class_823.method_4309(var1, 13, var0.field_3942, var2, false);
        class_823.method_4309(var1, 14, var0.field_3943, var2, false);
        class_823.method_4309(var1, 15, var0.field_3944, var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: aZ (android.os.Parcel) com.google.android.gms.drive.realtime.internal.event.ParcelableEvent
    public ParcelableEvent method_2206(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        String var4 = null;
        String var5 = null;
        ArrayList var6 = null;
        boolean var7 = false;
        String var8 = null;
        String var9 = null;
        TextInsertedDetails var10 = null;
        TextDeletedDetails var11 = null;
        ValuesAddedDetails var12 = null;
        ValuesRemovedDetails var13 = null;
        ValuesSetDetails var14 = null;
        ValueChangedDetails var15 = null;
        ReferenceShiftedDetails var16 = null;
        ObjectChangedDetails var17 = null;

        while(var1.dataPosition() < var2) {
            int var18 = class_824.method_4329(var1);
            switch(class_824.method_4340(var18)) {
                case 1:
                    var3 = class_824.method_4348(var1, var18);
                    break;
                case 2:
                    var4 = class_824.method_4356(var1, var18);
                    break;
                case 3:
                    var5 = class_824.method_4356(var1, var18);
                    break;
                case 4:
                    var6 = class_824.method_4332(var1, var18);
                    break;
                case 5:
                    var7 = class_824.method_4344(var1, var18);
                    break;
                case 6:
                    var8 = class_824.method_4356(var1, var18);
                    break;
                case 7:
                    var9 = class_824.method_4356(var1, var18);
                    break;
                case 8:
                    var10 = (TextInsertedDetails)class_824.method_4336(var1, var18, TextInsertedDetails.CREATOR);
                    break;
                case 9:
                    var11 = (TextDeletedDetails)class_824.method_4336(var1, var18, TextDeletedDetails.CREATOR);
                    break;
                case 10:
                    var12 = (ValuesAddedDetails)class_824.method_4336(var1, var18, ValuesAddedDetails.CREATOR);
                    break;
                case 11:
                    var13 = (ValuesRemovedDetails)class_824.method_4336(var1, var18, ValuesRemovedDetails.CREATOR);
                    break;
                case 12:
                    var14 = (ValuesSetDetails)class_824.method_4336(var1, var18, ValuesSetDetails.CREATOR);
                    break;
                case 13:
                    var15 = (ValueChangedDetails)class_824.method_4336(var1, var18, ValueChangedDetails.CREATOR);
                    break;
                case 14:
                    var16 = (ReferenceShiftedDetails)class_824.method_4336(var1, var18, ReferenceShiftedDetails.CREATOR);
                    break;
                case 15:
                    var17 = (ObjectChangedDetails)class_824.method_4336(var1, var18, ObjectChangedDetails.CREATOR);
                    break;
                default:
                    class_824.method_4341(var1, var18);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new ParcelableEvent(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17);
        }
    }

    // $FF: renamed from: cm (int) com.google.android.gms.drive.realtime.internal.event.ParcelableEvent[]
    public ParcelableEvent[] method_2207(int var1) {
        return new ParcelableEvent[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_2206(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_2207(var1);
    }
}

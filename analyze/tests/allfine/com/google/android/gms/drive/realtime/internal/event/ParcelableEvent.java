package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.ObjectChangedDetails;
import com.google.android.gms.drive.realtime.internal.event.ReferenceShiftedDetails;
import com.google.android.gms.drive.realtime.internal.event.TextDeletedDetails;
import com.google.android.gms.drive.realtime.internal.event.TextInsertedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValueChangedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesAddedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesRemovedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesSetDetails;
import com.google.android.gms.drive.realtime.internal.event.class_318;
import java.util.List;

public class ParcelableEvent implements SafeParcelable {
    public static final Creator<ParcelableEvent> CREATOR = new class_318();
    // $FF: renamed from: BR int
    final int field_3940;
    // $FF: renamed from: RA com.google.android.gms.drive.realtime.internal.event.ValuesSetDetails
    final ValuesSetDetails field_3941;
    // $FF: renamed from: RB com.google.android.gms.drive.realtime.internal.event.ValueChangedDetails
    final ValueChangedDetails field_3942;
    // $FF: renamed from: RC com.google.android.gms.drive.realtime.internal.event.ReferenceShiftedDetails
    final ReferenceShiftedDetails field_3943;
    // $FF: renamed from: RD com.google.android.gms.drive.realtime.internal.event.ObjectChangedDetails
    final ObjectChangedDetails field_3944;
    // $FF: renamed from: Rm java.lang.String
    final String field_3945;
    // $FF: renamed from: Rp java.lang.String
    final String field_3946;
    // $FF: renamed from: Rt java.util.List
    final List<String> field_3947;
    // $FF: renamed from: Ru boolean
    final boolean field_3948;
    // $FF: renamed from: Rv java.lang.String
    final String field_3949;
    // $FF: renamed from: Rw com.google.android.gms.drive.realtime.internal.event.TextInsertedDetails
    final TextInsertedDetails field_3950;
    // $FF: renamed from: Rx com.google.android.gms.drive.realtime.internal.event.TextDeletedDetails
    final TextDeletedDetails field_3951;
    // $FF: renamed from: Ry com.google.android.gms.drive.realtime.internal.event.ValuesAddedDetails
    final ValuesAddedDetails field_3952;
    // $FF: renamed from: Rz com.google.android.gms.drive.realtime.internal.event.ValuesRemovedDetails
    final ValuesRemovedDetails field_3953;
    // $FF: renamed from: vL java.lang.String
    final String field_3954;

    ParcelableEvent(int var1, String var2, String var3, List<String> var4, boolean var5, String var6, String var7, TextInsertedDetails var8, TextDeletedDetails var9, ValuesAddedDetails var10, ValuesRemovedDetails var11, ValuesSetDetails var12, ValueChangedDetails var13, ReferenceShiftedDetails var14, ObjectChangedDetails var15) {
        this.field_3940 = var1;
        this.field_3954 = var2;
        this.field_3945 = var3;
        this.field_3947 = var4;
        this.field_3948 = var5;
        this.field_3946 = var6;
        this.field_3949 = var7;
        this.field_3950 = var8;
        this.field_3951 = var9;
        this.field_3952 = var10;
        this.field_3953 = var11;
        this.field_3941 = var12;
        this.field_3942 = var13;
        this.field_3943 = var14;
        this.field_3944 = var15;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_318.method_2205(this, var1, var2);
    }
}

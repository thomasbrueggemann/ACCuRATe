package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.class_312;

public class ValuesAddedDetails implements SafeParcelable {
    public static final Creator<ValuesAddedDetails> CREATOR = new class_312();
    // $FF: renamed from: BR int
    final int field_4135;
    // $FF: renamed from: RN java.lang.String
    final String field_4136;
    // $FF: renamed from: RO int
    final int field_4137;
    // $FF: renamed from: Rr int
    final int field_4138;
    // $FF: renamed from: Rs int
    final int field_4139;
    final int mIndex;

    ValuesAddedDetails(int var1, int var2, int var3, int var4, String var5, int var6) {
        this.field_4135 = var1;
        this.mIndex = var2;
        this.field_4138 = var3;
        this.field_4139 = var4;
        this.field_4136 = var5;
        this.field_4137 = var6;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_312.method_2187(this, var1, var2);
    }
}

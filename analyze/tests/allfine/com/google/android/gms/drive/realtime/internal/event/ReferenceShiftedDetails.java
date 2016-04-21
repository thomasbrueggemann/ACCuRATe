package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.class_316;

public class ReferenceShiftedDetails implements SafeParcelable {
    public static final Creator<ReferenceShiftedDetails> CREATOR = new class_316();
    // $FF: renamed from: BR int
    final int field_4697;
    // $FF: renamed from: RH java.lang.String
    final String field_4698;
    // $FF: renamed from: RI java.lang.String
    final String field_4699;
    // $FF: renamed from: RJ int
    final int field_4700;
    // $FF: renamed from: RK int
    final int field_4701;

    ReferenceShiftedDetails(int var1, String var2, String var3, int var4, int var5) {
        this.field_4697 = var1;
        this.field_4698 = var2;
        this.field_4699 = var3;
        this.field_4700 = var4;
        this.field_4701 = var5;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_316.method_2199(this, var1, var2);
    }
}

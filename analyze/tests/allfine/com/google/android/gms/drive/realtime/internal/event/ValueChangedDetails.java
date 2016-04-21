package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.class_315;

public class ValueChangedDetails implements SafeParcelable {
    public static final Creator<ValueChangedDetails> CREATOR = new class_315();
    // $FF: renamed from: BR int
    final int field_1546;
    // $FF: renamed from: RM int
    final int field_1547;

    ValueChangedDetails(int var1, int var2) {
        this.field_1546 = var1;
        this.field_1547 = var2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_315.method_2196(this, var1, var2);
    }
}

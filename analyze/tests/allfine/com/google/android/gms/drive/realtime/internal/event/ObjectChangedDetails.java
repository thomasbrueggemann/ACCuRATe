package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.class_320;

public class ObjectChangedDetails implements SafeParcelable {
    public static final Creator<ObjectChangedDetails> CREATOR = new class_320();
    // $FF: renamed from: BR int
    final int field_1476;
    // $FF: renamed from: Rr int
    final int field_1477;
    // $FF: renamed from: Rs int
    final int field_1478;

    ObjectChangedDetails(int var1, int var2, int var3) {
        this.field_1476 = var1;
        this.field_1477 = var2;
        this.field_1478 = var3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_320.method_2211(this, var1, var2);
    }
}

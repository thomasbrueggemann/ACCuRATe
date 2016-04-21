package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.class_311;

public class ValuesSetDetails implements SafeParcelable {
    public static final Creator<ValuesSetDetails> CREATOR = new class_311();
    // $FF: renamed from: BR int
    final int field_2110;
    // $FF: renamed from: Rr int
    final int field_2111;
    // $FF: renamed from: Rs int
    final int field_2112;
    final int mIndex;

    ValuesSetDetails(int var1, int var2, int var3, int var4) {
        this.field_2110 = var1;
        this.mIndex = var2;
        this.field_2111 = var3;
        this.field_2112 = var4;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_311.method_2183(this, var1, var2);
    }
}

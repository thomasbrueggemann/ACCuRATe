package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.class_313;

public class ValuesRemovedDetails implements SafeParcelable {
    public static final Creator<ValuesRemovedDetails> CREATOR = new class_313();
    // $FF: renamed from: BR int
    final int field_2105;
    // $FF: renamed from: RP java.lang.String
    final String field_2106;
    // $FF: renamed from: RQ int
    final int field_2107;
    // $FF: renamed from: Rr int
    final int field_2108;
    // $FF: renamed from: Rs int
    final int field_2109;
    final int mIndex;

    ValuesRemovedDetails(int var1, int var2, int var3, int var4, String var5, int var6) {
        this.field_2105 = var1;
        this.mIndex = var2;
        this.field_2108 = var3;
        this.field_2109 = var4;
        this.field_2106 = var5;
        this.field_2107 = var6;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_313.method_2190(this, var1, var2);
    }
}

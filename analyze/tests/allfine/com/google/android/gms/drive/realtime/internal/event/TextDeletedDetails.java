package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.class_317;

public class TextDeletedDetails implements SafeParcelable {
    public static final Creator<TextDeletedDetails> CREATOR = new class_317();
    // $FF: renamed from: BR int
    final int field_3981;
    // $FF: renamed from: RL int
    final int field_3982;
    final int mIndex;

    TextDeletedDetails(int var1, int var2, int var3) {
        this.field_3981 = var1;
        this.mIndex = var2;
        this.field_3982 = var3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_317.method_2202(this, var1, var2);
    }
}

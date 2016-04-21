package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.class_314;

public class TextInsertedDetails implements SafeParcelable {
    public static final Creator<TextInsertedDetails> CREATOR = new class_314();
    // $FF: renamed from: BR int
    final int field_4538;
    // $FF: renamed from: RL int
    final int field_4539;
    final int mIndex;

    TextInsertedDetails(int var1, int var2, int var3) {
        this.field_4538 = var1;
        this.mIndex = var2;
        this.field_4539 = var3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_314.method_2193(this, var1, var2);
    }
}

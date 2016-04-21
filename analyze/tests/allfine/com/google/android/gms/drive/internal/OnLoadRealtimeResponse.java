package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_1108;

public class OnLoadRealtimeResponse implements SafeParcelable {
    public static final Creator<OnLoadRealtimeResponse> CREATOR = new class_1108();
    // $FF: renamed from: BR int
    final int field_4393;
    // $FF: renamed from: vR boolean
    final boolean field_4394;

    OnLoadRealtimeResponse(int var1, boolean var2) {
        this.field_4393 = var1;
        this.field_4394 = var2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1108.method_5748(this, var1, var2);
    }
}

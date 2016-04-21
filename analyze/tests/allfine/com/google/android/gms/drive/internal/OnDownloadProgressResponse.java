package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_1114;

public class OnDownloadProgressResponse implements SafeParcelable {
    public static final Creator<OnDownloadProgressResponse> CREATOR = new class_1114();
    // $FF: renamed from: BR int
    final int field_3584;
    // $FF: renamed from: Pp long
    final long field_3585;
    // $FF: renamed from: Pq long
    final long field_3586;

    OnDownloadProgressResponse(int var1, long var2, long var4) {
        this.field_3584 = var1;
        this.field_3585 = var2;
        this.field_3586 = var4;
    }

    public int describeContents() {
        return 0;
    }

    // $FF: renamed from: if () long
    public long method_4001() {
        return this.field_3585;
    }

    // $FF: renamed from: ig () long
    public long method_4002() {
        return this.field_3586;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1114.method_5766(this, var1, var2);
    }
}
